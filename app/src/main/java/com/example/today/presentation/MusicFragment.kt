package com.example.today.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.today.databinding.FragmentMusicBinding

class MusicFragment : Fragment() {

    lateinit var binding: FragmentMusicBinding
    private val viewModel by viewModels<MusicFragViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMusicBinding.inflate(inflater, container, false)
        binding.apply {
            lifecycleOwner = this@MusicFragment
            viewModel = this@MusicFragment.viewModel
        }
        return binding?.root

    }

}