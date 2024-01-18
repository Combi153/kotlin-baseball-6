package baseball.controller

import baseball.domain.Computer
import baseball.domain.GameResult
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

        var gameCommand: GameCommand = GameCommand.play()

        while (gameCommand.isPlaying()) {
            play(Computer.withRandomBall())
            gameCommand = inputView.readGameCommand()
        }
    }

    private fun play(computer: Computer) {
        var gameResult: GameResult

        do {
            val playerBall = inputView.readPlayerBall()
            gameResult = gameService.play(computer, playerBall)
            outputView.printResult(gameResult)
        } while (!gameResult.isEnd())

        outputView.printGameEnd()
    }
}
