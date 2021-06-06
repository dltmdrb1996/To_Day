package com.example.today.presentation.homeFrag


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.today.databinding.FragmentHomeBinding
import com.yy.mobile.rollingtextview.strategy.Strategy
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
        viewModel.time.observe(viewLifecycleOwner, {
            binding.clock.setTime(it.get(GregorianCalendar.HOUR), it.get(GregorianCalendar.MINUTE), it.get(GregorianCalendar.SECOND))
        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        setListener()
        viewModel.search("se")
        viewModel.getTime()
        setRollText()
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

    private fun setRollText(){
        binding.alphaBetView.animationDuration = 3000L
        binding.alphaBetView.charStrategy = Strategy.NormalAnimation()
        binding.alphaBetView.animationInterpolator = AccelerateDecelerateInterpolator()
        binding.alphaBetView.setText("좌우로 스크롤해주세요")
    }
}

