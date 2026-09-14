# AI Agent Repository Rules

## 1. Purpose

This repository is an Android/Kotlin reconstruction and modding project for **Idle Guild Master**.

All AI agents working in this repository MUST preserve the repository's organization, understand the existing architecture before making changes, and avoid generating unnecessary files or tooling.

The core rule is:

> **Every file must have a reason to exist and a clearly defined home.**

Do not treat the repository as a scratch workspace.

---

# 2. Before Making Changes

Before implementing a feature, fixing a bug, or creating tooling:

1. Read this file completely.
2. Read the root `README.md`.
3. Read relevant files under `docs/` — at minimum read `architecture.md`,
   `build-system.md`, `development.md`, and `scripts.md` before touching source,
   build configuration, or tooling.
4. Read `implementation_plan.md` when working on planned features.
5. Inspect the existing Kotlin architecture before creating new classes.
6. Search the repository for existing implementations before creating new utilities, scripts, helpers, or abstractions.
7. Determine where the new code/artifact belongs **before creating it**.

Do not immediately start generating files.

Prefer modifying or extending an existing appropriate implementation over creating another parallel implementation.

---

# 3. Repository Structure

The repository should follow this general organization:

```text
/
├── .agents/
│   └── AGENTS.md
│
├── app/
│   ├── src/
│   │   ├── main/            (kotlin/, res/, assets/, manifest — java/ is empty legacy)
│   │   ├── test/
│   │   └── androidTest/
│   ├── build.gradle.kts
│   └── build/               Generated output — never edit, never commit
│
├── docs/
│   ├── architecture.md
│   ├── asset-mapping.md
│   ├── build-system.md
│   ├── development.md
│   ├── known-uncertainties.md
│   ├── reverse-engineering.md
│   ├── save-format.md
│   ├── scripts.md
│   └── vanilla-behavior.md
│
├── scripts/
│   ├── build/               build.ps1 (test → build → deploy pipeline)
│   ├── save/                save_manager.ps1, update_save.py
│   └── tools/               scan_ports.ps1
│
├── save_editor/             index.html (browser-based save editor)
│
├── backups/                 LOCAL save snapshots — gitignored, never committed
├── save.json                LOCAL working save — gitignored, never committed
│
├── build.gradle.kts
├── settings.gradle.kts
├── gradle.properties
├── implementation_plan.md
├── README.md
└── ...
```

This is the **logical structure**, not an immutable list of directories.

The structure may evolve when the project grows, but new directories must have a clear purpose.
Do not add files to the root that belong under `app/`, `docs/`, `scripts/`, or `save_editor/`.

---

# 4. Root Directory Rules

Do NOT put arbitrary implementation files, scripts, dumps, experiments, generated files, or temporary files in the repository root.

The root should contain only project-level files such as:

* `README.md`
* `LICENSE`
* `implementation_plan.md`
* Gradle configuration
* repository configuration
* other files that genuinely belong at project level

Examples of files that do NOT belong in the root:

```text
test.py
debug.py
fix.py
patch.py
experiment.py
dump.txt
output.json
classes.txt
temp.txt
new_script.py
test_script.py
```

If a file does not clearly belong in the root, it does not belong in the root.

### Every new file needs a home

Before creating any new file, decide where it belongs using this flow:

```text
Is this application source?            → app/src/main/
Is this a test?                        → app/src/test/ or app/src/androidTest/
Is this reusable development tooling?  → scripts/
Is this project documentation?         → docs/
Is this an experimental/research artifact?  → research/ or another documented location
Is this generated output?              → build/ or another explicitly generated directory
Is this temporary?                     → external/temporary workspace, then delete
Is this a user-facing release artifact? → releases/ or the established release mechanism
```

If the answer is ambiguous, do not create the file yet: search the repository for an
existing equivalent and read `docs/development.md` / `docs/scripts.md` to find the
established home.

### File placement table (quick reference)

