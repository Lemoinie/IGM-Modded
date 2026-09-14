package it.paranoidsquirrels.idleguildmaster;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.paranoidsquirrels.idleguildmaster.storage.data.Data;
import it.paranoidsquirrels.idleguildmaster.storage.data.DataDeserializer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Skills;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffectType;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionsDrank;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Trait;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.dungeons.EnchantedForest;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class FunctionalParityTest {

    private Data data;

    @Before
    public void setUp() {
        this.data = new Data();
        MainActivity.data = this.data;
    }

    @Test
    public void test1_ApplicationStartup_DataInitialization() {
        assertNotNull("Data should not be null", this.data);
        assertEquals("Starting tutorial step should be 1", 1, this.data.getTutorialStep());
        assertNotNull("Enchanted Forest must be initialized", this.data.getEnchantedForest());
        assertTrue("Enchanted Forest should be unlocked by default", this.data.getEnchantedForest().isUnlocked());
        assertNotNull("The Desert must be initialized", this.data.getTheDesert());
        assertFalse("The Desert should be locked initially", this.data.getTheDesert().isUnlocked());
        assertEquals("Initial messages should contain 1 message", 1, this.data.getMessagesToShow().size());
    }

    @Test
    public void test2_SaveSerialization_RoundTrip() {
        Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(Data.class, new DataDeserializer()).create();
        this.data.setGems(150L);
        this.data.setMoney(2500L);

        String json = gson.toJson(this.data);
        assertNotNull("Serialized JSON should not be null", json);
        assertFalse("Serialized JSON should not be empty", json.isEmpty());

        Data loaded = gson.fromJson(json, Data.class);
        assertNotNull("Deserialized Data should not be null", loaded);
        assertEquals("Gems should match after round trip", 150L, loaded.getGems());
        assertEquals("Money should match after round trip", 2500L, loaded.getMoney());
        assertTrue("Enchanted Forest should remain unlocked", loaded.getEnchantedForest().isUnlocked());
    }

    @Test
    public void test3_AdventurerCreation_AndStatCalculations() {
        Adventurer footman = Adventurer.getInstance("Footman", 1, 1, 0, null, null, null, Trait.BRUTE, Trait.FERAL, new PotionsDrank(), null, false);
        assertNotNull("Adventurer instance should not be null", footman);
        assertEquals("Class should be Footman", "Footman", footman.getTrueClass());
        assertTrue("Base Max HP should be positive", footman.calculateTotalMaxHp() > 0);
        assertTrue("Base Attack Damage should be positive", footman.calculateMaxAttackDamage() > 0);
        assertEquals("Common trait should be BRUTE", Trait.BRUTE, footman.getTraitCommon());
        assertEquals("Rare trait should be FERAL", Trait.FERAL, footman.getTraitRare());
        assertEquals("Footman default skill should be ACTIVE_MIGHTY_STRIKE", Skills.ACTIVE_MIGHTY_STRIKE, footman.getActiveSkill());
    }

    @Test
    public void test4_Formulas_QuartersAndTavern() {
        assertEquals("Quarters price at level 0 should be 5", 5L, Formulas.getQuartersPrice());
        assertEquals("Tavern capacity at level 0 should be 1", 1, Formulas.getTavernCapacity());
        assertEquals("Storage spaces at level 0 should be 35", 35, Formulas.storageSpaces());
        assertEquals("Total stars to LP at rank 0", 4, Formulas.totalStarsToNextLp(0));
    }

    @Test
    public void test5_ReconstructedSkillCasting_AreaCastMethod() {
        EnchantedForest forest = this.data.getEnchantedForest();
        Adventurer hero = Adventurer.getInstance("Footman", 1, 1, 0, null, null, null, null, null, new PotionsDrank(), null, false);
        hero.setCurrentHp(hero.calculateTotalMaxHp());

        // Footman has ACTIVE_MIGHTY_STRIKE (Case 2 in smali packed switch)
        assertEquals(Skills.ACTIVE_MIGHTY_STRIKE, hero.getActiveSkill());
        List<Entity> targets = forest.cast(hero);
        // Does not throw UnsupportedOperationException!

        // RoyalSwordsman has ACTIVE_EN_GARDE (Applies DEFENSIVE_STANCE in smali)
        Adventurer royalSwordsman = Adventurer.getInstance("RoyalSwordsman", 2, 1, 0, null, null, null, null, null, new PotionsDrank(), null, false);
        assertEquals(Skills.ACTIVE_EN_GARDE, royalSwordsman.getActiveSkill());
        forest.cast(royalSwordsman);

        boolean hasStance = false;
        for (it.paranoidsquirrels.idleguildmaster.storage.data.entities.StatusEffect se : royalSwordsman.getPositiveStatusEffects()) {
            if (se.getType() == StatusEffectType.DEFENSIVE_STANCE) {
                hasStance = true;
                break;
            }
        }
        assertTrue("ACTIVE_EN_GARDE must apply DEFENSIVE_STANCE to caster", hasStance);
    }

    @Test
    public void test6_DungeonCombatSetup() {
        EnchantedForest forest = this.data.getEnchantedForest();
        Adventurer hero = Adventurer.getInstance("Footman", 1, 1, 0, null, null, null, null, null, new PotionsDrank(), null, false);
        hero.setCurrentHp(hero.calculateTotalMaxHp());
        this.data.getAdventurers().add(hero);
        forest.getAdventurersExploringIds().add(hero.getId());

        List<Enemy> enemies = forest.listEnemies();
        assertNotNull("Enchanted Forest should have an enemy pool", enemies);
        assertFalse("Enemy pool should not be empty", enemies.isEmpty());
    }
}
