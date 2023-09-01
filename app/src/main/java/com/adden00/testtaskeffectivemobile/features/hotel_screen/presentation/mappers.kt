package com.adden00.testtaskeffectivemobile.features.hotel_screen.presentation

import com.adden00.testtaskeffectivemobile.features.hotel_screen.domain.models.HotelDomainModel
import com.adden00.testtaskeffectivemobile.features.hotel_screen.presentation.models.HotelModel

fun HotelDomainModel.toPresentation(): HotelModel =
    HotelModel(
        id,
        name,
        address,
        minimalPrice,
        priceType,
        rating,
        ratingName,
        imageUrls,
        hotelDetailsDescription,
        hotelDetailsPeculiarities
    )