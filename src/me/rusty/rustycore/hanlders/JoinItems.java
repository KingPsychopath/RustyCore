package me.rusty.rustycore.hanlders;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

public class JoinItems {

	public static void spawnItems(Player player) {

		ItemStack nav = new ItemStack(Material.COMPASS);
		ItemMeta navm = nav.getItemMeta();
		navm.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Navigation");
		nav.setItemMeta(navm);

		ItemStack hide = new ItemStack(Material.SLIME_BALL);
		ItemMeta hidem = hide.getItemMeta();
		hidem.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD
				+ "Hide/Show Players");
		hide.setItemMeta(hidem);

		ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
		BookMeta bookm = (BookMeta) book.getItemMeta();
		bookm.setAuthor(ChatColor.AQUA + "RusticFX");
		bookm.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD
				+ "Game Types");
		bookm.addPage(ChatColor.RED
				+ ""
				+ ChatColor.BOLD
				+ "Rustic"
				+ ChatColor.GRAY
				+ ""
				+ ChatColor.BOLD
				+ "Network"
				+ ChatColor.DARK_GRAY
				+ "\n \n Welcome to RusticNetwork, where you can play all types of different games."
				+ "\n \n"
				+ ChatColor.GREEN
				+ ""
				+ ChatColor.BOLD
				+ "Factions"
				+ ChatColor.DARK_GRAY
				+ "\n"
				+ "Factions is where you can play with your friends, and try to raid, capture, and destroy other players bases!");
		bookm.addPage(ChatColor.GREEN
				+ ""
				+ ChatColor.BOLD
				+ "Creative"
				+ "\n"
				+ ChatColor.DARK_GRAY
				+ "Creative is where you can unleash your creativity on 129x129 plots. Show off, have fun, and maybe win build of the month!");
		book.setItemMeta(bookm);

		player.getInventory().clear();

		player.getInventory().setItem(2, book);
		player.getInventory().setItem(4, nav);
		player.getInventory().setItem(6, hide);

	}

}
