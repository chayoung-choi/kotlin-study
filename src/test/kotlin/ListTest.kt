import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class ListTest {
    @Test
    fun `리스트 생성`() {
        val list1 = List(3) { it + 1 }
        list1 shouldBe listOf(1, 2, 3)

        val list2 = (1..3).toList()
        list2 shouldBe listOf(1, 2, 3)

        val list3 = list1 + list2
        list3 shouldBe listOf(1, 2, 3, 1, 2, 3)

        val list4 = (1..10 step 2).toList()
        list4 shouldBe listOf(1, 3, 5, 7, 9)
    }

    @Test
    fun `리스트 일정 크기로 자르기`() {
        val list = (1..10).chunked(5)
        list shouldBe listOf(listOf(1, 2, 3, 4, 5), listOf(6, 7, 8, 9, 10))
    }

    @Test
    fun `이중 리스트 합치기`() {
        val list = listOf(listOf(1, 2, 3), listOf(6, 7, 8))
        list.flatten() shouldBe listOf(1, 2, 3, 6, 7, 8)
    }

    @Test
    fun `list로 정사각형 만들기`() {
        val size = 5
        val list = List(size.times(size)) { "*" }
        println(list.chunked(size).joinSquare())
    }

    fun List<List<String>>.joinSquare(): String {
        return this.joinToString("\n") { it.joinToString(" ") }
    }
}
