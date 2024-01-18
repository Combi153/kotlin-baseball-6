package baseball.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@Suppress("NonAsciiCharacters")
class GameCommandTest {

    @ParameterizedTest
    @CsvSource("1, true", "2, false")
    fun `게임을 지속하는지 확인한다`(command: String, expected: Boolean) {
        // given
        val gameCommand = GameCommand(command)

        // when
        val actual: Boolean = gameCommand.isPlaying()

        // then
        assertThat(actual).isEqualTo(expected)
    }
}
