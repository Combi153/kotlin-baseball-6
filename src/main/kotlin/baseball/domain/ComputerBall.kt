package baseball.domain

private const val START_INDEX = 0

class ComputerBall(val numbers: List<Int>) {

    fun countContainingBalls(balls: List<Int>): Int {
        return numbers.count { number -> balls.any { ball -> number == ball } }
    }

    fun countCorrectBalls(balls: List<Int>): Int {
        return numbers.filterIndexed { index, number -> number == balls[index] }.size
    }
}
