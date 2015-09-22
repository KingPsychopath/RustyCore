package me.rusty.rustycore.hanlders;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class Leave implements Listener {
	
	@EventHandler
	public void onLeave(PlayerQuitEvent event) {
		
		Bukkit.broadcastMessage(ChatColor.GRAY + "[-] " + event.getPlayer().getName());
		
	}

}
