package baseball.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@Suppress("NonAsciiCharacters")
class ComputerBallTest {

    @ParameterizedTest
    @CsvSource("1, 2, 3, 3", "2, 3, 4, 2", "3, 4, 5, 1", "4, 5, 6, 0", "1, 1, 1, 1")
    fun `포함하는 숫자의 개수를 센다`(first: Int, second: Int, third: Int, expected: Int) {
        // given
        val computerBall = ComputerBall(mutableListOf(1, 2, 3))

        // when
        val actual = computerBall.countContainingBalls(mutableListOf(first, second, third))

        // then
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource("1, 2, 3, 3", "2, 3, 4, 0", "1, 1, 1, 1")
    fun `일치하는 숫자의 개수를 센다`(first: Int, second: Int, third: Int, expected: Int) {
        // given
        val computerBall = ComputerBall(mutableListOf(1, 2, 3))

        // when
        val actual = computerBall.countCorrectBalls(mutableListOf(first, second, third))

        // then
        assertThat(actual).isEqualTo(expected)
    }
}


