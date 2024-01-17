package baseball.domain

class Computer internal constructor(private val numberGenerator: NumberGenerator) {

    val computerBall: ComputerBall = ComputerBall(numberGenerator.generate())

    fun compare(balls: List<Int>): GameResult {
        val containingCount = computerBall.countContainingBalls(balls)
        val correctCount = computerBall.countCorrectBalls(balls)
        return GameResult.of(containingCount, correctCount)
    }

    companion object {
        fun withRandomBall(): Computer {
            return Computer(RandomNumberGenerator())
        }
    }
}
