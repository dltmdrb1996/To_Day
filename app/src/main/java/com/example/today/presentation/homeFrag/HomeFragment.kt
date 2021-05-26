package com.example.today.presentation.homeFrag


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.today.R
import com.example.today.databinding.FragmentHomeBinding
import com.example.today.util.error.Failure
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class HomeFragment() : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<HomeFragViewModel>()
    private val adapter = WeatherInfoAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        _binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = this@HomeFragment.viewModel
            adapter = this@HomeFragment.adapter
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleFailure()
        setListener()
        viewModel.search("se")
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()

    }


    private fun setListener(){
        _binding?.apply {
            HomeFragBtnMovie.setOnClickListener {
                navigateFragment(it)
            }
            HomeFragBtnEng.setOnClickListener {
                navigateFragment(it)
            }
            HomeFragBtnMusic.setOnClickListener {
                navigateFragment(it)
            }
            HomeFragBtnSave.setOnClickListener {
                navigateFragment(it)
            }
        }
    }

    private fun navigateFragment(it: View) {
        when (it.id) {
            binding.HomeFragBtnEng.id ->
                Navigation.findNavController(it)
                    .navigate(HomeFragmentDirections.actionHomeFragmentToEngFragment())
            binding.HomeFragBtnMovie.id ->
                Navigation.findNavController(it)
                    .navigate(HomeFragmentDirections.actionHomeFragmentToMovieFragment())
            binding.HomeFragBtnMusic.id ->
                Navigation.findNavController(it)
                    .navigate(HomeFragmentDirections.actionHomeFragmentToMusicFragment())
            binding.HomeFragBtnSave.id ->
                Navigation.findNavController(it)
                    .navigate(HomeFragmentDirections.actionHomeFragmentToSaveFragment())
        }
    }


    private fun handleFailure() {
        viewModel.failure.observe(viewLifecycleOwner,{
            when (it) {
                is Failure.NetworkConnection -> {
                    Toast.makeText(activity, R.string.failure_network_connection, Toast.LENGTH_SHORT).show()
                }
                is Failure.ServerError -> {
                    Toast.makeText(activity, R.string.failure_server_error, Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(activity, R.string.default_error_message, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }


}