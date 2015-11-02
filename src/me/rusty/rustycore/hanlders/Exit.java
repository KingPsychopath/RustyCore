package me.rusty.rustycore.hanlders;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class Exit implements Listener {

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onExit(PlayerMoveEvent event) {

		Player player = event.getPlayer();
		
		if (player.getServer().getPort() == 25566) {

			if (player.getLocation().getY() <= 50
			        && (player.getLocation().getBlock().getType() == Material.AIR)) {
				
				player.teleport(Locations.hspawn);
				
			}
			
		}

	}
}
