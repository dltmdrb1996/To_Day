package com.example.today.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.today.R
import com.example.today.databinding.ActivityMainBinding
import com.example.today.presentation.homeFrag.HomeFragment
import com.example.today.presentation.saveFrag.SaveFragment
import com.fridayof1995.tabanimation.SnapTabLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewPagerAdapter: ViewPagerAdapter = ViewPagerAdapter(supportFragmentManager);
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )
        viewPagerAdapter.addFragment(MovieFragment())
        viewPagerAdapter.addFragment(MusicFragment())
        viewPagerAdapter.addFragment(HomeFragment())
        viewPagerAdapter.addFragment(EngFragment())
        viewPagerAdapter.addFragment(SaveFragment())

        binding.viewPager.adapter = viewPagerAdapter
        binding.viewPager.offscreenPageLimit = 0
        binding.tabLayout.numOfTabs = SnapTabLayout.NumOfTabs.FIVE

        binding.tabLayout.setBackgroundCollapsed(R.drawable.tab_gradient_collapsed)
        binding.tabLayout.setBackgroundExpanded(R.drawable.tab_gradient_expanded)

        binding.tabLayout.smallCenterButton.setImageResource(R.drawable.ic_baseline_home_24)
        binding.tabLayout.smallCenterButton.setColorFilter(R.color.black)
        binding.tabLayout.largeCenterButton.setImageResource(R.drawable.ring)
        binding.tabLayout.startButton.setImageResource(R.drawable.ic_baseline_movie_24)
        binding.tabLayout.endButton.setImageResource(R.drawable.ic_baseline_save_24)
        binding.tabLayout.midStart.setImageResource(R.drawable.ic_baseline_music_note_24)
        binding.tabLayout.midEnd.setImageResource(R.drawable.ic_baseline_school_24)
        binding.viewPager.offscreenPageLimit
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }


}