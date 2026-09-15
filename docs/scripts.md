# Scripts & Tooling

This document inventories every script and standalone tool in the repository. It is
the authoritative reference for what exists, what it does, and whether it is safe to
run. **Read this before creating any new script** — the usual answer is "reuse or
extend an existing one" (see `.agents/AGENTS.md`).

## Layout

```text
scripts/
├── build/
│   └── build.ps1            Build, test & deploy pipeline for the Android app
├── save/
│   ├── save_manager.ps1     All-in-one save-file manager (pull/push/edit/sync)
│   └── update_save.py       Inject pack heroes/items into a pulled save.json
└── tools/
    └── scan_ports.ps1       TCP port scanner (wireless debugging discovery)

save_editor/
└── index.html               Self-contained browser-based save editor
```

Root-level work files (gitignored, created by the save tools, not source):

```text
save.json      Local working save pulled from a device (gitignored)
backups/       Timestamped snapshots of save.json (gitignored)
```

---

## scripts/build/build.ps1

- **Purpose**: end-to-end dev pipeline — run unit tests, build the debug APK,
  install to a connected Android device (USB or wireless ADB), launch the game,
  optionally stream logcat.
- **Inputs (parameters)**: `-Clean` (gradle clean first), `-Test` (run
  `testDebugUnitTest`), `-NoDeploy` (build only), `-Logcat` (stream logcat after
  launch), `-Device <serial|ip:port>` (target a specific device).
- **Outputs**: debug APK in `app/build/outputs/apk/debug/`; installs it to the
  device; console progress messages.
- **Required for development**: optional convenience — the same tasks are runnable
  directly with `gradlew.bat`.
- **Modifies source?** No.
- **Generates files?** Yes: standard Gradle build output under `app/build/`.
- **Safe to run repeatedly?** Yes (idempotent; incremental via Gradle).
- **Dependencies**: JDK 21, Android SDK for `assembleDebug`; ADB + connected device
  for the deploy step (skipped with `-NoDeploy`).
- **Typical usage**
  ```powershell
  .\scripts\build\build.ps1 -Test -NoDeploy   # test + build, no device
  .\scripts\build\build.ps1 -Test             # test + build + install + launch
  ```

## scripts/save/save_manager.ps1

- **Purpose**: manage the live save while testing the mod — pull a save from the
  device to `save.json`, push it back, snapshot/restore, add gems/gold/heroes,
  unlock all packs, and set up wireless debugging.
- **Inputs (subcommands)**: `pull`, `push`, `backup`, `restore [file]`,
  `add-gems <num>`, `add-gold <num>`, `add-hero <spec>`, `unlock-all`,
  `connect <ip:port> [code]`, `scan [ip]`.
- **Outputs**: `save.json` and timestamped backups in `backups/`; device-side save
  file (`files/data.txt` + `files/databackup.txt`) on push; console messages.
- **Required for development**: optional — for save-driven mod testing.
- **Modifies source?** No.
- **Generates files?** Yes: `save.json`, `save.json.tmp`, `backups/*.json` — all
  gitignored.
- **Safe to run repeatedly?** Yes. `add-hero`/`unlock-all` are additive (they check
## scripts/save/update_save.py

- **Purpose**: Python tool that upgrades a pulled `save.json` in place: marks all
  five paid DLC packs purchased, raises shelter/quarters/max-adventurer capacity,
  appends the 8 pack-exclusive adventurers and 4 pack-exclusive items if missing.
- **Inputs**: `save.json` at the repository root (must already exist — run
  `save_manager.ps1 pull` first).
- **Outputs**: overwrites `save.json` with the updated data; prints a summary
  (`N adventurers, M items`).
- **Required for development**: optional; `save_manager.ps1 unlock-all` covers the
  pack/capacity part, but this script also injects the pack characters/items.
- **Modifies source?** No — only the gitignored `save.json`.
- **Generates files?** Yes: `save.json` (overwritten) only.
- **Safe to run repeatedly?** Yes — idempotent (skips ids/items already present).
- **Dependencies**: Python 3 (stdlib only — `json`, `os`). No pip packages.
- **Typical usage**
  ```powershell
  .\scripts\save\save_manager.ps1 pull
  python .\scripts\save\update_save.py
  .\scripts\save\save_manager.ps1 push
  ```

## scripts/tools/scan_ports.ps1

- **Purpose**: parallel TCP port scanner used to discover the Wireless Debugging
  port of a phone whose IP is known (Android 11+ pairing is often on random ports
  in the 33k–46k range).
- **Inputs (parameters)**: `-ip` (default `192.168.1.3`), `-startPort` (default
  `33000`), `-endPort` (default `46000`).
- **Outputs**: prints `FOUND OPEN PORT: <port>` for each open port found.
- **Required for development**: optional convenience for wireless-ADB setups.
- **Modifies source?** No. **Generates files?** No.
- **Safe to run repeatedly?** Yes.
- **Dependencies**: PowerShell, no add-ins; the target device must be reachable.
- **Typical usage**
  ```powershell
  .\scripts\tools\scan_ports.ps1 -ip 192.168.1.5
  # or through the save manager:
  .\scripts\save\save_manager.ps1 scan 192.168.1.5
  ```

## save_editor/index.html

- **Purpose**: fully client-side web save editor. Open the file in a browser, drag &
  drop a save JSON onto it, then edit resources (gold/gems), adventurers (level,
  traits, weapons, potions, doctrines), items (stacks, max-all), quests, and export
  the result — all in memory, nothing uploaded.
- **Inputs**: a save JSON dropped onto the page (e.g. `save.json` from a pull).
  UTF-8, UTF-8 with BOM, and UTF-16 (LE/BE) with BOM inputs are all accepted.
- **Outputs**: an exported **UTF-8 (no BOM)** JSON file via the in-page export
  button — the encoding the game's `FileManager` expects. (Older versions exported
  UTF-16, which the game could not parse and silently replaced with a fresh save.)
- **Required for development**: optional — an alternative to
  `save_manager.ps1`/`update_save.py` for manual editing.
- **Modifies source?** No. **Generates files?** Only the user-triggered export.
- **Safe to run repeatedly?** Yes.
- **Dependencies**: a modern web browser. No server, no build step, no packages.
- **Typical usage**: double-click `save_editor/index.html` → drag `save.json` →
  edit → Export.

## Policy Notes

- **Never create a new script without checking here first** (and in `app/`,
  `docs/`). Extend an existing tool when possible.
- Do not store transient analysis scripts here; one-off investigations belong to a
  temporary location and are deleted afterward (`.agents/AGENTS.md`).
- `save.json`, `save.json.tmp`, and `backups/` are **local artifacts**; they are
  gitignored and must never be committed.
  for existing ids before inserting duplicates).
- **Dependencies**: PowerShell, `adb`, a connected (or pairable) Android device with
  the rebuilt app installed.
- **Typical usage**
  ```powershell
  .\scripts\save\save_manager.ps1 pull
  .\scripts\save\save_manager.ps1 add-gems 50000
  .\scripts\save\save_manager.ps1 add-hero "DarkKnight,5"
  .\scripts\save\save_manager.ps1 unlock-all
  .\scripts\save\save_manager.ps1 connect 192.168.1.5:37843
  ```