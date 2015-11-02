package me.rusty.rustycore.commands;

import java.util.HashMap;
import java.util.UUID;

import me.rusty.rustycore.Core;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Home implements CommandExecutor {
	
	public static HashMap<UUID, Location> home = new HashMap<>();

	@Override
	public boolean onCommand(CommandSender sender, Command command, String cmd,
			String[] arg3) {
		
		Player player = (Player) sender;
		
		if (cmd.equalsIgnoreCase("sethome")) {
			
			home.put(player.getUniqueId(), player.getLocation());
			
		}
		
		else if (cmd.equalsIgnoreCase("home")) {
			
	        new BukkitRunnable() {
	        	 
	            @Override
	            public void run() {
	            
	            	player.teleport(home.get(player.getUniqueId()));
	            	
	            }
	 
	        }.runTaskLater(Core.getInstance(), 5 * 20);
	        
			player.sendMessage(ChatColor.GREEN
					+ "You will be teleported in 5 seconds.");
			
			if (!home.containsKey(player.getUniqueId())) {
				
				player.sendMessage(ChatColor.GREEN + "You have no home set.");
				
			}
			
		}
		
		return true;
	}
	
	

}
