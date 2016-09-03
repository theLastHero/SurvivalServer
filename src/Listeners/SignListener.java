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
import org.bukkit.event.player.PlayerInteractEvent;

import SurvivalServer.SurvivalServer;

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
		//if (player.getWorld().getName().equalsIgnoreCase(plugin.perksWorld)) {

			// Was a sign clicked
			if ((block.getType().equals(Material.SIGN_POST) || block.getType().equals(Material.WALL_SIGN))) {
				Sign sign = (Sign) block.getState();
				String[] ln = sign.getLines();

				if(!player.getWorld().getName().equalsIgnoreCase(SurvivalServer.instance.perksWorld)){
					return;
				}
				
				
				// check if a perks sign
				if (ln[0].toLowerCase().equalsIgnoreCase(SurvivalServer.instance.perksSign)) {

					String perkName = ln[1];
					String buyAmount = ln[2];
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
					
					if(SurvivalServer.perms.has("world", player.getName(), perm)){
						player.sendMessage(ChatColor.GREEN + "You already have this perk: " + ChatColor.RED + perkName);
						return;
					}
					
					// check and withdraw funds from player
					EconomyResponse r = plugin.econ.withdrawPlayer(player, Double.parseDouble(buyAmount));
			        if(r.transactionSuccess()) {
			        	player.sendMessage(ChatColor.GREEN + "you bought perk: " + ChatColor.RED + perm);
						SurvivalServer.perms.playerAdd(player, perm);
						return;
					} else {
						player.sendMessage(ChatColor.GREEN + "You dont have enough money to buy this perk: " + ChatColor.RED +  perkName);
						return;
					}
				}

			} else {
				return;
			}
		//} else {
		//	return;
		//}

	}

}
