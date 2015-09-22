package me.rusty.rustycore.commands;

import me.rusty.rustycore.Core;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Help implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String cmd,
			String[] args) {
		
		if (cmd.equalsIgnoreCase("help")) {
			
			sender.sendMessage(Core.prefix + ChatColor.GRAY + "Help");
			sender.sendMessage(ChatColor.GRAY + "/help - this command.");
			sender.sendMessage(ChatColor.GRAY + "/f - base command for factions.");
			sender.sendMessage(ChatColor.GRAY + "/spawn - teleports you to spawn.");
			
		}
		
		return true;
	}

}
