package com.daniel.worldproperties;

import org.bukkit.Bukkit;
import org.bukkit.World;
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

		try {

			String cmdName = cmd.getName();
			System.out.println("args length: " + args.length);

			if (args.length == 1) {
				System.out.println("args[0] " + args[0]);
			}

			switch (cmdName) {

			case "set_storm":
				if (args[0] != null) {
					world.setStorm(Boolean.parseBoolean(args[0])); // parse string to boolean
				} else {
					if (world.hasStorm()) {
						world.setStorm(false);
					} else {
						world.setStorm(true);
					}
				}

				sender.sendMessage(world.hasStorm() + "");
				break;

			case "set_thunder":
				if (args[0] != null) {
					world.setThundering(Boolean.parseBoolean(args[0])); // parse string to boolean
				} else {
					if (world.isThundering()) {
						world.setThundering(false);
					} else {
						world.setThundering(true);
					}
				}

				sender.sendMessage(world.isThundering() + "");
				break;

			case "set_time":
				if (args[0] != null) {
					world.setTime(Integer.parseInt(args[0]));
					sender.sendMessage("Time set to " + Integer.parseInt(args[0]));
				}
				break;
			case "spawn_location":
				sender.sendMessage(world.getSpawnLocation() + "");
				break;
			default:
				break;
			}

			return false;
		} catch (Error error) {
			sender.sendMessage("there was an error running your command");
			return false;
		}
	}
}
