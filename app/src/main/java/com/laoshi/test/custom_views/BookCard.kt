package com.laoshi.test.custom_views

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import com.laoshi.test.R
import kotlinx.android.synthetic.main.custom_book_row.view.*
import java.io.InputStream
import java.net.URL
import kotlin.concurrent.thread


@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class BookCard @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
) : LinearLayout(context, attrs, defStyle) {

    init {
        LayoutInflater.from(context).inflate(R.layout.custom_book_row, this, true)

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.book_attrs, 0, 0)
            val title = resources.getText(
                typedArray
                    .getResourceId(R.styleable.book_attrs_custom_book_title, R.string.def_val)
            )
            book_title.text = title
            typedArray.recycle()
        }
    }

    fun setTitle(title: String?) {
        if (!title.isNullOrEmpty()) book_title.text = title
    }

    fun setDescription(descr: String?) {
        if (!descr.isNullOrEmpty()) book_description.text = descr
    }

    fun setRowName(name: String?) {
        if (!name.isNullOrEmpty()) row_name.text = name
    }

    fun setPreview(bmp: Bitmap?) {
        book_preview.setImageBitmap(bmp)
    }
}