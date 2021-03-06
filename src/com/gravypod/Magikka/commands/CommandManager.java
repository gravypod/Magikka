package com.gravypod.Magikka.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gravypod.Magikka.Magikka;

public class CommandManager implements CommandExecutor {
	
	Magikka plugin;
	
	public CommandManager(Magikka plugin) {
		
		this.plugin = plugin;
	
	}
	
	private enum commandArg {
		fire
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {

		switch (commandArg.valueOf(args[1])) {
		case fire:
			fire(sender);
			return true;
		default:
			sender.sendMessage("That was not a real command");
			return true;
		}
	
	}
	
	private void fire(CommandSender sender) {
		
		if (sender instanceof Player) {
			Player player = (Player) sender;
			
			plugin.fireCasters.put(player, 0);
			
		} else {
			
			sender.sendMessage("You must be in game to use that!");
		
		}
	
	}
	
}
