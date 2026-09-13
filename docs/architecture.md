# Project Architecture

## Overview
Reconstruction of the vanilla Idle Guild Master (v2.148) codebase as a modern, maintainable native Android project targeting API 35 (Android 15) with minimum API 26 (Android 8.0).

## Module Layout
- pp/ - Main Android application module
  - src/main/res/ - Original vanilla layout XMLs, drawables, fonts, and strings
  - src/main/assets/ - Game binary assets, SFX, and metadata
  - src/main/java/ - Reconstructed vanilla Java sources (staged baseline)
  - src/main/kotlin/ - Target idiomatic Kotlin architecture (domain, game, data, ui)

## Target Architecture
The long-term Kotlin layout separates concerns into:
`
it.paranoidsquirrels.idleguildmaster/
├── domain/      # Pure domain models (Adventurers, Items, Traits, Skills, Enemies)
├── data/        # Persistence, JSON save serialization, repositories, asset loaders
├── game/        # Core game loops, combat calculations, simulation, idle time formulas
└── ui/          # Activities, Fragments, ViewModels, Dialogs, custom views
`

## Build System
- Gradle 8.9 (Kotlin DSL)
- Android Gradle Plugin 8.5.2
- Kotlin Android 1.9.24
- Java 21 toolchain (target bytecode Java 8 / Dalvik compatible)
- Android DataBinding and ViewBinding enabled
