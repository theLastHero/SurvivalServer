package Listeners;

import org.bukkit.craftbukkit.v1_10_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftEntity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

import net.minecraft.server.v1_10_R1.Entity;
import net.minecraft.server.v1_10_R1.World;
import CustomEntities.CustomEntityType;
import CustomEntities.DiamondSkeleton;
import CustomEntities.GoldSkeleton;
import CustomEntities.GolemOne;
import CustomEntities.IronSkeleton;
import CustomEntities.UltimateCreeper;
import CustomEntities.ZombieOne;
import Utils.Maths;

public class CustomMobListener implements Listener {

	@EventHandler
	public void onCreatureSpawn(CreatureSpawnEvent event) {

		boolean norm = false;
		net.minecraft.server.v1_10_R1.Entity mcEntity = (((CraftEntity) event.getEntity()).getHandle());
		LivingEntity sender = event.getEntity();
		
		int a = Maths.getRandom(1, 1200);

		if (event.isCancelled()) return;

		if (event.getSpawnReason() == SpawnReason.SPAWNER_EGG) {
			norm = true;
		}

		
		if (event.getEntityType() == EntityType.CREEPER) {
			if ((mcEntity instanceof UltimateCreeper == true)) {
				return;
			}
			
			//Ultimate Creeper
			if(a > 1 && a < 3){
				//not from spawner
				if (event.getSpawnReason() == SpawnReason.SPAWNER) {
					return;
				}
				//cancel spawn
				event.setCancelled(true);
				//do new spawn
				CustomEntityType.spawnEntity(new UltimateCreeper((CraftWorld) sender.getServer().getWorld("world")), sender.getLocation());
			}
		}
		

		if (event.getEntityType() == EntityType.SKELETON) {
			if ((mcEntity instanceof DiamondSkeleton == true)) {
				return;
			}
			
			//Diamond Skeleton
			if(a > 1 && a < 3){
				//not from spawner
				if (event.getSpawnReason() == SpawnReason.SPAWNER) {
					return;
				}
				//cancel spawn
				event.setCancelled(true);
				//do new spawn
				CustomEntityType.spawnEntity(new DiamondSkeleton((CraftWorld) sender.getServer().getWorld("world")), sender.getLocation());
			}
			
			if ((mcEntity instanceof IronSkeleton == true)) {
				return;
			}
			
			//Diamond Skeleton
			if(a > 4 && a < 8){
				//not from spawner
				if (event.getSpawnReason() == SpawnReason.SPAWNER) {
					return;
				}
				//cancel spawn
				event.setCancelled(true);
				//do new spawn
				CustomEntityType.spawnEntity(new IronSkeleton((CraftWorld) sender.getServer().getWorld("world")), sender.getLocation());
			}
			
			
			if ((mcEntity instanceof GoldSkeleton == true)) {
				return;
			}
			
			//Diamond Skeleton
			if(a > 9 && a < 15){
				//not from spawner
				if (event.getSpawnReason() == SpawnReason.SPAWNER) {
					return;
				}
				//cancel spawn
				event.setCancelled(true);
				//do new spawn
				CustomEntityType.spawnEntity(new GoldSkeleton((CraftWorld) sender.getServer().getWorld("world")), sender.getLocation());
			}
			

		}

	}

}
