package baseball.view

import baseball.controller.GameCommand
import baseball.domain.PlayerBall

class InputView {

    fun readPlayerBall(): PlayerBall {
        return print("숫자를 입력해주세요 : ").run { PlayerBall(readln()) }
    }

    fun readGameCommand(): GameCommand {
        return print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.").run { GameCommand(readln()) }
    }
}
