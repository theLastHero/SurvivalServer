package Managers;

import org.bukkit.entity.Player;

import SurvivalServer.SurvivalServer;

public class PermsManager {

	public static SurvivalServer plugin;

	// -------------------------------------------------------------------------------------
	// Constructor
	// -------------------------------------------------------------------------------------
	public PermsManager(SurvivalServer SurvivalServer) {
		plugin = SurvivalServer;
	}
	
	@SuppressWarnings("static-access")
	public boolean hasPerms(Player player, String perm){
		if(plugin.perms.has(player, perm)){
			return true;
		}
		return false;
	}
	

}
