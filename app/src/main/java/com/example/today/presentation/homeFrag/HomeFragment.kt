package com.example.today.presentation.homeFrag


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.example.today.R
import com.example.today.databinding.FragmentEngBinding
import com.example.today.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

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
        subscribeUI()
        viewModel.search("se")

        binding.HomeFragBtnMusic.setOnClickListener {
            navigateFragment(it)
        }
        binding.HomeFragBtnMovie.setOnClickListener {
            navigateFragment(it)
        }
        binding.HomeFragBtnEng.setOnClickListener {
            navigateFragment(it)
        }
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        Log.e("test","Home Destroy")
        super.onDestroyView()
    }

    private fun subscribeUI() {
        viewModel.toastTextId.observe(viewLifecycleOwner) { stringId ->
            Toast.makeText(activity, getString(stringId), Toast.LENGTH_SHORT).show()
        }
    }

    private fun navigateFragment(it: View) {
        when (it.id) {
            R.id.Home_Frag_Btn_Eng ->
                Navigation.findNavController(it)
                    .navigate(HomeFragmentDirections.actionHomeFragmentToEngFragment())
            R.id.Home_Frag_Btn_Movie ->
                Navigation.findNavController(it)
                    .navigate(HomeFragmentDirections.actionHomeFragmentToMovieFragment())
            R.id.Home_frag_Btn_Music ->
                Navigation.findNavController(it)
                    .navigate(HomeFragmentDirections.actionHomeFragmentToMusicFragment())
        }
    }
}