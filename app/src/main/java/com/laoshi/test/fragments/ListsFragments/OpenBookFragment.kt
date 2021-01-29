package com.laoshi.test.fragments.ListsFragments

import android.opengl.Visibility
import com.laoshi.test.R
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.laoshi.test.MainActivity
import com.laoshi.test.custom_views.CardView
import com.laoshi.test.custom_views.LongCardView
import com.laoshi.test.custom_views.ScrollableRow
import com.laoshi.test.entities.Entities
import com.laoshi.test.entities.Title
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.open_book_fragment.*
import java.lang.reflect.Type

class OpenBookFragment : Fragment() {
    lateinit var main: MainActivity
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.open_book_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        main = activity as MainActivity
        main.header.visibility = View.GONE
        var gson = Gson()
        val listType: Type = object : TypeToken<Entities.Book.Children?>() {}.getType()
        val bookObj =
            gson.fromJson<Entities.Book.Children>(arguments?.get("book_obj").toString(), listType)
        val openBookBody = view.findViewById<LinearLayout>(R.id.open_book_content)
        open_book_title.text = bookObj.title?.ru
        open_book_description.text = bookObj.description?.ru
        main.imageController.downloadImage(bookObj.image?.thumbnail)
            .observe(main as LifecycleOwner, Observer {
                open_book_image.setImageBitmap(main.imageController.roundImage(it, 40.toFloat()))
            })
        Log.e("open_book", "got " + bookObj.title?.ru + "(book) at OpenBookFragment")
        var num = 1
        for (bookChild in bookObj.children!!) {
            Log.e(
                "open_book",
                "got " + bookChild.title?.ru + " = " + bookChild.children.toString() + "(bookChild) at OpenBookFragment"
            )
            val longCard = LongCardView(view.context)
            longCard.setTitle(bookChild.title?.ru)
            longCard.setWordsCount(bookChild.words_count?.toString())
            longCard.setNumber(num.toString())
            openBookBody.addView(longCard)
            num++
        }


    }
}