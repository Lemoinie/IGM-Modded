package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest;
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager;

/* JADX INFO: loaded from: classes3.dex */
public class Exorcism extends Quest {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
    public void calculateTargetProgress(int i) {
        this.targetProgress = ((long) i) * 20;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
    protected void configure() {
        this.idName = R.string.quest_exorcism_name;
        this.idDescription = R.string.quest_exorcism_description;
        this.defaultRarity = 4;
        this.minimumDifficulty = 3;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
    public void realignStaticReference() {
        QuestsManager.exorcism = this;
    }
}
