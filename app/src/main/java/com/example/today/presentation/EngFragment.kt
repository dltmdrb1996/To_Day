package com.example.today.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.today.databinding.FragmentEngBinding
import com.example.today.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EngFragment : Fragment() {

    private val viewModel by viewModels<EngFragViewModel>()
    private var _binding: FragmentEngBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEngBinding.inflate(inflater, container, false)
        _binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = this@EngFragment.viewModel
        }
        viewModel.eng.observe(viewLifecycleOwner,{
            if (!it.img.isNullOrEmpty()) {
                Glide.with(this)
                    .load(it.img)
                    .skipMemoryCache(true)
                    .into(binding.appCompatImageView)
            }
        })
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        this.context?.let { Glide.get(it).clearMemory() };
        _binding = null
        super.onDestroyView()
    }
}