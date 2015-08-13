package me.rusty.rustycore.hanlders;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class Protection implements Listener {
	
	@EventHandler
	public void onPlace(BlockPlaceEvent event) {
		
		if (event.getPlayer().getWorld().getName().equals("world")) {
			
			event.setCancelled(true);
			
			event.getPlayer().sendMessage(ChatColor.RED + "Sorry, but you can't place blocks here.");
			
		}
		
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent event) {
		
		Player player = (Player) event.getPlayer();
		
		if (player.getWorld().getName().equals("world")) {
			
			event.setCancelled(true);
			
			player.sendMessage(ChatColor.RED + "Sorry, but you can't break blocks here.");
			
		}
		
	}
	
	@EventHandler
	public void onIgnite(BlockIgniteEvent event) {
		
		if (event.getPlayer().getWorld().getName().equals("world")) {
			
			event.setCancelled(true);
			
			event.getPlayer().sendMessage(ChatColor.RED + "Sorry, but you can't ignite blocks here.");
			
		}
		
	}
		
}	

