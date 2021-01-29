package com.laoshi.test

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import com.laoshi.test.controllers.DbController
import com.laoshi.test.controllers.ImageController
import com.laoshi.test.db.AppDatabase
import com.laoshi.test.entities.Entities
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var dbController: DbController
    lateinit var imageController: ImageController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dbController = DbController(context = this)
        dbController.initDb()
        dbController.updateEntities()
        dbController.updateWords()
        imageController = ImageController(this)
        navigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_lists -> {
                    Log.e("tag", "to_lists")
                    NavHostFragment.findNavController(nav_host_fragment)
                        .navigate(R.id.FirstFragment)
                    header_title.text = (getString(R.string.lists))
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.navigation_home -> {
                    Log.e("tag", "to_home")
                    NavHostFragment.findNavController(nav_host_fragment).navigate(R.id.HomeFragment)
                    header_title.text = (getString(R.string.home))
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.navigation_middle -> {
                    Log.e("tag", "to_middle")
                    NavHostFragment.findNavController(nav_host_fragment)
                        .navigate(R.id.MiddleFragment)
                    header_title.text = (getString(R.string.middle))
                    return@setOnNavigationItemSelectedListener true
                }

            }
            false

        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        val count = supportFragmentManager.backStackEntryCount
        if (count == 0) {
            super.onBackPressed()
            //additional code
        } else {
            supportFragmentManager.popBackStack()
        }
    }

}