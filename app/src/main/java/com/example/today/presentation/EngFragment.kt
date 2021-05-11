package com.example.today.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.today.databinding.FragmentEngBinding
import com.example.today.databinding.FragmentMovieBinding
import com.example.today.presentation.homeFrag.HomeFragViewModel

class EngFragment : Fragment() {

    lateinit var binding: FragmentEngBinding
    private val viewModel by viewModels<EngFragViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEngBinding.inflate(inflater, container, false)
        binding.apply {
            lifecycleOwner = this@EngFragment
            viewModel = this@EngFragment.viewModel
        }
        return binding?.root
    }



}