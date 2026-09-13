package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest;
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager;

/* JADX INFO: loaded from: classes3.dex */
public class Psychiatrist extends Quest {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
    public void calculateTargetProgress(int i) {
        this.targetProgress = 1000L;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
    protected void configure() {
        this.idName = R.string.quest_psychiatrist_name;
        this.idDescription = R.string.quest_psychiatrist_description;
        this.defaultRarity = 1;
        this.minimumDifficulty = 4;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
    public void realignStaticReference() {
        QuestsManager.psychiatrist = this;
    }
}
