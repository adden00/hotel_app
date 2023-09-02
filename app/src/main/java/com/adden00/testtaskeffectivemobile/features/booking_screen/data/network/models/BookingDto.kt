package com.adden00.testtaskeffectivemobile.features.booking_screen.data.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookingDto(
    @SerialName("id")
    val id: Int,

    @SerialName("hotel_name")
    val hotelName: String,

    @SerialName("hotel_adress")
    val hotelAddress: String,

    @SerialName("horating")
    val hotelRating: Int,

    @SerialName("rating_name")
    val hotelRatingName: String,

    @SerialName("departure")
    val departureCity: String,

    @SerialName("arrival_country")
    val arrivalCity: String,

    @SerialName("tour_date_start")
    val startDate: String,

    @SerialName("tour_date_stop")
    val stopDate: String,

    @SerialName("number_of_nights")
    val nightCount: Int,

    @SerialName("room")
    val roomBenefits: String,

    @SerialName("nutrition")
    val nutritionProgram: String,

    @SerialName("tour_price")
    val tourPrice: Int,

    @SerialName("fuel_charge")
    val fuelCharge: Int,

    @SerialName("service_charge")
    val serviceCharge: Int
)
