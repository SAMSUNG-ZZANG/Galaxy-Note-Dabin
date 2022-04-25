package org.sopt.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.sopt.core.util.ItemDiffCallback
import org.sopt.home.databinding.ItemFollowerBinding
import org.sopt.home.databinding.ItemRepositoryBinding

class HomeAdapter(private val inflater: LayoutInflater, private val itemViewType: String) :
    ListAdapter<Pair<String, String>, HomeAdapter.HomeViewHolder>(
        ItemDiffCallback<Pair<String, String>>(
            onContentsTheSame = { old, new -> old == new },
            onItemsTheSame = { old, new -> old == new }
        )
    ) {
    class HomeViewHolder(private val binding: ViewDataBinding, private val viewType: String) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Pair<String, String>) {
            when (viewType) {
                FOLLOWER -> {
                    with(binding as ItemFollowerBinding) {
                        tvName.text = data.first
                        tvContent.text = data.second
                    }
                }
                else -> {
                    with(binding as ItemRepositoryBinding) {
                        tvName.text = data.first
                        tvContent.text = data.second
                    }
                }
            }
        }
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = when (itemViewType) {
            FOLLOWER -> ItemFollowerBinding.inflate(inflater, parent, false)
            else -> ItemRepositoryBinding.inflate(inflater, parent, false)
        }
        return HomeViewHolder(binding, itemViewType)
    }

    companion object {
        const val FOLLOWER = "FOLLOWER"
        const val REPO = "REPO"
    }
}
