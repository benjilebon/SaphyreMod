# Saphyre : The Gacha-Like Minecraft mod


Saphyre is a mod that adds a new resource to the game : The Saphyre

This unique metal has the power and ability to transform to any random item in the game when used

**Saphyre adds a new exciting "gift" kind-of system to the game**


## Current features

- Saphyre Ore Generation in the overworld
- Gifting system
- Craft improved version of saphyre to have better loots !
- Achievements

## Planned features

- See todos in the project (mostly inside SaphyreMain)


# How to install & contribute

## Pre-Requirements

- An IDE (IntelliJ IDEA/Eclipse)
- Java 17
- Git

IntelliJ IDEA can be found here : https://www.jetbrains.com/fr-fr/idea/download/#section=windows
Eclipse can be found here : https://www.eclipse.org/downloads/

## Installation

- Clone this project with git (using CLI/GitHub Desktop/whatever)
- Open the project inside IntelliJ IDEA/Eclipse, wait for indexation..
- Run `./gradlew genIntellijRuns` to generate run configuration (reload IDE if needed)

## To Users of intelliJ IDEA :

- If you get errors during installation, try to refresh gradle dependencies by clicking the sync icon inside Gradle sidebar tab (or `Ctrl+Shift+A` => "Reload all gradle projects"), then run setupDecompWorkspace again
- In the top right bar, click "Edit configurations", and make sure "runClient" has this configuration :

Build and run : `java 17`

Build and run : `-cp saphyre.main (module)`

- Inside File > Project Structure, configure as follow :

Project SDK: 17 (Java 17)

Project Language Level: `17 - Sealed types, always-strict floating-point semantics`

Module > Sources : Language level should be 17 too

- You should be good !

## Run project

- Click on the Run/Debug "runClient" in the top right bar
- Game should start automatically


### License

All project licenses can be found under the licenses folder

