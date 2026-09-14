package it.paranoidsquirrels.idleguildmaster.storage.data.quests

import java.util.Objects

abstract class Quest {
    companion object {
        private const val CLASS_PATH = "it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances.%s"
        const val RARITY_COMMON: Int = 1
        const val RARITY_UNCOMMON: Int = 2
        const val RARITY_RARE: Int = 3
        const val RARITY_EPIC: Int = 4

        @JvmStatic
        fun createInstance(str: String, rarity: Int, difficulty: Int, progress: Int): Quest? {
            val quest = getInstance(str, rarity, progress) ?: return null
            quest.calculateTargetProgress(difficulty)
            return quest
        }

        @JvmStatic
        fun loadInstance(str: String, rarity: Int, targetProgress: Int, progress: Int): Quest? {
            val quest = getInstance(str, rarity, progress) ?: return null
            quest.targetProgress = targetProgress.toLong()
            quest.activate()
            return quest
        }

        private fun getInstance(str: String, rarity: Int, progress: Int): Quest? {
            return try {
                val clazz = Class.forName(String.format(CLASS_PATH, str))
                val quest = clazz.getConstructor().newInstance() as Quest
                quest.trueClass = str
                val actualRarity = if (rarity == 0) quest.defaultRarity else rarity
                quest.rarity = actualRarity
                quest.progress = progress.toLong()
                quest.active = false
                quest.configure()
                quest
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }
    }

    @JvmField @Transient protected var active: Boolean = false
    @JvmField @Transient protected var defaultRarity: Int = 0
    @JvmField @Transient protected var idDescription: Int = 0
    @JvmField @Transient protected var idName: Int = 0
    @JvmField @Transient protected var minimumDifficulty: Int = 0
    @JvmField protected var progress: Long = 0L
    @JvmField protected var rarity: Int = 0
    @JvmField protected var targetProgress: Long = 0L
    @JvmField protected var trueClass: String = ""

    abstract fun calculateTargetProgress(difficulty: Int)
    open fun cannotAppearWith(): Quest? = null
    protected abstract fun configure()
    abstract fun realignStaticReference()

    open fun getTrueClass(): String = trueClass
    open fun getProgress(): Long = progress
    open fun setProgress(j: Long) { progress = j }
    open fun getTargetProgress(): Long = targetProgress
    open fun getRarity(): Int = rarity
    open fun setRarity(i: Int) { rarity = i }
    open fun getIdName(): Int = idName
    open fun getIdDescription(): Int = idDescription
    open fun getDefaultRarity(): Int = defaultRarity
    open fun getMinimumDifficulty(): Int = minimumDifficulty
    open fun isActive(): Boolean = active
    open fun activate() { active = true }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other is Quest) return trueClass == other.trueClass
        return false
    }

    override fun hashCode(): Int = Objects.hash(trueClass)
}
