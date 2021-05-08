package com.example.today.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.today.databinding.FragmentMovieBinding
import com.example.today.presentation.homeFrag.HomeFragViewModel

class MovieFragment : Fragment() {

    private var mBinding : FragmentMovieBinding? = null
    private val viewModel by viewModels<MovieFragViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentMovieBinding.inflate(inflater, container, false)
        mBinding = binding
        return mBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("test",viewModel.test.toString())
    }

    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }
}