| File type                           | Location                                        |
| ----------------------------------- | ----------------------------------------------- |
| Kotlin application code             | `app/src/main/kotlin/`                          |
| Android manifest / resources        | `app/src/main/` (`AndroidManifest.xml`, `res/`, `assets/`) |
| Tests                               | `app/src/test/` / `app/src/androidTest/`        |
| Reusable scripts / tooling          | `scripts/`                                      |
| Documentation                       | `docs/`                                         |
| Build output                        | `app/build/` (generated, never edit/commit)     |
| Gradle cache                        | `.gradle/` (generated, never commit)            |
| Persistent research artifacts       | `research/` (only if the project actually needs it) |
| Temporary files                     | temporary workspace, removed after the task     |
| Local save working copy             | `save.json` (gitignored)                        |
| Save snapshots                      | `backups/` (gitignored)                         |
| Save editor (browser tool)          | `save_editor/`                                  |

Never create a new top-level directory for a single file when an existing category
already fits (see section 16).

---

# 5. Application Code

The application itself is Kotlin.

Application functionality belongs under:

```text
app/src/main/
```

Prefer Kotlin for:

* application logic
* game systems
* mod functionality
* domain models
* services
* repositories
* UI
* persistence logic
* reusable application utilities

Do NOT implement application architecture through Python scripts.

Python is tooling, not application architecture.

---

# 6. Kotlin Architecture

Before creating a new Kotlin class:

1. Search for an existing class that already performs the required responsibility.
2. Determine which architectural layer owns the responsibility.
3. Follow the existing package structure.
4. Reuse existing interfaces/utilities where appropriate.
5. Avoid creating duplicate abstractions.

Do not create generic "Manager", "Helper", "Utils", or "Service" classes unless their responsibility is clear and justified.

Avoid unnecessary abstraction.

Prefer:

```text
one clear responsibility
```

over:

```text
large generic framework
```

---

# 7. Python and Script Policy

Python scripts are allowed, but they are **tooling**, not part of the application's architecture.

Use scripts for tasks such as:

* reverse engineering
* APK/decompiled-data processing
* static analysis
* data extraction
* data conversion
* asset processing
* migration
* save-file processing
* repository analysis
* specialized automation
* generating reports or mappings

Before creating a Python script:

1. Search `scripts/` for an existing script that can be reused.
2. Check whether the task can reasonably be performed by existing Gradle/Kotlin tooling.
3. Determine whether the script is reusable or genuinely one-off.
4. Decide its correct directory before creating it.

---

# 8. Script Placement

Reusable scripts MUST live under `scripts/`.

Organize scripts by purpose.

Examples:

```text
scripts/
├── analysis/
├── assets/
├── build/
├── migration/
├── reverse_engineering/
├── save/
├── testing/
└── tools/
```

Only create a category when there is a real need for it.

Existing categories should be reused whenever possible.

Do not create:

```text
scripts/misc/
scripts/random/
scripts/temp/
scripts/stuff/
scripts/new/
```

unless there is a clearly documented reason.

---

# 9. One-Off Scripts

Do not permanently add a script to the repository just because it was convenient during one task.

If a script is truly one-off:

* use a temporary/external location when possible;
* or place it in an explicitly temporary, gitignored workspace;
* execute it;
* inspect the result;
* remove it when finished.

Do NOT leave dozens of disposable scripts behind.

Bad:

```text
fix1.py
fix2.py
fix_final.py
fix_final2.py
fix_really_final.py
debug.py
debug2.py
test.py
test_new.py
test_new2.py
```

Good:

```text
scripts/reverse_engineering/rebuild_mapping.py
```

when the tool is genuinely reusable.

---

# 10. Script Documentation

A reusable script should make its purpose obvious.

At minimum, its name and location should explain what it does.

For important or non-obvious scripts, document:

* purpose
* inputs
* outputs
* usage
* assumptions
* destructive behavior, if any

If a script becomes an important part of the development workflow, document it in the relevant `docs/` file or README.

---

# 11. Generated Files

Generated files MUST NOT be treated as source code.

Gradle-generated content belongs under:

```text
app/build/
.gradle/
```

or other appropriate generated-output locations.

Do NOT manually edit generated files.

Do NOT place generated output in:

```text
app/src/
docs/
scripts/
repository root
```

unless the generated artifact is intentionally version-controlled and has a documented purpose.

