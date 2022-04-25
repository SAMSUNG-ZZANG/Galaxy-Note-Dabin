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
import org.sopt.home.adapter.HomeAdapter.Companion.REPO
import org.sopt.home.databinding.FragmentRepositoryBinding
import org.sopt.home.viewmodel.HomeViewModel

@AndroidEntryPoint
class RepositoryFragment :
    BindingFragment<FragmentRepositoryBinding>(R.layout.fragment_repository) {
    private val viewModel: HomeViewModel by activityViewModels()
    private lateinit var repositoryAdapter: HomeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        observeData()
    }

    private fun observeData() {
        viewModel.repositoryList.flowWithLifecycle(viewLifecycleOwner.lifecycle)
            .onEach {
                repositoryAdapter.submitList(it)
            }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun initAdapter() {
        repositoryAdapter = HomeAdapter(requireActivity().layoutInflater, REPO)
        binding.rvRepository.adapter = repositoryAdapter
    }
}
