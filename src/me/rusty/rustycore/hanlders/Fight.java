package me.rusty.rustycore.hanlders;

import me.rusty.rustycore.Core;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class Fight implements Listener {
	
	@EventHandler
	public void onFight(EntityDamageByEntityEvent event) {
		
		if (event.getDamager() instanceof Player && (event.getEntity() instanceof Player)) {
			
			Player attacker = (Player) event.getDamager();
			Player attacked = (Player) event.getEntity();
			
			if (attacked.getLocation().getWorld().getName().equals("Spawn") && (attacker.getLocation().getWorld().getName().equals("Spawn"))) {
				
				event.setCancelled(true);
				
				attacker.sendMessage(Core.prefix + ChatColor.GRAY + "No attacking in spawn");
				
			}
			
		}
		
	}

}
