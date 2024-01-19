package baseball.controller

import baseball.domain.Computer
import baseball.service.GameService
import baseball.view.InputView
import baseball.view.OutputView

class GameController(
        private val inputView: InputView,
        private val outputView: OutputView,
        private val gameService: GameService
) {

    fun run() {
        outputView.printStart()
        do {
            play(Computer.withRandomBall())
            val gameCommand = inputView.readGameCommand()
        } while (gameCommand.isPlaying())
    }

    private fun play(computer: Computer) {
        do {
            val playerBall = inputView.readPlayerBall()
            val gameResult = gameService.play(computer, playerBall)
            outputView.printResult(gameResult)
        } while (!gameResult.isEnd())

        outputView.printGameEnd()
    }
}
