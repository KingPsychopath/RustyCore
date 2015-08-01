package me.rusty.rustycore.hanlders;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatHandler implements Listener {
	
	@EventHandler 
	public void onChat(AsyncPlayerChatEvent event) {
		
		Player player = (Player) event.getPlayer();
		
		if (PermissionHandler.ranks.get(player.getUniqueId()).equals("Mod")) {
			
			Bukkit.broadcastMessage(PermissionHandler.ranks+"; "+PermissionHandler.ranks.size());
			
			event.setFormat(ChatColor.DARK_GRAY + "[" + ChatColor.YELLOW + "MOD"
			+ ChatColor.DARK_GRAY + ":" + ChatColor.GRAY + event.getMessage());
			
		}
		
		else if (PermissionHandler.ranks.get(player.getUniqueId()).equals("Admin")) {
			
			event.setFormat(ChatColor.DARK_GRAY + "[" + ChatColor.RED + "ADMIN"
					+ ChatColor.DARK_GRAY + ":" + ChatColor.GRAY + event.getMessage());
			
		}
		
		else if (PermissionHandler.ranks.get(player.getUniqueId()).equals("Owner")) {
			
			event.setFormat(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "" + ChatColor.BOLD +  "OWNER"
					+ ChatColor.DARK_GRAY + ":" + ChatColor.WHITE + event.getMessage());
			
		}
		
		else {
			
			event.setFormat(ChatColor.GRAY + player.getName()+ ": " + event.getMessage());
			
		}
		
	}

}
