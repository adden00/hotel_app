package com.adden00.testtaskeffectivemobile.features.booking_screen.presentation

import com.adden00.testtaskeffectivemobile.features.booking_screen.domain.models.BookingDomainModel
import com.adden00.testtaskeffectivemobile.features.booking_screen.presentation.models.BookingModel

fun BookingDomainModel.toPresentation(): BookingModel =
    BookingModel(
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