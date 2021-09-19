package com.example.newsapplication.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.newsapplication.data.source.local.entity.EntertainmentEntity
import com.example.newsapplication.data.source.local.entity.HealthEntity
import com.example.newsapplication.utils.Utils
import com.example.newsapplications.R
import com.example.newsapplications.databinding.ListItemNewsBinding

class HealthAdapter :  PagedListAdapter<HealthEntity, HealthAdapter.HealthViewHolder>(
    DIFF_CALLBACK
) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<HealthEntity>() {
            override fun areItemsTheSame(
                oldItem: HealthEntity,
                newItem: HealthEntity
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: HealthEntity,
                newItem: HealthEntity
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HealthViewHolder {
        val itemNewBinding =
            ListItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HealthViewHolder(itemNewBinding)
    }

    override fun onBindViewHolder(holder: HealthViewHolder, position: Int) {
        val news = getItem(position)
        holder.bind(news)
    }

    class HealthViewHolder(private val binding: ListItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(news: HealthEntity?) {
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
