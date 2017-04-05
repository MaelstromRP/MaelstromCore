package me.embryogod.core;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import me.embryogod.persona.Persona;

/*
 * 
 * TODO:
 * ADD RACES!!!!!!!
 * LET PEOPLE CHANGE PERSONA INFO, SO ADD SAVING WHEN A PERSON CHANGES THAT
 * CHAT PLEASE
 * 
 */

public class MaelstromCore extends JavaPlugin implements Listener {

	// The Online players????
	public static HashMap<Player, Persona> onlinePlayers = new HashMap<Player, Persona>();

	
	// Clears the old onlinePlayers if for whatever reason it stayed in memory, and registers all our events
	@Override
	public void onEnable() {
		onlinePlayers.clear();
		getServer().getPluginManager().registerEvents(this, this);
	}

	// Clears the onlinePlayers for the next loadup
	@Override
	public void onDisable() {
		onlinePlayers.clear();
	}

	// The entire purpose of this is just to load up a persona and add it to the onlinePlayers map
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {

		Player ePlayer = event.getPlayer();
		Persona ePersona = null;
		FileConfiguration personaInfo = Util.loadPersonaInfo(this, ePlayer);
		
		// This is my workaround for having two personas, when they switch personas for whatever reason they set the new one active
		// And it saves
		if (personaInfo.getBoolean("persona_one.isActivePersona")) {
			ePersona = new Persona(personaInfo.getString("persona_one.name"),
					(short) personaInfo.getInt("persona_one.age"),
					Util.getRaceFromString(personaInfo.getString("persona_one.race")),
					personaInfo.getString("persona_one.bio"));
			Inventory inv = Util.StringToInventory(personaInfo.getString("persona_one.inventory"));
			ePlayer.getInventory().setContents(inv.getContents());
			ePlayer.updateInventory();

		} else {
			ePersona = new Persona(personaInfo.getString("persona_two.name"),
					(short) personaInfo.getInt("persona_two.age"),
					Util.getRaceFromString(personaInfo.getString("persona_two.race")),
					personaInfo.getString("persona_two.bio"));
			Inventory inv = Util.StringToInventory(personaInfo.getString("persona_two.inventory"));
			ePlayer.getInventory().setContents(inv.getContents());
			ePlayer.updateInventory();
		}
		
		onlinePlayers.put(ePlayer, ePersona);

	}

	
	// This will save the player's persona information when it's finished
	@EventHandler
	public void onLeave(PlayerQuitEvent event) {

		Player ePlayer = event.getPlayer();
		Persona ePersona = null;
		FileConfiguration personaInfo = Util.loadPersonaInfo(this, ePlayer);
		File personaFile = new File(getDataFolder() + "/" + ePlayer.getUniqueId() + "/persona.yml");
		
		// Checks if it is persona one or persona two that is active, then will save the personaFile respectively
		if (personaInfo.getBoolean("persona_one.isActivePersona")) {
			
			personaInfo.set("persona_one.name", onlinePlayers.get(ePlayer).getName());
			personaInfo.set("persona_one.age", onlinePlayers.get(ePlayer).getName());
			personaInfo.set("persona_one.race", onlinePlayers.get(ePlayer).getName());
			personaInfo.set("persona_one.bio", onlinePlayers.get(ePlayer).getName());
			personaInfo.set("persona_one.inventory", Util.InventoryToString(ePlayer.getInventory()));
			
			
		} else {
			
			personaInfo.set("persona_two.name", onlinePlayers.get(ePlayer).getName());
			personaInfo.set("persona_two.age", onlinePlayers.get(ePlayer).getName());
			personaInfo.set("persona_two.race", onlinePlayers.get(ePlayer).getName());
			personaInfo.set("persona_two.bio", onlinePlayers.get(ePlayer).getName());
			personaInfo.set("persona_two.inventory", Util.InventoryToString(ePlayer.getInventory()));
			
		}
		
		try {
			personaInfo.save(personaFile);
		} catch (IOException e) {
			// This won't ever happen (hopefully)
		}
		
		onlinePlayers.remove(ePlayer);

		
		

	}

}
