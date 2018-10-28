package com.example.sin.reweqad

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.main_activity.*

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val pagerAdapter = MyPagerAdapter(supportFragmentManager)
        pager.adapter = pagerAdapter

        tabs.setupWithViewPager(pager)
    }
}
