package me.embryogod.persona;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.embryogod.core.MaelstromCore;

public class PersonaCommands implements CommandExecutor {

	
	private MaelstromCore pl;
	
	public PersonaCommands(MaelstromCore pl) {
		this.pl = pl;
	}
	
	// Add set name, age, bio, and the opportunity to switch personas
	// Also add some admin commands to handle whitelisting people here pls thx
	// And don't forget to be able to change a race's string as it appears on the card (moderator commands duh)
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (label.equalsIgnoreCase("persona")) {
			
			Player player = null;
			
			if (sender instanceof Player) {
				player = (Player) sender;
			}
			
			if (args[0].equalsIgnoreCase("set") && player != null) {
			
				if (args[1].equalsIgnoreCase("name")) {
					if (sender instanceof Player) {
						if (args[2] != null) {
							MaelstromCore.onlinePlayers.get(player).setName(args[2]);
						}
					}
				}
				
			} else if (args[0].equalsIgnoreCase("view") && player != null) {
				
				Player targetPlayer = null;
				
				for (Player p : pl.getServer().getOnlinePlayers()) {
					if (p.getName().equalsIgnoreCase(args[3]))
						targetPlayer = p;
				}
				
				if (targetPlayer != null) {
					player.sendMessage("" + new Card(MaelstromCore.onlinePlayers.get(targetPlayer)));
				}
				
			} else if (args[0].equalsIgnoreCase("clearbio") && player != null) {
				
				MaelstromCore.onlinePlayers.get(player).clearBio();
				
			} else if (args[0].equalsIgnoreCase("addbio") && player != null) {
				
				MaelstromCore.onlinePlayers.get(player).addBio(args[1]);
				
				
			} else if (args[0].equalsIgnoreCase("create")) {
				// This will clear the player's current persona and start the process anew
				// For admins, this will be part of the whitelisting process
			}
			
		}
		
		return false;
	}
	
	
	

}
