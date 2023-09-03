package com.adden00.hotel_screen.data

import com.adden00.hotel_screen.data.network.models.HotelDto
import com.adden00.hotel_screen.domain.models.HotelDomainModel

fun HotelDto.toDomain(): HotelDomainModel =
    HotelDomainModel(
        id = id,
        name = name,
        address = address,
        minimalPrice = minimalPrice,
        priceType = priceType,
        rating = rating,
        ratingName = ratingName,
        imageUrls = imageUrls,
        hotelDetailsDescription = hotelDetails.description,
        hotelDetailsPeculiarities = hotelDetails.peculiarities
    )