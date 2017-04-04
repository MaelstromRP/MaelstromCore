package me.embryogod.persona;

import org.bukkit.ChatColor;

public class Card {

	private String cardInformation;
	
	public Card(Persona persona) {
		StringBuilder cardBuilder = new StringBuilder();
		cardBuilder.append("*********************************************");
		cardBuilder.append(ChatColor.GOLD + "Name: " + persona.getName() + "\n");
		cardBuilder.append(ChatColor.GOLD +"Age:" + persona.getAge() + "\n");
		cardBuilder.append(ChatColor.GOLD +"Race:" + persona.getRace() + "\n");
		cardBuilder.append(ChatColor.WHITE + persona.getBio() + "\n");
		cardBuilder.append("*********************************************");
		cardInformation = cardBuilder.toString();
	}
	
	public String toString() {
		return cardInformation;
	}
	
}
