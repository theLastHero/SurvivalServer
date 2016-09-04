package Listeners;

import net.milkbowl.vault.economy.EconomyResponse;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import SurvivalServer.SurvivalServer;


/* SignListener:
 * Contains code for buying in game perk/permissions
 * and spawners.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

public class SignListener implements Listener {

	public static SurvivalServer plugin;

	// -------------------------------------------------------------------------------------
	// Constructor
	// -------------------------------------------------------------------------------------
	public SignListener(SurvivalServer SurvivalServer) {
		plugin = SurvivalServer;
	}

	// -------------------------------------------------------------------------------------
	// onPlayerInteract
	// -------------------------------------------------------------------------------------
	@SuppressWarnings({ "static-access", "deprecation" })
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {

		Block block = e.getClickedBlock();
		Player player = e.getPlayer();

		// check world sign is in
		// if (player.getWorld().getName().equalsIgnoreCase(plugin.perksWorld)) {

		// not in world_start then exit
		if (!player.getWorld().getName().equalsIgnoreCase(SurvivalServer.instance.perksWorld)) {
			return;
		}

		//make it right click only
		if(!(e.getAction() == Action.RIGHT_CLICK_BLOCK)){
			return;
		}
		// Was a sign clicked
		if ((block.getType().equals(Material.SIGN_POST) || block.getType().equals(Material.WALL_SIGN))) {
			Sign sign = (Sign) block.getState();
			String[] ln = sign.getLines();

			// check if a perks sign
			if (ChatColor.stripColor(ln[0]).toLowerCase().equalsIgnoreCase(SurvivalServer.instance.perksSign)) {

				String perkName = ln[1];
				String buyAmount = ln[2].replace("$", "");;
				String perm = null;

				switch (perkName) {
				case "/craft":
					perm = "essentials.workbench";
					break;

				case "/hat":
					perm = "essentials.hat";
					break;

				case "/ptime":
					perm = "essentials.ptime";
					break;

				case "/near":
					perm = "essentials.near";
					break;

				case "/nick":
					perm = "essentials.nick";
					break;

				case "/recipe":
					perm = "essentials.recipe";
					break;

				case "/enderchest":
					perm = "essentials.enderchest";
					break;

				case "/back":
					perm = "essentials.back";
					break;

				case "keepxp":
					perm = "essentials.keepxp";
					break;

				case "/top":
					perm = "essentials.top";
					break;

				case "chat colors":
					perm = "essentials.chat.color";
					break;

				case "join full server":
					perm = "essentials.joinfullserver";
					break;

				case "color on signs":
					perm = "essentials.signs.color";
					break;

				default:
					break;
				}

				if (perm != null) {
					if (SurvivalServer.perms.has("world", player.getName(), perm)) {
						player.sendMessage(ChatColor.GREEN + "You already have this perk: " + ChatColor.RED + perkName);
						return;
					}

					// check and withdraw funds from player
					EconomyResponse r = plugin.econ.withdrawPlayer(player, Double.parseDouble(buyAmount));
					if (r.transactionSuccess()) {
						player.sendMessage(ChatColor.GREEN + "you bought perk: " + ChatColor.RED + perm);
						SurvivalServer.perms.playerAdd(player, perm);
						return;
					} else {
						player.sendMessage(ChatColor.GREEN + "You dont have enough money to buy this perk: " + ChatColor.RED + perkName);
						return;
					}
				}
			}

			// check if a BuySpawner sign
			if (ChatColor.stripColor(ln[0]).toLowerCase().equalsIgnoreCase(SurvivalServer.instance.spawnerSign)) {

				String spawnerName = ln[1];
				String buyAmount = ln[2].replace("$", "");
				String spawnerCommand = null;

				switch (spawnerName) {
				case "Zombie":
					spawnerCommand = "zombie";
					break;

				case "Skeleton":
					spawnerCommand = "skeleton";
					break;
					
				case "Creeper":
					spawnerCommand = "creeper";
					break;
					
				case "Spider":
					spawnerCommand = "spider";
					break;
					
				case "Giant":
					spawnerCommand = "giant";
					break;
					
				case "Slime":
					spawnerCommand = "slime";
					break;
					
				case "Ghast":
					spawnerCommand = "ghast";
					break;
					
				case "PigZombie":
					spawnerCommand = "zombiepigman";
					break;
					
				case "Enderman":
					spawnerCommand = "enderman";
					break;
					
				case "CaveSpider":
					spawnerCommand = "cavespider";
					break;
					
				case "Silverfish":
					spawnerCommand = "silverfish";
					break;
					
				case "Blaze":
					spawnerCommand = "blaze";
					break;
					
				case "LavaSlime":
					spawnerCommand = "magmacube";
					break;
					
				case "EnderDragon":
					spawnerCommand = "enderdragon";
					break;
					
				case "WitherBoss":
					spawnerCommand = "witherboss";
					break;
					
				case "Witch":
					spawnerCommand = "witch";
					break;
					
				case "Endermite":
					spawnerCommand = "endermite";
					break;
					
				case "Guardian":
					spawnerCommand = "guardian";
					break;
					
				case "Shulker":
					spawnerCommand = "shulker";
					break;
					
				case "Bat":
					spawnerCommand = "bat";
					break;
					
				case "Pig":
					spawnerCommand = "pig";
					break;
					
				case "Sheep":
					spawnerCommand = "sheep";
					break;
					
				case "Cow":
					spawnerCommand = "cow";
					break;
					
				case "Chicken":
					spawnerCommand = "chicken";
					break;
					
				case "Squid":
					spawnerCommand = "squid";
					break;
					
				case "Wolf":
					spawnerCommand = "wolf";
					break;
					
				case "MushroomCow":
					spawnerCommand = "mooshroom";
					break;
					
				case "SnowMan":
					spawnerCommand = "snowgolem";
					break;
					
				case "Ozelot":
					spawnerCommand = "ocelot";
					break;
					
				case "IronGolem":
					spawnerCommand = "irongolem";
					break;
					
				case "Villager":
					spawnerCommand = "villager";
					break;
					
				case "Horse":
					spawnerCommand = "horse";
					break;
					
				case "Rabbit":
					spawnerCommand = "rabbit";
					break;
					
				case "PolarBear":
					spawnerCommand = "polarbear";
					break;

				default:
					break;
				}
				if (spawnerCommand != null) {
					
					
					// check and withdraw funds from player
					EconomyResponse r = plugin.econ.withdrawPlayer(player, Double.parseDouble(buyAmount));
					if (r.transactionSuccess()) {
						player.sendMessage(ChatColor.GREEN + "you bought perk: " + ChatColor.RED + spawnerName + ChatColor.GREEN + " spawner.");
						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "silkspawners give " + player.getName() + " " + spawnerCommand + " 1");
						return;
					} else {
						player.sendMessage(ChatColor.GREEN + "You dont have enough money to buy this " + ChatColor.RED + spawnerName + ChatColor.GREEN + " spawner. ");
						return;
					}
					
				}

			}

		}

	}

}
