package com.adden00.testtaskeffectivemobile.core.delegate_utills


interface DelegateItem {
    fun content(): Any
    fun id(): Int
    fun compareToOther(other: DelegateItem): Boolean
}
