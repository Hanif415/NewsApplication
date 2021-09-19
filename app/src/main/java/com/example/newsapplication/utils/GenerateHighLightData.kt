package com.example.newsapplication.utils

import com.example.newsapplication.data.source.local.entity.Highlight

object GenerateHighLightData {

    fun generateData(): ArrayList<Highlight> {
        val highlight = ArrayList<Highlight>()

        highlight.add(Highlight("title1"))
        highlight.add(Highlight("title2"))
        highlight.add(Highlight("title3"))
        highlight.add(Highlight("title4"))
        highlight.add(Highlight("title5"))

        return highlight
    }
}