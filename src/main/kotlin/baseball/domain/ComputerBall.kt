package baseball.domain

private const val START_INDEX = 0

class ComputerBall(private val numbers: MutableList<Int>) {

    fun countContainingBalls(balls: MutableList<Int>): Int {
        return numbers.count { number -> balls.any { ball -> number == ball } }
    }

    fun countCorrectBalls(balls: MutableList<Int>): Int {
        return (START_INDEX until numbers.size).count { idx -> numbers[idx] == balls[idx] }
    }
}
