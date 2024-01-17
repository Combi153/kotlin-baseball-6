package baseball.test

import baseball.domain.NumberGenerator

class TestNumberGenerator(private val testNumbers: List<Int>) : NumberGenerator {

    override fun generate(): List<Int> {
        return testNumbers
    }
}
