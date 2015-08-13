package me.rusty.rustycore.commands;

import me.rusty.rustycore.Core;
import me.rusty.rustycore.enums.Mode;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetMode implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String cmd,
			String[] args) {
		
		Player player = (Player) sender;
		
		if (cmd.equalsIgnoreCase("mode") && (player.hasPermission("rustycore.admin") || (player.hasPermission("rustycore.owner")))) {
			
			player.sendMessage(ChatColor.RED + "Rusty " + Core.prefix + ChatColor.GRAY + "The current mode is: " + Mode.getMode().toString());
			
		}
		
		else if (args[0].equalsIgnoreCase("Maintenance")) {
			
			Mode.setMode(Mode.Maintenance);
			player.sendMessage(ChatColor.RED + "Rusty " + Core.prefix + ChatColor.GRAY + "The current mode is: " + Mode.getMode().toString());
			
            for (Player p : Bukkit.getOnlinePlayers()) { 
                if (!p.hasPermission("rustycore.mod") && (!p.hasPermission("rustycore.admin")
                		&& (!p.hasPermission("rustycore.owner")))) { 
                	p.kickPlayer(ChatColor.RED + "Sorry, the server is in Maintenance Mode.");
                    
                }
            }
			
		}
		
		else if (args[0].equalsIgnoreCase("Beta")) {
			
			Mode.setMode(Mode.Beta);
			player.sendMessage(ChatColor.RED + "Rusty " + Core.prefix + ChatColor.GRAY + "The current mode is: " + Mode.getMode().toString());
			
            for (Player p : Bukkit.getOnlinePlayers()) { 
                if (!p.hasPermission("rustycore.mod") && (!p.hasPermission("rustycore.admin")
                		&& (!p.hasPermission("rustycore.owner")))) { 
                	p.kickPlayer(ChatColor.RED + "Sorry, the server is in Beta Mode.");
                    
                }
            }
			
		}
		
		else if (args[0].equalsIgnoreCase("Online")) {
			
			Mode.setMode(Mode.Online);
			player.sendMessage(ChatColor.RED + "Rusty " + Core.prefix + ChatColor.GRAY + "The current mode is: " + Mode.getMode().toString());
			
		}
		
		return true;
	}

}
