package me.rusty.rustycore.hanlders;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class Damaged implements Listener {
	
	@EventHandler
	public void damage(EntityDamageEvent event) {
		
		
		if (event.getEntity().getType() == EntityType.PLAYER) {
			
			Player player = (Player) event.getEntity();
			
			if (player.getServer().getPort() == 25566) {
			
			event.setCancelled(true);
			
			}
			
		}
		
	}
	
	@EventHandler
	public void damage(FoodLevelChangeEvent event) {
			
		if (event.getEntity().getType() == EntityType.PLAYER) {
			
			Player player = (Player) event.getEntity();
			
			if (player.getServer().getPort() == 25566) {
			
			event.setCancelled(true);
			
			}
			
		}
	
}
}
