package com.example.newsapplication.ui.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapplication.data.source.local.entity.Highlight
import com.example.newsapplications.databinding.ListItemHighlightBinding
import java.util.*
import kotlin.collections.ArrayList

class HighLightAdapter(private val dataSet: ArrayList<Highlight>) :
    RecyclerView.Adapter<HighLightAdapter.HighLightViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class HighLightViewHolder(private val binding: ListItemHighlightBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(highlight: Highlight) {
            val rnd = Random()
            val color: Int = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
            binding.cardView.setBackgroundColor(color)

            binding.title.text = highlight.title
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HighLightViewHolder {
        // Create a new view, which defines the UI of the list item
        val itemNewBinding =
            ListItemHighlightBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return HighLightViewHolder(itemNewBinding)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(highLightViewHolder: HighLightViewHolder, position: Int) {

        val data = dataSet[position]
        highLightViewHolder.bind(data)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}