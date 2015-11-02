package me.rusty.rustycore.hanlders;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/* Port 25560 */

public class Kit implements Listener {

	public static void spawnturtle(Player player) {

		/* Turtle Sword */
		ItemStack ts = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta tsm = ts.getItemMeta();
		tsm.setDisplayName(ChatColor.GREEN + "Turtle " + ChatColor.GRAY
				+ "Sword");
		tsm.setLore(Arrays.asList(ChatColor.GOLD + "RusticNetwork"));
		ts.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		ts.addEnchantment(Enchantment.DAMAGE_ALL, 2);
		ts.setItemMeta(tsm);

		ItemStack tf = new ItemStack(Material.COOKED_BEEF, 32);

		player.getInventory().setItem(0, ts);
		player.getInventory().setItem(8, tf);

	}

}
