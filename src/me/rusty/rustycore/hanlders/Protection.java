package me.rusty.rustycore.hanlders;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class Protection implements Listener {
	
	@EventHandler
	public void onPlace(BlockPlaceEvent event) {
		
		if (event.getPlayer().getWorld().getName().equals("Spawn") && (!event.getPlayer().hasPermission("rustycore.owner") && (!event.getPlayer().hasPermission("rustycore.admin")))) {
			
			event.setCancelled(true);
			
			event.getPlayer().sendMessage(ChatColor.RED + "Such wrong, much disapointment, wow.");
			
		}
		
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent event) {
		
		Player player = (Player) event.getPlayer();
		
		if (player.getWorld().getName().equals("Spawn") && (!player.hasPermission("rustycore.owner") && (!player.hasPermission("rustycore.admin")))) {
			
			event.setCancelled(true);
			
			player.sendMessage(ChatColor.RED + "Such wrong, much disapointment, wow.");
			
		}
		
	}
		
}	

