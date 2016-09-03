package Managers;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;

import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;

import SurvivalServer.SurvivalServer;


public class EcoManager {
	
	public static SurvivalServer plugin;

	// -------------------------------------------------------------------------------------
	// Constructor
	// -------------------------------------------------------------------------------------
	public EcoManager(SurvivalServer SurvivalServer) {
		plugin = SurvivalServer;
	}


	
	public boolean withdrawnFunds(Player player, String buyAmount){
		
		
		EconomyResponse r = plugin.econ.withdrawPlayer(player, Double.parseDouble(buyAmount));
        if(r.transactionSuccess()) {
        	return true;
        }
        else { return false;
        
        }
	}
	

}
