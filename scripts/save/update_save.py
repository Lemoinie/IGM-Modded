import json
import os

repo_root = os.path.abspath(os.path.join(os.path.dirname(__file__), "..", ".."))
save_path = os.path.join(repo_root, "save.json")

if not os.path.exists(save_path):
    print(f"Error: {save_path} does not exist. Pull a save first using save_manager.ps1 pull.")
    exit(1)

with open(save_path, "r", encoding="utf-8-sig") as f:
    data = json.load(f)

# Ensure packs are active
data["starterPackPurchased"] = True
data["adventurerPackPurchased"] = True
data["merchantPackPurchased"] = True
data["imperialVanguardPurchased"] = True
data["unholyCrusadePurchased"] = True

# Ensure capacity
data["maxAdventurersOwned"] = max(data.get("maxAdventurersOwned", 0), 20)
data["upgradeShelter"] = max(data.get("upgradeShelter", 0), 10)
data["upgradeQuarters"] = max(data.get("upgradeQuarters", 0), 10)

empty_potions = {
    "potionOfAgilityDrank": 0,
    "potionOfConstitutionDrank": 0,
    "potionOfDarknessDrank": 0,
    "potionOfDefenseDrank": 0,
    "potionOfDexterityDrank": 0,
    "potionOfHealthDrank": 0,
    "potionOfImmunityDrank": 0,
    "potionOfIntelligenceDrank": 0,
    "potionOfMagicDefenseDrank": 0,
    "potionOfPrecisionDrank": 0,
    "potionOfViciousnessDrank": 0
}

empty_doctrine = {
    "l1": 0,
    "l2": 0,
    "l3": 0,
    "l4": 0,
    "l5": 0,
    "l6": 0,
    "trueClass": "EmptyDoctrine"
}

def create_adventurer(adv_id, true_class, trait_common, trait_rare, weapon_class, level=1):
    return {
        "ascended": False,
        "doctrine": dict(empty_doctrine),
        "experience": 0,
        "id": adv_id,
        "level": level,
        "potionsDrank": dict(empty_potions),
        "seen": False,
        "timeWhenDismissed": 0,
        "traitCommon": trait_common,
        "traitRare": trait_rare,
        "weapon": {
            "stack": 1,
            "trueClass": weapon_class
        },
        "currentHp": 80,
        "currentMana": 60,
        "currentShield": 0,
        "negativeStatusEffects": [],
        "positiveStatusEffects": [],
        "trueClass": true_class
    }

# 8 Characters from Imperial Vanguard & Unholy Crusade
pack_characters = [
    # Imperial Vanguard (4)
    (101, "HolyKnight", "BRUTE_PLUS", "BLESSED", "Spade", 5),
    (102, "WhiteMage", "BOOKWORM_PLUS", "EMPATHETIC", "Cane", 5),
    (103, "RedMage", "BOOKWORM_PLUS", "GIFTED", "Cane", 5),
    (104, "Sureshot", "FERAL_PLUS", "RUTHLESS", "TrainingBow", 5),
    # Unholy Crusade (4)
    (105, "DarkKnight", "BRUTE_PLUS", "FOCUSED", "Spade", 5),
    (106, "Necromancer", "BOOKWORM_PLUS", "CURSED", "Cane", 5),
    (107, "Assassin", "FERAL_PLUS", "RUTHLESS", "Sickle", 5),
    (108, "PoisonBow", "FERAL_PLUS", "ALERT", "TrainingBow", 5)
]

existing_advs = data.get("adventurers", [])
existing_ids = {adv.get("id") for adv in existing_advs}

for adv_id, true_class, trait_common, trait_rare, weapon_class, lvl in pack_characters:
    if adv_id not in existing_ids:
        new_adv = create_adventurer(adv_id, true_class, trait_common, trait_rare, weapon_class, lvl)
        existing_advs.append(new_adv)

data["adventurers"] = existing_advs

# Add Pack Exclusive Items if not in items list
items_list = data.get("items", [])
existing_item_classes = {it.get("trueClass") for it in items_list if isinstance(it, dict) and "trueClass" in it}

pack_items = ["Intercession", "ImperialArmor", "RingOfLife", "ScarletStrand"]
for it_name in pack_items:
    if it_name not in existing_item_classes:
        items_list.append({"stack": 1, "trueClass": it_name})

data["items"] = items_list

with open(save_path, "w", encoding="utf-8") as f:
    json.dump(data, f, indent=2)

print(f"Successfully updated save.json: {len(existing_advs)} adventurers, {len(items_list)} items.")
