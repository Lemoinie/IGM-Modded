package it.paranoidsquirrels.idleguildmaster.ui.components;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

/* JADX INFO: loaded from: classes3.dex */
public class NonScrollableGridView extends GridView {
    public NonScrollableGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }
}
