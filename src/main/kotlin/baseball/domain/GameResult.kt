package baseball.domain

class GameResult private constructor(val ballCount: Int, val strikeCount: Int) {

    companion object {
        fun of(containingCount: Int, correctCount: Int): GameResult {
            return GameResult(containingCount - correctCount, correctCount)
        }
    }
}
