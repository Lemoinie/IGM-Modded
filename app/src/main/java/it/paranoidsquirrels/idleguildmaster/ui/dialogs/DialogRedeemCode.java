package it.paranoidsquirrels.idleguildmaster.ui.dialogs;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.viewbinding.ViewBinding;
import com.google.common.base.Ascii;
import it.paranoidsquirrels.idleguildmaster.AchievementsUtils;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.TrueTimeUtils;
import it.paranoidsquirrels.idleguildmaster.UIUtils;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.databinding.DialogRedeemCodeBinding;
import it.paranoidsquirrels.idleguildmaster.storage.FileManager;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.PotionsDrank;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Trait;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.Item;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Weapon;
import it.paranoidsquirrels.idleguildmaster.storage.data.quests.QuestsManager;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class DialogRedeemCode extends CustomDialog {
    private DialogRedeemCodeBinding binding;

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void initialize(Bundle bundle) {
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding getBinding() {
        return this.binding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setBinding(ViewBinding viewBinding) {
        this.binding = (DialogRedeemCodeBinding) viewBinding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected String getTitle() {
        return getString(R.string.drawer_redeem_code_title);
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        DialogRedeemCodeBinding dialogRedeemCodeBindingInflate = DialogRedeemCodeBinding.inflate(layoutInflater, viewGroup, z);
        this.binding = dialogRedeemCodeBindingInflate;
        return dialogRedeemCodeBindingInflate;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void attachListeners() {
        this.binding.close.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogRedeemCode$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogRedeemCode.this.m393x7ec349ca(view);
            }
        });
        this.binding.ok.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogRedeemCode$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogRedeemCode.this.m394xe8f2d1e9(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$0$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogRedeemCode, reason: not valid java name */
    /* synthetic */ void m393x7ec349ca(View view) {
        dismiss();
    }

    /* JADX INFO: renamed from: lambda$attachListeners$1$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogRedeemCode, reason: not valid java name */
    /* synthetic */ void m394xe8f2d1e9(View view) {
        redeem(this.binding.editText.getText().toString());
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void redeem(String str) {
        String strSubstring;
        byte b = 8;
        String strSubstring2 = str.length() < 8 ? "voidcode" : str;
        if (strSubstring2.length() <= 8) {
            strSubstring = "";
        } else {
            strSubstring = strSubstring2.substring(8);
            strSubstring2 = strSubstring2.substring(0, 8);
        }
        strSubstring2.hashCode();
        switch (strSubstring2.hashCode()) {
            case -1983989988:
                b = !strSubstring2.equals("g75nfkf4") ? (byte) -1 : (byte) 0;
                break;
            case -1518631661:
                b = !strSubstring2.equals("f3hqt045") ? (byte) -1 : (byte) 1;
                break;
            case -1295623761:
                b = !strSubstring2.equals("fj9rf8hh") ? (byte) -1 : (byte) 2;
                break;
            case -1177675120:
                b = !strSubstring2.equals("g394te91") ? (byte) -1 : (byte) 3;
                break;
            case -37578884:
                b = !strSubstring2.equals("rotdrv9d") ? (byte) -1 : (byte) 4;
                break;
            case 435147280:
                b = !strSubstring2.equals("e44ttr7z") ? (byte) -1 : (byte) 5;
                break;
            case 504801599:
                b = !strSubstring2.equals("vrd75ywc") ? (byte) -1 : (byte) 6;
                break;
            case 524485825:
                b = !strSubstring2.equals("brttr5g5") ? (byte) -1 : (byte) 7;
                break;
            case 571677660:
                if (!strSubstring2.equals("UNLOCKME")) {
                    b = -1;
                }
                break;
            case 960152065:
                b = !strSubstring2.equals("vrt4983y") ? (byte) -1 : (byte) 9;
                break;
            case 1227746507:
                b = !strSubstring2.equals("f1r29u15") ? (byte) -1 : (byte) 10;
                break;
            case 1330416413:
                b = !strSubstring2.equals("DEBUG000") ? (byte) -1 : Ascii.VT;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                if (MainActivity.data.isRedeem_g73mfkf4()) {
                    displayMessage(getString(R.string.drawer_redeem_already_redeemed), false);
                } else {
                    redeemGems(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
                    MainActivity.data.setRedeem_g73mfkf4(true);
                }
                break;
            case 1:
                if (MainActivity.data.isRedeemed_f8hf3045()) {
                    displayMessage(getString(R.string.drawer_redeem_already_redeemed), false);
                } else {
                    try {
                        Item item = Item.getInstance(strSubstring, 1);
                        if (item == null) {
                            throw new Exception();
                        }
                        Utils.collectItem(item, MainActivity.data.getItems());
                        MainActivity.headquartersFragment.refresh();
                        MainActivity.data.setRedeemed_f8hf3045(true);
                        clearInput();
                    } catch (Exception unused) {
                        blinkInput();
                        return;
                    }
                }
                break;
            case 2:
                if (MainActivity.data.isRedeemed_fj9rf8hh()) {
                    displayMessage(getString(R.string.drawer_redeem_already_redeemed), false);
                } else {
                    redeemGems(100);
                    MainActivity.data.setRedeemed_fj9rf8hh(true);
                }
                break;
            case 3:
                if (MainActivity.data.isRedeemed_g294ps91()) {
                    displayMessage(getString(R.string.drawer_redeem_already_redeemed), false);
                } else {
                    try {
                        Item item2 = Item.getInstance(strSubstring.substring(1), Integer.parseInt(strSubstring.substring(0, 1)));
                        if (item2 == null) {
                            throw new Exception();
                        }
                        Utils.collectItem(item2, MainActivity.data.getItems());
                        MainActivity.headquartersFragment.refresh();
                        MainActivity.data.setRedeemed_g294ps91(true);
                        clearInput();
                    } catch (Exception unused2) {
                        blinkInput();
                        return;
                    }
                }
                break;
            case 4:
                if (MainActivity.data.isRedeem_potionsRefund1()) {
                    displayMessage(getString(R.string.drawer_redeem_already_redeemed), false);
                } else {
                    if (strSubstring.isEmpty()) {
                        if (MainActivity.data.getKingsQuests().isEmpty() && TrueTimeUtils.millis() <= 1750435056102L) {
                            QuestsManager.extractQuests();
                            ((MainActivity) getActivity()).refreshIcons();
                        }
                    } else if (strSubstring.equals("eq")) {
                        Utils.collectItem(Item.getInstance("PatricianArmor", 2), MainActivity.data.getItems());
                        Utils.collectItem(Item.getInstance("DiamondAmulet", 19), MainActivity.data.getItems());
                        Utils.collectItem(Item.getInstance("CottontailJacket", 10), MainActivity.data.getItems());
                        Utils.collectItem(Item.getInstance("GhostRabbitCloak", 6), MainActivity.data.getItems());
                        Utils.collectItem(Item.getInstance("CeremonialCake", 10), MainActivity.data.getItems());
                        Utils.collectItem(Item.getInstance("PotionOfConstitution", 100), MainActivity.data.getItems());
                        Utils.collectItem(Item.getInstance("PotionOfDexterity", 100), MainActivity.data.getItems());
                        Utils.collectItem(Item.getInstance("PotionOfIntelligence", 100), MainActivity.data.getItems());
                        Utils.collectItem(Item.getInstance("PotionOfHealth", 100), MainActivity.data.getItems());
                        Utils.collectItem(Item.getInstance("PotionOfDefense", 100), MainActivity.data.getItems());
                        Utils.collectItem(Item.getInstance("PotionOfMagicDefense", 100), MainActivity.data.getItems());
                        Utils.collectItem(Item.getInstance("PotionOfPrecision", 100), MainActivity.data.getItems());
                        Utils.collectItem(Item.getInstance("PotionOfViciousness", 100), MainActivity.data.getItems());
                        Utils.collectItem(Item.getInstance("PotionOfDarkness", 100), MainActivity.data.getItems());
                        Utils.collectItem(Item.getInstance("PotionOfImmunity", 100), MainActivity.data.getItems());
                        Utils.collectItem(Item.getInstance("PotionOfAgility", 100), MainActivity.data.getItems());
                        MainActivity.data.setMoney(MainActivity.data.getMoney() + 10000000);
                    }
                    MainActivity.headquartersFragment.refresh();
                    MainActivity.data.setRedeem_potionsRefund1(true);
                    clearInput();
                }
                break;
            case 5:
                if (MainActivity.data.isRedeemed_e44opo7z()) {
                    displayMessage(getString(R.string.drawer_redeem_already_redeemed), false);
                } else {
                    redeemGems(2000);
                    MainActivity.data.setRedeemed_e44opo7z(true);
                }
                break;
            case 6:
                if (MainActivity.data.isRedeemed_vrw74ync()) {
                    displayMessage(getString(R.string.drawer_redeem_already_redeemed), false);
                } else {
                    redeemGems(1000);
                    MainActivity.data.setRedeemed_vrw74ync(true);
                }
                break;
            case 7:
                MainActivity.data.getSeenEnemies().add("Gcss");
                MainActivity.data.getSeenEnemies().add("ReinforcedDoor");
                MainActivity.data.getSeenEnemies().add("LegateHadrian");
                clearInput();
                break;
            case 8:
                AchievementsUtils.retroactivelyUnlockAchievements();
                clearInput();
                break;
            case 9:
                if (MainActivity.data.isRedeemed_vre8983y()) {
                    displayMessage(getString(R.string.drawer_redeem_already_redeemed), false);
                } else {
                    redeemGems(500);
                    MainActivity.data.setRedeemed_vre8983y(true);
                }
                break;
            case 10:
                if (MainActivity.data.isRedeem_f1r39h15()) {
                    displayMessage(getString(R.string.drawer_redeem_already_redeemed), false);
                } else {
                    if (strSubstring.isEmpty()) {
                        try {
                            if (!MainActivity.data.getCelestialMothership().completed()) {
                                blinkInput();
                            } else {
                                MainActivity.data.getSeenEnemies().add("Gcss");
                                MainActivity.data.getSeenEnemies().add("ReinforcedDoor");
                                MainActivity.data.getSeenItems().remove("Evo23Vial");
                                MainActivity.data.getCelestialMothership().setMaxProgress(16);
                                MainActivity.raidsFragment.refresh();
                            }
                        } catch (Exception unused3) {
                            blinkInput();
                            return;
                        }
                    } else if (strSubstring.equals("eq")) {
                        MainActivity.data.getAdventurers().add(Adventurer.getInstance("DivineChampion", 25, 45, 0, (Weapon) Item.getInstance("Spade"), null, null, Trait.BRUTE, Trait.FOCUSED, new PotionsDrank(), null, false));
                        Utils.collectItem(Item.getInstance("ChampionArmor", 1), MainActivity.data.getItems());
                        Utils.collectItem(Item.getInstance("SpikedPrimevalShield", 1), MainActivity.data.getItems());
                        Utils.collectItem(Item.getInstance("EternalHunger", 2), MainActivity.data.getItems());
                        Utils.collectItem(Item.getInstance("SeekingGlass", 1), MainActivity.data.getItems());
                        Utils.collectItem(Item.getInstance("ScarletVeil", 1), MainActivity.data.getItems());
                        Utils.collectItem(Item.getInstance("ReassemblingJacket", 1), MainActivity.data.getItems());
                        MainActivity.headquartersFragment.refresh();
                        MainActivity.adventurersFragment.refresh();
                        MainActivity.dungeonsFragment.refresh();
                    }
                    MainActivity.data.setRedeem_f1r39h15(true);
                    clearInput();
                }
                break;
            case 11:
                File saveFile = FileManager.getSaveFile(getContext());
                if (saveFile == null) {
                    Toast.makeText(getActivity(), "No file found", 0).show();
                }
                Uri uriForFile = FileProvider.getUriForFile(getContext(), getActivity().getPackageName() + ".fileprovider", saveFile);
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.EMAIL", new String[]{"beyond.idle.incremental@gmail.com"});
                intent.putExtra("android.intent.extra.SUBJECT", "Data");
                intent.putExtra("android.intent.extra.TEXT", "Data");
                intent.putExtra("android.intent.extra.STREAM", uriForFile);
                intent.addFlags(1);
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(Intent.createChooser(intent, "Send Email"));
                } else {
                    Toast.makeText(getActivity(), "No email client installed.", 0).show();
                }
                break;
            default:
                blinkInput();
                break;
        }
    }

    private void redeemGems(int i) {
        MainActivity.data.setGems(MainActivity.data.getGems() + ((long) i));
        ((MainActivity) MainActivity.headquartersFragment.getActivity()).refreshGems();
        displayMessage(String.format(getString(R.string.drawer_redeem_gems), String.valueOf(i)), true);
        clearInput();
    }

    private void displayMessage(String str, boolean z) {
        this.binding.message.setText(str);
        this.binding.message.setTextColor(getResources().getColor(z ? R.color.success : UIUtils.getFailureColor(), getContext().getTheme()));
    }

    private void clearInput() {
        this.binding.editText.getText().clear();
    }

    private void blinkInput() {
        ValueAnimator valueAnimatorOfArgb = ValueAnimator.ofArgb(getContext().getColor(R.color.dim_white), getContext().getColor(UIUtils.getFailureColor()), getContext().getColor(R.color.dim_white));
        valueAnimatorOfArgb.setInterpolator(new LinearInterpolator());
        valueAnimatorOfArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogRedeemCode$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DialogRedeemCode.this.m395xedc41f1a(valueAnimator);
            }
        });
        valueAnimatorOfArgb.setDuration(400L);
        valueAnimatorOfArgb.start();
    }

    /* JADX INFO: renamed from: lambda$blinkInput$2$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogRedeemCode, reason: not valid java name */
    /* synthetic */ void m395xedc41f1a(ValueAnimator valueAnimator) {
        this.binding.editText.setTextColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MainActivity.shownDialogRedeemCode = this;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        MainActivity.shownDialogRedeemCode = null;
        super.onStop();
    }
}
