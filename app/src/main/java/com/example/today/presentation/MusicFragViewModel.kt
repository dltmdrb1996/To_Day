package com.example.today.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.today.domain.model.Music
import com.example.today.domain.usecase.GetMusic
import com.example.today.domain.usecase.RoomDataUseCase
import com.example.today.util.error.Failure
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MusicFragViewModel @Inject constructor(
    private val getMusic: GetMusic,
    private val roomDataUseCase: RoomDataUseCase
) : ViewModel() {

    private val _music = MutableLiveData<Music>()
    val music: LiveData<Music> = _music

    private val _failure: MutableLiveData<Failure> = MutableLiveData()
    val failure: LiveData<Failure> = _failure

    fun insert(title: String) {
        viewModelScope.launch {
            roomDataUseCase.insert(title)
        }
    }

    fun loadMusicDetails(day: Int) =
        getMusic(GetMusic.Params(day)) { it.fold(::handleFailure, ::handleMusicDetails) }

    private fun handleMusicDetails(music: Music?) {
        _music.value = music?.apply { Music(title, singer, cast, script, url, album) }
    }

    private fun handleFailure(failure: Failure) { _failure.value = failure }

}