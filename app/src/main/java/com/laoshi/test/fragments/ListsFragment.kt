package com.laoshi.test.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.laoshi.test.MainActivity
import com.laoshi.test.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_lists.*


class ListsFragment : Fragment() {
    lateinit var main: MainActivity
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lists, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        main = activity as MainActivity
        main.header.visibility = View.VISIBLE
        switchMenu(view.findViewById<ConstraintLayout>(R.id.theme_menu), view)
        //  view.findViewById<Button>(R.id.button_first).setOnClickListener {
        //      findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        //  }
        view.findViewById<ConstraintLayout>(R.id.theme_menu).setOnClickListener {
            switchMenu(it, view)

        }
        view.findViewById<ConstraintLayout>(R.id.books_menu).setOnClickListener {
            switchMenu(it, view)

        }
        view.findViewById<ConstraintLayout>(R.id.hsk_menu).setOnClickListener {
            switchMenu(it, view)

        }
        view.findViewById<ConstraintLayout>(R.id.mine_menu).setOnClickListener {
            switchMenu(it, view)

        }
    }

    private fun switchMenu(view: View, mainView: View) {
        when (view.id) {
            R.id.theme_menu -> {
                view.findViewById<ImageView>(R.id.theme_icon)
                    .setImageResource(R.drawable.ic_circle_checked)
                view.setBackgroundResource(R.drawable.rounded_corners)

                mainView.findViewById<ImageView>(R.id.books_icon)
                    .setImageResource(R.drawable.ic_circle_unchecked)
                mainView.findViewById<ConstraintLayout>(R.id.books_menu)
                    .setBackgroundResource(R.drawable.rounded_corners_trans)

                mainView.findViewById<ImageView>(R.id.hsk_icon)
                    .setImageResource(R.drawable.ic_circle_unchecked)
                mainView.findViewById<ConstraintLayout>(R.id.hsk_menu)
                    .setBackgroundResource(R.drawable.rounded_corners_trans)

                mainView.findViewById<ImageView>(R.id.mine_icon)
                    .setImageResource(R.drawable.ic_circle_unchecked)
                mainView.findViewById<ConstraintLayout>(R.id.mine_menu)
                    .setBackgroundResource(R.drawable.rounded_corners_trans)
                main.findNavController(R.id.nav_lists_fragment).navigate(R.id.CollectionFragment)
            }
            R.id.books_menu -> {
                view.findViewById<ImageView>(R.id.books_icon)
                    .setImageResource(R.drawable.ic_circle_checked)
                view.setBackgroundResource(R.drawable.rounded_corners)

                mainView.findViewById<ImageView>(R.id.theme_icon)
                    .setImageResource(R.drawable.ic_circle_unchecked)
                mainView.findViewById<ConstraintLayout>(R.id.theme_menu)
                    .setBackgroundResource(R.drawable.rounded_corners_trans)

                mainView.findViewById<ImageView>(R.id.hsk_icon)
                    .setImageResource(R.drawable.ic_circle_unchecked)
                mainView.findViewById<ConstraintLayout>(R.id.hsk_menu)
                    .setBackgroundResource(R.drawable.rounded_corners_trans)

                mainView.findViewById<ImageView>(R.id.mine_icon)
                    .setImageResource(R.drawable.ic_circle_unchecked)
                mainView.findViewById<ConstraintLayout>(R.id.mine_menu)
                    .setBackgroundResource(R.drawable.rounded_corners_trans)
                main.findNavController(R.id.nav_lists_fragment).navigate(R.id.BookFragment)

            }
            R.id.hsk_menu -> {
                view.findViewById<ImageView>(R.id.hsk_icon)
                    .setImageResource(R.drawable.ic_circle_checked)
                view.setBackgroundResource(R.drawable.rounded_corners)

                mainView.findViewById<ImageView>(R.id.books_icon)
                    .setImageResource(R.drawable.ic_circle_unchecked)
                mainView.findViewById<ConstraintLayout>(R.id.books_menu)
                    .setBackgroundResource(R.drawable.rounded_corners_trans)

                mainView.findViewById<ImageView>(R.id.theme_icon)
                    .setImageResource(R.drawable.ic_circle_unchecked)
                mainView.findViewById<ConstraintLayout>(R.id.theme_menu)
                    .setBackgroundResource(R.drawable.rounded_corners_trans)

                mainView.findViewById<ImageView>(R.id.mine_icon)
                    .setImageResource(R.drawable.ic_circle_unchecked)
                mainView.findViewById<ConstraintLayout>(R.id.mine_menu)
                    .setBackgroundResource(R.drawable.rounded_corners_trans)
                main.findNavController(R.id.nav_lists_fragment).navigate(R.id.HskFragment)

            }
            R.id.mine_menu -> {
                view.findViewById<ImageView>(R.id.mine_icon)
                    .setImageResource(R.drawable.ic_circle_checked)
                view.setBackgroundResource(R.drawable.rounded_corners)

                mainView.findViewById<ImageView>(R.id.books_icon)
                    .setImageResource(R.drawable.ic_circle_unchecked)
                mainView.findViewById<ConstraintLayout>(R.id.books_menu)
                    .setBackgroundResource(R.drawable.rounded_corners_trans)

                mainView.findViewById<ImageView>(R.id.hsk_icon)
                    .setImageResource(R.drawable.ic_circle_unchecked)
                mainView.findViewById<ConstraintLayout>(R.id.hsk_menu)
                    .setBackgroundResource(R.drawable.rounded_corners_trans)

                mainView.findViewById<ImageView>(R.id.theme_icon)
                    .setImageResource(R.drawable.ic_circle_unchecked)
                mainView.findViewById<ConstraintLayout>(R.id.theme_menu)
                    .setBackgroundResource(R.drawable.rounded_corners_trans)
                main.findNavController(R.id.nav_lists_fragment).navigate(R.id.MineFragment)

            }
        }
    }
}