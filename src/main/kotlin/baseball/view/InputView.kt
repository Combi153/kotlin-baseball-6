package baseball.view

import baseball.controller.GameCommand
import baseball.domain.PlayerBall

class InputView {

    fun readPlayerBall(): PlayerBall {
        print("숫자를 입력해주세요 : ")
        return PlayerBall(readln())
    }

    fun readGameCommand(): GameCommand {
        print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        return GameCommand(readln())
    }
}
