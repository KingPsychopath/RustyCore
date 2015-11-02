package me.rusty.rustycore.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Help implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String cmd,
			String[] args) {
		
		if (cmd.equalsIgnoreCase("help")) {
			
			if (Bukkit.getServer().getPort() == 25566) {
				
				sender.sendMessage(ChatColor.GREEN + "Help");
				sender.sendMessage(ChatColor.GRAY + "/help - this command.");
				sender.sendMessage(ChatColor.GRAY + "/hub - teleports you to the spawn.");
				sender.sendMessage(ChatColor.GRAY + "/spawn - teleports you to spawn.");
				
				if (!cmd.equalsIgnoreCase("help")) {

					if (sender.hasPermission("rustycore.staff")) {

					}

					if (!sender.hasPermission("rustycore.staff")) {

						sender.sendMessage(ChatColor.RED
								+ "Oops, please choose a server, then try again.");

					}

				}

			}
			
			if (Bukkit.getServer().getPort() == 25567) {
				
				sender.sendMessage(ChatColor.GREEN + "Help");
				sender.sendMessage(ChatColor.GRAY + "/help - this command.");
				sender.sendMessage(ChatColor.GRAY + "/hub - teleports you to the hub server.");
				sender.sendMessage(ChatColor.GRAY + "/f - base command for factions.");
				sender.sendMessage(ChatColor.GRAY + "/spawn - teleports you to spawn.");
				
			}
			
		}
		
		return true;
	}

}
