package com.example.newsapp.ui.trend

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.newsapp.R
import com.example.newsapp.databinding.FragmentTrendingBinding

class TrendingFragment : Fragment() {

    private var _binding: FragmentTrendingBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val trendViewModel = ViewModelProvider(this).get(TrendingViewModel::class.java)
        _binding = FragmentTrendingBinding.inflate(inflater, container, false)

        val root: View = binding.root
        val textView: TextView = binding.textTrend
        trendViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}