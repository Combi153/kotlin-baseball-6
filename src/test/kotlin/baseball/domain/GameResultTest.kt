package baseball.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@Suppress("NonAsciiCharacters")
class GameResultTest {

    @ParameterizedTest
    @CsvSource("3, 1, 2, 1", "3, 3, 0, 3", "0, 0, 0, 0")
    fun `볼과 스트라이크 개수를 계산해 생성된다`(containingCount: Int, correctCount: Int, ball: Int, strike: Int) {
        // given
        val gameResult = GameResult.of(containingCount, correctCount)

        // expect
        assertAll(
            { assertThat(gameResult.ballCount).isEqualTo(ball) },
            { assertThat(gameResult.strikeCount).isEqualTo(strike) }
        )
    }
}
