package me.rusty.rustycore.hanlders;

import me.rusty.rustycore.Core;
import me.rusty.rustycore.enums.Mode;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.connorlinfoot.titleapi.TitleAPI;

public class Join implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		if (Mode.getMode().equals(Mode.Beta) && (!event.getPlayer().hasPermission("rustycore.mod")
				|| (!event.getPlayer().hasPermission("rustycore.admin") || (!event.getPlayer().hasPermission("rustycore.owner"))))) {
			
			event.getPlayer().kickPlayer(ChatColor.RED + "Sorry, the server is in Beta Mode.");
			
		}
		
		else if (Mode.getMode().equals(Mode.Maintenance) && (!event.getPlayer().hasPermission("rustycore.mod")
				|| (!event.getPlayer().hasPermission("rustycore.admin") || (!event.getPlayer().hasPermission("rustycore.owner"))))) {
			
			event.getPlayer().kickPlayer(ChatColor.RED + "Sorry, the server is in Maintenance Mode.");
			
		}
		
		if (!event.getPlayer().hasPlayedBefore()) {
		
		TitleAPI.sendTitle(event.getPlayer(), 20, 40, 20, ChatColor.RED + ""
		+ ChatColor.BOLD + "Welcome!", ChatColor.GRAY + "to RustyCraft " + event.getPlayer().getName() + "!");
		
		Bukkit.broadcastMessage(Core.prefix + ChatColor.WHITE + event.getPlayer().getName() + "has joined for the first time!");
		
		}
		
		else if (event.getPlayer().hasPlayedBefore()) {
			
			TitleAPI.sendTitle(event.getPlayer(), 20, 40, 20, ChatColor.GOLD + "" + ChatColor.BOLD + 
					"Welcome Back!", ChatColor.DARK_GRAY + event.getPlayer().getName());
			
		}
		
	}

}
