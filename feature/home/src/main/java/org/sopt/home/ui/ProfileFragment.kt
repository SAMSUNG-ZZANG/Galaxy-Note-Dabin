package org.sopt.home.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.core.base.BindingFragment
import org.sopt.core.util.ext.replace
import org.sopt.home.R
import org.sopt.home.databinding.FragmentProfileBinding
import org.sopt.home.viewmodel.HomeViewModel

@AndroidEntryPoint
class ProfileFragment : BindingFragment<FragmentProfileBinding>(R.layout.fragment_profile) {
    private val viewModel: HomeViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        replace(R.id.container_home, FollowerFragment())
        binding.btnFollower.isSelected = true
        initClickEvent()
        initData()
    }

    private fun initData() {
        viewModel.getFollowerList()
        viewModel.getRepositoryList()
    }

    private fun initClickEvent() {
        with(binding) {
            btnFollower.setOnClickListener {
                it.isSelected = true
                btnRepo.isSelected = !it.isSelected
                replace(R.id.container_home, FollowerFragment())
            }

            btnRepo.setOnClickListener {
                it.isSelected = true
                btnFollower.isSelected = !it.isSelected
                replace(R.id.container_home, RepositoryFragment())
            }
        }
    }
}
