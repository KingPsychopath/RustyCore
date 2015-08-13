package me.rusty.rustycore.hanlders;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Chat implements Listener {
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		
		Player player = (Player) event.getPlayer();
		
		if (player.hasPermission("rustycore.member")) {
			
			event.setFormat(ChatColor.DARK_GRAY + player.getName() + ": " + ChatColor.GRAY + event.getMessage());
			
		}
		
		else if (player.hasPermission("rustycore.mod")) {
			
			ChatColor.translateAlternateColorCodes('&', event.getMessage());
			
			event.setFormat(ChatColor.DARK_GRAY + "[" + ChatColor.YELLOW +
					"MOD" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + player.getName()
					+ ": " + ChatColor.GRAY + "" + ChatColor.BOLD + event.getMessage());
			
		}
		
		else if (player.hasPermission("rustycore.admin")) {
			
			ChatColor.translateAlternateColorCodes('&', event.getMessage());
			
			event.setFormat(ChatColor.DARK_GRAY + "[" + ChatColor.RED +
					"ADMIN" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + player.getName()
					+ ": " + ChatColor.WHITE + event.getMessage());
			
		}
		
		else if (player.hasPermission("rustycore.owner")) {
			
			ChatColor.translateAlternateColorCodes('&', event.getMessage());
			
			event.setFormat(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA +
					"OWNER" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + player.getName()
					+ ": " + ChatColor.WHITE + "" + ChatColor.BOLD + event.getMessage());
			
		}
		
	}

}
