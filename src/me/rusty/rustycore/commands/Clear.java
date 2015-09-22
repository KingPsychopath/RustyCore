package me.rusty.rustycore.commands;

import me.rusty.rustycore.Core;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Clear implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String cmd,
			String[] args) {
		
		Player player = (Player) sender;
		
		if (cmd.equalsIgnoreCase("ci") && (player.hasPermission("rustycore.staff"))) {
			
			player.getInventory().clear();
			player.sendMessage(Core.prefix + ChatColor.GRAY + "Your inventory has been cleared.");
			
		}
		
		else if (!player.hasPermission("rustycore.staff")) {
			
			player.sendMessage(Core.prefix + ChatColor.GRAY + "You do not have permission to clear your inventory.");
			
		}
		
		return true;
	}

}
