package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances;

import androidx.work.WorkRequest;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest;
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager;

/* JADX INFO: loaded from: classes3.dex */
public class CriticalHit extends Quest {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
    public void calculateTargetProgress(int i) {
        switch (i) {
            case 1:
                this.targetProgress = 100L;
                break;
            case 2:
                this.targetProgress = 300L;
                break;
            case 3:
                this.targetProgress = 1000L;
                break;
            case 4:
                this.targetProgress = 3000L;
                break;
            case 5:
                this.targetProgress = 5000L;
                break;
            case 6:
                this.targetProgress = 7500L;
                break;
            case 7:
                this.targetProgress = 10000L;
                break;
            case 8:
                this.targetProgress = 13750L;
                break;
            case 9:
                this.targetProgress = 17500L;
                break;
            case 10:
                this.targetProgress = 21250L;
                break;
            default:
                this.targetProgress = 25000L;
                break;
        }
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
    protected void configure() {
        this.idName = R.string.quest_critical_hit_name;
        this.idDescription = R.string.quest_critical_hit_description;
        this.defaultRarity = 1;
        this.minimumDifficulty = 1;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
    public void realignStaticReference() {
        QuestsManager.criticalHit = this;
    }
}
