package it.paranoidsquirrels.idleguildmaster.storage.data.quests.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest;
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager;

/* JADX INFO: loaded from: classes3.dex */
public class Annihilator extends Quest {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
    public void calculateTargetProgress(int i) {
        switch (i) {
            case 2:
                this.targetProgress = 80L;
                break;
            case 3:
                this.targetProgress = 150L;
                break;
            case 4:
                this.targetProgress = 250L;
                break;
            case 5:
                this.targetProgress = 400L;
                break;
            case 6:
                this.targetProgress = 700L;
                break;
            case 7:
                this.targetProgress = 1000L;
                break;
            case 8:
                this.targetProgress = 1500L;
                break;
            case 9:
                this.targetProgress = 2000L;
                break;
            case 10:
                this.targetProgress = 3000L;
                break;
            case 11:
                this.targetProgress = 5000L;
                break;
            default:
                this.targetProgress = 30L;
                break;
        }
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
    protected void configure() {
        this.idName = R.string.quest_annihilator_name;
        this.idDescription = R.string.quest_annihilator_description;
        this.defaultRarity = 1;
        this.minimumDifficulty = 1;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest
    public void realignStaticReference() {
        QuestsManager.annihilator = this;
    }
}
