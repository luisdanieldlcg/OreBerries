package daniking.oreberries.item;

import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class EssenceOreBerryItem extends OreBerryItem {

    public EssenceOreBerryItem(Settings settings, String color, String tooltip) {
        super(settings, color, tooltip);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        final ItemStack stack = user.getStackInHand(hand);
        if (world instanceof ServerWorld server) {
            ExperienceOrbEntity.spawn(server, user.getPos(), world.getRandom().nextInt(14) + 6);
            if (user.isCreative()) {
                return TypedActionResult.success(stack);
            } else {
                stack.decrement(1);
                return TypedActionResult.consume(stack);
            }
        }
        return super.use(world, user, hand);
    }
}
