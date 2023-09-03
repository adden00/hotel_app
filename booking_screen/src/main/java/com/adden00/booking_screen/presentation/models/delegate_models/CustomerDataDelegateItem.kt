package com.adden00.booking_screen.presentation.models.delegate_models

import com.adden00.booking_screen.presentation.models.TouristCollapseType
import com.adden00.core.delegate_utills.DelegateItem

data class CustomerDataDelegateItem(
//    val id: Int,
    val collapseType: TouristCollapseType,
    val touristNum: Int

) : DelegateItem {
    override fun content(): Any = this
    override fun id(): Int = hashCode()
    override fun compareToOther(other: DelegateItem): Boolean =
        (other as CustomerDataDelegateItem).content() == this.content()
}