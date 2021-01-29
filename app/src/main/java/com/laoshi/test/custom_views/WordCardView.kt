package com.laoshi.test.custom_views

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.LayoutInflater
import com.laoshi.test.R
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.word_card_view.view.*

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class WordCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
) : ConstraintLayout(context, attrs, defStyle) {

    init {
        LayoutInflater.from(context).inflate(R.layout.word_card_view, this, true)

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.card_view_attrs, 0, 0)
            val title = resources.getText(
                typedArray
                    .getResourceId(R.styleable.card_view_attrs_custom_card_title, R.string.def_val)
            )
            word_chinese_chars.text = title
            typedArray.recycle()
        }
    }

    fun setChinese(value: String?) {
        if (!value.isNullOrEmpty()) word_chinese_chars.text = value
    }

    fun setTranslation(value: String?) {
        if (!value.isNullOrEmpty()) word_translation.text = value
    }

    fun setTranscription(value: String?) {
        if (!value.isNullOrEmpty()) word_transcription.text = value
    }

    fun setLevel(value: String?) {
        if (!value.isNullOrEmpty()) word_level.text = value
    }
}