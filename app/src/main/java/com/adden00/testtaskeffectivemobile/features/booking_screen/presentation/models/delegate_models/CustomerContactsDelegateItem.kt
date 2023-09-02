package com.adden00.testtaskeffectivemobile.features.booking_screen.presentation.models.delegate_models

import com.adden00.testtaskeffectivemobile.core.delegate_utills.DelegateItem

data class CustomerContactsDelegateItem(
    val id: Int,
) : DelegateItem {
    override fun content(): Any = this
    override fun id(): Int = hashCode()
    override fun compareToOther(other: DelegateItem): Boolean =
        (other as CustomerContactsDelegateItem).content() == this.content()
}