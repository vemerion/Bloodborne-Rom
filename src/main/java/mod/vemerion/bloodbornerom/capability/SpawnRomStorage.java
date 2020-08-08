package mod.vemerion.bloodbornerom.capability;

import net.minecraft.nbt.ByteNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class SpawnRomStorage implements IStorage<SpawnRom> {

	@Override
	public INBT writeNBT(Capability<SpawnRom> capability, SpawnRom instance, Direction side) {
		return ByteNBT.valueOf(instance.isSpawned());
		
	}

	@Override
	public void readNBT(Capability<SpawnRom> capability, SpawnRom instance, Direction side, INBT nbt) {
		instance.setSpawned(((ByteNBT)nbt).getByte() == 1);
	}
}
