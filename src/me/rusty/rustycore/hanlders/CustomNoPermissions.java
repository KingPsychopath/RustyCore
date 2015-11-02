package me.rusty.rustycore.hanlders;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CustomNoPermissions implements Listener {

	@EventHandler
	public void onCommandSend(PlayerCommandPreprocessEvent event) {
		
		if (event.getMessage().startsWith("/")) {
			
			if (event.getMessage().startsWith("")) {
				
				return;
				
			}
			
			if (event.getPlayer().hasPermission(
					Bukkit.getServer()
							.getPluginCommand(
									event.getMessage().replace("/", ""))
							.getPermission())) {
				
				return;

			}
			
			if (!event.getPlayer().hasPermission(
					Bukkit.getServer()
							.getPluginCommand(
									event.getMessage().replace("/", ""))
							.getPermission())) {

				Bukkit.getServer()
						.getPluginCommand(event.getMessage().replace("/", ""))
						.setPermissionMessage(
								ChatColor.RED
										+ "Oops, please check your permissions");

				event.setCancelled(true);

			}

		}
		
	}

}
