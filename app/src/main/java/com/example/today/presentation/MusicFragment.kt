package com.example.today.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.today.R
import com.example.today.databinding.FragmentMusicBinding
import com.example.today.util.error.Failure
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MusicFragment : Fragment() {
    private var _binding: FragmentMusicBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<MusicFragViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMusicBinding.inflate(inflater, container, false)
        _binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = this@MusicFragment.viewModel
        }
        handleFailure()
        viewModel.loadMusicDetails(1)

        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setYoutube()
    }

    override fun onPause() {
        super.onPause()
    }
    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
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

    private fun setYoutube(){
        viewModel.music.observe(viewLifecycleOwner,{
            binding.youtubePlayerView.addYouTubePlayerListener(object :
                AbstractYouTubePlayerListener() {
                override fun onReady(@NonNull youTubePlayer: YouTubePlayer) {
                    val videoId = it.url
                    youTubePlayer.cueVideo(videoId, 0f)
                }
            })
        })
    }
}
