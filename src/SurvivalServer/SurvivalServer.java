package SurvivalServer;

import java.io.File;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import Listeners.NpcListener;
import Listeners.SignListener;
import Managers.EcoManager;
import Managers.PermsManager;
import Utils.BookUtil;

public class SurvivalServer extends JavaPlugin {

	public static SurvivalServer instance;
	public SurvivalServer plugin;
	public EcoManager EcoManager;
	public PermsManager PermsManager;
	public BookUtil BookUtils;


public static Economy econ = null;
    public static Permission perms = null;

	public String perksSign = "[PERKS]";
	public String spawnerSign = "[BUYSPAWNER]";
	public String perksWorld = "World_Start";
	public String playerDataFolderPath = this.getDataFolder() + File.separator + "player_data";  //where player data is stored
	
	public boolean DEBUG_MODE = true;
	
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
		Bukkit.getServer().getPluginManager().registerEvents(new NpcListener(), this);
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
	
	/**
	 * @return the plugin
	 */
	public SurvivalServer getPlugin() {
		return plugin;
	}

	/**
	 * @param plugin the plugin to set
	 */
	public void setPlugin(SurvivalServer plugin) {
		this.plugin = plugin;
	}

	/**
	 * @return the ecoManager
	 */
	public EcoManager getEcoManager() {
		return EcoManager;
	}

	/**
	 * @param ecoManager the ecoManager to set
	 */
	public void setEcoManager(EcoManager ecoManager) {
		EcoManager = ecoManager;
	}

	/**
	 * @return the permsManager
	 */
	public PermsManager getPermsManager() {
		return PermsManager;
	}

	/**
	 * @param permsManager the permsManager to set
	 */
	public void setPermsManager(PermsManager permsManager) {
		PermsManager = permsManager;
	}

	/**
	 * @return the bookUtils
	 */
	public BookUtil getBookUtils() {
		return BookUtils;
	}

	/**
	 * @param bookUtils the bookUtils to set
	 */
	public void setBookUtils(BookUtil bookUtils) {
		BookUtils = bookUtils;
	}

	/**
	 * @return the econ
	 */
	public static Economy getEcon() {
		return econ;
	}

	/**
	 * @param econ the econ to set
	 */
	public static void setEcon(Economy econ) {
		SurvivalServer.econ = econ;
	}

	/**
	 * @return the perms
	 */
	public static Permission getPerms() {
		return perms;
	}

	/**
	 * @param perms the perms to set
	 */
	public static void setPerms(Permission perms) {
		SurvivalServer.perms = perms;
	}

	/**
	 * @return the perksSign
	 */
	public String getPerksSign() {
		return perksSign;
	}

	/**
	 * @param perksSign the perksSign to set
	 */
	public void setPerksSign(String perksSign) {
		this.perksSign = perksSign;
	}

	/**
	 * @return the spawnerSign
	 */
	public String getSpawnerSign() {
		return spawnerSign;
	}

	/**
	 * @param spawnerSign the spawnerSign to set
	 */
	public void setSpawnerSign(String spawnerSign) {
		this.spawnerSign = spawnerSign;
	}

	/**
	 * @return the perksWorld
	 */
	public String getPerksWorld() {
		return perksWorld;
	}

	/**
	 * @param perksWorld the perksWorld to set
	 */
	public void setPerksWorld(String perksWorld) {
		this.perksWorld = perksWorld;
	}

	/**
	 * @return the playerDataFolderPath
	 */
	public String getPlayerDataFolderPath() {
		return playerDataFolderPath;
	}

	/**
	 * @param playerDataFolderPath the playerDataFolderPath to set
	 */
	public void setPlayerDataFolderPath(String playerDataFolderPath) {
		this.playerDataFolderPath = playerDataFolderPath;
	}

	/**
	 * @return the dEBUG_MODE
	 */
	public boolean isDEBUG_MODE() {
		return DEBUG_MODE;
	}

	/**
	 * @param dEBUG_MODE the dEBUG_MODE to set
	 */
	public void setDEBUG_MODE(boolean dEBUG_MODE) {
		DEBUG_MODE = dEBUG_MODE;
	}

	/**
	 * @param instance the instance to set
	 */
	public static void setInstance(SurvivalServer instance) {
		SurvivalServer.instance = instance;
	}

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
