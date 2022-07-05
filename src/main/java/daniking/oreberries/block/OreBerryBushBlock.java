package daniking.oreberries.block;

import daniking.oreberries.util.ConfigStateAccess;
import daniking.oreberries.util.OBHelper;
import daniking.oreberries.util.OreBerryColorProvider;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class OreBerryBushBlock extends Block  implements OreBerryColorProvider {

    private static final int MAX_AGE = 3;
    private static final IntProperty AGE = Properties.AGE_3;
    private static final VoxelShape[] OUTLINE_SHAPES_BY_AGE = new VoxelShape[] {
            createCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 8.0D, 12.0D),
            createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D),
            createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
    };
    private static final VoxelShape[] COLLISION_SHAPES_BY_AGE = new VoxelShape[] {
            OUTLINE_SHAPES_BY_AGE[0],
            OUTLINE_SHAPES_BY_AGE[1],
            createCuboidShape(0.0D, 0.0D, 0.0D, 15.0D, 15.0D, 15.0D),
            createCuboidShape(0.0D, 0.0D, 0.0D, 15.0D, 15.0D, 15.0D),
    };


    private final int color;
    private final OBHelper.OreBerryType type;

    public OreBerryBushBlock(Settings settings, String color, OBHelper.OreBerryType type) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(AGE, 0));
        if (!color.isEmpty()) {
            this.color = Integer.decode(color);
        } else {
            this.color = -1;
        }
        this.type = type;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
            if (!world.isClient && canGrow(world, pos, state)) {
                grow(world, pos, state);
            }
    }
    protected boolean canGrow(World world, BlockPos pos, BlockState state) {
        return state.get(AGE) < MAX_AGE && (this.getConfigAccess().growsInLight() || world.getLightLevel(pos) < 10);
    }

    protected void grow(World world, BlockPos pos, BlockState state) {
        world.setBlockState(pos, this.getDefaultState().with(AGE, state.get(AGE) + 1), Block.NOTIFY_ALL);
    }

    // Harvest berries on left click
    @Override
    public void onBlockBreakStart(BlockState state, World world, BlockPos pos, PlayerEntity player) {
        tryHarvest(world, pos, state, player);
    }

    // Harvest berries on right click
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (tryHarvest(world, pos, state, player)) {
            return ActionResult.success(world.isClient());
        } else {
            return ActionResult.PASS;
        }
    }

    public ItemStack getBerries(Random rand) {
        return new ItemStack(this.getConfigAccess().getBerry(), MathHelper.nextInt(rand, this.getConfigAccess().minDrop(), this.getConfigAccess().maxDrop()));
    }

    protected boolean tryHarvest(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (state.get(AGE) >= MAX_AGE) {
            world.setBlockState(pos, state.with(AGE, 2), Block.NOTIFY_ALL);
            final ItemStack output = getBerries(world.getRandom());
            if (!player.getInventory().insertStack(output)) {
                player.dropItem(output, false, true);
            }
            return true;
        }
        return false;
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity) {
            entity.damage(DamageSource.CACTUS, 1.0F);
        }
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return OUTLINE_SHAPES_BY_AGE[state.get(AGE)];
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return COLLISION_SHAPES_BY_AGE[state.get(AGE)];
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return this.getConfigAccess().growsInLight() || world.getLightLevel(pos) < 13;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    public int getColor() {
        return this.color;
    }
    private ConfigStateAccess getConfigAccess() {
        return OBHelper.getConfigAccessFor(this.type);
    }

}
