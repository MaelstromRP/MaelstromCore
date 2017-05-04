# MaelstromCore

This is going to be the core plugin for the Maelstrom Roleplay server. Below will list out the Directories and what each one is responsible for.
I want this plugin to work based off modules, so you can basically load a module in the Main class that handles whatever you want done, for instance a module for Personas. That way most of the code can be abstract, and changing one small thing in one bit of code doesn't mess with the rest of the program.

# Core

This includes the Main class (located in MaelstromCore) as well as a utilities class. The Util class serves as the backbone, providing ambiguous infrastructure to the rest of the program (i.e saving a player's inventory, loading a player's inventory, saving YML files, loading YML files).

# Persona

This has a class layout for Personas, a class for Commands, an Enum for races (which as of right now are all temporary), and a Card class that will display the player's information on an event.
Any events related to Personas (i.e their creation, when a player talks, etc. etc.) will all be found here for ease of access, and named appropriately.
