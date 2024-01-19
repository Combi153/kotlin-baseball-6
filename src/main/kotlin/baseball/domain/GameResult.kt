package baseball.domain

private const val EMPTY_COUNT = 0
private const val STRIKE_OUT_COUNT = 3

data class GameResult internal constructor(val ballCount: Int, val strikeCount: Int) {
    fun hasBall(): Boolean {
        return ballCount != EMPTY_COUNT
    }

    fun hasStrike(): Boolean {
        return strikeCount != EMPTY_COUNT
    }

    fun hasNoCount(): Boolean {
        return ballCount == EMPTY_COUNT && strikeCount == EMPTY_COUNT
    }

    fun isEnd(): Boolean {
        return strikeCount == STRIKE_OUT_COUNT
    }

    companion object {
        fun of(containingCount: Int, correctCount: Int): GameResult {
            return GameResult(containingCount - correctCount, correctCount)
        }
    }
}
