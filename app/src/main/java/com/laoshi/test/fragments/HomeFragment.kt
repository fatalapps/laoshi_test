package com.laoshi.test.fragments

import com.laoshi.test.R

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.laoshi.test.MainActivity
import kotlinx.android.synthetic.main.activity_main.*

class HomeFragment : Fragment() {
    lateinit var main: MainActivity
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        main = activity as MainActivity
        main.header.visibility = View.VISIBLE

    }
}