package com.laoshi.test.custom_views

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.laoshi.test.R

import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.card_view.view.*

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class CardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
) : ConstraintLayout(context, attrs, defStyle) {

    init {
        LayoutInflater.from(context).inflate(R.layout.card_view, this, true)

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.card_view_attrs, 0, 0)
            val title = resources.getText(
                typedArray
                    .getResourceId(R.styleable.card_view_attrs_custom_card_title, R.string.def_val)
            )
            card_title.text = title
            words_count.hint = "${resources.getString(R.string.def_val)} $title"

            typedArray.recycle()
        }
    }

    fun setTitle(title: String?) {
        if (!title.isNullOrEmpty()) card_title.text = title
    }

    fun setWordsCount(count: String?) {
        if (!count.isNullOrEmpty()) words_count.text = count
    }
}