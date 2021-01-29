package com.laoshi.test.fragments.ListsFragments

import com.laoshi.test.R
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.os.bundleOf
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.google.gson.Gson
import com.laoshi.test.MainActivity
import com.laoshi.test.custom_views.BookCard
import com.laoshi.test.custom_views.CardView
import com.laoshi.test.custom_views.ScrollableRow

class BookFragment : Fragment() {
    lateinit var main: MainActivity
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_book, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        main = activity as MainActivity
        val bookBody = view.findViewById<LinearLayout>(R.id.book_body)
        main.dbController.getBooks().observe(main as LifecycleOwner, Observer {
            Log.e("book", "got " + it.size + "(book) at BookFragment")
            for (book in it) {
                val title = book.title?.ru
                val description = book.description?.ru
                val count = book.words_count
                val image = book.image?.preview
                val type = book.type
                val index = book.index
                val size = book.children?.size
                val bookCard = BookCard(view.context)
                bookCard.setTitle(title)
                bookCard.setDescription(description)
                main.imageController.downloadImage(image).observe(main as LifecycleOwner, Observer {
                    bookCard.setPreview(main.imageController.roundImage(it, 70.toFloat()))
                })
                val row = getRowName(title)
                bookCard.setRowName(row)
                (bookCard.findViewById<ConstraintLayout>(R.id.clickable_row)).setOnClickListener {
                    Log.e("book", "book clicked")
                    var gson = Gson()
                    var bundle = bundleOf(Pair("book_obj", gson.toJson(book)))
                    main.findNavController(R.id.nav_host_fragment)
                        .navigate(R.id.OpenBookFragment, bundle)
                }
                bookBody.addView(bookCard)
                Log.e("book", "book - [$title, $description, $count, $image, $type, $index, $size]")
            }
        })
    }

    fun getRowName(title: String?): String {
        return if (title!!.get(0).isDigit()) "0 - 9" else title!!.get(0).toString()
    }
}