package baseball.domain

class RandomBall(private val randomNumbers: MutableList<String>) {

    fun countContainingNumbers(numbers: MutableList<String>): Int {
        var count = 0

        for (randomNumber in randomNumbers) {
            for (number in numbers) {
                if (randomNumber == number) {
                    count++
                }
            }
        }
        return count;
    }

    fun countCorrectNumbers(numbers: MutableList<String>): Int {
        var count = 0

        for (idx in 0..2) {
            if (randomNumbers[idx] == numbers[idx]) {
                count++
            }
        }

        return count;
    }
}
