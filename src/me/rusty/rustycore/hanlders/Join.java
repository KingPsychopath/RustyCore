package me.rusty.rustycore.hanlders;

import java.util.Random;

import me.rusty.rustycore.Core;
import me.rusty.rustycore.utils.TitleManager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.GameMode;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.meta.FireworkMeta;

public class Join implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {

		Player player = event.getPlayer();

		if (player.hasPermission("rustycore.hero")) {

			Firework joinfw = (Firework) player.getWorld().spawnEntity(
					player.getLocation(), EntityType.FIREWORK);
			FireworkMeta joinfwm = joinfw.getFireworkMeta();

			Random r = new Random();

			FireworkEffect joinfwe = FireworkEffect.builder()
					.flicker(r.nextBoolean()).withColor(Color.LIME)
					.trail(r.nextBoolean()).build();

			joinfwm.addEffect(joinfwe);

			joinfw.setFireworkMeta(joinfwm);
		}

		if (player.hasPermission("rustycore.titan")) {

			for (Player p : Bukkit.getOnlinePlayers()) {

				TitleManager.sendFullTitle(p, 20, 60, 20, ChatColor.GRAY + "["
						+ ChatColor.RED + "" + ChatColor.BOLD + "TITAN"
						+ ChatColor.GRAY + "",
						ChatColor.GRAY + player.getName()
								+ " has joined the game.");

			}

		}

		if (player.hasPermission("rustycore.staff")) {

			player.setGameMode(GameMode.CREATIVE);

		}

		if (player.hasPermission("rustycore.member")) {

			Core.member.addPlayer(player);

		}

		if (player.hasPermission("rustycore.mod")) {

			Core.mod.addPlayer(player);

		}

		if (player.hasPermission("rustycore.admin")) {

			Core.admin.addPlayer(player);

		}

		if (player.hasPermission("rustycore.owner")) {

			Core.owner.addPlayer(player);

		}

		if (player.hasPlayedBefore()) {

			event.setJoinMessage(ChatColor.GRAY + "[+] " + player.getName());

		}

		if (!player.hasPlayedBefore()) {

			event.setJoinMessage(ChatColor.GRAY + "[+] " + player.getName()
					+ " has joined for the first time!");

		}

		else if (Bukkit.getServer().getPort() == 25566) {

			player.teleport(Locations.hspawn);
			player.setGameMode(GameMode.SURVIVAL);

			TitleManager.sendFullTitle(player, 20, 40, 20, ChatColor.GREEN + ""
					+ ChatColor.BOLD + "Rustic " + ChatColor.WHITE + ""
					+ ChatColor.BOLD + "MC", ChatColor.GRAY
					+ "Welcomes you!");

			JoinItems.spawnItems(player);

		}

		if (Bukkit.getServer().getPort() == 25567) {

			player.teleport(Locations.fspawn);
			player.setGameMode(GameMode.SURVIVAL);

			TitleManager.sendFullTitle(player, 20, 40, 20, ChatColor.GREEN + ""
					+ ChatColor.BOLD + "Rustic " + ChatColor.WHITE + ""
					+ ChatColor.BOLD + "MC", ChatColor.GRAY
					+ "Welcomes you to factions!");

		}

		if (Bukkit.getServer().getPort() == 25568) {

			player.teleport(Locations.cspawn);
			player.setGameMode(GameMode.CREATIVE);

			TitleManager.sendFullTitle(player, 20, 40, 20, ChatColor.GREEN + ""
					+ ChatColor.BOLD + "Rustic " + ChatColor.WHITE + ""
					+ ChatColor.BOLD + "MC", ChatColor.GRAY
					+ "Welcomes you to creative!");

		}

	}

}
