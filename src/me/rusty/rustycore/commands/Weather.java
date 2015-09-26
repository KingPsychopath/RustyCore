package me.rusty.rustycore.commands;

import me.rusty.rustycore.Core;

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
				
				player.sendMessage(Core.prefix + ChatColor.GRAY + "You must provide the type of weather.");
				
			}
			
			else if (args[0].equalsIgnoreCase("clear")) {
				
				Bukkit.getWorld(player.getWorld().getName()).setStorm(false);
				player.sendMessage(Core.prefix + ChatColor.GRAY + "The weather has been set to: " + args[0]);
					
			}
			
			else if (args[0].equalsIgnoreCase("rain")) {
				
				Bukkit.getWorld(player.getWorld().getName()).setStorm(true);
				player.sendMessage(Core.prefix + ChatColor.GRAY + "The weather has been set to: " + args[0]);
				
			}
			
			else if (!args[0].equalsIgnoreCase("rain") && (!args[0].equalsIgnoreCase("clear"))) {
				
				player.sendMessage(Core.prefix + ChatColor.GRAY + "Invalid Arguments, please try again.");
				
			}
			
		}
		
		else if (!player.hasPermission("rustycore.staff")) {
			
			player.sendMessage(Core.prefix + ChatColor.GRAY + "You do not have permission to change the weather.");
			
		}
		
		return true;
	}

}
