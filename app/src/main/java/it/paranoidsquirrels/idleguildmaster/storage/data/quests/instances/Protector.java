package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances;

import androidx.work.WorkRequest;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest;
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager;

/* JADX INFO: loaded from: classes3.dex */
public class Protector extends Quest {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
    public void calculateTargetProgress(int i) {
        this.targetProgress = (((long) (i - 1)) * 60000) + 10000L;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
    protected void configure() {
        this.idName = R.string.quest_protector_name;
        this.idDescription = R.string.quest_protector_description;
        this.defaultRarity = 1;
        this.minimumDifficulty = 1;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
    public void realignStaticReference() {
        QuestsManager.protector = this;
    }
}
