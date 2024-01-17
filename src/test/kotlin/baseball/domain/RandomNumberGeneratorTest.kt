package baseball.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

@Suppress("NonAsciiCharacters")
class RandomNumberGeneratorTest {

    @Test
    fun `숫자 세 개를 생성한다`() {
        // given
        val ballGenerator = RandomNumberGenerator()

        // when
        val balls: List<Int> = ballGenerator.generate()

        // then
        assertThat(balls).hasSize(3)
    }
}
