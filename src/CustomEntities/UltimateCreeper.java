package CustomEntities;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_11_R1.EntityCreeper;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_11_R1.CraftWorld;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import de.slikey.effectlib.effect.ExplodeEffect;
import de.slikey.effectlib.effect.ShieldEffect;
import de.slikey.effectlib.util.ParticleEffect;
import SurvivalServer.SurvivalServer;
import Utils.ItemsBuilder;

public class UltimateCreeper extends EntityCreeper implements Listener {

	
	private Location location;
	private ShieldEffect effect;



	public UltimateCreeper(org.bukkit.World world) {
		super(((CraftWorld) world).getHandle());
		
		//SurvivalServer.getPlugin(SurvivalServer.class).mobsList.add(e)

		// register death event
		Bukkit.getServer().getPluginManager().registerEvents(this, SurvivalServer.getPlugin(SurvivalServer.class));

		// set name
		((LivingEntity) this.getBukkitEntity()).setCustomName(ChatColor.MAGIC.toString() + "UltimateCreeper");
		((LivingEntity) this.getBukkitEntity()).setCustomNameVisible(true);
		this.setPowered(true);
		((LivingEntity) this.getBukkitEntity()).setMaxHealth(170);
		((LivingEntity) this.getBukkitEntity()).setHealth(170);
		// HELMENT
		ItemStack helment = ItemsBuilder.addEnchantment(new ItemStack(Material.IRON_BLOCK), Enchantment.PROTECTION_ENVIRONMENTAL, 2, null);
		helment = ItemsBuilder.addEnchantment(helment, Enchantment.PROTECTION_EXPLOSIONS, 2, null);
		helment = ItemsBuilder.addEnchantment(helment, Enchantment.PROTECTION_FIRE, 2, null);
		helment = ItemsBuilder.addEnchantment(helment, Enchantment.PROTECTION_PROJECTILE, 2, null);
		helment = ItemsBuilder.addEnchantment(helment, Enchantment.DURABILITY, 2, null);
		((LivingEntity) this.getBukkitEntity()).getEquipment().setHelmet(helment);
		((LivingEntity) this.getBukkitEntity()).getEquipment().setHelmetDropChance(0F);

		this.effect = new ShieldEffect(SurvivalServer.getPlugin(SurvivalServer.class).em); effect.setEntity(this.getBukkitEntity()); 
		this.effect.infinite();
		this.effect.radius = 2;
		this.effect.particle = ParticleEffect.ENCHANTMENT_TABLE;
		this.effect.start();
		
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

			this.effect.cancel();
			
			ExplodeEffect effect2 = new ExplodeEffect (SurvivalServer.getPlugin(SurvivalServer.class).em); effect2.setLocation(e.getEntity().getLocation()); 
			effect2.duration = 200;
			
			effect2.start();
			
			
			// set durability to full for all items
			for (ItemStack ac : e.getDrops()) {
				ac.setDurability((short) 0);
			}
		}
	}

}
