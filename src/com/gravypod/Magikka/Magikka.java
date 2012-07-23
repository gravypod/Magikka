package com.gravypod.Magikka;

import java.util.HashMap;
import java.util.logging.Logger;

import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.gravypod.Magikka.listeners.MobListener;
import com.gravypod.Magikka.listeners.PlayerListener;

public class Magikka extends JavaPlugin {
	
	public HashMap<Player, Integer> fireCasters = new HashMap<Player, Integer>(); // Move this to a HashMap; Hold a <Player, Int>; Int = amount of times they used this command
	
	Logger log = Logger.getLogger("Minecraft");
	
	@Override
	public void onEnable() {
		
		log.info("Magikka has started");
		
		registerEvents();
		
	}
	
	@Override
	public void onDisable() {
		
		
		
	}
	
	private void registerEvents() {
		
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new PlayerListener(this), this);
		pm.registerEvents(new MobListener(this), this);
		
	}
}
