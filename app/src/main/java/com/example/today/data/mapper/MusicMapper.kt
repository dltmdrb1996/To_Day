package com.example.today.data.mapper

import com.example.today.data.db.model.MusicDTO
import com.example.today.domain.model.Music
import javax.inject.Inject

class MusicMapper @Inject constructor() {
    fun transform(MusicDTO : MusicDTO): Music? =
        with(MusicDTO) {
            Music(title, singer, cast, script, url, album)
        }
}