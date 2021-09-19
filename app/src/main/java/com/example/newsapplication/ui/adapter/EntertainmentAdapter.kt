package com.example.newsapplication.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.newsapplication.data.source.local.entity.BusinessEntity
import com.example.newsapplication.data.source.local.entity.EntertainmentEntity
import com.example.newsapplication.utils.Utils
import com.example.newsapplications.R
import com.example.newsapplications.databinding.ListItemNewsBinding

class EntertainmentAdapter :
    PagedListAdapter<EntertainmentEntity, EntertainmentAdapter.EntertainmentViewHolder>(
        DIFF_CALLBACK
    ) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<EntertainmentEntity>() {
            override fun areItemsTheSame(
                oldItem: EntertainmentEntity,
                newItem: EntertainmentEntity
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: EntertainmentEntity,
                newItem: EntertainmentEntity
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntertainmentViewHolder {
        val itemNewBinding =
            ListItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EntertainmentViewHolder(itemNewBinding)
    }

    override fun onBindViewHolder(holder: EntertainmentViewHolder, position: Int) {
        val news = getItem(position)
        holder.bind(news)
    }

    class EntertainmentViewHolder(private val binding: ListItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(news: EntertainmentEntity?) {
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