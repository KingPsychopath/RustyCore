package me.rusty.rustycore.hanlders;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Hub implements Listener, CommandExecutor {
	
	public static Location hub = new Location(Bukkit.getWorld("HUB"), 13, 45, 56);

	@Override
	public boolean onCommand(CommandSender sender, Command command, String cmd,
			String[] args) {
		
		Player player = (Player) sender;
		
		if (cmd.equalsIgnoreCase("hub")) {
			
			player.teleport(hub);
			
		}
		
		return true;
	}

}
