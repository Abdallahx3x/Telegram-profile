package com.example.telegram_profile

import android.os.Bundle
import android.view.Menu
import android.view.View
import android.view.View.OnCreateContextMenuListener
import android.widget.ImageView
import android.widget.Toolbar
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import com.example.telegram_profile.databinding.ActivityScrollingBinding
import com.google.android.material.appbar.AppBarLayout

class ScrollingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        changeProfileName()
        makeProfileCircle()


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_scrolling,menu)
        return true
    }
    private fun makeProfileCircle(){

        val appBarLayout = findViewById<AppBarLayout>(R.id.app_bar)
        val profileImageToolbar = findViewById<ImageView>(R.id.circle_image_profile)
        appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            val maxScroll = appBarLayout.totalScrollRange
            val percentage = 1 - Math.abs(verticalOffset).toFloat() / maxScroll.toFloat()
            // If the toolbar is fully collapsed, show the profile picture in the toolbar
            if (percentage == 0f) {
                profileImageToolbar.visibility = View.VISIBLE
            } else {
                profileImageToolbar.visibility = View.GONE
            }
        })

    }

    private fun changeProfileName(){
        setSupportActionBar(findViewById(R.id.toolbar))
        binding.toolbarLayout.title = "Abdallah"
    }



}