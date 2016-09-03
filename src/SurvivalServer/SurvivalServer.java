package SurvivalServer;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import Listeners.SignListener;
import Managers.EcoManager;
import Managers.PermsManager;

public class SurvivalServer extends JavaPlugin {

	public static SurvivalServer instance;
	public SurvivalServer plugin;
	public EcoManager EcoManager;
	public PermsManager PermsManager;

	public static Economy econ = null;
    public static Permission perms = null;

	public String perksSign = "[perks]";
	public String perksWorld = "World_Start";

	// -------------------------------------------------------------------------------------
	// getInstance
	// -------------------------------------------------------------------------------------
	public static Plugin getInstance() {
		return instance;
	}

	// -------------------------------------------------------------------------------------
	// onDisable
	// -------------------------------------------------------------------------------------
	@Override
	public void onDisable() {
	}

	// -------------------------------------------------------------------------------------
	// onEnable
	// -------------------------------------------------------------------------------------
	@Override
	public void onEnable() {

		// Registers
		instance = this;
		Bukkit.getServer().getPluginManager().registerEvents(new SignListener(plugin), this);
		new EcoManager(this);
		new PermsManager(this);

		// setup eco
		setupEconomy();

		// setp perms
		setupPermissions();

	}
	
	// -------------------------------------------------------------------------------------
	// setupEconomy
	// -------------------------------------------------------------------------------------
	
	private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }
	
	
	private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }
	
	

}
