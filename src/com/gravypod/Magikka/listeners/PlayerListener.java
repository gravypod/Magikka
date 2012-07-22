package com.gravypod.Magikka.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.gravypod.Magikka.Magikka;
import com.gravypod.Magikka.spells.FireSpells;

public class PlayerListener implements Listener {
	
	Magikka plugin;
	
	public PlayerListener(Magikka plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
	public void onPlayerInteractEvent(PlayerInteractEvent event) {
		
		if (event.getAction().equals(Action.LEFT_CLICK_AIR)) {
			
			Player player = event.getPlayer();
			
			if ((player != null) && (player.getItemInHand().getType().equals(Material.STICK))) {
				new FireSpells(plugin).fireSpell(player);
			}
			
		} else {
			return;
		}
		
	}
	
}
