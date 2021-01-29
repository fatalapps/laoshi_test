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
import androidx.core.view.marginTop
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.google.gson.Gson
import com.laoshi.test.MainActivity
import com.laoshi.test.custom_views.CardView
import com.laoshi.test.custom_views.ScrollableRow

class CollectionFragment : Fragment() {
    lateinit var main: MainActivity
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_collection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        main = activity as MainActivity
        val collectionBody = view.findViewById<LinearLayout>(R.id.collection_body)
        main.dbController.getCollection().observe(main as LifecycleOwner, Observer {
            Log.e("collection", "got " + it.size + "(collection) at CollectionFragment")

            for (collection in it) {
                val scrollable = ScrollableRow(view.context)
                scrollable.setTitle(collection.title?.ru)
                for (child in collection.children!!) {
                    val custom_card = CardView(view.context)
                    custom_card.setTitle(child.title?.ru)
                    custom_card.setWordsCount(child.words_count!!.toString())
                    custom_card.findViewById<ConstraintLayout>(R.id.clickable_card)
                        .setOnClickListener {
                            Log.e("book", "book clicked")
                            var gson = Gson()
                            var bundle = bundleOf(
                                Pair("words_obj", gson.toJson(child.words)),
                                Pair("section_title", child.title!!.ru)
                            )
                            main.findNavController(R.id.nav_host_fragment)
                                .navigate(R.id.WordsFragment, bundle)
                        }
                    scrollable.addChild(custom_card)
                }
                collectionBody.addView(scrollable)
            }

        })
    }
}