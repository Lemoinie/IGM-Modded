package it.paranoidsquirrels.idleguildmaster.ui.components

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.GridView

class NonScrollableGridView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : GridView(context, attrs) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(
            widthMeasureSpec,
            View.MeasureSpec.makeMeasureSpec(536870911, View.MeasureSpec.AT_MOST)
        )
        layoutParams?.let {
            it.height = measuredHeight
        }
    }
}
