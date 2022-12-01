import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

data class Car(val name: String)

class Race(cars: List<Car>) {
    private val _cars: MutableList<Car> = cars.toMutableList()

    val cars: List<Car>
        get() = _cars.toList()

    fun enroll(car: Car) {
        _cars.add(car)
    }

    fun count(): Int = _cars.size
}

class RaceTest {

    @Test
    fun enroll() {
        val cars = emptyList<Car>().toMutableList()
        val race = Race(cars)
        race.enroll(Car("chayoung"))
        race.count() shouldBe 1

        cars.add(Car("pobi"))
        race.count() shouldBe 1
        println(race.cars.toList()) // pobi
    }

    @Test
    fun cars() {
        val race = Race(listOf(Car("jason")))
        race.enroll(Car("pobi"))
        val cars = race.cars as MutableList
        cars.add(Car("dk"))
        race.cars.size shouldBe 2
    }
}
