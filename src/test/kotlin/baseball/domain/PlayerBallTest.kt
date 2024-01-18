package baseball.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

@Suppress("NonAsciiCharacters")
class PlayerBallTest {

    @Test
    fun `입력값을 파싱한 후 정상 생성된다`() {
        // given
        val numbers = "123"

        // when
        val playerBall = PlayerBall(numbers)

        // then
        assertThat(playerBall.numbers).contains(1, 2, 3)
    }
}
