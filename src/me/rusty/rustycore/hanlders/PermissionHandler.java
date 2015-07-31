package me.rusty.rustycore.hanlders;

import java.util.HashMap;
import java.util.UUID;

import me.rusty.rustycore.Core;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.permissions.PermissionAttachment;

public class PermissionHandler implements Listener {
	
	public static HashMap<UUID, String> ranks = new HashMap<>();
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		Player player = (Player) event.getPlayer();
		
		PermissionAttachment perms = player.addAttachment(Core.plugin);
		
		if (!player.hasPlayedBefore()) {
			
			//ranks.put(key, value)
			
			if (player.getUniqueId().toString().equals("fdb63a2b-994f-4276-82e9-06ae2ac75f1d")) {
				
				ranks.put(player.getUniqueId(), "Owner");
				
			}
			
			else if (player.getUniqueId().toString().equals("2dadc524-df17-4215-9bc5-99b88c4ca0c5")) {
				
				ranks.put(player.getUniqueId(), "Mod");
				
			}
			
			else if (player.getUniqueId().toString().equals("e583093f-11dd-42ed-b0fb-c4d3c02cd28f")) {
				
				ranks.put(player.getUniqueId(), "Mod");
				
			}
			
			else if (player.getUniqueId().toString().equals("6936a1f2-dcd1-400e-ae12-87fa0f70eafe")) {
				
				ranks.put(player.getUniqueId(), "Admin");
				
			}
			
			else {
				
				ranks.put(player.getUniqueId(), "Member");
				
			}
			
		}
		
		if (ranks.get(player.getUniqueId()).equals("Owner")) {
			
			perms.setPermission("rustycore.owner", true);
			
		}
		
		else if (ranks.get(player.getUniqueId()).equals("Admin")) {
			
			perms.setPermission("rustycore.admin", true);
			
		}
		
		else if (ranks.get(player.getUniqueId()).equals("Mod")) {
			
			perms.setPermission("rustycore.mod", true);
			
		}
		
		else if (ranks.get(player.getUniqueId()).equals("Member")) {
			
			perms.setPermission("rustycore.member", true);
			
		}
		
	}

}
