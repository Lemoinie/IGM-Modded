# Redeem Code Lockdown

Disable all vanilla redeem codes that grant items, heroes, and equipment.
Only `Z3gAAzrt` remains active and **unchanged** (still grants the lvl-100 Semi pet).
All blocked codes silently blink red (treated as unknown), preventing players
from fast-tracking progression.

---

## Scope

Two files contain redeem logic:

| File | Role |
|------|------|
| `DialogRedeemCode.kt` | UI dialog — vanilla `when (prefix)` branches |
| `RedeemCodes.kt` | Mod extension — dev commands + `Z3gAAzrt` |

---

## Codes After This Change

### DialogRedeemCode.kt

| Code (prefix) | Current Effect | Action |
|---|---|---|
| `g75nfkf4` | 500 gems | KEEP |
| `fj9rf8hh` | 100 gems | KEEP |
| `e44ttr7z` | 2 000 gems | KEEP |
| `vrd75ywc` | 1 000 gems | KEEP |
| `vrt4983y` | 500 gems | KEEP |
| `DEBUG000` | Share save file via email | KEEP (no game advantage) |
| `f3hqt045` | Grant any item by name | **DISABLE** |
| `g394te91` | Grant any item with count | **DISABLE** |
| `rotdrv9d` | Large item/equipment bundle | **DISABLE** |
| `f1r29u15` | Adventurer + items bundle | **DISABLE** |
| `brttr5g5` | Unlock seen-enemies entries | **DISABLE** |
| `UNLOCKME` | Retroactively unlock achievements | **DISABLE** |

### RedeemCodes.kt

| Code | Current Effect | Action |
|---|---|---|
| `Z3GAAZRT` | Lvl-100 Semi pet | KEEP |
| Dev codes | ITEM, HERO, PET… | Already blocked in release builds |

---

## Proposed Changes

### [MODIFY] DialogRedeemCode.kt

Delete the 6 disabled `when` branches entirely. They fall through to the
existing `else -> blinkInput()`.

Branches removed: `f3hqt045`, `g394te91`, `rotdrv9d`, `f1r29u15`,
`brttr5g5`, `UNLOCKME`.

Old saves with `isRedeemed_*` flags already true are unaffected — the flags
will simply never be checked again.

### RedeemCodes.kt — no changes

`Z3GAAZRT` keeps its current behaviour (grants lvl-100 Semi with Bloodcrave/Lacerate/Serrated/Savage).
No edits required.

---

## Open Questions

- **`DEBUG000`**: kept (save-share email, no economy impact). Remove if desired.

---

## Verification Plan

`
./gradlew assembleDebug
`

Manual checks:
1. `f3hqt045ScarletStrand` → blink red
2. `g394te911ScarletStrand` → blink red
3. `rotdrv9deq` → blink red
4. `f1r29u15eq` → blink red
5. `Z3gAAzrt` → grants Semi pet, marks redeemed
6. `Z3gAAzrt` again → "Code already redeemed!"
7. `g75nfkf4` → still grants gems normally
