package baseball.domain

private const val BALL_SIZE = 1

class PlayerBall(numbers: String) {

    val numbers: List<Int>

    init {
        this.numbers = numbers.chunked(BALL_SIZE).map { number -> number.toInt() }
    }
}
