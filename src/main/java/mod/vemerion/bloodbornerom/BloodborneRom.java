package mod.vemerion.bloodbornerom;

import net.minecraft.particles.BasicParticleType;
import mod.vemerion.bloodbornerom.capability.SpawnRom;
import mod.vemerion.bloodbornerom.mobs.entities.MissileEntity;
import mod.vemerion.bloodbornerom.mobs.entities.RomDeathEntity;
import mod.vemerion.bloodbornerom.mobs.entities.RomEntity;
import mod.vemerion.bloodbornerom.mobs.entities.RomSpiderEntity;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.WorldType;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod(BloodborneRom.MODID)
public class BloodborneRom {
	public static final String MODID = "bloodborne-rom";
	
	@ObjectHolder(BloodborneRom.MODID + ":rom_spider_entity")
	public static final EntityType<RomSpiderEntity> ROM_SPIDER_ENTITY = null;
	
	@ObjectHolder(BloodborneRom.MODID + ":rom_entity")
	public static final EntityType<RomEntity> ROM_ENTITY = null;
	
	@ObjectHolder(BloodborneRom.MODID + ":rom_death_entity")
	public static final EntityType<RomDeathEntity> ROM_DEATH_ENTITY = null;
	
	@ObjectHolder(BloodborneRom.MODID + ":saw_cleaver")
	public static final Item SAW_CLEAVER = null;
	
	@ObjectHolder(BloodborneRom.MODID + ":saw_cleaver_tricked")
	public static final Item SAW_CLEAVER_TRICKED = null;
	
	@ObjectHolder(BloodborneRom.MODID + ":blue_smoke_particle_type")
	public static final BasicParticleType BLUE_SMOKE_PARTICLE_TYPE = null;
	
	@ObjectHolder(BloodborneRom.MODID + ":missile_entity")
	public static final EntityType<MissileEntity> MISSILE_ENTITY = null;
	
	public static WorldType ROM_WORLD_TYPE = new RomWorldType();
	
	@ObjectHolder(BloodborneRom.MODID + ":rom_water_block")
	public static final Block ROM_WATER_BLOCK = null;
	
	@CapabilityInject(SpawnRom.class)
	public static final Capability<SpawnRom> SPAWNROM_CAP = null;
	
	@ObjectHolder(BloodborneRom.MODID + ":missile_hit_sound")
	public static final SoundEvent MISSILE_HIT_SOUND = null;
	
	@ObjectHolder(BloodborneRom.MODID + ":rom_aoe_sound")
	public static final SoundEvent ROM_AOE_SOUND = null;
	
	@ObjectHolder(BloodborneRom.MODID + ":rom_aoe_windup_sound")
	public static final SoundEvent ROM_AOE_WINDUP_SOUND = null;
	
	@ObjectHolder(BloodborneRom.MODID + ":rom_spider_cobweb_sound")
	public static final SoundEvent ROM_SPIDER_COBWEB_SOUND = null;
	
	@ObjectHolder(BloodborneRom.MODID + ":rom_spider_hit_sound")
	public static final SoundEvent ROM_SPIDER_HIT_SOUND = null;
}
