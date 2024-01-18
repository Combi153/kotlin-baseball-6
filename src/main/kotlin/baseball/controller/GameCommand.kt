package baseball.controller

private const val GAME_START = "1"
private const val GAME_END = "2"

class GameCommand(private val command: String) {

    init {
        validateCommand()
    }

    private fun validateCommand() {
        if (command != GAME_START && command != GAME_END) {
            throw IllegalArgumentException("유효하지 않은 명령어입니다. 입력 값 : $command")
        }
    }

    fun isPlaying(): Boolean {
        return command == GAME_START
    }

    companion object {
        fun play(): GameCommand {
            return GameCommand(GAME_START)
        }
    }
}
