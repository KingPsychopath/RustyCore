package me.rusty.rustycore.hanlders;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class Leave implements Listener {
	
	@EventHandler
	public void onLeave(PlayerQuitEvent event) {

		event.setQuitMessage(ChatColor.GRAY + "[+] "
				+ event.getPlayer().getName());

	}

}
