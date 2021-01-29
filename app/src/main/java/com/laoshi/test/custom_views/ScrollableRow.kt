package com.laoshi.test.custom_views

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.laoshi.test.R
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.custom_horizontal_scroll.view.*

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class ScrollableRow @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
) : LinearLayout(context, attrs, defStyle) {

    init {
        LayoutInflater.from(context).inflate(R.layout.custom_horizontal_scroll, this, true)

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.horizontal_attrs, 0, 0)
            val title = resources.getText(
                typedArray
                    .getResourceId(R.styleable.horizontal_attrs_custom_row_name, R.string.def_val)
            )
            row_name.text = title
            typedArray.recycle()
        }
    }

    fun setTitle(title: String?) {
        if (!title.isNullOrEmpty()) row_name.text = title
    }

    fun addChild(view: View) {
        findViewById<LinearLayout>(R.id.horizontal_body).addView(view)
    }
}