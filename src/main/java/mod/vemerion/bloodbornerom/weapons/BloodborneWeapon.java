package mod.vemerion.bloodbornerom.weapons;

import java.util.Random;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SwordItem;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public abstract class BloodborneWeapon extends SwordItem {

	public BloodborneWeapon(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}
	
	protected abstract Item getTransform();
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		playerIn.setHeldItem(handIn, new ItemStack(getTransform()));
		return ActionResult.resultPass(playerIn.getHeldItem(handIn));
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		Random rand = target.getRNG();
		addBloodParticles(rand.nextInt(50) + 50, target, rand);
		return super.hitEntity(stack, target, attacker);
	}

	private void addBloodParticles(int count, LivingEntity target, Random rand) {
		float width = target.getWidth() * 0.5f;
		float height = target.getHeight() * 0.5f;
		for (int i = 0; i < count; ++i) {
			Vec3d offset = new Vec3d(0, 0, 0);
			offset = offset.add(rand.nextDouble() * width - width / 2, rand.nextDouble() * height - height / 2,
					rand.nextDouble() * width - width / 2);
			Vec3d position = new Vec3d(target.getPosX(), target.getPosYEye(), target.getPosZ());
			if (target.world instanceof ServerWorld) {
				((ServerWorld) target.world).spawnParticle(
						new ItemParticleData(ParticleTypes.ITEM, new ItemStack(Items.REDSTONE)), position.x, position.y,
						position.z, 1, offset.x, offset.y + 0.05D, offset.z, 0.1D);
			}
		}
	}
}
