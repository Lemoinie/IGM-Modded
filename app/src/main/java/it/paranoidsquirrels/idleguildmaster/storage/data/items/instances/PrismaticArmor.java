package it.paranoidsquirrels.idleguildmaster.storage.data.items.instances;

import it.paranoidsquirrels.idleguildmaster.R;
import it.paranoidsquirrels.idleguildmaster.storage.data.items.abstractClasses.HeavyArmor;

/* JADX INFO: loaded from: classes3.dex */
public class PrismaticArmor extends HeavyArmor {
    @Override // it.paranoidsquirrels.idleguildmaster.storage.data.items.Item
    protected void configureProperties() {
        this.idName = R.string.armor_heavy_prismatic_armor_name;
        this.idDescription = R.string.armor_heavy_prismatic_armor_description;
        this.idImage = R.drawable.prismatic_armor;
        this.price = 20850L;
        this.maxHp = 230;
        this.defense = 15;
        this.magicDefense = 15;
    }
}
