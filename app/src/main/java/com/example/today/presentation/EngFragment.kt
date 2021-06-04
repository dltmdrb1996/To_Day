package com.example.today.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.today.R
import com.example.today.databinding.FragmentEngBinding
import com.example.today.util.error.Failure
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EngFragment : Fragment() {

    private val viewModel by viewModels<EngFragViewModel>()
    private var _binding: FragmentEngBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEngBinding.inflate(inflater, container, false)
        _binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = this@EngFragment.viewModel
        }
        handleFailure()
        viewModel.loadEngDetails(1)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setImg()
    }
    override fun onDestroyView() {
        this.context?.let { Glide.get(it).clearMemory() };
        _binding = null
        super.onDestroyView()
    }

    private fun setImg(){
        viewModel.eng.observe(viewLifecycleOwner,{
            if (!it.img.isNullOrEmpty()) {
                this.context?.let { it1 ->
                    Glide.with(it1)
                        .load(it.img)
                        .thumbnail(0.5f)
                        .into(binding.appCompatImageView)
                }

            }
        })
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