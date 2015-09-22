package me.rusty.rustycore;

import me.rusty.rustycore.commands.Clear;
import me.rusty.rustycore.commands.Help;
import me.rusty.rustycore.commands.Plugins;
import me.rusty.rustycore.commands.Spawn;
import me.rusty.rustycore.commands.TP;
import me.rusty.rustycore.commands.Time;
import me.rusty.rustycore.commands.Weather;
import me.rusty.rustycore.hanlders.Chat;
import me.rusty.rustycore.hanlders.Fight;
import me.rusty.rustycore.hanlders.Gamemode;
import me.rusty.rustycore.hanlders.Join;
import me.rusty.rustycore.hanlders.Kits;
import me.rusty.rustycore.hanlders.MOTD;
import me.rusty.rustycore.hanlders.Protection;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class Core extends JavaPlugin {
	
	public void onEnable() {
		
		initializeevents();
		initializecommands();
		
	}
	
    private static Core instance;

    public Core() {
        instance = this;
    }

    public static Core getInstance() {
        return instance;
    }
	
	public void onDisable() {
		
		
		
	}
	
	public void initializeevents() {
		
		PluginManager pm = Bukkit.getServer().getPluginManager();
		
		pm.registerEvents(new Protection(), this);
		pm.registerEvents(new Chat(), this);
		pm.registerEvents(new Join(), this);
		pm.registerEvents(new MOTD(), this);
		pm.registerEvents(new Fight(), this);
		
		
	}
	
	public void initializecommands() {
		
		getCommand("help").setExecutor(new Help());
		getCommand("spawn").setExecutor(new Spawn());
		getCommand("gm").setExecutor(new Gamemode());
		getCommand("weather").setExecutor(new Weather());
		getCommand("time").setExecutor(new Time());
		getCommand("tp").setExecutor(new TP());
		getCommand("ci").setExecutor(new Clear());
		getCommand("kit").setExecutor(new Kits());
		getCommand("?").setExecutor(new Plugins());
		getCommand("pl").setExecutor(new Plugins());
		getCommand("plugins").setExecutor(new Plugins());
		
	}
	
	public static String prefix = ChatColor.RED + "" + ChatColor.BOLD + "> " + ChatColor.GRAY + "" + ChatColor.BOLD + "> ";

}



