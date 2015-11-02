package me.rusty.rustycore.hanlders;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class Visibility implements Listener {

	public static List<UUID> oph = new ArrayList<>();

	@EventHandler
	public void onClick(PlayerInteractEvent event) {

		if (event.getAction() == Action.RIGHT_CLICK_AIR
				|| (event.getAction() == Action.RIGHT_CLICK_BLOCK)) {

			if (Bukkit.getServer().getPort() == 25566) {

				if (event.getPlayer().getItemInHand().getType() == Material.SLIME_BALL) {

					if (oph.contains(event.getPlayer().getUniqueId())) {

						event.getPlayer().sendMessage(
								ChatColor.GREEN
										+ "All players have been shown.");
						oph.remove(event.getPlayer().getUniqueId());

						for (Player p : Bukkit.getOnlinePlayers()) {

							event.getPlayer().showPlayer(p);

						}

					}

					else if (!oph.contains(event.getPlayer().getUniqueId())) {

						event.getPlayer().sendMessage(
								ChatColor.GREEN
										+ "All players have been hidden.");
						oph.add(event.getPlayer().getUniqueId());

						for (Player p : Bukkit.getOnlinePlayers()) {

							event.getPlayer().hidePlayer(p);

						}

					}

				}

			}

		}

	}
	
}
