package com.example.today.presentation.homeFrag


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.today.R
import com.example.today.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment() : Fragment() {

    private val viewModel by viewModels<HomeFragViewModel>()
    private val adapter = WeatherInfoAdapter()
    lateinit var binding : FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.apply {
            lifecycleOwner = this@HomeFragment
            viewModel = this@HomeFragment.viewModel
            adapter = this@HomeFragment.adapter
        }

        subscribeUI()

        viewModel.search("se")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.HomeFragBtnMovie.setOnClickListener {
            view.findNavController().navigate(R.id.movieFragment)
        }
        binding.HomeFragBtnMusic.setOnClickListener {
            view.findNavController().navigate(R.id.musicFragment)
        }
        binding.HomeFragBtnEng.setOnClickListener {
            view.findNavController().navigate(R.id.engFragment)
        }
    }

    private fun subscribeUI() {
        viewModel.toastTextId.observe(viewLifecycleOwner) { stringId ->
            Toast.makeText(activity, getString(stringId), Toast.LENGTH_SHORT).show()
        }
    }

}