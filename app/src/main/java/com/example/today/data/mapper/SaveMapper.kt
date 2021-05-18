package com.example.today.data.mapper

import com.example.today.data.weatherdata.model.LocationDTO
import com.example.today.data.db.room.SaveDTO
import com.example.today.domain.model.Location
import com.example.today.domain.model.Save
import javax.inject.Inject

class SaveMapper @Inject constructor() {
    fun transform(saveDTO: SaveDTO): Save =
        with(saveDTO) {
            Save(
                title = title,
                id = id,
            )
        }
    fun reTransform(save: Save): SaveDTO =
        with(save) {
            SaveDTO(
                title = title,
            )
        }
}