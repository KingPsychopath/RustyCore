package me.rusty.rustycore.hanlders;

import java.util.ArrayList;
import java.util.UUID;

import me.rusty.rustycore.Core;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class Kits implements CommandExecutor, Listener {
		
		ArrayList<UUID> cooldowns = new ArrayList<>();

	@Override
	public boolean onCommand(CommandSender sender, Command command, String cmd,
			String[] args) {
		
		Player player = (Player) sender;
		
		if (cmd.equalsIgnoreCase("kit")) {
			
			if (args.length == 0 && (player.hasPermission("rustycore.kit.default"))) {
				
				player.sendMessage(Core.prefix + ChatColor.GRAY + "Please select a kit. Avaliable Kits: Default");
				
			}
			
			else if (args.length == 0 && (player.hasPermission("rustycore.kit.default") && (player.hasPermission("rustycore.kit.admin")))) {
				
				player.sendMessage(Core.prefix + ChatColor.GRAY + "Please select a kit. Avaliable Kits: Default, Admin");
				
			}
			
			else if (args[0].equalsIgnoreCase("default") && (player.hasPermission("rustycore.kit.default"))) {
				
					if (player.hasPermission("rustycore.cooldown.bypass") || (!cooldowns.contains(player.getUniqueId()))) {
						
						ItemStack dh = new ItemStack(Material.DIAMOND_HELMET);
						dh.addEnchantment(Enchantment.DURABILITY, 2);
						dh.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
						
						ItemStack dc = new ItemStack(Material.DIAMOND_CHESTPLATE);
						dc.addEnchantment(Enchantment.DURABILITY, 2);
						dc.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
						
						ItemStack dl = new ItemStack(Material.DIAMOND_LEGGINGS);
						dl.addEnchantment(Enchantment.DURABILITY, 2);
						dl.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
						
						ItemStack db = new ItemStack(Material.DIAMOND_BOOTS);
						db.addEnchantment(Enchantment.DURABILITY, 2);
						db.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
						
						ItemStack ds = new ItemStack(Material.COOKED_BEEF);
						ds.setAmount(32);
						
						ItemStack dsw = new ItemStack(Material.DIAMOND_SWORD);
						dsw.addEnchantment(Enchantment.DURABILITY, 1);
						dsw.addEnchantment(Enchantment.DAMAGE_ALL, 1);
						
						player.sendMessage(Core.prefix + ChatColor.GRAY + "You have been given the default kit.");
						player.getInventory().setHelmet(dh);
						player.getInventory().setChestplate(dc);
						player.getInventory().setLeggings(dl);
						player.getInventory().setBoots(db);
						player.getInventory().setItem(8, ds);
						player.getInventory().setItem(0, dsw);
						
						if (!player.hasPermission("rustycore.cooldown.bypass") && (!cooldowns.contains(player.getUniqueId()))) {
							
							cooldowns.add(player.getUniqueId());
							
							 new BukkitRunnable() {
					        	 
						            @Override
						            public void run() {
						            
						            	cooldowns.remove(player.getUniqueId());
						            	
						            }
						 
						        }.runTaskLater(Core.getInstance(), 20 * 60 * 60 * 12);
							
						}
						
					}
					
					else if (cooldowns.contains(player.getUniqueId())) {
						
						player.sendMessage(Core.prefix + ChatColor.GRAY + "You recently issued this command.");
						
					}
				
			}
			
			else if (args[0].equalsIgnoreCase("admin") && (player.hasPermission("rustycore.kit.admin"))) {
				
				ItemStack dh = new ItemStack(Material.DIAMOND_HELMET);
				dh.addEnchantment(Enchantment.DURABILITY, 3);
				dh.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				
				ItemStack dc = new ItemStack(Material.DIAMOND_CHESTPLATE);
				dc.addEnchantment(Enchantment.DURABILITY, 3);
				dc.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				
				ItemStack dl = new ItemStack(Material.DIAMOND_LEGGINGS);
				dl.addEnchantment(Enchantment.DURABILITY, 3);
				dl.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				
				ItemStack db = new ItemStack(Material.DIAMOND_BOOTS);
				db.addEnchantment(Enchantment.DURABILITY, 3);
				db.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
				
				ItemStack ds = new ItemStack(Material.COOKED_BEEF);
				ds.setAmount(64);
				
				ItemStack dsw = new ItemStack(Material.DIAMOND_SWORD);
				dsw.addEnchantment(Enchantment.DURABILITY, 3);
				dsw.addEnchantment(Enchantment.DAMAGE_ALL, 5);
				
				player.sendMessage(Core.prefix + ChatColor.GRAY + "You have been given the default kit.");
				player.getInventory().setHelmet(dh);
				player.getInventory().setChestplate(dc);
				player.getInventory().setLeggings(dl);
				player.getInventory().setBoots(db);
				player.getInventory().setItem(8, ds);
				player.getInventory().setItem(0, dsw);
				
			}
			
			else if (!args[0].equalsIgnoreCase("default") && (!args[0].equalsIgnoreCase("admin"))) {
				
				player.sendMessage(Core.prefix + ChatColor.GRAY + "Invalid arguments, please try again.");
				
			}
			
		}
		
		return true;
	}
	
	

}
