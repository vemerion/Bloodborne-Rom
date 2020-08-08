package mod.vemerion.bloodbornerom;

import java.util.Random;

import mod.vemerion.bloodbornerom.capability.SpawnRom;
import mod.vemerion.bloodbornerom.capability.SpawnRomProvider;
import mod.vemerion.bloodbornerom.mobs.entities.RomEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = BloodborneRom.MODID, bus = EventBusSubscriber.Bus.FORGE)
public class ForgeEventSubscriber {

	@SubscribeEvent
	public static void spawnRom(PlayerLoggedInEvent event) {
		PlayerEntity player = event.getPlayer();
		World world = player.world;
		if (!world.isRemote && world.getWorldType() instanceof RomWorldType) {
			Vec3d playerPos = player.getPositionVec();
			Random rand = player.getRNG();
			SpawnRom spawnRom = world.getCapability(BloodborneRom.SPAWNROM_CAP).orElseThrow(() -> new IllegalArgumentException("LazyOptional cannot be empty!"));
			if (!spawnRom.isSpawned()) {
				spawnRom.setSpawned(true);
				RomEntity rom = new RomEntity(BloodborneRom.ROM_ENTITY, world);
				Vec3d direction = Vec3d.fromPitchYaw(0, rand.nextFloat() * 360);
				Vec3d spawnPosition = playerPos.add(direction.getX() * 30, 0, direction.getZ() * 30);
				rom.setPosition(spawnPosition.getX(), spawnPosition.getY(), spawnPosition.getZ());
				world.addEntity(rom);
			}
		}
	}
	
	@SubscribeEvent
	public static void givePlayerSawCleaver(PlayerLoggedInEvent event) {
		World world = event.getPlayer().world;
		if (!world.isRemote && world.getWorldType() instanceof RomWorldType) {
			event.getPlayer().addItemStackToInventory(new ItemStack(BloodborneRom.SAW_CLEAVER));
			event.getPlayer().addItemStackToInventory(new ItemStack(Items.COOKED_BEEF, 10));
		}
	}
	
	public static final ResourceLocation SPAWNROM_CAP = new ResourceLocation(BloodborneRom.MODID, "spawnrom");

	// Add spawn rom capability to worlds
	@SubscribeEvent
	public static void attachCapability(AttachCapabilitiesEvent<World> event) {
		event.addCapability(SPAWNROM_CAP, new SpawnRomProvider());
	}
}
