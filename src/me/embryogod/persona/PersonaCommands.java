package me.embryogod.persona;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

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
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	

}
