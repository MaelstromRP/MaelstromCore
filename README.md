# MaelstromCore

This is the project for my up and coming Minecraft Roleplay Server, Maelstrom RolePlay. 

The project is divided into 3 packages which contain their respective functions.

# Core
Core is the main package where all of the code eventually gets run at. It contains MaelstromCore.java, which handles new players via a HashMap and all of the java-y goodness.

It also contains Util.java, which has some nifty functions for loading the Persona information files, saving cutomized inventories, and so on and so forth. 

# Persona
Persona is the package that handles the meat of creating and maintaining a persona. This includes a CommandExecutor which will handle all Administrative and Player-based commands, a Persona class which handles all the information regarding a persona, an enum for Races (I've decided that for the sake of speed on the server, Races will be hard programmed in, instead of done through a config file), and a Card class which will display all of the Persona's information when properly interacted with.

# Chat
This package will eventually contain all chat events and functions, including chat channels for Global OOC, Local OOC, General RolePlay, and most other forms of RolePlay. It also will handle ModeratorChat, TeamChat, and the like.  
