package com.example.today.data.mapper

import com.example.today.data.api.model.LocationDTO
import com.example.today.domain.model.Location
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocationMapper @Inject constructor() {
    fun transform(locationDTO: LocationDTO): Location =
        with(locationDTO) {
            Location(
                id = id,
                title = title,
                locationType = locationType,
                lattLong = lattLong
            )
        }
}