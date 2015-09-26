package me.rusty.rustycore.hanlders;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		Player player = (Player) event.getPlayer();
		
		
		if (!player.hasPlayedBefore()) {
			
			player.teleport(Locations.spawn);
			
			event.setJoinMessage(ChatColor.DARK_GRAY + "[+] " + player.getName() + " has joined for the first time!");
			
		}
		
		else if (player.hasPlayedBefore()) {
			
			player.teleport(Locations.spawn);
			
			event.setJoinMessage(ChatColor.DARK_GRAY + "[+] " + player.getName());
			
		}
		
	}

}
