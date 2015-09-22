package me.rusty.rustycore.commands;

import me.rusty.rustycore.Core;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Time implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String cmd,
			String[] args) {
		
		Player player = (Player) sender;
		
		if (cmd.equalsIgnoreCase("time") && (player.hasPermission("rustycore.staff"))) {
			
			if (args.length == 0) {
				
				player.sendMessage(Core.prefix + ChatColor.GRAY + "Please select a time.");
				
			}
			
			else if (args[0].equalsIgnoreCase("day")) {
				
				Bukkit.getWorld(player.getWorld().getName()).setTime(1000);
				player.sendMessage(Core.prefix + ChatColor.GRAY + "The time was set to day.");
				
			}
			
			else if (args[0].equalsIgnoreCase("night")) {
				
				Bukkit.getWorld(player.getWorld().getName()).setTime(14000);
				player.sendMessage(Core.prefix + ChatColor.GRAY + "The time was set to night.");
				
			}
			
		}
		
		else if (!player.hasPermission("rustycore.staff")) {
			
			player.sendMessage(Core.prefix + ChatColor.GRAY + "You do not have permission to change the time of day.");
			
		}
		
		return true;
	}

}
