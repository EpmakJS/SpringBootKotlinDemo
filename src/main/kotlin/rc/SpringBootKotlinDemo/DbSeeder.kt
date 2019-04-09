package rc.SpringBootKotlinDemo

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import kotlin.contracts.contract

@Component
class DbSeeder(val hotelRepository: HotelRepository) : CommandLineRunner {
    override fun run(vararg p0: String?) {
        this.hotelRepository.deleteAll()

        val ibis = Hotel("Ibis", 3, 30)
        val intercontinental = Hotel("Intercontinental", 5, 90)
        val goldenTulip = Hotel(name = "Golden Tulip", classification = 4, nbRooms = 40)

        val hotels = listOf(ibis, intercontinental, goldenTulip)

        this.hotelRepository.saveAll(hotels)
        println(" -- Database has been initialized")
    }
}