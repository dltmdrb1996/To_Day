package com.example.today.domain.mapper

import com.example.today.data.db.model.MovieDTO
import com.example.today.domain.model.Movie
import javax.inject.Inject

class MovieMapper @Inject constructor() {
    fun transform(MovieDTO : MovieDTO): Movie =
        with(MovieDTO) {
            Movie(title, director, img, actor, script, story, time)
        }
}