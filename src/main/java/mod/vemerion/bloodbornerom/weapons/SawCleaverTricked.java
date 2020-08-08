package mod.vemerion.bloodbornerom.weapons;

import mod.vemerion.bloodbornerom.BloodborneRom;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemTier;

public class SawCleaverTricked extends BloodborneWeapon {

	public SawCleaverTricked() {
		super(ItemTier.DIAMOND, 3, -2.4F, (new Item.Properties()).group(ItemGroup.COMBAT));
	}

	@Override
	protected Item getTransform() {
		return BloodborneRom.SAW_CLEAVER;
	}
}
