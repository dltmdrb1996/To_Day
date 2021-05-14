package com.example.today.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.today.databinding.FragmentMovieBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieFragment : Fragment() {

    private val viewModel by viewModels<MovieFragViewModel>()
    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieBinding.inflate(inflater, container, false)
        _binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = this@MovieFragment.viewModel
        }

        viewModel.movie.observe(viewLifecycleOwner,{
            if (!it.img.isNullOrEmpty()) {
                Glide.with(this)
                    .load(it.img)
                    .skipMemoryCache(true)
                    .into(binding.moviePoster)

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