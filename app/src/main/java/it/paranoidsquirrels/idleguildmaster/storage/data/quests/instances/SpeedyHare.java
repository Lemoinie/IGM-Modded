package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest;
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager;

/* JADX INFO: loaded from: classes3.dex */
public class SpeedyHare extends Quest {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
    public void calculateTargetProgress(int i) {
        this.targetProgress = (((long) (i - 8)) * 20) + 50;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
    protected void configure() {
        this.idName = R.string.quest_speedy_hare_name;
        this.idDescription = R.string.quest_speedy_hare_description;
        this.defaultRarity = 1;
        this.minimumDifficulty = 8;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
    public void realignStaticReference() {
        QuestsManager.speedyHare = this;
    }
}
