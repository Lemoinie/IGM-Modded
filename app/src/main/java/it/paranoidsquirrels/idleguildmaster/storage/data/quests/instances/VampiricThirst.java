package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest;
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager;

/* JADX INFO: loaded from: classes3.dex */
public class VampiricThirst extends Quest {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
    public void calculateTargetProgress(int i) {
        this.targetProgress = (long) (Math.pow(1.7d, i - 3) * 5000.0d);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
    protected void configure() {
        this.idName = R.string.quest_vampiric_thirst_name;
        this.idDescription = R.string.quest_vampiric_thirst_description;
        this.defaultRarity = 1;
        this.minimumDifficulty = 4;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
    public void realignStaticReference() {
        QuestsManager.vampiricThirst = this;
    }
}
