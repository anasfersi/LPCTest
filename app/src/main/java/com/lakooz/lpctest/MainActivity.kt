package com.lakooz.lpctest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager2.adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        setSupportActionBar(toolbar)

        TabLayoutMediator(tab_layout, viewPager2,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                tab.text = when (position) {
                    0 -> "Anniversaire"
                    1 -> "Départ"
                    2 -> "Solidaire"
                    else -> "Anniversaire"
                }
            }).attach()


        swipe_refresh_layout.setProgressViewOffset(
            true,
            START_SWIPE_REFRESH,
            resources.getDimension(R.dimen.swipe_refresh_offset).toInt()
        )

        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.isRefreshing.observe(this, Observer {
            swipe_refresh_layout.isRefreshing = it
        })


        swipe_refresh_layout.setOnRefreshListener {
            viewModel.getPots()
        }

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrollStateChanged(state: Int) {
                val viewPagerIdle = state == ViewPager2.SCROLL_STATE_IDLE
                swipe_refresh_layout.isEnabled = viewPagerIdle
            }
        })

        fab.setOnClickListener {
            viewModel.createPot(viewPager2.currentItem)
        }
    }

    companion object {
        private const val START_SWIPE_REFRESH = 50
    }
}