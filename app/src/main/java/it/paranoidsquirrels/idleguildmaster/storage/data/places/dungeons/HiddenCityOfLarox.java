package it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons;

import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutDungeonBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Event;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger;
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class HiddenCityOfLarox extends Area {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getAreaType() {
        return 0;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getDarkness() {
        return 8;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getName() {
        return R.string.dungeon_name_hidden_city_of_larox;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getSummaryDrawable() {
        return R.drawable.summary_hidden_city_of_larox;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public int getDetailDrawable() {
        return R.drawable.area_hidden_city_of_larox;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LayoutDungeonBinding getLayout() {
        return MainActivity.dungeonsFragment.getBinding().hiddenCityOfLarox;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected List<Enemy> rollEnemies() {
        double dRandom = Utils.random() * 1000.0d;
        if (dRandom >= 464.0d) {
            return new CopyOnWriteArrayList();
        }
        if (dRandom < 25.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Imp")));
        }
        if (dRandom < 50.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("MagicArmor")));
        }
        if (dRandom < 75.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Imp"), Enemy.getInstance("Imp")));
        }
        if (dRandom < 100.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("MagicArmor"), Enemy.getInstance("MagicArmor")));
        }
        if (dRandom < 125.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Imp"), Enemy.getInstance("NexusResearcher")));
        }
        if (dRandom < 150.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Imp"), Enemy.getInstance("MagicArmor")));
        }
        if (dRandom < 175.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("NexusResearcher"), Enemy.getInstance("MagicArmor")));
        }
        if (dRandom < 200.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("MagicArmor"), Enemy.getInstance("WizardOfLarox")));
        }
        if (dRandom < 222.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Imp"), Enemy.getInstance("Imp"), Enemy.getInstance("Imp")));
        }
        if (dRandom < 244.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("MagicArmor"), Enemy.getInstance("NexusResearcher"), Enemy.getInstance("MagicArmor")));
        }
        if (dRandom < 266.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Imp"), Enemy.getInstance("NexusResearcher"), Enemy.getInstance("MagicArmor")));
        }
        if (dRandom < 288.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("MagicArmor"), Enemy.getInstance("NexusResearcher"), Enemy.getInstance("WizardOfLarox")));
        }
        if (dRandom < 310.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("WizardOfLarox"), Enemy.getInstance("MagicArmor"), Enemy.getInstance("WizardOfLarox")));
        }
        if (dRandom < 332.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Imp"), Enemy.getInstance("MagicArmor"), Enemy.getInstance("WizardOfLarox")));
        }
        if (dRandom < 354.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("MagicArmor"), Enemy.getInstance("WizardOfLarox"), Enemy.getInstance("MagicArmor")));
        }
        if (dRandom < 376.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("MagicArmor"), Enemy.getInstance("WizardOfLarox"), Enemy.getInstance("NexusResearcher"), Enemy.getInstance("MagicArmor")));
        }
        if (dRandom < 398.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("MagicArmor"), Enemy.getInstance("WizardOfLarox"), Enemy.getInstance("ArchmageOfLarox"), Enemy.getInstance("MagicArmor")));
        }
        if (dRandom < 420.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("MagicArmor"), Enemy.getInstance("WizardOfLarox"), Enemy.getInstance("NexusResearcher"), Enemy.getInstance("Imp")));
        }
        if (dRandom < 442.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("Imp"), Enemy.getInstance("NexusResearcher"), Enemy.getInstance("WizardOfLarox"), Enemy.getInstance("Imp")));
        }
        if (dRandom < 464.0d) {
            return new CopyOnWriteArrayList(Arrays.asList(Enemy.getInstance("MagicArmor"), Enemy.getInstance("WickedTribute"), Enemy.getInstance("NexusResearcher"), Enemy.getInstance("MagicArmor")));
        }
        return new CopyOnWriteArrayList();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected void searchRoom() {
        double dRandom = Utils.random() * 1000.0d;
        if (this.event == null || dRandom < 200.0d) {
            this.event = new Event(Event.MAGIC_AMPLIFICATION);
            this.event.setProgress((int) (Utils.random() * 100.0d));
            Logger.log(this, 109, Integer.valueOf((int) ((magicDamageAmplification() * 100.0d) - 100.0d)));
            return;
        }
        if (dRandom < 230.0d) {
            trapEncounter(R.string.log_hidden_city_of_larox_finding_1, R.string.intelligence, 50, 100, true);
            return;
        }
        if (dRandom >= 260.0d) {
            if (dRandom < 280.0d) {
                for (Adventurer adventurer : this.adventurersExploring) {
                    adventurer.setCurrentHp(adventurer.calculateTotalMaxHp());
                    adventurer.getNegativeStatusEffects().clear();
                }
                refreshDialog();
                Logger.log(this, 102, Integer.valueOf(R.string.log_hidden_city_of_larox_finding_3));
                return;
            }
            Logger.log(this, 41, new Object[0]);
            return;
        }
        Logger.log(this, 101, Integer.valueOf(R.string.log_hidden_city_of_larox_finding_2));
        StatusEffect statusEffect = new StatusEffect(StatusEffectType.ABLAZE, null, 5, 0.85d);
        StatusEffect statusEffect2 = new StatusEffect(StatusEffectType.FROZEN, null, 5, 0.85d);
        StatusEffect statusEffect3 = new StatusEffect(StatusEffectType.SILENCE, null, 5, 0.85d);
        for (Adventurer adventurer2 : this.adventurersExploring) {
            if (adventurer2.getCurrentHp() > 0) {
                applyStatus(adventurer2, statusEffect, 0.0d);
                applyStatus(adventurer2, statusEffect2, 0.0d);
                applyStatus(adventurer2, statusEffect3, 0.0d);
            }
        }
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected void triggerEvent(String str) {
        str.hashCode();
        switch (str) {
            case "enter_room":
                double dRandom = Utils.random();
                if (dRandom < 0.1d) {
                    Logger.log(this, 100, Integer.valueOf(R.string.log_hidden_city_of_larox_room_1));
                    break;
                } else {
                    if (dRandom < 0.2d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_hidden_city_of_larox_room_2));
                    } else if (dRandom < 0.3d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_hidden_city_of_larox_room_3));
                    } else if (dRandom < 0.4d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_hidden_city_of_larox_room_4));
                    } else if (dRandom < 0.5d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_hidden_city_of_larox_room_5));
                    } else if (dRandom < 0.6d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_hidden_city_of_larox_room_6));
                    } else if (dRandom < 0.7d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_hidden_city_of_larox_room_7));
                    } else if (dRandom < 0.8d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_hidden_city_of_larox_room_8));
                    } else if (dRandom < 0.9d) {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_hidden_city_of_larox_room_9));
                    } else {
                        Logger.log(this, 100, Integer.valueOf(R.string.log_hidden_city_of_larox_room_10));
                    }
                    break;
                }
                            case "fight_start":
                double dRandom2 = Utils.random();
                if (dRandom2 < 0.2d) {
                    Logger.log(this, 101, Integer.valueOf(R.string.log_hidden_city_of_larox_encounter_1));
                    break;
                } else {
                    if (dRandom2 < 0.4d) {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_hidden_city_of_larox_encounter_2));
                    } else if (dRandom2 < 0.6d) {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_hidden_city_of_larox_encounter_3));
                    } else if (dRandom2 < 0.8d) {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_hidden_city_of_larox_encounter_4));
                    } else {
                        Logger.log(this, 101, Integer.valueOf(R.string.log_hidden_city_of_larox_encounter_5));
                    }
                    break;
                }
                            case "kill_ArchmageOfLarox":
                QuestsManager.increment(QuestsManager.coupDEtat, 1L);
                break;
            case "kill_WickedTribute":
                QuestsManager.increment(QuestsManager.fromHell, 1L);
                break;
            case "enter_dungeon":
                Logger.log(this, 100, Integer.valueOf(R.string.log_hidden_city_of_larox_enter));
                break;
        }
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Area, Integer> listAreasUnlocked() {
        LinkedHashMap<Area, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(MainActivity.data.getLostLands(), 100);
        return linkedHashMap;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public List<Enemy> listEnemies() {
        return Arrays.asList(Enemy.getInstance("Imp"), Enemy.getInstance("MagicArmor"), Enemy.getInstance("NexusResearcher"), Enemy.getInstance("WizardOfLarox"), Enemy.getInstance("ArchmageOfLarox"), Enemy.getInstance("WickedTribute"));
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Item, Integer> rollMerchantRegularOffers() {
        LinkedHashMap<Item, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(Item.getInstance("SpellwovenHide", 6), 326);
        linkedHashMap.put(Item.getInstance("AnimatedScraps", 9), 326);
        linkedHashMap.put(Item.getInstance("LaroxianFabric", 3), 326);
        linkedHashMap.put(Item.getInstance("VeilBreaker", 1), 11);
        linkedHashMap.put(Item.getInstance("UnstableGem", 1), 11);
        return linkedHashMap;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    public LinkedHashMap<Item, Integer> rollMerchantSpecialOffers() {
        LinkedHashMap<Item, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(Item.getInstance("SpellwovenJacket", 1), 90);
        linkedHashMap.put(Item.getInstance("AnimatedCuirass", 1), 91);
        linkedHashMap.put(Item.getInstance("LaroxianRobe", 1), 91);
        linkedHashMap.put(Item.getInstance("AnimatedSword", 1), 91);
        linkedHashMap.put(Item.getInstance("AnimatedStaff", 1), 91);
        linkedHashMap.put(Item.getInstance("AnimatedDagger", 1), 91);
        linkedHashMap.put(Item.getInstance("AnimatedBow", 1), 91);
        linkedHashMap.put(Item.getInstance("AnimatedHelm", 1), 91);
        linkedHashMap.put(Item.getInstance("AnimatedBuckler", 1), 91);
        linkedHashMap.put(Item.getInstance("LaroxianGloves", 1), 91);
        linkedHashMap.put(Item.getInstance("LaroxianBoots", 1), 91);
        return linkedHashMap;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.places.Area
    protected double magicDamageAmplification() {
        int progress = this.event == null ? 0 : this.event.getProgress();
        if (progress <= 45) {
            return ((((double) progress) * 10.0d) / 900.0d) + 0.5d;
        }
        if (progress < 55) {
            return 1.0d;
        }
        return ((((double) (progress - 54)) * 15.0d) / 900.0d) + 1.0d;
    }
}
