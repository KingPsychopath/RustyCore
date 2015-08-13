package me.rusty.rustycore.hanlders;

import me.rusty.rustycore.Core;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.connorlinfoot.titleapi.TitleAPI;

public class Join implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		if (!event.getPlayer().hasPlayedBefore()) {
		
		TitleAPI.sendTitle(event.getPlayer(), 20, 40, 20, ChatColor.RED + ""
		+ ChatColor.BOLD + "Welcome!", ChatColor.GRAY + "to RustyCraft " + event.getPlayer().getName() + "!");
		
		Bukkit.broadcastMessage(Core.prefix + ChatColor.WHITE + event.getPlayer().getName() + "has joined for the first time!");
		
		}
		
		else if (event.getPlayer().hasPlayedBefore()) {
			
			TitleAPI.sendTitle(event.getPlayer(), 20, 40, 20, ChatColor.RED + "" + ChatColor.BOLD + 
					"Welcome Back!", ChatColor.DARK_GRAY + "to RustyCraft" + event.getPlayer().getName());
			
		}
		
	}

}
