package com.gravypod.Magikka.listeners;

import java.util.HashMap;

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
	private HashMap<Player, Integer> fireCast = plugin.fireCasters;

	public PlayerListener(Magikka plugin) {
		this.plugin = plugin;
	}

	@EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
	public void onPlayerInteractEvent(PlayerInteractEvent event) {
		
		if (fireCast.containsKey(event.getPlayer())) {

			if (event.getAction().equals(Action.LEFT_CLICK_AIR)) {
				
				Player player = event.getPlayer();

				if ((player != null) && (player.getItemInHand().getType().equals(Material.STICK))) {
					
					int timesUsed = fireCast.get(event.getPlayer()).intValue();
					
					if (timesUsed <= 3) {
						
						new FireSpells(plugin).fireSpell(player);
						fireCast.put(player, ++timesUsed);
						return;
						
					} else {
						fireCast.remove(player);
						player.sendMessage("You are out of casts for FireBalls");
						return;
					}
					
				}

			} else {
				return;
			}
		}
	
	}
}
