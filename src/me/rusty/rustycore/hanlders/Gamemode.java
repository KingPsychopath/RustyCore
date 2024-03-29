package me.rusty.rustycore.hanlders;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemode implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String cmd,
			String[] args) {
		
		Player player = (Player) sender;
	
		if (cmd.equalsIgnoreCase("gm") && (sender.hasPermission("rustycore.staff"))) {
			
			if (args.length == 0) {
			
				player.sendMessage(ChatColor.GREEN
						+ "Please define a gamemode.");
			
			}
			
			else if (args[0].equalsIgnoreCase("s")) {
				
				player.setGameMode(GameMode.SURVIVAL);
				player.sendMessage(ChatColor.GREEN
						+ "You have changed your gamemode to: " + args[0]);
				
			}
			
			else if (args[0].equalsIgnoreCase("c")) {
				
				player.setGameMode(GameMode.CREATIVE);
				player.sendMessage(ChatColor.GREEN
						+ "You have changed your gamemode to: " + args[0]);
				
			}
			
			else if (args[0].equalsIgnoreCase("a")) {
				
				player.setGameMode(GameMode.ADVENTURE);
				player.sendMessage(ChatColor.GREEN
						+ "You have changed your gamemode to: " + args[0]);
				
			}
			
			else if (args[0].equalsIgnoreCase("sp")) {
				
				player.setGameMode(GameMode.SPECTATOR);
				player.sendMessage(ChatColor.GREEN
						+ "You have changed your gamemode to: " + args[0]);
				
			}
			
		}
		
		else if (!player.hasPermission("rustycore.staff")) {
			
			player.sendMessage(ChatColor.GREEN
					+ "You do not have permission to change your gamemode.");
			
		}
		
		return true;
	}

}
