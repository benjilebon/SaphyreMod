# The Saphyre


Saphyre is a mod that adds a new resource and a new entity to the game :

- The Saphyre is a new generated ore that can be crafted into a crystal that gives you a random item based on how enhanced it is
- Saphyre is also an entity that looks like a dog, it is fleeing humans with very high speed and gives Saphyre on kill


## Current features

- New Ore : The Saphyre Ore
- New entity : Saphyre
- New Advancements
- New Items : Saphyre (with its modified version : Enhanced, Amazing, Incredible & Ultimate)

## Planned features

- See todos in the project (mostly inside SaphyreMain.java)


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

