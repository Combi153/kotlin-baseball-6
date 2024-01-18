package baseball.service

import baseball.domain.Computer
import baseball.domain.GameResult
import baseball.domain.PlayerBall

class GameService {

    fun play(computer: Computer, playerBall: PlayerBall): GameResult {
        return computer.compare(playerBall.numbers)
    }
}
