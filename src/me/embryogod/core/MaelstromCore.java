package me.embryogod.core;

import java.util.HashMap;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.embryogod.persona.Persona;

/*
 * 
 * TODO:
 * ADD RACES!!!!!!!
 * LET PEOPLE CHANGE PERSONA INFO, SO ADD SAVING WHEN A PERSON CHANGES THAT
 * CHAT PLEASE
 * 
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

		} else {
			ePersona = new Persona(personaInfo.getString("persona_two.name"),
					(short) personaInfo.getInt("persona_two.age"),
					Util.getRaceFromString(personaInfo.getString("persona_two.race")),
					personaInfo.getString("persona_two.bio"));
		}
		
		onlinePlayers.put(ePlayer, ePersona);

	}

	
	// This will save the player's persona information when it's finished
	@EventHandler
	public void onLeave(PlayerQuitEvent event) {

		onlinePlayers.remove(event.getPlayer());
		/*
		 * IMPLEMENT SAVE CODE
		 */

	}

}
