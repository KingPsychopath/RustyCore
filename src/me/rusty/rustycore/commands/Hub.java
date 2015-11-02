package me.rusty.rustycore.commands;

import me.rusty.rustycore.Core;
import me.rusty.rustycore.hanlders.Locations;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

public class Hub implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String cmd,
			String[] args) {
		
		Player player = (Player) sender;
		
			if (cmd.equalsIgnoreCase("hub")) {
				
				if (Bukkit.getServer().getPort() == 25566) {
					
						player.teleport(Locations.hspawn);
					
				}
				
				if (Bukkit.getServer().getPort() == 25567) {
					
			        ByteArrayDataOutput out = ByteStreams.newDataOutput();
			        out.writeUTF("Connect");
			        out.writeUTF("Hub");
			        player.sendPluginMessage(Core.getInstance(), "BungeeCord", out.toByteArray());
					
				}
				
				if (Bukkit.getServer().getPort() == 25568) {
					
			        ByteArrayDataOutput out = ByteStreams.newDataOutput();
			        out.writeUTF("Connect");
			        out.writeUTF("Hub");
			        player.sendPluginMessage(Core.getInstance(), "BungeeCord", out.toByteArray());
					
				}
				
			}
			
		return true;
	}

}
