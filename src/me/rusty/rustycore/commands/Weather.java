package me.rusty.rustycore.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Weather implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String cmd,
			String[] args) {
		
		Player player = (Player) sender;
		
		if (cmd.equalsIgnoreCase("weather") && (player.hasPermission("rustycore.staff"))) {
			
			if (args.length == 0) {
				
				player.sendMessage(ChatColor.GREEN
						+ "You must provide the type of weather.");
				
			}
			
			else if (args[0].equalsIgnoreCase("clear")) {
				
				Bukkit.getWorld(player.getWorld().getName()).setStorm(false);
				player.sendMessage(ChatColor.GREEN
						+ "The weather has been set to: " + args[0]);
					
			}
			
			else if (args[0].equalsIgnoreCase("rain")) {
				
				Bukkit.getWorld(player.getWorld().getName()).setStorm(true);
				player.sendMessage(ChatColor.GREEN
						+ "The weather has been set to: " + args[0]);
				
			}
			
			else if (!args[0].equalsIgnoreCase("rain") && (!args[0].equalsIgnoreCase("clear"))) {
				
				player.sendMessage(ChatColor.GREEN
						+ "Invalid Arguments, please try again.");
				
			}
			
		}
		
		else if (!player.hasPermission("rustycore.staff")) {
			
			player.sendMessage(ChatColor.GREEN
					+ "You do not have permission to change the weather.");
			
		}
		
		return true;
	}

}
