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
import com.laoshi.test.custom_views.WordCardView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_words.*
import java.lang.reflect.Type

class WordsFragment : Fragment() {
    lateinit var main: MainActivity
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_words, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        main = activity as MainActivity
        main.header.visibility = View.GONE
        var gson = Gson()
        val listType: Type = object : TypeToken<List<Int>>() {}.getType()
        val title = arguments?.get("section_title").toString()
        val wordsIds = gson.fromJson<List<Int>>(arguments?.get("words_obj").toString(), listType)
        val wordsBody = view.findViewById<LinearLayout>(R.id.words_body)
        words_section_name.text = title
        Log.e("open_book", "got $title (words' section) at WordsFragment")
        for (wordId in wordsIds) {
            main.dbController.getWord(wordId.toString()).observe(main as LifecycleOwner, Observer {
                val wordCard = WordCardView(view.context)
                wordCard.setChinese(it.word)
                var category = ""
                if (it.categories!!.size > 0) category = it.categories.get(0).ru!!
                wordCard.setLevel(category)
                wordCard.setTranslation(it.translations!!.ru)
                wordCard.setTranscription(it.transcriptions.toString())
                wordsBody.addView(wordCard)
            })
        }


    }
}