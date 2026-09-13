package it.paranoidsquirrels.idleguildmaster.ui.dialogs;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import androidx.viewbinding.ViewBinding;
import it.paranoidsquirrels.idleguildmaster.BuildConfig;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.databinding.DialogSettingsBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Area;
import it.paranoidsquirrels.idleguildmaster.storage.data.places.Logger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class DialogSettings extends CustomDialog {
    private static Map<Integer, String> languageMap;
    private boolean autoOpenDungeonDetail;
    public DialogSettingsBinding binding;
    private boolean colorblindMode;
    private boolean confirmRetreat;
    private boolean confirmSwap;
    private boolean confirmUpgrade;
    private boolean craftMaxAmount;
    private String language;
    private boolean sellMaxAmount;
    private boolean verboseLogs;

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding getBinding() {
        return this.binding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setBinding(ViewBinding viewBinding) {
        this.binding = (DialogSettingsBinding) viewBinding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected String getTitle() {
        return getString(R.string.drawer_settings_title);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setLayout() {
        getDialog().getWindow().setLayout((int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.9d), -2);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        DialogSettingsBinding dialogSettingsBindingInflate = DialogSettingsBinding.inflate(layoutInflater, viewGroup, z);
        this.binding = dialogSettingsBindingInflate;
        return dialogSettingsBindingInflate;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void initialize(Bundle bundle) {
        this.binding.version.setText(String.format(getString(R.string.drawer_settings_version_number), BuildConfig.VERSION_NAME));
        if (languageMap == null) {
            HashMap map = new HashMap();
            languageMap = map;
            map.put(0, "en");
            languageMap.put(1, "zh");
            languageMap.put(2, "fr");
            languageMap.put(3, "de");
            languageMap.put(4, "it");
            languageMap.put(5, "ja");
            languageMap.put(6, "ko");
            languageMap.put(7, "pl");
            languageMap.put(8, "pt");
            languageMap.put(9, "ru");
            languageMap.put(10, "es");
            languageMap.put(11, "th");
        }
        this.language = getString(R.string.language_code);
        this.sellMaxAmount = MainActivity.data.isSettingSellMaxAmount();
        this.craftMaxAmount = MainActivity.data.isSettingCraftMaxAmount();
        this.confirmUpgrade = MainActivity.data.isSettingConfirmUpgrade();
        this.confirmRetreat = MainActivity.data.isSettingConfirmRetreat();
        this.confirmSwap = MainActivity.data.isSettingConfirmSwap();
        this.autoOpenDungeonDetail = MainActivity.data.isSettingAutoOpenDungeonDetail();
        this.verboseLogs = MainActivity.data.isSettingVerboseLogs();
        this.colorblindMode = MainActivity.data.isSettingColorblindMode();
        ArrayAdapter<CharSequence> arrayAdapterCreateFromResource = ArrayAdapter.createFromResource(getContext(), R.array.drawer_settings_languages, android.R.layout.simple_spinner_item);
        arrayAdapterCreateFromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.binding.languageSpinner.setAdapter((SpinnerAdapter) arrayAdapterCreateFromResource);
        for (Map.Entry<Integer, String> entry : languageMap.entrySet()) {
            if (this.language.equals(entry.getValue())) {
                this.binding.languageSpinner.setSelection(entry.getKey().intValue());
            }
        }
        refreshValues();
    }

    private void refreshValues() {
        this.binding.valueSellAmount.setText(this.sellMaxAmount ? R.string.max : R.string.one);
        this.binding.valueCraftAmount.setText(this.craftMaxAmount ? R.string.max : R.string.one);
        this.binding.valueConfirmUpgrades.setText(this.confirmUpgrade ? R.string.yes : R.string.no);
        this.binding.valueConfirmRetreat.setText(this.confirmRetreat ? R.string.yes : R.string.no);
        this.binding.valueSwapEquipment.setText(this.confirmSwap ? R.string.yes : R.string.no);
        this.binding.valueAutoOpenDungeon.setText(this.autoOpenDungeonDetail ? R.string.yes : R.string.no);
        this.binding.valueVerboseLogs.setText(this.verboseLogs ? R.string.yes : R.string.no);
        this.binding.valueColorblindMode.setText(this.colorblindMode ? R.string.yes : R.string.no);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void attachListeners() {
        this.binding.languageSpinner.setOnItemSelectedListener(new LanguageSpinnerListener());
        this.binding.valueSellAmount.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSettings$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogSettings.this.m420xa7d7ec84(view);
            }
        });
        this.binding.valueCraftAmount.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSettings$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogSettings.this.m421x2638f063(view);
            }
        });
        this.binding.valueConfirmUpgrades.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSettings$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogSettings.this.m423xa499f442(view);
            }
        });
        this.binding.valueConfirmRetreat.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSettings$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogSettings.this.m424x22faf821(view);
            }
        });
        this.binding.valueSwapEquipment.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSettings$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogSettings.this.m425xa15bfc00(view);
            }
        });
        this.binding.valueAutoOpenDungeon.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSettings$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogSettings.this.m426x1fbcffdf(view);
            }
        });
        this.binding.valueVerboseLogs.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSettings$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogSettings.this.m427x9e1e03be(view);
            }
        });
        this.binding.valueColorblindMode.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSettings$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogSettings.this.m428x1c7f079d(view);
            }
        });
        this.binding.restorePurchases.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSettings$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogSettings.this.m429x9ae00b7c(view);
            }
        });
        this.binding.cancel.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSettings$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogSettings.this.m430x19410f5b(view);
            }
        });
        this.binding.save.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogSettings$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogSettings.this.m422x73718747(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$0$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogSettings, reason: not valid java name */
    /* synthetic */ void m420xa7d7ec84(View view) {
        this.sellMaxAmount = !this.sellMaxAmount;
        refreshValues();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$1$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogSettings, reason: not valid java name */
    /* synthetic */ void m421x2638f063(View view) {
        this.craftMaxAmount = !this.craftMaxAmount;
        refreshValues();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$2$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogSettings, reason: not valid java name */
    /* synthetic */ void m423xa499f442(View view) {
        this.confirmUpgrade = !this.confirmUpgrade;
        refreshValues();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$3$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogSettings, reason: not valid java name */
    /* synthetic */ void m424x22faf821(View view) {
        this.confirmRetreat = !this.confirmRetreat;
        refreshValues();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$4$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogSettings, reason: not valid java name */
    /* synthetic */ void m425xa15bfc00(View view) {
        this.confirmSwap = !this.confirmSwap;
        refreshValues();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$5$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogSettings, reason: not valid java name */
    /* synthetic */ void m426x1fbcffdf(View view) {
        this.autoOpenDungeonDetail = !this.autoOpenDungeonDetail;
        refreshValues();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$6$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogSettings, reason: not valid java name */
    /* synthetic */ void m427x9e1e03be(View view) {
        this.verboseLogs = !this.verboseLogs;
        refreshValues();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$7$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogSettings, reason: not valid java name */
    /* synthetic */ void m428x1c7f079d(View view) {
        this.colorblindMode = !this.colorblindMode;
        refreshValues();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$8$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogSettings, reason: not valid java name */
    /* synthetic */ void m429x9ae00b7c(View view) {
        try {
            MainActivity.IAPWrapper.restorePurchases();
        } catch (Exception e) {
            e.printStackTrace();
        }
        dismiss();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$9$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogSettings, reason: not valid java name */
    /* synthetic */ void m430x19410f5b(View view) {
        dismiss();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$10$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogSettings, reason: not valid java name */
    /* synthetic */ void m422x73718747(View view) {
        MainActivity.data.setSettingSellMaxAmount(this.sellMaxAmount);
        MainActivity.data.setSettingCraftMaxAmount(this.craftMaxAmount);
        MainActivity.data.setSettingConfirmUpgrade(this.confirmUpgrade);
        MainActivity.data.setSettingConfirmRetreat(this.confirmRetreat);
        MainActivity.data.setSettingConfirmSwap(this.confirmSwap);
        MainActivity.data.setSettingAutoOpenDungeonDetail(this.autoOpenDungeonDetail);
        MainActivity.data.setSettingVerboseLogs(this.verboseLogs);
        MainActivity.data.setSettingColorblindMode(this.colorblindMode);
        if (!this.language.equals(MainActivity.data.getSettingsLanguage())) {
            MainActivity.data.setSettingsLanguage(this.language);
            Logger.invalidate();
            Iterator<Area> it2 = Utils.compileDungeonRaidList().iterator();
            while (it2.hasNext()) {
                it2.next().invalidateAnimator();
            }
            getActivity().startActivity(new Intent(getActivity(), (Class<?>) MainActivity.class));
            getActivity().finish();
        }
        dismiss();
    }

    public class LanguageSpinnerListener implements AdapterView.OnItemSelectedListener {
        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }

        public LanguageSpinnerListener() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            DialogSettings.this.language = (String) DialogSettings.languageMap.get(Integer.valueOf(i));
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainActivity.shownDialogSettings = this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        MainActivity.shownDialogSettings = null;
        super.onStop();
    }
}
