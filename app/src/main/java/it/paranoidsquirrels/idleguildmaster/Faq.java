package it.paranoidsquirrels.idleguildmaster;

/* JADX INFO: loaded from: classes3.dex */
public enum Faq {
    FAQ_1(R.string.drawer_faq_idle_progression_title, R.string.drawer_faq_idle_progression_body),
    FAQ_2(R.string.drawer_faq_death_title, R.string.drawer_faq_death_body),
    FAQ_3(R.string.drawer_faq_dismiss_reorder_title, R.string.drawer_faq_dismiss_reorder_body),
    FAQ_4(R.string.fragment_name_raids, R.string.drawer_faq_raids_body),
    FAQ_5(R.string.drawer_faq_epic_raids_title, R.string.drawer_faq_epic_raids_body);

    public int body;
    public int title;

    Faq(int i, int i2) {
        this.title = i;
        this.body = i2;
    }
}
