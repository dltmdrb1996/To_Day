package com.example.today.presentation.homeFrag


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.today.R
import com.example.today.databinding.FragmentHomeBinding
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
        subscribeUI()
        setListener()
        viewModel.search("se")


        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun subscribeUI() {
        viewModel.toastTextId.observe(viewLifecycleOwner) { stringId ->
            Toast.makeText(activity, getString(stringId), Toast.LENGTH_SHORT).show()
        }
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
            R.id.Home_Frag_Btn_Eng ->
                Navigation.findNavController(it)
                    .navigate(HomeFragmentDirections.actionHomeFragmentToEngFragment())
            R.id.Home_Frag_Btn_Movie ->
                Navigation.findNavController(it)
                    .navigate(HomeFragmentDirections.actionHomeFragmentToMovieFragment())
            R.id.Home_frag_Btn_Music ->
                Navigation.findNavController(it)
                    .navigate(HomeFragmentDirections.actionHomeFragmentToMusicFragment())
            R.id.Home_Frag_Btn_Save ->
                Navigation.findNavController(it)
                    .navigate(HomeFragmentDirections.actionHomeFragmentToSaveFragment())
        }
    }

}