Before committing generated files, determine whether they are actually required.

### Never commit build junk

The following are generated or local artifacts and MUST remain untracked:

```text
.gradle/
app/build/
/build
*.apk
*.aab
local.properties          (machine-specific SDK path)
save.json                 (local save working copy)
save.json.tmp             (save pull staging file)
backups/                  (timestamped save snapshots)
```

- Do **not** `git add -f` these paths, however convenient for debugging.
- Do **not** commit `app/build/` intermediates, generated DataBinding/`R` classes,
  test reports, or APK outputs.
- `local.properties` must never be committed (each developer has their own SDK path).
- If a generated artifact genuinely needs to be tracked, it must be justified and
  documented; the default is exclusion.

---

# 12. Temporary Files and Debug Output

Temporary files, dumps, logs, generated reports, intermediate data, and experiments must not accumulate in source directories.

Examples:

```text
*.tmp
*.dump
*.bak
debug_output.*
test_output.*
dump.*
```

Keep temporary artifacts outside the repository or inside an explicitly gitignored temporary location.

Clean them up when the task is complete.

---

# 13. Reverse Engineering Artifacts

Reverse-engineering artifacts are important, but they must remain distinguishable from production source.

Examples include:

* decompiled code
* extracted metadata
* mappings
* APK analysis
* class trees
* behavioral observations
* reconstructed structures
* uncertainty reports

Permanent knowledge should go into `docs/`.

Large generated/decompiled datasets should live in an appropriate dedicated location rather than being mixed with application source.

Do not duplicate the same information in multiple places without a reason.

---

# 14. Documentation

Important discoveries must be documented.

Relevant documentation includes:

```text
docs/
├── architecture.md       Project/package architecture & where code lives
├── asset-mapping.md      Resource tree, naming, generated R/Binding classes
├── build-system.md       Gradle tasks, versions, APK output, source vs generated
├── development.md        Day-to-day workflow: features, builds, tests, saves
├── known-uncertainties.md  Open/resolved reverse-engineering questions
├── reverse-engineering.md  Origins of the reconstruction & verification workflow
├── save-format.md        On-disk JSON schema and save tooling
├── scripts.md            Inventory of every script/tool
└── vanilla-behavior.md   Verified vanilla quirks & the mod interface
```

Update existing documentation instead of creating duplicate documents.

Before creating a new documentation file, ask:

> Does this information belong in an existing document?

Only create a new document when it represents a genuinely distinct topic.

Documentation should describe the **actual current repository**, not an imagined architecture.

Do not invent behavior that has not been verified.

When something is uncertain, record it as uncertain.

---

# 15. Experiments and Research

Experiments must be clearly separated from production code.

Do not put experimental implementations into `app/src/main/` simply because they are being tested.

When an experiment becomes a real feature:

1. validate the implementation;
2. integrate it into the proper architecture;
3. remove obsolete experimental code;
4. document important findings.

Do not allow abandoned experiments to accumulate indefinitely.

---

# 16. New Directories

Do not create a new top-level directory casually.

Before creating one, determine:

1. What belongs there?
2. Why does the existing structure not already provide a suitable location?
3. Is this category likely to contain multiple related files?
4. Should the content instead belong in `app/`, `docs/`, `scripts/`, `save_editor/`, or a generated-output directory?

A new top-level directory should have a clear architectural purpose.

---

# 17. Reuse Before Creation

Before creating any new:

* script
* utility
* helper
* parser
* converter
* documentation file
* configuration file
* directory
* abstraction

search the repository first.

Prefer:

```text
reuse existing → extend existing → refactor existing → create new
```

Do not create parallel implementations simply because the existing one is not immediately convenient.

---

# 18. File Naming

Names should describe purpose.

Avoid vague names such as:

```text
stuff.kt
misc.py
helper.py
new.py
test2.py
temp.py
final.py
```

Prefer names such as:

```text
SaveDataParser.kt
AssetMappingGenerator.py
ReverseEngineeringReport.md
SaveMigrationTool.py
```

Names should remain understandable months later.

---

# 19. Do Not Fight the Existing Build System

