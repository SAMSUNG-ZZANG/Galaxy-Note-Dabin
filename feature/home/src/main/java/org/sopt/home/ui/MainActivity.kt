package org.sopt.home.ui

import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.core.base.BindingActivity
import org.sopt.home.R
import org.sopt.home.adapter.SOPTViewPagerAdapter
import org.sopt.home.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewPager()
    }

    private fun initViewPager() {
        with(binding) {
            vpMain.adapter = SOPTViewPagerAdapter(this@MainActivity).apply {
                fragmentList = listOf(ProfileFragment(), HomeFragment(), CameraFragment())
            }

            vpMain.registerOnPageChangeCallback(
                object : ViewPager2.OnPageChangeCallback() {
                    override fun onPageSelected(position: Int) {
                        bnvMain.menu.getItem(
                            when (position) {
                                0 -> 0
                                1 -> 1
                                else -> 2
                            }
                        ).isChecked = true
                    }
                }
            )

            bnvMain.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.menu_profile -> vpMain.currentItem = 0
                    R.id.menu_home -> vpMain.currentItem = 1
                    else -> vpMain.currentItem = 2
                }
                return@setOnItemSelectedListener true
            }
        }
    }
}
