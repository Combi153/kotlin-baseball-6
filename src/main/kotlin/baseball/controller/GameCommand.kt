package baseball.controller

private const val GAME_START = "1"

class GameCommand(private val command: String) {

    fun isPlaying(): Boolean {
        return command == GAME_START
    }

    companion object {
        fun play(): GameCommand {
            return GameCommand(GAME_START)
        }
    }
}
