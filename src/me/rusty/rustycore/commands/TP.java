package me.rusty.rustycore.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TP implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String cmd,
			String[] args) {
		
		Player player = (Player) sender;
		
		if (cmd.equalsIgnoreCase("tp") && (player.hasPermission("rustycore.staff"))) {
			
			if (args.length == 0) {
				
				player.sendMessage(ChatColor.GREEN
						+ "Please specify a player to be teleported to.");
				
			}
			
			else if (args.length == 1) {
				
				if (args[0].equalsIgnoreCase(Bukkit.getServer().getPlayer(args[0]).getName())) {
					
					Player targetPlayer = Bukkit.getServer().getPlayer(args[0]);
					
					if (targetPlayer.isOnline()) {
					
					player.teleport(targetPlayer.getLocation());
					
						player.sendMessage(ChatColor.GREEN
								+ "You are being teleported to " + args[0]);
					
					targetPlayer.sendMessage(ChatColor.RED + "WARNING: " + ChatColor.GRAY + player.getName() + " is teleporting to you.");
					
					}
					
					else if (!targetPlayer.isOnline()) {
						
						player.sendMessage(ChatColor.GREEN + args[0] + " is not online.");
						
					}
					
				}
				
				else if (args.length > 1) {
					
					player.sendMessage(ChatColor.GREEN + "Invalid arguments, please try again.");
					
				}
			
		}
		
		else if (!player.hasPermission("rustycore.staff")) {
			
				player.sendMessage(ChatColor.GREEN
						+ "You do not have permission to teleport to other players.");
			
			}
		}
		
		return true;
	}
}
