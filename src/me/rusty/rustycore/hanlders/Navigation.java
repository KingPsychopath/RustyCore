package me.rusty.rustycore.hanlders;

import me.rusty.rustycore.Core;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

@SuppressWarnings("deprecation")
public class Navigation implements Listener {

	public static Inventory nav = Bukkit.createInventory(null, 9,
			ChatColor.RED + "" + ChatColor.BOLD + "Choose a server to begin.");


	static {

		ItemStack glass = new ItemStack(Material.STAINED_GLASS, 1,
				DyeColor.LIME.getData());
		ItemMeta glassm = glass.getItemMeta();
		glassm.setDisplayName(ChatColor.GRAY + "");
		glass.setItemMeta(glassm);

		ItemStack creative = new ItemStack(Material.GRASS, 1);
		ItemMeta creativem = creative.getItemMeta();
		creativem.setDisplayName(ChatColor.GREEN + "Creative");
		creative.setItemMeta(creativem);

		ItemStack factions = new ItemStack(Material.DIAMOND_SWORD, 1);
		ItemMeta factionsm = factions.getItemMeta();
		factionsm.setDisplayName(ChatColor.RED + "Factions");
		factions.setItemMeta(factionsm);

		ItemStack skyblock = new ItemStack(Material.BEDROCK, 1);
		ItemMeta skyblockm = skyblock.getItemMeta();
		skyblockm.setDisplayName(ChatColor.AQUA + "SkyBlock");
		skyblock.setItemMeta(skyblockm);

		// First Row
		nav.setItem(0, glass);
		nav.setItem(1, skyblock);
		nav.setItem(2, glass);
		nav.setItem(3, glass);
		nav.setItem(4, creative);
		nav.setItem(5, glass);
		nav.setItem(6, glass);
		nav.setItem(7, factions);
		nav.setItem(8, glass);

	}

	@EventHandler
	public void onClick(PlayerInteractEvent event) {

		Player player = event.getPlayer();

		if (player.getServer().getPort() == 25566) {

			if (event.getAction() == Action.RIGHT_CLICK_AIR
					|| (event.getAction() == Action.RIGHT_CLICK_BLOCK)) {

				if (event.getPlayer().getItemInHand().getType() == Material.COMPASS) {

					player.openInventory(nav);

					event.setCancelled(true);

						player.playSound(player.getLocation(),
 Sound.NOTE_PLING,
							10, 0);


				}

			}

		}

	}

	@EventHandler
	public void onClickInv(InventoryClickEvent event) {

		Player player = (Player) event.getWhoClicked();
		ItemStack clicked = event.getCurrentItem();
		Inventory inventory = event.getInventory();


		if (player.getServer().getPort() == 25566
 && (inventory.equals(nav))) {

			event.setCancelled(true);

			if (clicked.getType() == Material.BED) {

				player.closeInventory();

			}

			else if (clicked.getType() == Material.GRASS) {

				ByteArrayDataOutput out = ByteStreams.newDataOutput();
				out.writeUTF("Connect");
				out.writeUTF("Creative");
				player.sendPluginMessage(Core.getInstance(), "BungeeCord",
						out.toByteArray());

			}

			else if (clicked.getType() == Material.DIAMOND_SWORD) {

				ByteArrayDataOutput out = ByteStreams.newDataOutput();
				out.writeUTF("Connect");
				out.writeUTF("Factions");
				player.sendPluginMessage(Core.getInstance(), "BungeeCord",
						out.toByteArray());

			}

			else if (clicked.getType() == Material.BEDROCK) {

				ByteArrayDataOutput out = ByteStreams.newDataOutput();
				out.writeUTF("Connect");
				out.writeUTF("SkyBlock");
				player.sendPluginMessage(Core.getInstance(), "BungeeCord",
						out.toByteArray());

			}

		}

	}

}
