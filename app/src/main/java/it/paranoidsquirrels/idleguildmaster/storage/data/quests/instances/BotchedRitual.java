package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest;
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager;

/* JADX INFO: loaded from: classes3.dex */
public class BotchedRitual extends Quest {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
    public void calculateTargetProgress(int i) {
        this.targetProgress = 5L;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
    protected void configure() {
        this.idName = R.string.quest_botched_ritual_name;
        this.idDescription = R.string.quest_botched_ritual_description;
        this.defaultRarity = 2;
        this.minimumDifficulty = 8;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
    public void realignStaticReference() {
        QuestsManager.botchedRitual = this;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
    public Quest cannotAppearWith() {
        return QuestsManager.endlessAgony;
    }
}
