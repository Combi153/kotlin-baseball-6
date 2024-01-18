package baseball.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

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

    @ParameterizedTest
    @ValueSource(strings = ["1234", "12"])
    @EmptySource
    fun `숫자를 3개를 입력하지 않으면 예외가 발생한다`(numbers: String) {
        // expect
        assertThatThrownBy { PlayerBall(numbers) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("숫자는 3개를 입력해야 합니다.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["1a2", "1 2"])
    fun `숫자가 아닌 문자를 입력하면 예외가 발생한다`(numbers: String) {
        // expect
        assertThatThrownBy { PlayerBall(numbers) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("숫자만 입력할 수 있습니다.")
    }
}
