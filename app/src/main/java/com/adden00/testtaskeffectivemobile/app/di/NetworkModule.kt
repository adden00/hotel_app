package com.adden00.testtaskeffectivemobile.app.di

import com.adden00.booking_screen.data.network.BookingApiClient
import com.adden00.core.Constants
import com.adden00.hotel_screen.data.network.HotelApiClient
import com.adden00.rooms_screen.data.network.RoomsApiClient
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideHotelApiClient(client: OkHttpClient): HotelApiClient {
        val json = Json { ignoreUnknownKeys = true }
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(
                @OptIn(ExperimentalSerializationApi::class)
                json.asConverterFactory("application/json".toMediaType())
            )
            .client(client)
            .build()
            .create(HotelApiClient::class.java)
    }

    @Provides
    @Singleton
    fun provideRoomsApiClient(client: OkHttpClient): RoomsApiClient {
        val json = Json { ignoreUnknownKeys = true }
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(
                @OptIn(ExperimentalSerializationApi::class)
                json.asConverterFactory("application/json".toMediaType())
            )
            .client(client)
            .build()
            .create(RoomsApiClient::class.java)
    }

    @Provides
    @Singleton
    fun provideBookingApiClient(client: OkHttpClient): BookingApiClient {
        val json = Json { ignoreUnknownKeys = true }
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(
                @OptIn(ExperimentalSerializationApi::class)
                json.asConverterFactory("application/json".toMediaType())
            )
            .client(client)
            .build()
            .create(BookingApiClient::class.java)
    }


    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .callTimeout(10, TimeUnit.SECONDS)
            .build()
}