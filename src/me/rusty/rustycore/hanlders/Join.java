package me.rusty.rustycore.hanlders;

import me.rusty.rustycore.Core;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		Player player = (Player) event.getPlayer();
		
		player.teleport(Locations.spawn);

		Bukkit.broadcastMessage(ChatColor.GRAY + "[+] " + player.getName());
		player.sendMessage(Core.prefix + ChatColor.GRAY + "Spawn By: RustyDesigns and LethalDesigns");
		
	}

}
