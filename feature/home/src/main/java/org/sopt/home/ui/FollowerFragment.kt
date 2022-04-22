package org.sopt.home.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.sopt.core.base.BindingFragment
import org.sopt.home.R
import org.sopt.home.adapter.HomeAdapter
import org.sopt.home.databinding.FragmentFollowerBinding
import org.sopt.home.viewmodel.HomeViewModel

@AndroidEntryPoint
class FollowerFragment : BindingFragment<FragmentFollowerBinding>(R.layout.fragment_follower) {
    private val viewModel: HomeViewModel by activityViewModels()
    private lateinit var followerAdapter: HomeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        observeData()
    }

    private fun observeData() {
        viewModel.repositoryList.flowWithLifecycle(viewLifecycleOwner.lifecycle)
            .onEach {
                followerAdapter.submitList(it)
            }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun initAdapter() {
        followerAdapter = HomeAdapter(requireActivity().layoutInflater, HomeAdapter.FOLLOWER)
        binding.rvFollower.adapter = followerAdapter
    }
}
