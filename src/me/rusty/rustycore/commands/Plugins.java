package me.rusty.rustycore.commands;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Plugins implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String cmd,
			String[] arg3) {
		
		Player player = (Player) sender;
				
		if (cmd.equalsIgnoreCase("?")) {
			
			player.sendMessage(ChatColor.WHITE + "Plugins(2):" + ChatColor.GREEN + "RustyCore, PermissionsEx");
			
		}
		
		if (cmd.equalsIgnoreCase("pl")) {
			
			player.sendMessage(ChatColor.WHITE + "Plugins(2):" + ChatColor.GREEN + "RustyCore, PermissionsEx");
			
		}
		
		if (cmd.equalsIgnoreCase("plugins")) {
			
			player.sendMessage(ChatColor.WHITE + "Plugins(2):" + ChatColor.GREEN + "RustyCore, PermissionsEx");
			
		}
		
		return true;
	}

}
