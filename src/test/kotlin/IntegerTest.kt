import io.kotest.matchers.types.shouldBeSameInstanceAs
import io.kotest.matchers.types.shouldNotBeSameInstanceAs
import org.junit.jupiter.api.Test

class IntegerTest {
    @Test
    fun integer() {
        /**
         * nullable 처리를 고려해야지 코틀린 다양한 버그 해결 할 수 있음
         * 가급적 동일성 비교보단 동등성(==) 비교를 버릇처럼 사용하는게 좋다!!
         */
        val int1: Int? = 1
        val int2: Int? = 1
        int1 shouldBeSameInstanceAs int2

        val int3: Int = 1
        val int4: Int = 1
        int3 shouldBeSameInstanceAs int4

        val int5: Int? = 129
        val int6: Int? = 129
        int5 shouldNotBeSameInstanceAs int6

        val int7: Int = 129
        val int8: Int = 129
        int7 shouldNotBeSameInstanceAs int8 // boxing 처리 때문에
    }
}
