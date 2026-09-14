package it.paranoidsquirrels.idleguildmaster.ui.dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import it.paranoidsquirrels.idleguildmaster.AchievementsUtils;
import it.paranoidsquirrels.idleguildmaster.Formulas;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.TrueTimeUtils;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.databinding.DialogQuestsBinding;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutQuestBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.Quest;
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class DialogQuests extends CustomDialog {
    private DialogQuestsBinding binding;
    private int completedInThisInstance;
    private Map<ProgressBar, Quest> updateList = new HashMap();

    private int rewardFromRarity(int i, boolean z) {
        if (i == 1) {
            return z ? 10 : 1;
        }
        if (i == 2) {
            return z ? 20 : 2;
        }
        if (i == 3) {
            return z ? 40 : 3;
        }
        if (i != 4) {
            return 1;
        }
        return z ? 100 : 5;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding getBinding() {
        return this.binding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setBinding(ViewBinding viewBinding) {
        this.binding = (DialogQuestsBinding) viewBinding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected String getTitle() {
        return getString(R.string.dialog_quests_title);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        DialogQuestsBinding dialogQuestsBindingInflate = DialogQuestsBinding.inflate(layoutInflater, viewGroup, z);
        this.binding = dialogQuestsBindingInflate;
        return dialogQuestsBindingInflate;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void initialize(Bundle bundle) {
        refreshLpInfo();
        this.updateList.clear();
        setupQuests(this.binding.containerKingsQuests, this.binding.kingsQuestsList, MainActivity.data.getKingsQuests());
        setupQuests(this.binding.containerAfflictionQuests, this.binding.afflictionQuestsList, MainActivity.data.getAfflictionQuests());
        setupQuests(this.binding.containerControlQuests, this.binding.controlQuestsList, MainActivity.data.getControlQuests());
        setupQuests(this.binding.containerFortitudeQuests, this.binding.fortitudeQuestsList, MainActivity.data.getFortitudeQuests());
        setupQuests(this.binding.containerGraceQuests, this.binding.graceQuestsList, MainActivity.data.getGraceQuests());
        setupQuests(this.binding.containerIllusionQuests, this.binding.illusionQuestsList, MainActivity.data.getIllusionQuests());
        setupQuests(this.binding.containerKnowledgeQuests, this.binding.knowledgeQuestsList, MainActivity.data.getKnowledgeQuests());
        setupQuests(this.binding.containerRuinQuests, this.binding.ruinQuestsList, MainActivity.data.getRuinQuests());
        setupQuests(this.binding.containerWarQuests, this.binding.warQuestsList, MainActivity.data.getWarQuests());
        this.binding.scrollView.setVisibility(this.updateList.isEmpty() ? 8 : 0);
        this.binding.noQuestsMessage.setVisibility(this.updateList.isEmpty() ? 0 : 8);
        this.binding.refresh.setVisibility(MainActivity.data.isQuestsRefreshed() ? 8 : 0);
    }

    private void refreshLpInfo() {
        setupLpInfo(this.binding.afflictionLpBonus, this.binding.afflictionProgress, MainActivity.data.getAfflictionLevel(), MainActivity.data.getAfflictionProgress());
        setupLpInfo(this.binding.controlLpBonus, this.binding.controlProgress, MainActivity.data.getControlLevel(), MainActivity.data.getControlProgress());
        setupLpInfo(this.binding.fortitudeLpBonus, this.binding.fortitudeProgress, MainActivity.data.getFortitudeLevel(), MainActivity.data.getFortitudeProgress());
        setupLpInfo(this.binding.graceLpBonus, this.binding.graceProgress, MainActivity.data.getGraceLevel(), MainActivity.data.getGraceProgress());
        setupLpInfo(this.binding.illusionLpBonus, this.binding.illusionProgress, MainActivity.data.getIllusionLevel(), MainActivity.data.getIllusionProgress());
        setupLpInfo(this.binding.knowledgeLpBonus, this.binding.knowledgeProgress, MainActivity.data.getKnowledgeLevel(), MainActivity.data.getKnowledgeProgress());
        setupLpInfo(this.binding.ruinLpBonus, this.binding.ruinProgress, MainActivity.data.getRuinLevel(), MainActivity.data.getRuinProgress());
        setupLpInfo(this.binding.warLpBonus, this.binding.warProgress, MainActivity.data.getWarLevel(), MainActivity.data.getWarProgress());
    }

    private void setupLpInfo(TextView textView, TextView textView2, int i, int i2) {
        textView.setText(i == 0 ? "" : String.format(getString(R.string.dialog_quests_lp_formatted), Integer.valueOf(i)));
        textView2.setText(String.format(getString(R.string.dialog_quests_progress_formatted), Integer.valueOf(Formulas.totalStarsToNextLp(i) - i2)));
        if (i >= 10) {
            textView.setTextColor(getResources().getColor(R.color.ascended_unit, getContext().getTheme()));
            textView2.setTextColor(getResources().getColor(R.color.ascended_unit, getContext().getTheme()));
            textView2.setText(R.string.max);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19, types: [int] */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23, types: [int] */
    /* JADX WARN: Type inference failed for: r1v24, types: [androidx.constraintlayout.widget.ConstraintLayout] */
    /* JADX WARN: Type inference failed for: r1v25, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r1v26, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void setupQuests(ConstraintLayout constraintLayout, final LinearLayout linearLayout, final List<Quest> list) {
        boolean z = true;
        boolean z2 = false;
        boolean z3 = constraintLayout == this.binding.containerKingsQuests;
        boolean z4 = list.size() > 0;
        constraintLayout.setVisibility(z4 ? 0 : 8);
        linearLayout.setVisibility(z4 ? 0 : 8);
        linearLayout.removeAllViews();
        for (final Quest quest : list) {
            final LayoutQuestBinding layoutQuestBindingInflate = LayoutQuestBinding.inflate(getLayoutInflater(), linearLayout, z2);
            this.updateList.put(layoutQuestBindingInflate.questProgress, quest);
            layoutQuestBindingInflate.questName.setText(getString(quest.getIdName()));
            layoutQuestBindingInflate.questDescription.setText(String.format(getString(quest.getIdDescription()), Long.valueOf(quest.getTargetProgress())));
            layoutQuestBindingInflate.questProgress.setProgress(Math.round(Math.min(1.0f, (float) (quest.getProgress() / quest.getTargetProgress())) * 100.0f));
            final int iRewardFromRarity = rewardFromRarity(quest.getRarity(), z3);
            layoutQuestBindingInflate.questReward.setText(z3 ? String.format(getString(R.string.dialog_quests_gems_formatted), Integer.valueOf(iRewardFromRarity)) : formatStars(iRewardFromRarity, false));
            layoutQuestBindingInflate.questRewardClickableText.setText(z3 ? String.format(getString(R.string.dialog_quests_gems_formatted), Integer.valueOf(iRewardFromRarity)) : formatStars(iRewardFromRarity, true));
            layoutQuestBindingInflate.questRewardClickableGems.setVisibility(z3 ? 0 : 8);
            boolean z5 = quest.getProgress() >= quest.getTargetProgress();
            layoutQuestBindingInflate.questRewardClickable.setVisibility(z5 ? 0 : 8);
            layoutQuestBindingInflate.questReward.setVisibility(z5 ? 8 : 0);
            layoutQuestBindingInflate.questRewardGems.setVisibility((!z3 || z5) ? 8 : 0);
            final boolean z6 = z3;
            layoutQuestBindingInflate.questRewardClickable.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogQuests$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogQuests.this.m382x6da0313e(z6, iRewardFromRarity, list, linearLayout, layoutQuestBindingInflate, quest, view);
                }
            });
            linearLayout.addView(layoutQuestBindingInflate.getRoot());
            z = true;
            z2 = false;
        }
    }

    /* JADX INFO: renamed from: lambda$setupQuests$0$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogQuests, reason: not valid java name */
    /* synthetic */ void m382x6da0313e(boolean z, int i, List list, LinearLayout linearLayout, LayoutQuestBinding layoutQuestBinding, Quest quest, View view) {
        if (z) {
            MainActivity.data.setGems(MainActivity.data.getGems() + ((long) i));
            ((MainActivity) MainActivity.dungeonsFragment.getActivity()).refreshGems();
        } else if (list == MainActivity.data.getAfflictionQuests()) {
            int afflictionProgress = Formulas.totalStarsToNextLp(MainActivity.data.getAfflictionLevel()) - MainActivity.data.getAfflictionProgress();
            if (afflictionProgress <= i) {
                MainActivity.data.setAfflictionLevel(MainActivity.data.getAfflictionLevel() + 1);
                MainActivity.data.setAfflictionProgress(i - afflictionProgress);
            } else {
                MainActivity.data.setAfflictionProgress(MainActivity.data.getAfflictionProgress() + i);
            }
        } else if (list == MainActivity.data.getControlQuests()) {
            int controlProgress = Formulas.totalStarsToNextLp(MainActivity.data.getControlLevel()) - MainActivity.data.getControlProgress();
            if (controlProgress <= i) {
                MainActivity.data.setControlLevel(MainActivity.data.getControlLevel() + 1);
                MainActivity.data.setControlProgress(i - controlProgress);
            } else {
                MainActivity.data.setControlProgress(MainActivity.data.getControlProgress() + i);
            }
        } else if (list == MainActivity.data.getFortitudeQuests()) {
            int fortitudeProgress = Formulas.totalStarsToNextLp(MainActivity.data.getFortitudeLevel()) - MainActivity.data.getFortitudeProgress();
            if (fortitudeProgress <= i) {
                MainActivity.data.setFortitudeLevel(MainActivity.data.getFortitudeLevel() + 1);
                MainActivity.data.setFortitudeProgress(i - fortitudeProgress);
            } else {
                MainActivity.data.setFortitudeProgress(MainActivity.data.getFortitudeProgress() + i);
            }
        } else if (list == MainActivity.data.getGraceQuests()) {
            int graceProgress = Formulas.totalStarsToNextLp(MainActivity.data.getGraceLevel()) - MainActivity.data.getGraceProgress();
            if (graceProgress <= i) {
                MainActivity.data.setGraceLevel(MainActivity.data.getGraceLevel() + 1);
                MainActivity.data.setGraceProgress(i - graceProgress);
            } else {
                MainActivity.data.setGraceProgress(MainActivity.data.getGraceProgress() + i);
            }
        } else if (list == MainActivity.data.getIllusionQuests()) {
            int illusionProgress = Formulas.totalStarsToNextLp(MainActivity.data.getIllusionLevel()) - MainActivity.data.getIllusionProgress();
            if (illusionProgress <= i) {
                MainActivity.data.setIllusionLevel(MainActivity.data.getIllusionLevel() + 1);
                MainActivity.data.setIllusionProgress(i - illusionProgress);
            } else {
                MainActivity.data.setIllusionProgress(MainActivity.data.getIllusionProgress() + i);
            }
        } else if (list == MainActivity.data.getKnowledgeQuests()) {
            int knowledgeProgress = Formulas.totalStarsToNextLp(MainActivity.data.getKnowledgeLevel()) - MainActivity.data.getKnowledgeProgress();
            if (knowledgeProgress <= i) {
                MainActivity.data.setKnowledgeLevel(MainActivity.data.getKnowledgeLevel() + 1);
                MainActivity.data.setKnowledgeProgress(i - knowledgeProgress);
            } else {
                MainActivity.data.setKnowledgeProgress(MainActivity.data.getKnowledgeProgress() + i);
            }
        } else if (list == MainActivity.data.getRuinQuests()) {
            int ruinProgress = Formulas.totalStarsToNextLp(MainActivity.data.getRuinLevel()) - MainActivity.data.getRuinProgress();
            if (ruinProgress <= i) {
                MainActivity.data.setRuinLevel(MainActivity.data.getRuinLevel() + 1);
                MainActivity.data.setRuinProgress(i - ruinProgress);
            } else {
                MainActivity.data.setRuinProgress(MainActivity.data.getRuinProgress() + i);
            }
        } else if (list == MainActivity.data.getWarQuests()) {
            int warProgress = Formulas.totalStarsToNextLp(MainActivity.data.getWarLevel()) - MainActivity.data.getWarProgress();
            if (warProgress <= i) {
                MainActivity.data.setWarLevel(MainActivity.data.getWarLevel() + 1);
                MainActivity.data.setWarProgress(i - warProgress);
            } else {
                MainActivity.data.setWarProgress(MainActivity.data.getWarProgress() + i);
            }
        }
        linearLayout.removeView(layoutQuestBinding.getRoot());
        list.remove(quest);
        this.updateList.remove(layoutQuestBinding.questProgress, quest);
        refreshLpInfo();
        this.completedInThisInstance++;
        if (this.updateList.isEmpty()) {
            initialize(null);
        }
        ((MainActivity) getActivity()).refreshIcons();
    }

    private String formatStars(int i, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            if (z && (i2 == 2 || i2 == 4)) {
                sb.append("\n");
            }
            sb.append("★");
        }
        return sb.toString();
    }

    public void refreshCooldowns(int i, int i2, int i3) {
        this.binding.newQuestsTime.setText(String.format(getString(R.string.time_days_hours_minutes), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)));
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void attachListeners() {
        this.binding.refresh.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogQuests$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogQuests.this.m380xcaa4811(view);
            }
        });
        this.binding.close.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogQuests$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogQuests.this.m381xa0e8b7b0(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$1$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogQuests, reason: not valid java name */
    /* synthetic */ void m380xcaa4811(View view) {
        if (MainActivity.shownDialogRefreshQuests != null) {
            return;
        }
        MainActivity.shownDialogRefreshQuests = new DialogRefreshQuests();
        MainActivity.shownDialogRefreshQuests.show(getParentFragmentManager(), "dialog_refresh_quests");
    }

    /* JADX INFO: renamed from: lambda$attachListeners$2$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogQuests, reason: not valid java name */
    /* synthetic */ void m381xa0e8b7b0(View view) {
        dismiss();
    }

    public void update() {
        for (Map.Entry<ProgressBar, Quest> entry : this.updateList.entrySet()) {
            Quest value = entry.getValue();
            entry.getKey().setProgress(Math.round(Math.min(1.0f, (float) (value.getProgress() / value.getTargetProgress())) * 100.0f));
        }
    }

    public void reInitialize() {
        initialize(null);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.completedInThisInstance = 0;
        MainActivity.shownDialogQuests = this;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Utils.refreshCooldowns(TrueTimeUtils.millis());
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        int i;
        QuestsManager.QUEST_NOTIFICATION = notificationValue();
        ((MainActivity) getActivity()).refreshIcons();
        MainActivity.shownDialogQuests = null;
        int questsCompleted = MainActivity.data.getQuestsCompleted();
        if (questsCompleted < 150 && (i = this.completedInThisInstance) > 0) {
            if (questsCompleted < 25) {
                AchievementsUtils.increment(AchievementsUtils.ACHIEVEMENT_BUSY, i);
            }
            AchievementsUtils.increment(AchievementsUtils.ACHIEVEMENT_WORKAHOLIC, this.completedInThisInstance);
            MainActivity.data.setQuestsCompleted(Math.min(150, questsCompleted + this.completedInThisInstance));
        }
        super.onStop();
    }

    private boolean notificationValue() {
        for (Quest quest : MainActivity.data.getKingsQuests()) {
            if (quest.getProgress() >= quest.getTargetProgress()) {
                return true;
            }
        }
        for (Quest quest2 : MainActivity.data.getAfflictionQuests()) {
            if (quest2.getProgress() >= quest2.getTargetProgress()) {
                return true;
            }
        }
        for (Quest quest3 : MainActivity.data.getControlQuests()) {
            if (quest3.getProgress() >= quest3.getTargetProgress()) {
                return true;
            }
        }
        for (Quest quest4 : MainActivity.data.getFortitudeQuests()) {
            if (quest4.getProgress() >= quest4.getTargetProgress()) {
                return true;
            }
        }
        for (Quest quest5 : MainActivity.data.getGraceQuests()) {
            if (quest5.getProgress() >= quest5.getTargetProgress()) {
                return true;
            }
        }
        for (Quest quest6 : MainActivity.data.getIllusionQuests()) {
            if (quest6.getProgress() >= quest6.getTargetProgress()) {
                return true;
            }
        }
        for (Quest quest7 : MainActivity.data.getKnowledgeQuests()) {
            if (quest7.getProgress() >= quest7.getTargetProgress()) {
                return true;
            }
        }
        for (Quest quest8 : MainActivity.data.getRuinQuests()) {
            if (quest8.getProgress() >= quest8.getTargetProgress()) {
                return true;
            }
        }
        for (Quest quest9 : MainActivity.data.getWarQuests()) {
            if (quest9.getProgress() >= quest9.getTargetProgress()) {
                return true;
            }
        }
        return false;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setLayout() {
        getDialog().getWindow().setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.9d), -2);
    }
}
