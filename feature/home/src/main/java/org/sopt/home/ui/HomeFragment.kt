package org.sopt.home.ui

import android.os.Bundle
import android.view.View
import coil.load
import com.google.android.material.tabs.TabLayoutMediator
import org.sopt.core.base.BindingFragment
import org.sopt.core.util.ext.stringListFrom
import org.sopt.core.util.getGifLoader
import org.sopt.home.R
import org.sopt.home.adapter.SOPTViewPagerAdapter
import org.sopt.home.databinding.FragmentHomeBinding

class HomeFragment : BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ivLogo.load(R.raw.gif_guy_run, requireContext().getGifLoader())
        initViewPager()
    }

    private fun initViewPager() {
        with(binding) {
            vpHome.adapter = SOPTViewPagerAdapter(requireActivity()).apply {
                fragmentList = listOf(EmptyFragment(), EmptyFragment())
            }

            TabLayoutMediator(tlHome, vpHome) { tab, position ->
                tab.text = stringListFrom(R.array.tab_label)[position]
            }.attach()
        }
    }
}
