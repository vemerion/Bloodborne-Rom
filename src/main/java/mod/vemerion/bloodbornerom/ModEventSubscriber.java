package mod.vemerion.bloodbornerom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.PushReaction;
import mod.vemerion.bloodbornerom.capability.SpawnRom;
import mod.vemerion.bloodbornerom.capability.SpawnRomStorage;
import mod.vemerion.bloodbornerom.mobs.entities.MissileEntity;
import mod.vemerion.bloodbornerom.mobs.entities.RomDeathEntity;
import mod.vemerion.bloodbornerom.mobs.entities.RomEntity;
import mod.vemerion.bloodbornerom.mobs.entities.RomSpiderEntity;
import mod.vemerion.bloodbornerom.weapons.SawCleaver;
import mod.vemerion.bloodbornerom.weapons.SawCleaverTricked;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.IForgeRegistryEntry;

@EventBusSubscriber(modid = BloodborneRom.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventSubscriber {

	@SubscribeEvent
	public static void onRegisterEntity(RegistryEvent.Register<EntityType<?>> event) {
		EntityType<RomSpiderEntity> romSpider = EntityType.Builder
				.<RomSpiderEntity>create(RomSpiderEntity::new, EntityClassification.CREATURE).size(1, 1F).build("rom_spider_entity");
		EntityType<RomEntity> rom = EntityType.Builder.create(RomEntity::new, EntityClassification.CREATURE).size(4, 4F)
				.build("rom_entity");
		EntityType<RomDeathEntity> romDeath = EntityType.Builder.create(RomDeathEntity::new, EntityClassification.MISC)
				.size(0, 0).build("rom_death_entity");
		EntityType<MissileEntity> missileEntity = EntityType.Builder.<MissileEntity>create(MissileEntity::new, EntityClassification.MISC)
				.size(1, 1).build("missile_entity");

		event.getRegistry().register(setup(romSpider, "rom_spider_entity"));
		event.getRegistry().register(setup(rom, "rom_entity"));
		event.getRegistry().register(setup(romDeath, "rom_death_entity"));
		event.getRegistry().register(setup(missileEntity, "missile_entity"));

	}
	
	@SubscribeEvent
	public static void onRegisterBlock(RegistryEvent.Register<Block> event) {
		SoundType romWaterSound = new SoundType(1.0F, 1.0F, SoundEvents.ENTITY_BOAT_PADDLE_WATER, SoundEvents.ENTITY_BOAT_PADDLE_WATER, SoundEvents.ENTITY_BOAT_PADDLE_WATER, SoundEvents.ENTITY_BOAT_PADDLE_WATER, SoundEvents.ENTITY_BOAT_PADDLE_WATER);
		Material romWaterMaterial = new Material(MaterialColor.WATER, false, true, true, false, false, false, false, PushReaction.BLOCK);


		Block romWater = new Block(Block.Properties.create(romWaterMaterial).hardnessAndResistance(100).noDrops().sound(romWaterSound).lightValue(11)) {
			   @Override
			   public boolean canEntitySpawn(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type) {
			      return false;
			   }

		};

		event.getRegistry().register(setup(romWater, "rom_water_block"));
	}
	
	@SubscribeEvent
	public static void onRegisterSound(RegistryEvent.Register<SoundEvent> event) {
		SoundEvent missileHitSound = new SoundEvent(new ResourceLocation(BloodborneRom.MODID, "missile_hit_sound"));
		SoundEvent romAoeSound = new SoundEvent(new ResourceLocation(BloodborneRom.MODID, "rom_aoe_sound"));
		SoundEvent romAoeWindupSound = new SoundEvent(new ResourceLocation(BloodborneRom.MODID, "rom_aoe_windup_sound"));
		SoundEvent romSpiderCobwebSound = new SoundEvent(new ResourceLocation(BloodborneRom.MODID, "rom_spider_cobweb_sound"));
		SoundEvent romSpiderHitSound = new SoundEvent(new ResourceLocation(BloodborneRom.MODID, "rom_spider_hit_sound"));

		event.getRegistry().register(setup(missileHitSound, "missile_hit_sound"));
		event.getRegistry().register(setup(romAoeSound, "rom_aoe_sound"));
		event.getRegistry().register(setup(romAoeWindupSound, "rom_aoe_windup_sound"));
		event.getRegistry().register(setup(romSpiderCobwebSound, "rom_spider_cobweb_sound"));
		event.getRegistry().register(setup(romSpiderHitSound, "rom_spider_hit_sound"));

	}

	@SubscribeEvent
	public static void onRegisterItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().register(setup(new SawCleaver(), "saw_cleaver"));
		event.getRegistry().register(setup(new SawCleaverTricked(), "saw_cleaver_tricked"));

	}
	
	@SubscribeEvent
	public static void commonSetup(final FMLCommonSetupEvent event){
        CapabilityManager.INSTANCE.register(SpawnRom.class, new SpawnRomStorage(), SpawnRom::new);
    }

	@SubscribeEvent
	public static void onIParticleTypeRegistration(RegistryEvent.Register<ParticleType<?>> event) {
		BasicParticleType blueSmoke = new BasicParticleType(true);
		event.getRegistry().register(setup(blueSmoke, "blue_smoke_particle_type"));
	}

	public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) {
		return setup(entry, new ResourceLocation(BloodborneRom.MODID, name));
	}

	public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) {
		entry.setRegistryName(registryName);
		return entry;
	}
}
