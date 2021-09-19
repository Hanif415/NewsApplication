package com.example.newsapplication.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapplication.ui.adapter.BusinessAdapter
import com.example.newsapplication.ui.viewmodel.ViewModel
import com.example.newsapplications.R
import com.example.newsapplications.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentHealth : Fragment() {

    var strCountry: String? = null
    var businessAdapter: BusinessAdapter? = null

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

        businessAdapter = BusinessAdapter()

        binding.tvTitle.text = getString(R.string.headlines_text)

        binding.rvListNews.layoutManager = LinearLayoutManager(context)
        binding.rvListNews.setHasFixedSize(true)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}