package CustomEntities;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_11_R1.EntitySkeleton;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_11_R1.CraftWorld;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import SurvivalServer.SurvivalServer;
import Utils.ItemsBuilder;

public class GoldSkeleton extends EntitySkeleton implements Listener {

	public GoldSkeleton(org.bukkit.World world) {
		super(((CraftWorld) world).getHandle());

		// register death event
		Bukkit.getServer().getPluginManager().registerEvents(this, SurvivalServer.getPlugin(SurvivalServer.class));

		//set name
		((LivingEntity) this.getBukkitEntity()).setCustomName(ChatColor.GOLD.toString() + ChatColor.BOLD.toString() + "Gold Skeleton");
		((LivingEntity) this.getBukkitEntity()).setCustomNameVisible(true);

		// HELMENT
		ItemStack helment = ItemsBuilder.addEnchantment(new ItemStack(Material.GOLD_BLOCK), Enchantment.PROTECTION_ENVIRONMENTAL, 3, null);
		helment = ItemsBuilder.addEnchantment(helment, Enchantment.PROTECTION_EXPLOSIONS, 3, null);
		helment = ItemsBuilder.addEnchantment(helment, Enchantment.PROTECTION_FIRE, 3, null);
		helment = ItemsBuilder.addEnchantment(helment, Enchantment.PROTECTION_PROJECTILE, 3, null);
		helment = ItemsBuilder.addEnchantment(helment, Enchantment.DURABILITY, 3, null);
		((LivingEntity) this.getBukkitEntity()).getEquipment().setHelmet(helment);
		((LivingEntity) this.getBukkitEntity()).getEquipment().setHelmetDropChance(0F);

		// CHESTPLATE
		ItemStack chestPlate = ItemsBuilder.addEnchantment(new ItemStack(Material.GOLD_CHESTPLATE), Enchantment.PROTECTION_ENVIRONMENTAL, 3, ChatColor.GOLD + "DiamondSkeleton ChestPlate");
		chestPlate = ItemsBuilder.addEnchantment(chestPlate, Enchantment.PROTECTION_EXPLOSIONS, 3, null);
		chestPlate = ItemsBuilder.addEnchantment(chestPlate, Enchantment.PROTECTION_FIRE, 3, null);
		chestPlate = ItemsBuilder.addEnchantment(chestPlate, Enchantment.PROTECTION_PROJECTILE, 3, null);
		chestPlate = ItemsBuilder.addEnchantment(chestPlate, Enchantment.DURABILITY, 3, null);
		((LivingEntity) this.getBukkitEntity()).getEquipment().setChestplate(chestPlate);
		((LivingEntity) this.getBukkitEntity()).getEquipment().setChestplateDropChance(0.3F);

		// LEGGINGS
		ItemStack leggings = ItemsBuilder.addEnchantment(new ItemStack(Material.GOLD_LEGGINGS), Enchantment.PROTECTION_ENVIRONMENTAL, 3, ChatColor.GOLD + "DiamondSkeleton Leggings");
		leggings = ItemsBuilder.addEnchantment(leggings, Enchantment.PROTECTION_EXPLOSIONS, 3, null);
		leggings = ItemsBuilder.addEnchantment(leggings, Enchantment.PROTECTION_FIRE, 3, null);
		leggings = ItemsBuilder.addEnchantment(leggings, Enchantment.PROTECTION_PROJECTILE, 3, null);
		leggings = ItemsBuilder.addEnchantment(leggings, Enchantment.DURABILITY, 3, null);
		((LivingEntity) this.getBukkitEntity()).getEquipment().setLeggings(leggings);
		((LivingEntity) this.getBukkitEntity()).getEquipment().setLeggingsDropChance(0.3F);

		// BOOTS
		ItemStack boots = ItemsBuilder.addEnchantment(new ItemStack(Material.GOLD_BOOTS), Enchantment.PROTECTION_ENVIRONMENTAL, 3, ChatColor.GOLD + "DiamondSkeleton Boots");
		boots = ItemsBuilder.addEnchantment(boots, Enchantment.PROTECTION_EXPLOSIONS, 3, null);
		boots = ItemsBuilder.addEnchantment(boots, Enchantment.PROTECTION_FIRE, 3, null);
		boots = ItemsBuilder.addEnchantment(boots, Enchantment.PROTECTION_PROJECTILE, 3, null);
		boots = ItemsBuilder.addEnchantment(boots, Enchantment.DURABILITY, 3, null);
		((LivingEntity) this.getBukkitEntity()).getEquipment().setBoots(boots);
		((LivingEntity) this.getBukkitEntity()).getEquipment().setBootsDropChance(0.3F);

		// MAINHAND
		ItemStack mainHand = ItemsBuilder.addEnchantment(new ItemStack(Material.GOLD_AXE), Enchantment.DAMAGE_ALL, 3, ChatColor.GOLD + "DiamondSkeleton MainHand Axe");
		mainHand = ItemsBuilder.addEnchantment(mainHand, Enchantment.FIRE_ASPECT, 2, null);
		mainHand = ItemsBuilder.addEnchantment(mainHand, Enchantment.DURABILITY, 3, null);
		mainHand = ItemsBuilder.addEnchantment(mainHand, Enchantment.LOOT_BONUS_MOBS, 2, null);
		mainHand = ItemsBuilder.addEnchantment(mainHand, Enchantment.DAMAGE_ALL, 3, null);
		((LivingEntity) this.getBukkitEntity()).getEquipment().setItemInMainHand(mainHand);
		((LivingEntity) this.getBukkitEntity()).getEquipment().setItemInMainHandDropChance(0.3F);

		// OFFHAND
		ItemStack offHand = ItemsBuilder.addEnchantment(new ItemStack(Material.GOLD_AXE), Enchantment.DAMAGE_ALL, 3, ChatColor.GOLD + "DiamondSkeleton OffHand Axe");
		offHand = ItemsBuilder.addEnchantment(offHand, Enchantment.FIRE_ASPECT, 2, null);
		offHand = ItemsBuilder.addEnchantment(offHand, Enchantment.DURABILITY, 3, null);
		offHand = ItemsBuilder.addEnchantment(offHand, Enchantment.LOOT_BONUS_MOBS, 2, null);
		mainHand = ItemsBuilder.addEnchantment(mainHand, Enchantment.DAMAGE_ALL, 3, null);
		((LivingEntity) this.getBukkitEntity()).getEquipment().setItemInOffHand(offHand);
		((LivingEntity) this.getBukkitEntity()).getEquipment().setItemInOffHandDropChance(0.3F);

	}

	@EventHandler
	public void death(EntityDeathEvent e) {
		if (e.getEntity().getEntityId() == this.getBukkitEntity().getEntityId()) {

			//set durability to full for all items
			for (ItemStack ac : e.getDrops()) {
				ac.setDurability((short) 0);
			}
		}
	}

}
