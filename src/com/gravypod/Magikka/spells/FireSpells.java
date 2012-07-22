package com.gravypod.Magikka.spells;

import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;

import com.gravypod.Magikka.Magikka;

public class FireSpells {
	
	Magikka plugin;
	
	public FireSpells(Magikka plugin) {
		this.plugin = plugin;
	}
	
	
	public void fireSpell(Player player) {
		player.launchProjectile(Fireball.class);
	}
	
	
}
