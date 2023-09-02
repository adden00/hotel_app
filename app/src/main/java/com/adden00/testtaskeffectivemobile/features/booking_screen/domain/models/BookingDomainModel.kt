package com.adden00.testtaskeffectivemobile.features.booking_screen.domain.models

data class BookingDomainModel(
    val id: Int,
    val hotelName: String,
    val hotelAddress: String,
    val hotelRating: Int,
    val hotelRatingName: String,
    val departureCity: String,
    val arrivalCity: String,
    val startDate: String,
    val stopDate: String,
    val nightCount: Int,
    val roomBenefits: String,
    val nutritionProgram: String,
    val tourPrice: Int,
    val fuelCharge: Int,
    val serviceCharge: Int
)
