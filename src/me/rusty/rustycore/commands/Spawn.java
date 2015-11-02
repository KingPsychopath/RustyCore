package me.rusty.rustycore.commands;

import me.rusty.rustycore.Core;
import me.rusty.rustycore.hanlders.Locations;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
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
			
			player.sendMessage(ChatColor.GREEN
					+ "You will be teleported in 5 seconds.");
			
	        new BukkitRunnable() {
	        	 
	            @Override
	            public void run() {
	            
	    			if (Bukkit.getServer().getPort() == 25566) {
	    				
	    				player.teleport(Locations.hspawn);
	    				player.setGameMode(GameMode.ADVENTURE);
	    				
	    			}
	    			
	    			if (Bukkit.getServer().getPort() == 25567) {
	    				
	    				player.teleport(Locations.fspawn);
	    				player.setGameMode(GameMode.SURVIVAL);
	    				
	    			}
	    			
	    			if (Bukkit.getServer().getPort() == 25568) {
	    				
	    				player.teleport(Locations.cspawn);
	    				player.setGameMode(GameMode.CREATIVE);
	    				
	    			}
	            	
	            }
	 
	        }.runTaskLater(Core.getInstance(), 5 * 20);

			}
			
		
		return true;
		
	}

}
