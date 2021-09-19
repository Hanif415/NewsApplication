package com.example.newsapplication.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.newsapplication.data.source.local.entity.SportsEntity
import com.example.newsapplication.utils.Utils
import com.example.newsapplications.R
import com.example.newsapplications.databinding.ListItemNewsBinding

class SportsAdapter : PagedListAdapter<SportsEntity, SportsAdapter.SportViewHolder>(
    DIFF_CALLBACK
) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<SportsEntity>() {
            override fun areItemsTheSame(
                oldItem: SportsEntity,
                newItem: SportsEntity
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: SportsEntity,
                newItem: SportsEntity
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportViewHolder {
        val itemNewBinding =
            ListItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SportViewHolder(itemNewBinding)
    }

    override fun onBindViewHolder(holder: SportViewHolder, position: Int) {
        val news = getItem(position)
        holder.bind(news)
    }

    class SportViewHolder(private val binding: ListItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(news: SportsEntity?) {
            with(binding) {
                if (news != null) {
                    tvTimeAgo.text = Utils.dateTimeHourAgo(news.publishedAt)
                    tvNameSource.text = news.source
                    tvTitleNews.text = news.title
                    tvDateTime.text = Utils.dateFormat(news.publishedAt)

                    Glide.with(itemView.context).load(news.urlToImage).apply(
                        RequestOptions.placeholderOf(
                            R.drawable.ic_loading
                        ).error(R.drawable.ic_error)
                    ).into(imageThumbnail)
                }
            }
        }
    }
}