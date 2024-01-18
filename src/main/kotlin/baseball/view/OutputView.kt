package baseball.view

import baseball.domain.GameResult
import java.util.*

private const val DELIMITER = " "

class OutputView {

    fun printStart() {
        println("숫자 야구 게임을 시작합니다.")
    }

    fun printResult(gameResult: GameResult) {
        val stringJoiner = StringJoiner(DELIMITER)

        when {
            gameResult.hasBall() -> stringJoiner.add("${gameResult.ballCount}볼")
            gameResult.hasStrike() -> stringJoiner.add("${gameResult.strikeCount}스트라이크")
            (!gameResult.hasBall()) && (!gameResult.hasStrike()) -> stringJoiner.add("낫싱")
        }

        println(stringJoiner.toString())
    }

    fun printGameEnd() {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }
}
