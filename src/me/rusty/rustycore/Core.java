package me.rusty.rustycore;

import me.rusty.rustycore.hanlders.ChatHandler;
import me.rusty.rustycore.hanlders.PermissionHandler;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class Core extends JavaPlugin {
	
	public static Core plugin;
	
	public void onEnable() {
		
		PluginManager pm = Bukkit.getServer().getPluginManager();
		
		pm.registerEvents(new PermissionHandler(), this);
		pm.registerEvents(new ChatHandler(), this);
		
	}
	
	public void onDisable() {
		
		
		
	}

}
