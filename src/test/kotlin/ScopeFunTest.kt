import org.junit.jupiter.api.Test

/**
 * 범위 지정 함수(Scope Function)
 * 1. apply - 수신객체 내부 프로퍼티를 변경 후 수신객체 자체를 반환
 * 2. run - apply와 동일 동작하지만 수신 객체 반환하지 않고, run 블록의 마지막 라인을 반환
 * 3. with - 수신객체 작업 후 마지막 라인 반환(run과 동일). 차이는 확장 함수와 아니야의 차이
 * 4. let - 수신객체 작업 후 마지막 라인 반환. nullable 값 처리할때 사용
 * 5. also - applay와 동일 동작. 추가적인 작업(로깅, 유효성 검사 등) 한 후 객체 반환할때 사용
 */
class ScopeFunTest {
    data class Person(
        var name: String = "",
        var age: Int = 0,
        var temperature: Float = 36.5f
    ) {
        fun isSick(): Boolean = temperature > 37.5f
    }

    @Test
    fun apply() {
        val person = Person().apply {
            name = "Choi"
            age = 34
            temperature = 36.8f
        }
        println(person)
    }

    @Test
    fun run() {
        val person = Person(
            name = "Choi",
            age = 34,
            temperature = 36.8f
        )
        val isPersonSick = person.run {
            temperature = 37.8f
            isSick() // return 값
        }
        println("PersonSick: $isPersonSick")
    }

    @Test
    fun with() {
        val person = Person(
            name = "Choi",
            age = 34,
            temperature = 36.8f
        )
        val isPersonSick = with(person) {
            temperature = 37.8f
            isSick() // return 값
        }
        println("PersonSick: $isPersonSick")
    }

    @Test
    fun let() {
        val person: Person? = null
        val isPersonSick = person?.let { it.isSick() }
    }

    @Test
    fun also() {
        val person = Person(
            name = "Choi",
            age = 34,
            temperature = 36.8f
        )
        person.also {
            println(it)
        }
    }
}
