package baseball.domain

private const val BALL_SIZE = 1
private const val VALID_BALLS_SIZE = 3
private const val NUMBER_REGEX = "\\d"

class PlayerBall(numbers: String) {

    val numbers: List<Int>

    init {
        val balls: List<String> = numbers.chunked(BALL_SIZE)
        validateBalls(balls)

        this.numbers = balls.map { ball -> ball.toInt() }
    }

    private fun validateBalls(balls: List<String>) {
        require(isNumberBall(balls)) {
            "숫자만 입력할 수 있습니다."
        }
        require(balls.size == VALID_BALLS_SIZE) {
            "숫자는 3개를 입력해야 합니다."
        }
    }

    private fun isNumberBall(balls: List<String>): Boolean {
        return balls.all { it.toIntOrNull() != null }
    }
}
