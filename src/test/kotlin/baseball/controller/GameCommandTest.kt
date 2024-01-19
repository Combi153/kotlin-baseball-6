package baseball.controller

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

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

    @ParameterizedTest
    @ValueSource(strings = ["3", "one"])
    fun `유효하지 않은 명령어를 입력하면 예외를 던진다`(command: String) {
        // expect
        assertThatThrownBy { GameCommand(command) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("유효하지 않은 명령어입니다. 입력 값 : $command")
    }
}
