package baseball.domain

import baseball.test.TestNumberGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

@Suppress("NonAsciiCharacters")
class ComputerTest {

    @Test
    fun `정상적으로 생성된다`() {
        // given
        val computer = Computer.withRandomBall()

        // expect
        assertThat(computer.computerBall.numbers).hasSize(3)
    }

    @Test
    fun `공을 비교한다`() {
        // given
        val computer = Computer(TestNumberGenerator(listOf(1, 2, 3)))

        // when
        val gameResult: GameResult = computer.compare(listOf(1, 2, 3))

        // then
        assertThat(gameResult).isEqualTo(GameResult(0, 3))
    }
}
