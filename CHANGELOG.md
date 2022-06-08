# Changelog

Each version has its own version that follows isolated versioning pattern with the following format :

`MAJOR.MINOR.PATCH-MC_VERSION-API`

When a version is ported to a new game release, it starts from the preceding version major.minor numbers

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/)

## [0.3.0-118-FORGE] - 06/06/2022

### Added

- Port to Minecraft 1.18.2
- Textures

### Changed

- Hover gifted items in chat

### Removed

- Saphyre Ingot, in favour of direct smelting to saphyre usable item

## [0.2.0-112-FORGE] - UNRELEASED

### Added

- Ingot smelting
- Drop lists handling in gifting items

### Changed

- Removed anonymous classes initialization on drop lists
- Give item variants when possible

### Fixed

- Fixed inventory full gift still consuming the item while not giving anything

## [0.1.0-112-FORGE] - 20/09/2021

### Added

- Saphyre Ore Generation
- Gifting System
- Saphyre items + upgrades
- Crafting Recipes (except smelting)
- Networking