package baseball

import baseball.controller.GameController
import baseball.service.GameService
import baseball.view.InputView
import baseball.view.OutputView

fun main() {
    val gameController = GameController(InputView(), OutputView(), GameService())
    gameController.run()
}
