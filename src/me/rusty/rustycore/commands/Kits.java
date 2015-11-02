package me.rusty.rustycore.commands;

import me.rusty.rustycore.hanlders.Kit;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kits implements CommandExecutor {

	/* Port 25560 */

	@Override
	public boolean onCommand(CommandSender sender, Command command, String cmd,
			String[] args) {

		Player player = (Player) sender;

		if (!(player.getServer().getPort() == 25560)) {

			player.sendMessage(ChatColor.RED
					+ "Oops, check that you are on the correct server.");

		}

		if (cmd.equalsIgnoreCase("kit")) {

			if (args.length == 0) {

				player.sendMessage(ChatColor.RED
						+ "Oops, please enter the kit you would like to recieve.");

			}

			if (args[0].equalsIgnoreCase("turtle")) {

				Kit.spawnturtle(player);
				player.sendMessage(ChatColor.RED
						+ "You have recieved the kit turtle!");

			}

		}

		return true;
	}

}
