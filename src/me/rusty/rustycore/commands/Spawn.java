package me.rusty.rustycore.commands;

import me.rusty.rustycore.Core;
import me.rusty.rustycore.hanlders.Locations;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Spawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String cmd,
			String[] args) {
		
		Player player = (Player) sender;
		
		if (cmd.equalsIgnoreCase("spawn")) {
			
			player.sendMessage(Core.prefix + ChatColor.GRAY + "You will be teleported in 5 seconds.");
			
	        new BukkitRunnable() {
	        	 
	            @Override
	            public void run() {
	            
	            	player.teleport(Locations.spawn);
	            	
	            }
	 
	        }.runTaskLater(Core.getInstance(), 5 * 20);

			}
			
		
		return true;
		
	}

}
