package me.rusty.rustycore.hanlders;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class MOTD implements Listener {
	
	@EventHandler
	public void loadMOTD(ServerListPingEvent event) {
		
		event.setMotd(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + "----------------" + ChatColor.RED +
				" Rusty " + ChatColor.GRAY + "Craft " + ChatColor.DARK_GRAY + "" +
				ChatColor.STRIKETHROUGH + "-----------------" + ChatColor.GOLD + "\n Factions, Awesome Staff, Custom Plugins!");
		
	}

}
