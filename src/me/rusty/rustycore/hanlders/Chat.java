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
			
			event.setFormat(ChatColor.DARK_GRAY + "[" + ChatColor.YELLOW + "" + ChatColor.BOLD + 
					"MOD" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + player.getName()
					+ ": " + ChatColor.GRAY + event.getMessage());
			
		}
		
		else if (player.hasPermission("rustycore.admin")) {
			
			event.setFormat(ChatColor.DARK_GRAY + "[" + ChatColor.RED + "" + ChatColor.BOLD + 
					"ADMIN" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + player.getName()
					+ ": " + ChatColor.WHITE + event.getMessage());
			
		}
		
		else if (player.hasPermission("rustycore.owner")) {
			
			event.setFormat(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "" + ChatColor.BOLD + 
					"OWNER" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + player.getName()
					+ ": " + ChatColor.WHITE + event.getMessage());
			
		}
		
		else if (player.hasPermission("rustycore.vip")) {
			
			event.setFormat(ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "" + ChatColor.BOLD + 
					"VIP" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY + player.getName()
					+ ": " + ChatColor.GRAY + event.getMessage());
			
		}
		
		if (player.getWorld().getName().equals("HUB") && (!player.hasPermission("rustycore.staff"))) {
			
			event.setCancelled(true);
			player.sendMessage(ChatColor.RED + "Sorry, but chat is disabled in spawn.");
			
		}
		
	}

}
