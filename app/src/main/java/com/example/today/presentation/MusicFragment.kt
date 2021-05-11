package com.example.today.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.today.databinding.FragmentMusicBinding
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener


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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.music.observe(viewLifecycleOwner,{
            binding.youtubePlayerView.addYouTubePlayerListener(object :
                AbstractYouTubePlayerListener() {
                override fun onReady(@NonNull youTubePlayer: YouTubePlayer) {
                    val videoId = "Cvq4hflIZj0"
                    youTubePlayer.cueVideo(videoId, 0f)
                }
            })
        })
    }
}