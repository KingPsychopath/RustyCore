package me.rusty.rustycore.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlySpeed implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String cmd,
			String[] args) {
		
		Player player = (Player) sender;
		
		if (cmd.equalsIgnoreCase("flyspeed")
				&& (player.hasPermission("rustycore.staff"))) {

			if (args.length == 0) {

				player.sendMessage(ChatColor.RED + "Invalid Arguments");

			}

			else if (args[0].equalsIgnoreCase("1")) {

				player.setFlySpeed(0.1f);

			}

			else if (args[0].equalsIgnoreCase("2")) {

				player.setFlySpeed(0.2f);

			}

			else if (args[0].equalsIgnoreCase("3")) {

				player.setFlySpeed(0.3f);

			}

			else if (args[0].equalsIgnoreCase("4")) {

				player.setFlySpeed(0.4f);

			}

			else if (args[0].equalsIgnoreCase("5")) {

				player.setFlySpeed(0.5f);

			}

			else if (args[0].equalsIgnoreCase("6")) {

				player.setFlySpeed(0.6f);

			}

			else if (args[0].equalsIgnoreCase("7")) {

				player.setFlySpeed(0.7f);

			}

			else if (args[0].equalsIgnoreCase("8")) {

				player.setFlySpeed(0.8f);

			}

			else if (args[0].equalsIgnoreCase("9")) {

				player.setFlySpeed(0.9f);

			}

			else if (args[0].equalsIgnoreCase("10")) {

				player.setFlySpeed(1f);

			}

		}

		if (!player.hasPermission("rustycore.staff")) {

			player.sendMessage(ChatColor.RED + "Oops, check your permissions.");

		}
			
		return true;
	}

}