This is a Kotlin/Gradle project.

Prefer existing Gradle tasks and project tooling for:

* compilation
* testing
* packaging
* APK generation
* dependency management
* standard project automation

Do not create a Python replacement for an existing Gradle capability unless there is a specific technical reason.

---

# 20. Validation

After making changes:

1. Check that newly created files are in the correct directories.
2. Check for accidental temporary files.
3. Check for duplicate utilities/scripts.
4. Check that references to moved or renamed files still work.
5. Run the relevant build/test/validation commands.
6. Check that generated files were not accidentally modified as source.
7. Update documentation when architecture or behavior changed.

If a script or file was created only for the task and is no longer needed, remove it.

---

# 21. Repository Hygiene Checklist

Before finishing a task, verify:

```text
[ ] No unnecessary files were created
[ ] No disposable scripts remain
[ ] No scripts were placed in the root
[ ] No application logic was implemented in Python
[ ] Reusable scripts are under scripts/
[ ] Generated files remain in generated/build locations
[ ] No generated files were manually modified
[ ] No build junk, save.json, save.json.tmp, or backups/ contents were committed
[ ] No duplicate utilities were created
[ ] No unnecessary directories were created
[ ] Documentation reflects important changes (check docs/scripts.md when tools change)
[ ] Temporary/debug artifacts were removed
[ ] Existing references were updated after renames/moves
[ ] Relevant tests/builds were run
```

---

# 22. When an Agent Needs a New Tool

If a task appears to require a new script or utility, do not automatically create one.

First determine:

### Case A — Existing tool is sufficient

Reuse it.

### Case B — Existing tool can be extended

Extend it rather than creating another tool.

### Case C — New reusable tool is justified

Create it under the appropriate `scripts/<category>/` directory and document it if necessary.

### Case D — Truly one-off operation

Use a temporary location and remove the artifact afterward.

---

# 23. Avoid Over-Engineering

Do not introduce architecture merely for the sake of architecture.

Avoid:

* unnecessary frameworks
* excessive abstraction
* wrapper classes with no meaningful behavior
* generic utility libraries
* duplicate configuration systems
* scripts that duplicate Gradle functionality
* elaborate automation for a one-time operation

The simplest structure that correctly solves the problem is preferred.

---

# 24. Documentation Is Part of the Implementation

When an implementation reveals important information about:

* vanilla behavior
* save format
* asset relationships
* reverse-engineered classes
* architecture
* compatibility
* limitations
* known uncertainties

update the appropriate documentation.

Do not rely on the next AI agent rediscovering the same information.

---

# 25. Agent Behavior

AI agents should behave as maintainers of an existing project, not as generators operating in an empty workspace.

Before creating files, think:

> **Where does this belong?**

Before creating a script, think:

> **Does this already exist?**

Before creating an abstraction, think:

> **Can the existing architecture handle this?**

Before leaving a temporary artifact, think:

> **Will someone mistake this for a permanent project file later?**

Before creating a directory, think:

> **Does this represent a real category of project content?**

---

# 26. Core Rules

The following rules take priority over convenience:

1. **Every file must have a reason to exist.**
2. **Every file must have a clearly defined home.**
3. **Do not put junk in the repository root.**
4. **Python is tooling, not application architecture.**
5. **Reuse existing tools before creating new ones.**
6. **One-off scripts should not become permanent repository clutter.**
7. **Generated files are not source files.**
8. **Do not manually modify generated build output.**
9. **Documentation should preserve important reverse-engineering knowledge.**
10. **Do not create duplicate implementations without justification.**
11. **Do not create new top-level directories without a clear purpose.**
12. **Clean up temporary artifacts before finishing.**
13. **Prefer simple, maintainable solutions over unnecessary infrastructure.**
14. **Treat the repository as a maintained software project, not a scratch directory.**
15. **Never commit build junk or local artifacts** (`.gradle/`, `app/build/`,
    `*.apk`, `local.properties`, `save.json`, `backups/`).
16. **Documentation is codebase infrastructure** — record discoveries in `docs/`
    instead of leaving them in an AI conversation.

These rules apply to every future AI-assisted task in this repository.
