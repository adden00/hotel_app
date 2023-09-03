
import com.adden00.booking_screen.data.network.models.BookingDto
import com.adden00.booking_screen.domain.models.BookingDomainModel

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