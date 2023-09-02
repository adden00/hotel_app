package com.adden00.testtaskeffectivemobile.features.booking_screen.presentation.models

import com.adden00.testtaskeffectivemobile.core.delegate_utills.DelegateItem
import com.adden00.testtaskeffectivemobile.features.booking_screen.presentation.models.delegate_models.BookingPriceDelegateItem
import com.adden00.testtaskeffectivemobile.features.booking_screen.presentation.models.delegate_models.CustomerContactsDelegateItem
import com.adden00.testtaskeffectivemobile.features.booking_screen.presentation.models.delegate_models.CustomerDataDelegateItem
import com.adden00.testtaskeffectivemobile.features.booking_screen.presentation.models.delegate_models.HotelAddressDelegateItem
import com.adden00.testtaskeffectivemobile.features.booking_screen.presentation.models.delegate_models.HotelDetailsDelegateItem

fun BookingModel.createDelegateList(): List<DelegateItem> {
    val hotelAddressDelegateItem = HotelAddressDelegateItem(
        id, hotelName, hotelAddress, hotelRating, hotelRatingName
    )
    val hotelDetailsDelegateItem = HotelDetailsDelegateItem(
        id,
        hotelName,
        departureCity,
        arrivalCity,
        startDate,
        stopDate,
        nightCount,
        roomBenefits,
        nutritionProgram
    )
    val customerContactsDelegateItem = CustomerContactsDelegateItem(
        id
    )
    val customerDataDelegateItem = touristList.mapIndexed { idx, type ->
        CustomerDataDelegateItem(type, idx + 1)
    }.toMutableList().apply { add(CustomerDataDelegateItem(TouristCollapseType.Add, -1)) }


    val bookingPriceDelegateItem = BookingPriceDelegateItem(
        id, tourPrice, fuelCharge, serviceCharge
    )

    return listOf<DelegateItem>(
        hotelAddressDelegateItem,
        hotelDetailsDelegateItem,
        customerContactsDelegateItem
    ) + customerDataDelegateItem + listOf<DelegateItem>(bookingPriceDelegateItem)
}