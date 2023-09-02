package com.adden00.testtaskeffectivemobile.features.booking_screen.data

import com.adden00.testtaskeffectivemobile.features.booking_screen.data.network.models.BookingDto
import com.adden00.testtaskeffectivemobile.features.booking_screen.domain.models.BookingDomainModel

fun BookingDto.toDomain(): BookingDomainModel =
    BookingDomainModel(
        id,
        hotelName,
        hotelAddress,
        hotelRating,
        hotelRatingName,
        departureCity,
        arrivalCity,
        startDate,
        stopDate,
        nightCount,
        roomBenefits,
        nutritionProgram,
        tourPrice,
        fuelCharge,
        serviceCharge
    )