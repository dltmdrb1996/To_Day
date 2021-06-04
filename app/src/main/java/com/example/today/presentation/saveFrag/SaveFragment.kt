    package com.example.today.presentation.saveFrag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.today.databinding.FragmentSaveBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SaveFragment : Fragment() {

    private lateinit var listAdapter: SaveAdapter
    private val viewModel by viewModels<SaveFragViewModel>()
    private var _binding: FragmentSaveBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSaveBinding.inflate(inflater, container, false)
        _binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = this@SaveFragment.viewModel
        }
        listAdapter = SaveAdapter(viewModel)
        binding.recyclerView.adapter = listAdapter

        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}