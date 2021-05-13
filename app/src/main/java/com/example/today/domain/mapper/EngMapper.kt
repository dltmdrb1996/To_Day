package com.example.today.domain.mapper

import android.util.Log
import com.example.today.data.db.model.EngDTO
import com.example.today.domain.model.Eng
import javax.inject.Inject

class EngMapper @Inject constructor() {
    fun transform(EngDTO: EngDTO): Eng? =
        with(EngDTO) {
            Eng(img, person, eng, kor)
        }
}
