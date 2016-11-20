package CustomEntities;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_11_R1.EntityGolem;
import net.minecraft.server.v1_11_R1.EntityIronGolem;
import net.minecraft.server.v1_11_R1.EntityZombie;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_11_R1.CraftWorld;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

import SurvivalServer.SurvivalServer;
import Utils.ItemsBuilder;

public class GolemOne extends EntityIronGolem implements Listener {

	
	private Location location;



	public GolemOne(org.bukkit.World world) {
		super(((CraftWorld) world).getHandle());

		// register death event
		Bukkit.getServer().getPluginManager().registerEvents(this, SurvivalServer.getPlugin(SurvivalServer.class));

		// set name
		((LivingEntity) this.getBukkitEntity()).setCustomName(ChatColor.RED.toString() + ChatColor.BOLD.toString() + "GolemOne3");
		((LivingEntity) this.getBukkitEntity()).setCustomNameVisible(true);

		// HELMENT
		ItemStack helment = ItemsBuilder.addEnchantment(new ItemStack(Material.IRON_BLOCK), Enchantment.PROTECTION_ENVIRONMENTAL, 2, null);
		helment = ItemsBuilder.addEnchantment(helment, Enchantment.PROTECTION_EXPLOSIONS, 2, null);
		helment = ItemsBuilder.addEnchantment(helment, Enchantment.PROTECTION_FIRE, 2, null);
		helment = ItemsBuilder.addEnchantment(helment, Enchantment.PROTECTION_PROJECTILE, 2, null);
		helment = ItemsBuilder.addEnchantment(helment, Enchantment.DURABILITY, 2, null);
		((LivingEntity) this.getBukkitEntity()).getEquipment().setHelmet(helment);
		((LivingEntity) this.getBukkitEntity()).getEquipment().setHelmetDropChance(0F);

		//Bukkit.broadcastMessage(location.toString());
	a();
		
	}
	
	public void a(){
		new BukkitRunnable() {
		    public void run() {
		        // runs every 1 second.
		    	location = getBukkitEntity().getLocation();
		    	//Bukkit.broadcastMessage(location.toString());
		    	        Bukkit.getWorld("world").spigot().playEffect(location.add(0,4,0), Effect.FIREWORKS_SPARK,0,0,0,0,0,0,3,32);
	                
		    }
		}.runTaskTimer(SurvivalServer.getPlugin(SurvivalServer.class), 20, 20);
		
	
	}
 
		/*
		public void run() {
	        // What you want to schedule goes here

			for (int i = 0; i < 12; i++) {
				Bukkit.broadcastMessage("ffffffff");
			}
				Location location = this.location;
				Location l = new Location((World) world, location .getX() + 2, location.getY(), location.getZ() + 2);
				((World) world).spigot().playEffect(l, Effect.COLOURED_DUST, 0, 0, 244/255, 222/255, 14/255, 1, 0, 16);
			}
	    */


	@EventHandler
	public void death(EntityDeathEvent e) {
		if (e.getEntity().getEntityId() == this.getBukkitEntity().getEntityId()) {

			// set durability to full for all items
			for (ItemStack ac : e.getDrops()) {
				ac.setDurability((short) 0);
			}
		}
	}

}
