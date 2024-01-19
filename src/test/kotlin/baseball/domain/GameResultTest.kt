package baseball.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@Suppress("NonAsciiCharacters")
class GameResultTest {

    @ParameterizedTest
    @CsvSource("3, 1, 2, 1", "3, 3, 0, 3", "0, 0, 0, 0", "2, 1, 1, 1")
    fun `볼과 스트라이크 개수를 계산해 생성된다`(containingCount: Int, correctCount: Int, ball: Int, strike: Int) {
        // given
        val gameResult = GameResult.of(containingCount, correctCount)

        // expect
        assertAll(
                { assertThat(gameResult.ballCount).isEqualTo(ball) },
                { assertThat(gameResult.strikeCount).isEqualTo(strike) }
        )
    }

    @ParameterizedTest
    @CsvSource("1, true", "0, false")
    fun `볼이 있는지 확인한다`(ballCount: Int, expected: Boolean) {
        // given
        val gameResult = GameResult(ballCount, 0)

        // expect
        assertThat(gameResult.hasBall()).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource("1, true", "0, false")
    fun `스트라이크가 있는지 확인한다`(strikeCount: Int, expected: Boolean) {
        // given
        val gameResult = GameResult(0, strikeCount)

        // expect
        assertThat(gameResult.hasStrike()).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource("0, 0, true", "1, 0, false", "0, 1, false")
    fun `볼이나 스트라이크가 모두 없는지 확인한다`(ballCount: Int, strikeCount: Int, expected: Boolean) {
        // given
        val gameResult = GameResult(ballCount, strikeCount)

        // expect
        assertThat(gameResult.hasNoCount()).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource("3, true", "2, false")
    fun `게임이 끝났는지 확인한다`(strikeCount: Int, expected: Boolean) {
        // given
        val gameResult = GameResult(3, strikeCount)

        // expect
        assertThat(gameResult.isEnd()).isEqualTo(expected)
    }
}
