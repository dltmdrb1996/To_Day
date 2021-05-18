package com.example.today.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.today.domain.model.Music
import com.example.today.domain.usecase.GetMusicDataUseCase
import com.example.today.domain.usecase.RoomDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MusicFragViewModel @Inject constructor(
    private val getMusicDataUserCase: GetMusicDataUseCase,
    private val roomDataUseCase: RoomDataUseCase
) : ViewModel() {
    private val _music = MutableLiveData<Music>()
    val music: LiveData<Music> = _music

    init {
        viewModelScope.launch {
            _music.value = getMusicDataUserCase()!!
        }
    }

    fun insert(title: String) {
        viewModelScope.launch {
            roomDataUseCase.insert(title)
        }
    }
}