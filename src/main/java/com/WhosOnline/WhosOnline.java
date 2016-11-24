package com.WhosOnline;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import com.WhosOnline.commands.Online;
import com.WhosOnline.events.WhosOnlineMenuEvents;

public class WhosOnline extends JavaPlugin {
	
	PluginManager pm = Bukkit.getPluginManager();
	private static WhosOnline pl;
	
	public void onEnable() {
		
		FileConfiguration config = getConfig();
		config.options().copyDefaults(true);
		saveConfig();
		
		System.out.println("[WhosOnline] has been ENABLED");
		
		pm.registerEvents(new WhosOnlineMenuEvents(this), this);
		
		this.getCommand("online").setExecutor(new Online());
		this.getCommand("who").setExecutor(new Online());
		this.getCommand("list").setExecutor(new Online());
		this.getCommand("users").setExecutor(new Online());
		this.getCommand("whom").setExecutor(new Online());
		
	}
	
	public void onDisable() {
		
		System.out.println("[WhosOnline] has been DISABLED");
		
	}
	
	public WhosOnline() {
		pl = this;
	}

	public static WhosOnline pl() {
		return pl;
	}

}