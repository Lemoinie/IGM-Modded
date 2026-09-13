package it.paranoidsquirrels.idleguildmaster.ui.dialogs;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewbinding.ViewBinding;
import it.paranoidsquirrels.idleguildmaster.MainActivity;
import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.UIUtils;
import it.paranoidsquirrels.idleguildmaster.Utils;
import it.paranoidsquirrels.idleguildmaster.databinding.DialogEntityDetailBinding;
import it.paranoidsquirrels.idleguildmaster.databinding.LayoutItemBinding;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.Entity;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.Adventurer;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.adventurers.doctrines.instances.EmptyDoctrine;
import it.paranoidsquirrels.idleguildmaster.storage.data.entities.enemies.Enemy;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.ItemWrapper;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.Equipment;
import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public class DialogEntityDetail extends CustomDialog {
    public boolean allowEquipmentChange;
    private DialogEntityDetailBinding binding;
    private int currentPage;
    private Entity entity;
    public boolean promotion;

    static /* synthetic */ void lambda$attachListeners$51(View view) {
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding getBinding() {
        return this.binding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void setBinding(ViewBinding viewBinding) {
        this.binding = (DialogEntityDetailBinding) viewBinding;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected String getTitle() {
        return getString(this.entity.getIdName());
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected ViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        DialogEntityDetailBinding dialogEntityDetailBindingInflate = DialogEntityDetailBinding.inflate(layoutInflater, viewGroup, z);
        this.binding = dialogEntityDetailBindingInflate;
        return dialogEntityDetailBindingInflate;
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void initialize(Bundle bundle) {
        this.currentPage = 0;
        changePage(true);
        this.binding.help.setText(this.entity.getIdDescription());
        Entity entity = this.entity;
        if (entity instanceof Adventurer) {
            this.binding.lootTitle.setVisibility(8);
            this.binding.lootContent.setVisibility(8);
            this.binding.lootContentScroller.setVisibility(8);
            if (((Adventurer) this.entity).isAscended()) {
                this.binding.detailExperienceBar.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.ascended_unit, getContext().getTheme())));
                this.binding.detailLevel.setTextColor(getResources().getColor(R.color.ascended_unit, getContext().getTheme()));
                this.binding.detailExperience.setTextColor(getResources().getColor(R.color.ascended_unit, getContext().getTheme()));
                this.binding.detailImage.setBackgroundResource(R.drawable.object_border_ascended);
                this.binding.detailWeapon.setBackgroundResource(R.drawable.object_border_ascended);
                this.binding.detailArmor.setBackgroundResource(R.drawable.object_border_ascended);
                this.binding.detailAccessory.setBackgroundResource(R.drawable.object_border_ascended);
                this.binding.swapEquipment.setBackgroundResource(R.drawable.object_border_ascended);
            }
        } else if (entity instanceof Enemy) {
            this.binding.detailLevel.setVisibility(8);
            this.binding.levelupAdventurer.setVisibility(8);
            this.binding.detailExperience.setVisibility(8);
            this.binding.detailExperienceBar.setVisibility(8);
            this.binding.detailTraits.setVisibility(8);
            this.binding.detailContainerEquipments.setVisibility(8);
            this.binding.swapEquipment.setVisibility(8);
            this.binding.detailDarknessReduction.setVisibility(8);
            this.binding.detailExpBonus.setVisibility(8);
            this.binding.detailHealModifier.setVisibility(8);
            this.binding.detailDecay.setVisibility(8);
            HashSet hashSet = new HashSet();
            for (final ItemWrapper itemWrapper : ((Enemy) this.entity).listDrops(0).keySet()) {
                String trueClass = itemWrapper.getItem().getTrueClass();
                if (!hashSet.contains(trueClass)) {
                    hashSet.add(trueClass);
                    LayoutItemBinding layoutItemBindingInflate = LayoutItemBinding.inflate(getLayoutInflater(), this.binding.lootContent, false);
                    layoutItemBindingInflate.stack.setVisibility(8);
                    layoutItemBindingInflate.getRoot().setBackgroundResource(R.drawable.object_border_dim_white);
                    layoutItemBindingInflate.image.setImageDrawable(ResourcesCompat.getDrawable(getResources(), MainActivity.data.getSeenItems().contains(trueClass) ? itemWrapper.getItem().getIdImage() : R.drawable.unknown, getContext().getTheme()));
                    if (MainActivity.data.getSeenItems().contains(trueClass)) {
                        layoutItemBindingInflate.getRoot().setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda48
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                UIUtils.openItemDetail(itemWrapper.getItem());
                            }
                        });
                    }
                    this.binding.lootContent.addView(layoutItemBindingInflate.getRoot());
                }
            }
        }
        update();
    }

    @Override // it.paranoidsquirrels.idleguildmaster.ui.dialogs.CustomDialog
    protected void attachListeners() {
        this.binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogEntityDetail.this.m282x775f4654(view);
            }
        });
        this.binding.containerPassive.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogEntityDetail.this.m293x13cd42b3(view);
            }
        });
        this.binding.containerActive.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogEntityDetail.this.m304xb03b3f12(view);
            }
        });
        this.binding.detailLevel.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda27
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogEntityDetail.this.m315x4ca93b71(view);
            }
        });
        this.binding.detailExperience.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda39
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogEntityDetail.this.m326xe91737d0(view);
            }
        });
        this.binding.detailExperienceBar.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda42
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogEntityDetail.this.m329x8585342f(view);
            }
        });
        this.binding.detailAttackType.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda43
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogEntityDetail.this.m330x21f3308e(view);
            }
        });
        this.binding.detailHp.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda45
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogEntityDetail.this.m331xbe612ced(view);
            }
        });
        this.binding.detailConstitution.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda46
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogEntityDetail.this.m332x5acf294c(view);
            }
        });
        this.binding.detailDexterity.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda47
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogEntityDetail.this.m283xb6e9cb38(view);
            }
        });
        this.binding.detailDefense.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogEntityDetail.this.m284x5357c797(view);
            }
        });
        this.binding.detailMana.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda33
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogEntityDetail.this.m285xefc5c3f6(view);
            }
        });
        this.binding.detailIntelligence.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda44
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogEntityDetail.this.m286x8c33c055(view);
            }
        });
        this.binding.detailMagicDefense.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda49
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogEntityDetail.this.m287x28a1bcb4(view);
            }
        });
        this.binding.detailThreat.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda50
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogEntityDetail.this.m288xc50fb913(view);
            }
        });
        this.binding.detailDodge.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda51
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogEntityDetail.this.m289x617db572(view);
            }
        });
        this.binding.detailCritChance.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda52
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogEntityDetail.this.m290xfdebb1d1(view);
            }
        });
        this.binding.detailCritDamage.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda53
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogEntityDetail.this.m291x9a59ae30(view);
            }
        });
        this.binding.detailStatusImmunity.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogEntityDetail.this.m292x36c7aa8f(view);
            }
        });
        this.binding.detailCounterattack.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogEntityDetail.this.m294xa83b5ab9(view);
            }
        });
        this.binding.detailLifesteal.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogEntityDetail.this.m295x44a95718(view);
            }
        });
        this.binding.detailDarknessDamage.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogEntityDetail.this.m296xe1175377(view);
            }
        });
        this.binding.detailRetaliation.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogEntityDetail.this.m297x7d854fd6(view);
            }
        });
        this.binding.detailRegeneration.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogEntityDetail.this.m298x19f34c35(view);
            }
        });
        this.binding.detailImage.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogEntityDetail.this.m299xb6614894(view);
            }
        });
        Entity entity = this.entity;
        if (entity instanceof Adventurer) {
            final Adventurer adventurer = (Adventurer) entity;
            this.binding.detailTraits.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogEntityDetail.this.m300x52cf44f3(adventurer, view);
                }
            });
            this.binding.detailWeapon.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogEntityDetail.this.m301xef3d4152(adventurer, view);
                }
            });
            this.binding.detailArmor.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda12
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogEntityDetail.this.m302x8bab3db1(adventurer, view);
                }
            });
            this.binding.detailAccessory.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda13
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogEntityDetail.this.m303x28193a10(adventurer, view);
                }
            });
            this.binding.levelupAdventurer.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda14
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogEntityDetail.this.m305x998cea3a(adventurer, view);
                }
            });
            this.binding.detailAttackDamage.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda16
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogEntityDetail.this.m306x35fae699(adventurer, view);
                }
            });
            this.binding.detailDarknessReduction.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda17
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogEntityDetail.this.m307xd268e2f8(view);
                }
            });
            this.binding.detailExpBonus.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda18
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogEntityDetail.this.m308x6ed6df57(view);
                }
            });
            this.binding.detailHealModifier.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda19
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogEntityDetail.this.m309xb44dbb6(view);
                }
            });
            this.binding.detailDecay.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda20
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogEntityDetail.this.m310xa7b2d815(view);
                }
            });
            this.binding.detailPotionHealth.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda21
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogEntityDetail.this.m311x4420d474(view);
                }
            });
            this.binding.detailPotionConstitution.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda23
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogEntityDetail.this.m312xe08ed0d3(view);
                }
            });
            this.binding.detailPotionDexterity.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda24
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogEntityDetail.this.m313x7cfccd32(view);
                }
            });
            this.binding.detailPotionIntelligence.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda25
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogEntityDetail.this.m314x196ac991(view);
                }
            });
            this.binding.detailPotionDefense.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda26
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogEntityDetail.this.m316x8ade79bb(view);
                }
            });
            this.binding.detailPotionMagicDefense.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda28
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogEntityDetail.this.m317x274c761a(view);
                }
            });
            this.binding.detailPotionPrecision.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda29
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogEntityDetail.this.m318xc3ba7279(view);
                }
            });
            this.binding.detailPotionViciousness.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda30
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogEntityDetail.this.m319x60286ed8(view);
                }
            });
            this.binding.detailPotionAgility.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda31
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogEntityDetail.this.m320xfc966b37(view);
                }
            });
            this.binding.detailPotionImmunity.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda32
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogEntityDetail.this.m321x99046796(view);
                }
            });
            this.binding.detailPotionDarkness.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda34
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogEntityDetail.this.m322x357263f5(view);
                }
            });
            this.binding.doctrine.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda35
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogEntityDetail.this.m323xd1e06054(adventurer, view);
                }
            });
        } else if (entity instanceof Enemy) {
            this.binding.detailAttackDamage.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda36
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogEntityDetail.this.m324x6e4e5cb3(view);
                }
            });
        }
        this.binding.arrowLeft.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda37
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogEntityDetail.this.m325xabc5912(view);
            }
        });
        this.binding.arrowRight.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda38
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogEntityDetail.this.m327x7c30093c(view);
            }
        });
        this.binding.help.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda40
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogEntityDetail.lambda$attachListeners$51(view);
            }
        });
        this.binding.exit2.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda41
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogEntityDetail.this.m328xb50c01fa(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$attachListeners$1$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m282x775f4654(View view) {
        populateHelp(view, "", false, null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$2$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m293x13cd42b3(View view) {
        populateHelp(view, getString(this.entity.getPassiveSkill().description), false, null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$3$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m304xb03b3f12(View view) {
        populateHelp(view, getString(this.entity.getActiveSkill().description), false, null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$4$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m315x4ca93b71(View view) {
        populateHelp(view, getString(R.string.help_level), false, null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$5$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m326xe91737d0(View view) {
        populateHelp(view, getString(R.string.help_experience), false, null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$6$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m329x8585342f(View view) {
        populateHelp(view, getString(R.string.help_experience), false, null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$7$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m330x21f3308e(View view) {
        populateHelp(view, String.format(getString(R.string.attack_type_description), getString(this.entity.isRanged() ? R.string.ranged_description : R.string.melee_description), getString(this.entity.isMagic() ? R.string.magic_description : R.string.physical_description)), false, null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$8$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m331xbe612ced(View view) {
        populateHelp(view, getString(R.string.help_hp), false, null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$9$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m332x5acf294c(View view) {
        populateHelp(view, getString(R.string.help_constitution), false, null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$10$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m283xb6e9cb38(View view) {
        populateHelp(view, getString(R.string.help_dexterity), false, null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$11$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m284x5357c797(View view) {
        populateHelp(view, getString(R.string.help_defense), false, null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$12$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m285xefc5c3f6(View view) {
        populateHelp(view, String.format(getString(R.string.help_mana), 100), false, null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$13$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m286x8c33c055(View view) {
        populateHelp(view, getString(R.string.help_intelligence), false, null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$14$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m287x28a1bcb4(View view) {
        populateHelp(view, getString(R.string.help_magic_defense), false, null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$15$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m288xc50fb913(View view) {
        populateHelp(view, getString(R.string.help_threat), false, null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$16$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m289x617db572(View view) {
        populateHelp(view, getString(R.string.help_dodge), false, null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$17$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m290xfdebb1d1(View view) {
        populateHelp(view, getString(R.string.help_crit_chance), false, null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$18$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m291x9a59ae30(View view) {
        populateHelp(view, getString(R.string.help_crit_damage), false, null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$19$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m292x36c7aa8f(View view) {
        populateHelp(view, getString(R.string.help_status_immunity), false, null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$20$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m294xa83b5ab9(View view) {
        populateHelp(view, getString(R.string.help_counterattack), false, null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$21$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m295x44a95718(View view) {
        populateHelp(view, getString(R.string.help_lifesteal), false, null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$22$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m296xe1175377(View view) {
        populateHelp(view, getString(R.string.help_darkness_damage), false, null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$23$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m297x7d854fd6(View view) {
        populateHelp(view, getString(R.string.help_retaliation), false, null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$24$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m298x19f34c35(View view) {
        populateHelp(view, getString(R.string.help_regeneration), false, null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$25$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m299xb6614894(View view) {
        populateHelp(view, getString(this.entity.getIdDescription()), false, null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$26$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m300x52cf44f3(Adventurer adventurer, View view) {
        populateHelp(view, UIUtils.traitsToLongString(adventurer, getResources()), false, null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$27$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m301xef3d4152(Adventurer adventurer, View view) {
        populateHelp(view, formatEquipmentHelp(adventurer.getWeapon(), getResources()), true, "weapon");
    }

    /* JADX INFO: renamed from: lambda$attachListeners$28$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m302x8bab3db1(Adventurer adventurer, View view) {
        populateHelp(view, adventurer.getArmor() == null ? "" : formatEquipmentHelp(adventurer.getArmor(), getResources()), true, "armor");
    }

    /* JADX INFO: renamed from: lambda$attachListeners$29$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m303x28193a10(Adventurer adventurer, View view) {
        populateHelp(view, adventurer.getAccessory() == null ? "" : formatEquipmentHelp(adventurer.getAccessory(), getResources()), true, "accessory");
    }

    /* JADX INFO: renamed from: lambda$attachListeners$30$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m305x998cea3a(Adventurer adventurer, View view) {
        dialogAdventurerPromotion(adventurer);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$31$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m306x35fae699(Adventurer adventurer, View view) {
        populateHelp(view, String.format(getString(R.string.help_attack), getString(adventurer.getWeapon().damageDescription())), false, null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$32$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m307xd268e2f8(View view) {
        populateHelp(view, getString(R.string.help_darkness_reduction), false, null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$33$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m308x6ed6df57(View view) {
        populateHelp(view, getString(R.string.help_exp_bonus), false, null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$34$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m309xb44dbb6(View view) {
        populateHelp(view, getString(R.string.help_heal_modifier), false, null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$35$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m310xa7b2d815(View view) {
        populateHelp(view, getString(R.string.help_decay), false, null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$36$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m311x4420d474(View view) {
        populateHelp(view, getString(R.string.help_potion_health), false, null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$37$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m312xe08ed0d3(View view) {
        populateHelp(view, getString(R.string.help_potion_constitution), false, null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$38$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m313x7cfccd32(View view) {
        populateHelp(view, getString(R.string.help_potion_dexterity), false, null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$39$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m314x196ac991(View view) {
        populateHelp(view, getString(R.string.help_potion_intelligence), false, null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$40$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m316x8ade79bb(View view) {
        populateHelp(view, getString(R.string.help_potion_defense), false, null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$41$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m317x274c761a(View view) {
        populateHelp(view, getString(R.string.help_potion_magic_defense), false, null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$42$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m318xc3ba7279(View view) {
        populateHelp(view, getString(R.string.help_potion_precision), false, null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$43$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m319x60286ed8(View view) {
        populateHelp(view, getString(R.string.help_potion_viciousness), false, null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$44$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m320xfc966b37(View view) {
        populateHelp(view, getString(R.string.help_potion_agility), false, null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$45$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m321x99046796(View view) {
        populateHelp(view, getString(R.string.help_potion_immunity), false, null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$46$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m322x357263f5(View view) {
        populateHelp(view, getString(R.string.help_potion_darkness), false, null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$47$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m323xd1e06054(Adventurer adventurer, View view) {
        clickDoctrine(adventurer);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$48$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m324x6e4e5cb3(View view) {
        populateHelp(view, getString(R.string.help_attack_enemy), false, null);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$49$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m325xabc5912(View view) {
        changePage(false);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$50$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m327x7c30093c(View view) {
        changePage(true);
    }

    /* JADX INFO: renamed from: lambda$attachListeners$52$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m328xb50c01fa(View view) {
        dismiss();
    }

    public void update() {
        if (this.binding == null) {
            return;
        }
        if (!this.entity.canPickDoctrine()) {
            this.binding.doctrine.setVisibility(8);
            this.binding.expendableDoctrinePoints.setVisibility(8);
        }
        this.binding.eightDpFromDoctrine.setVisibility(this.entity.canPickDoctrine() ? 0 : 8);
        this.binding.detailImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), this.entity.getImageId(), getContext().getTheme()));
        this.binding.namePassive.setText(getString(this.entity.getPassiveSkill().name));
        this.binding.nameActive.setText(getString(this.entity.getActiveSkill().name));
        this.binding.detailAttackDamage.setText(String.format(getString(R.string.attack_formatted), Integer.valueOf(this.entity.calculateMinAttackDamage()), Integer.valueOf(this.entity.calculateMaxAttackDamage())));
        this.binding.detailAttackType.setText(String.format(getString(R.string.attack_type), getString(this.entity.isRanged() ? R.string.ranged : R.string.melee), getString(this.entity.isMagic() ? R.string.magic : R.string.physical)));
        this.binding.detailHp.setText(String.format(getString(R.string.hp_formatted), Integer.valueOf(this.entity.calculateTotalMaxHp())));
        this.binding.detailMana.setText(String.format(getString(R.string.mana_gain_formatted), Integer.valueOf(this.entity.calculateManaRegen())));
        this.binding.detailConstitution.setText(String.format(getString(R.string.constitution_formatted), Integer.valueOf(this.entity.calculateTotalConstitution())));
        this.binding.detailDexterity.setText(String.format(getString(R.string.dexterity_formatted), Integer.valueOf(this.entity.calculateTotalDexterity())));
        this.binding.detailIntelligence.setText(String.format(getString(R.string.intelligence_formatted), Integer.valueOf(this.entity.calculateTotalIntelligence())));
        this.binding.detailDefense.setText(String.format(getString(R.string.defense_formatted), Integer.valueOf(this.entity.calculateTotalDefense())));
        this.binding.detailMagicDefense.setText(String.format(getString(R.string.magic_defense_formatted), Integer.valueOf(this.entity.calculateTotalMagicDefense())));
        this.binding.detailThreat.setText(String.format(getString(R.string.threat_formatted), Integer.valueOf(this.entity.getThreat())));
        this.binding.detailDodge.setText(String.format(getString(R.string.bonus_dodge_formatted), Integer.valueOf(Utils.round(this.entity.calculateTotalFlatDodgeChance() * 100.0d))));
        this.binding.detailCritChance.setText(String.format(getString(R.string.critical_chance_formatted), Integer.valueOf(Utils.round(this.entity.calculateCriticalChance() * 100.0d))));
        this.binding.detailCritDamage.setText(String.format(getString(R.string.critical_damage_formatted), Integer.valueOf(Utils.round(this.entity.calculateCriticalDamage() * 100.0d))));
        this.binding.detailStatusImmunity.setText(String.format(getString(R.string.status_immunity_formatted), Integer.valueOf(Utils.round(Math.min(1.0d, this.entity.calculateImmunityToStatus()) * 100.0d))));
        this.binding.detailCounterattack.setText(String.format(getString(R.string.counterattack_formatted), Integer.valueOf(Utils.round(Math.min(1.0d, this.entity.calculateCounterattackChance()) * 100.0d))));
        this.binding.detailLifesteal.setText(String.format(getString(R.string.lifesteal_formatted), Integer.valueOf(this.entity.calculateTotalLifesteal())));
        this.binding.detailDarknessDamage.setText(String.format(getString(R.string.darkness_damage_formatted), UIUtils.formatDouble1Decimal(this.entity.calculateTotalDarknessDamageAmplification() * 100.0d)));
        this.binding.detailRetaliation.setText(String.format(getString(R.string.retaliation_formatted), Integer.valueOf(this.entity.calculateRetaliationPhysicalDamage()), Integer.valueOf(this.entity.calculateRetaliationMagicalDamage())));
        this.binding.detailRegeneration.setText(String.format(getString(R.string.regeneration_formatted), Integer.valueOf(this.entity.calculateTotalRegeneration())));
        Entity entity = this.entity;
        if (entity instanceof Adventurer) {
            Adventurer adventurer = (Adventurer) entity;
            this.binding.detailTraits.setText(UIUtils.traitsToShortString(adventurer, getResources()));
            this.binding.detailWeapon.setImageDrawable(Utils.getEquipmentDrawable(adventurer.getWeapon(), getContext()));
            this.binding.detailArmor.setImageDrawable(Utils.getEquipmentDrawable(adventurer.getArmor(), getContext()));
            this.binding.detailAccessory.setImageDrawable(Utils.getEquipmentDrawable(adventurer.getAccessory(), getContext()));
            this.binding.detailLevel.setText(String.format(getString(R.string.level_formatted_long), Integer.valueOf(adventurer.getLevel()), Integer.valueOf(adventurer.getMaxLevel())));
            this.binding.detailExperienceBar.setProgress((int) (((double) (adventurer.getExperience() * 100)) / ((double) adventurer.totalExperienceToNextLevel())));
            this.binding.detailExperience.setText(adventurer.getLevel() >= adventurer.getMaxLevel() ? getString(R.string.experience_max) : String.format(getString(R.string.experience_formatted), Integer.valueOf(adventurer.getExperience()), formatMaxExperience(adventurer.totalExperienceToNextLevel())));
            this.binding.doctrine.setImageDrawable(ResourcesCompat.getDrawable(getResources(), adventurer.getDoctrine().getIdImage(), getContext().getTheme()));
            this.binding.expendableDoctrinePoints.setVisibility(adventurer.getDoctrinePoints() > 0 ? 0 : 8);
            this.binding.detailDarknessReduction.setText(String.format(getString(R.string.darkness_reduction_formatted), Integer.valueOf(adventurer.darknessReduction())));
            this.binding.detailExpBonus.setText(String.format(getString(R.string.experience_bonus_formatted), Integer.valueOf(Utils.round(adventurer.experienceMultiplier() * 100.0d))));
            this.binding.detailHealModifier.setText(String.format(getString(R.string.healing_modifier_formatted), Integer.valueOf(Utils.round(adventurer.calculateHealingModifier() * 100.0d))));
            this.binding.detailDecay.setText(String.format(getString(R.string.decay_formatted), Integer.valueOf(adventurer.decay())));
            formatPotion(this.binding.detailPotionHealth, adventurer, 3);
            formatPotion(this.binding.detailPotionConstitution, adventurer, 0);
            boolean z = true;
            formatPotion(this.binding.detailPotionDexterity, adventurer, 1);
            formatPotion(this.binding.detailPotionIntelligence, adventurer, 2);
            formatPotion(this.binding.detailPotionDefense, adventurer, 4);
            formatPotion(this.binding.detailPotionMagicDefense, adventurer, 5);
            formatPotion(this.binding.detailPotionPrecision, adventurer, 6);
            formatPotion(this.binding.detailPotionViciousness, adventurer, 7);
            formatPotion(this.binding.detailPotionAgility, adventurer, 10);
            formatPotion(this.binding.detailPotionImmunity, adventurer, 9);
            formatPotion(this.binding.detailPotionDarkness, adventurer, 8);
            if (adventurer.getLevel() < adventurer.getMaxLevel() || (adventurer.isAscended() && adventurer.getNextClasses().isEmpty())) {
                z = false;
            }
            if (z && this.binding.levelupAdventurer.getAnimation() == null) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setRepeatMode(2);
                alphaAnimation.setRepeatCount(-1);
                this.binding.levelupAdventurer.startAnimation(alphaAnimation);
            } else if (!z && this.binding.levelupAdventurer.getAnimation() != null) {
                this.binding.levelupAdventurer.clearAnimation();
            }
            this.binding.levelupAdventurer.setVisibility(z ? 0 : 4);
            this.binding.detailImage.setAlpha(z ? 0.5f : 1.0f);
        }
    }

    public void populateHelp(View view, String str, boolean z, final String str2) {
        DialogEntityDetailBinding dialogEntityDetailBinding = this.binding;
        if (dialogEntityDetailBinding == null) {
            return;
        }
        dialogEntityDetailBinding.help.setText(str);
        boolean z2 = z && this.allowEquipmentChange;
        this.binding.swapEquipment.setVisibility(z2 ? 0 : 8);
        if (z2) {
            this.binding.swapEquipment.setOnClickListener(new View.OnClickListener() { // from class: it.paranoidsquirrels.idleguildmaster.ui.dialogs.DialogEntityDetail$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    DialogEntityDetail.this.m333x2cfa6884(str2, view2);
                }
            });
        }
        if (view == null) {
            return;
        }
        selectElement(this.binding.getRoot().findViewWithTag("selected"), false);
        selectElement(view, true);
    }

    /* JADX INFO: renamed from: lambda$populateHelp$53$it-paranoidsquirrels-idleguildmaster-ui-dialogs-DialogEntityDetail, reason: not valid java name */
    /* synthetic */ void m333x2cfa6884(String str, View view) {
        if (MainActivity.shownDialogSelectEquipment != null) {
            return;
        }
        DialogSelectEquipment dialogSelectEquipment = new DialogSelectEquipment();
        dialogSelectEquipment.type = str;
        dialogSelectEquipment.adventurer = (Adventurer) this.entity;
        dialogSelectEquipment.show(getParentFragmentManager(), "select_equipment");
    }

    private void selectElement(View view, boolean z) {
        int i;
        if (z || view != null) {
            if (z && view == this.binding.getRoot()) {
                return;
            }
            view.setTag(z ? "selected" : "");
            Entity entity = this.entity;
            boolean z2 = (entity instanceof Adventurer) && ((Adventurer) entity).isAscended();
            if (view instanceof TextView) {
                ((TextView) view).setTypeface(null, z ? 1 : 0);
                return;
            }
            if (view instanceof ConstraintLayout) {
                view.setBackgroundResource(z ? R.drawable.object_border_dim_white_extra_opaque : R.drawable.object_border_dim_white);
                return;
            }
            if (!(view instanceof ImageView)) {
                if (view == this.binding.detailExperienceBar) {
                    this.binding.detailExperience.setTypeface(null, z ? 1 : 0);
                }
            } else {
                if (z) {
                    i = z2 ? R.drawable.object_border_ascended_extra_opaque : R.drawable.object_border_dim_white_extra_opaque;
                } else {
                    i = z2 ? R.drawable.object_border_ascended : R.drawable.object_border_dim_white;
                }
                view.setBackgroundResource(i);
            }
        }
    }

    public static String formatEquipmentHelp(Equipment equipment, Resources resources) {
        return resources.getString(equipment.getIdName()) + "\n" + UIUtils.formatEquipmentDescription(equipment, resources);
    }

    private String formatMaxExperience(int i) {
        return String.valueOf(i >= 10000 ? (i / 1000) + getString(R.string.abbreviation_thousands) : Integer.valueOf(i));
    }

    private void dialogAdventurerPromotion(Adventurer adventurer) {
        if (adventurer.getMaxLevel() < 45) {
            promote(adventurer);
        } else {
            ascend(adventurer);
        }
    }

    private void promote(Adventurer adventurer) {
        if (MainActivity.shownDialogPromotionChoices != null) {
            return;
        }
        DialogPromotionChoices dialogPromotionChoices = new DialogPromotionChoices();
        dialogPromotionChoices.setAdventurer(adventurer);
        dialogPromotionChoices.show(getParentFragmentManager(), "dialog_promotion");
    }

    private void ascend(Adventurer adventurer) {
        DialogPromotionChoices.showConfirmationDialog(this, adventurer, Adventurer.getInstance(Utils.getBaseClass(adventurer), adventurer.getId(), 1, 0, adventurer.getWeapon(), adventurer.getArmor(), adventurer.getAccessory(), adventurer.getTraitCommon(), adventurer.getTraitRare(), adventurer.getPotionsDrank(), adventurer.getDoctrine(), true));
    }

    private void clickDoctrine(Adventurer adventurer) {
        if (adventurer.getDoctrine() == null || (adventurer.getDoctrine() instanceof EmptyDoctrine)) {
            if (MainActivity.shownDialogChooseDoctrine != null) {
                return;
            }
            DialogChooseDoctrine dialogChooseDoctrine = new DialogChooseDoctrine();
            dialogChooseDoctrine.setAdventurer(adventurer);
            dialogChooseDoctrine.show(getParentFragmentManager(), "dialog_change_doctrine");
            return;
        }
        UIUtils.openDoctrineDialog(adventurer, null);
    }

    private void formatPotion(TextView textView, Adventurer adventurer, int i) {
        int i2 = adventurer.getPotionsDrank().get(i);
        int iCalculateMaxPotions = adventurer.calculateMaxPotions(i);
        textView.setText(String.format(getString(R.string.min_bar_max), Integer.valueOf(i2), Integer.valueOf(iCalculateMaxPotions)));
        if (i2 >= iCalculateMaxPotions) {
            textView.setTextColor(getResources().getColor(R.color.brass_filler, getContext().getTheme()));
        }
    }

    private void changePage(boolean z) {
        int i;
        boolean z2;
        boolean z3;
        Entity entity = this.entity;
        if (entity instanceof Adventurer) {
            i = ((Adventurer) entity).isSummonedMinion() ? 3 : 4;
        } else {
            i = 2;
        }
        int i2 = this.currentPage + (z ? 1 : -1);
        this.currentPage = i2;
        if (i2 == 1) {
            z2 = false;
            z3 = true;
        } else if (i2 >= i) {
            z3 = false;
            z2 = true;
        } else {
            z2 = true;
            z3 = true;
        }
        this.binding.arrowLeft.setVisibility(z2 ? 0 : 8);
        this.binding.arrowRight.setVisibility(z3 ? 0 : 8);
        this.binding.page.setText(String.format(getString(R.string.min_bar_max), Integer.valueOf(this.currentPage), Integer.valueOf(i)));
        this.binding.containerStats.setVisibility(this.currentPage == 1 ? 0 : 4);
        this.binding.containerSecondaryStats.setVisibility(this.currentPage == 2 ? 0 : 4);
        this.binding.containerTertiaryStats.setVisibility(this.currentPage == 3 ? 0 : 4);
        this.binding.containerPotions.setVisibility(this.currentPage == 4 ? 0 : 4);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.promotion) {
            MainActivity.shownDialogAdventurerDetailPromotion = this;
        } else {
            MainActivity.shownDialogEntityDetail = this;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        if (this.promotion) {
            MainActivity.shownDialogAdventurerDetailPromotion = null;
        } else {
            MainActivity.shownDialogEntityDetail = null;
        }
        super.onStop();
    }

    public Entity getEntity() {
        return this.entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }
}
