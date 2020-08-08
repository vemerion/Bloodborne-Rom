package mod.vemerion.bloodbornerom.capability;

import mod.vemerion.bloodbornerom.BloodborneRom;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class SpawnRomProvider implements ICapabilitySerializable<INBT>{

	private LazyOptional<SpawnRom> instance = LazyOptional.of(BloodborneRom.SPAWNROM_CAP::getDefaultInstance);

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
		return BloodborneRom.SPAWNROM_CAP.orEmpty(cap, instance);
	}

	@Override
	public INBT serializeNBT() {
		return BloodborneRom.SPAWNROM_CAP.getStorage().writeNBT(BloodborneRom.SPAWNROM_CAP, instance.orElseThrow(() -> new IllegalArgumentException("LazyOptional cannot be empty!")), null);
	}

	@Override
	public void deserializeNBT(INBT nbt) {
		BloodborneRom.SPAWNROM_CAP.getStorage().readNBT(BloodborneRom.SPAWNROM_CAP, instance.orElseThrow(() -> new IllegalArgumentException("LazyOptional cannot be empty!")), null, nbt);
	}
}
