package org.sopt.home.ui

import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.core.base.BindingActivity
import org.sopt.core.util.ext.replace
import org.sopt.home.R
import org.sopt.home.databinding.ActivityHomeBinding
import org.sopt.home.viewmodel.HomeViewModel

@AndroidEntryPoint
class HomeActivity : BindingActivity<ActivityHomeBinding>(R.layout.activity_home) {
    private val viewModel : HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        replace(R.id.container_home, FollowerFragment())
        initClickEvent()
        initData()
    }

    private fun initData() {
        viewModel.getFollowerList()
        viewModel.getRepositoryList()
    }

    private fun initClickEvent() {
        binding.btnFollower.setOnClickListener {
            replace(R.id.container_home, FollowerFragment())
        }

        binding.btnRepo.setOnClickListener {
            replace(R.id.container_home, RepositoryFragment())
        }
    }
}
