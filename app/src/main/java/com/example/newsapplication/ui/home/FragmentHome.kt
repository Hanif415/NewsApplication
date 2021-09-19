package com.example.newsapplication.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HeaderViewListAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapplication.ui.adapter.BusinessAdapter
import com.example.newsapplication.ui.adapter.HeadlinesAdapter
import com.example.newsapplication.ui.adapter.HighLightAdapter
import com.example.newsapplication.ui.viewmodel.ViewModel
import com.example.newsapplication.utils.GenerateHighLightData
import com.example.newsapplication.vo.Status
import com.example.newsapplications.R
import com.example.newsapplications.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentHome : Fragment() {
    private var highlightData = GenerateHighLightData.generateData()
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: ViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val headlinesAdapter = HeadlinesAdapter()
        val highLightAdapter = HighLightAdapter(highlightData)

        viewModel.getHeadlineNews().observe(viewLifecycleOwner, { headlinesNews ->
            if (headlinesNews != null) {
                when (headlinesNews.status) {
                    Status.SUCCESS -> {
                        headlinesAdapter.submitList(headlinesNews.data)
                        binding.rvListNews.hideShimmerAdapter()
                        binding.rvListNews2.hideShimmerAdapter()
                    }

                    Status.ERROR -> Toast.makeText(context, "Something Wrong", Toast.LENGTH_SHORT)
                        .show()

                    else -> Log.d("TEST : ", headlinesNews.data.toString())
                }
            }
        })

        with(binding.rvListNews) {
            this.layoutManager = LinearLayoutManager(context)
            this.setHasFixedSize(true)
            this.adapter = headlinesAdapter
            this.showShimmerAdapter()
        }

        with(binding.todayHighlightRecyclerview) {
            this.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            this.setHasFixedSize(true)
            this.adapter = highLightAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}