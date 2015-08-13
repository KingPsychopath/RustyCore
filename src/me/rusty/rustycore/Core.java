package me.rusty.rustycore;

import me.rusty.rustycore.hanlders.Join;
import me.rusty.rustycore.hanlders.Protection;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class Core extends JavaPlugin {
	
	public static Core plugin;
	
	public void onEnable() {
		
		initializeevents();
		
	}
	
	public void onDisable() {
		
		
		
	}
	
	public void initializeevents() {
		
		PluginManager pm = Bukkit.getServer().getPluginManager();
		
		pm.registerEvents(new Protection(), this);
		pm.registerEvents(new Join(), this);
		
	}
	
	public static String prefix = ChatColor.GRAY + "" + ChatColor.BOLD + "> " + ChatColor.RED + "" + ChatColor.BOLD + "> ";

}
