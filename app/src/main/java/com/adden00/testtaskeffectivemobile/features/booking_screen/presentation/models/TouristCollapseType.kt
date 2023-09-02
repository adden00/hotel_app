package com.adden00.testtaskeffectivemobile.features.booking_screen.presentation.models

sealed class TouristCollapseType {
    class Collapsed(val touristNumber: Int) : TouristCollapseType()
    class Expanded(val touristNumber: Int) : TouristCollapseType()
    object Add : TouristCollapseType()
}