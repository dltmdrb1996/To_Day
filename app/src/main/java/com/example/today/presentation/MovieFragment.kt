package com.example.today.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.today.databinding.FragmentMovieBinding

class MovieFragment : Fragment() {

    private var mBinding : FragmentMovieBinding? = null

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
        val navControler = Navigation.findNavController(view)

    }

    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }
}