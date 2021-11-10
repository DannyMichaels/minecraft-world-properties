package com.daniel.worldproperties;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	public World world = null;

	@Override
	public void onEnable() {
		System.out.println("world properties plugin enabled!");

		world = Bukkit.getWorld("world"); // .getWorld(worldName)

//		world.setStorm(true); // set whether if world is raining or not
//		world.setThundering(true); // set whether if world is thundering or not
//		world.setTime(14000); // set daytime (starts at 0 and ends at 24000)
//		
//		
//		world.setBiome(0, 10, 0, Biome.BADLANDS); // set biome
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		String cmdName = cmd.getName();
		System.out.println("ARGS: " + args);

		switch (cmdName) {

		case "set_storm":
			if (args[1] != null) {
				world.setStorm(args[1] == "true" ? true : false);
			} else {
				if (world.hasStorm()) {
					world.setStorm(false);
				} else {
					world.setStorm(true);
				}
			}

			break;

		case "set_thunder":
			if (args[1] != null) {
				world.setThundering(args[1] == "true" ? true : false);
			} else {
				if (world.isThundering()) {
					world.setThundering(false);
				} else {
					world.setThundering(true);
				}
			}
			break;

		case "set_time":
			if (args[1] != null) {
				world.setTime(Integer.parseInt(args[1]));
			}

		case "spawn_location":
			sender.sendMessage(world.getSpawnLocation() + "");
		default:
			break;
		}

		return false;
	}

	@Override
	public void onDisable() {

	}
}
