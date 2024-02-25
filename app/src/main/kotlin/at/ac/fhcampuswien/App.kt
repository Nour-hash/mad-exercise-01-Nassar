/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package at.ac.fhcampuswien

class App {
    // Game logic for a number guessing game
    fun playNumberGame(digitsToGuess: Int = 4) {
        val generatedNumber = generateRandomNonRepeatingNumber(digitsToGuess)
        println("A random $digitsToGuess-digit number has been generated. Try to guess it!")

        var guess: Int
        var firstAttempt = true
        var result = CompareResult(0, 0) // Dummy initialization

        do {
            if (!firstAttempt) {
                println("Feedback: ${result.n} correct digits, ${result.m} in the correct position.")
            }
            print("Your guess: ")
            val userInput = readLine()
            guess = userInput?.toIntOrNull() ?: 0

            if (userInput == null || guess == 0) {
                println("Please enter a valid $digitsToGuess-digit number.")
                continue
            }

            result = checkUserInputAgainstGeneratedNumber(guess, generatedNumber)
            firstAttempt = false

        } while (result.m != digitsToGuess)

        println("Congratulations! You've guessed the number $generatedNumber correctly.")
}

    /**
     * Generates a non-repeating number of a specified length between 1-9.
     *
     * Note: The function is designed to generate a number where each digit is unique and does not repeat.
     * It is important to ensure that the length parameter does not exceed the maximum possible length
     * for non-repeating digits (which is 9 excluding 0 for base-10 numbers).
     *
     * @param length The length of the non-repeating number to be generated.
     *               This dictates how many digits the generated number will have.
     * @return An integer of generated non-repeating number.
     *         The generated number will have a number of digits equal to the specified length and will
     *         contain unique, non-repeating digits.
     * @throws IllegalArgumentException if the length is more than 9 or less than 1.
     */
    val generateRandomNonRepeatingNumber: (Int) -> Int = { length ->
        if (length < 1 || length > 9) throw IllegalArgumentException("Length must be between 1 and 9")

        val digits = (1..9).shuffled().take(length) // Shuffle digits 1-9 and take 'length' number of digits
        val number = digits.joinToString("").toInt() // Join them into a string and convert to an integer

        number
    }

    /**
     * Compares the user's input integer against a generated number for a guessing game.
     * This function evaluates how many digits the user guessed correctly and how many of those
     * are in the correct position. The game generates number with non-repeating digits.
     *
     * Note: The input and the generated number must both be numbers.
     * If the inputs do not meet these criteria, an IllegalArgumentException is thrown.
     *
     * @param input The user's input integer. It should be a number with non-repeating digits.
     * @param generatedNumber The generated number with non-repeating digits to compare against.
     * @return [CompareResult] with two properties:
     *         1. `n`: The number of digits guessed correctly (regardless of their position).
     *         2. `m`: The number of digits guessed correctly and in the correct position.
     *         The result is formatted as "Output: m:n", where "m" and "n" represent the above values, respectively.
     * @throws IllegalArgumentException if the inputs do not have the same number of digits.
     */
    val checkUserInputAgainstGeneratedNumber: (Int, Int) -> CompareResult = { input, generatedNumber ->
        val inputDigits = input.toString().toList()
        val generatedDigits = generatedNumber.toString().toList()

        if (inputDigits.size != generatedDigits.size) {
            throw IllegalArgumentException("Input and generated number must have the same number of digits")
        }

        val correctPositions = inputDigits.zip(generatedDigits).count { (inputDigit, generatedDigit) -> inputDigit == generatedDigit }

        val matchedDigits = mutableSetOf<Char>()
        inputDigits.forEach { digit ->
            if (digit in generatedDigits && digit !in matchedDigits) {
                matchedDigits.add(digit)
            }
        }
        val correctDigits = matchedDigits.size

        CompareResult(correctDigits, correctPositions)
    }

}

fun main() {
    val app = App()
    println("Welcome to the Number Guessing Game!")

    // Default game with 4 digits
    app.playNumberGame()

    // Uncomment the following line to play the game with a different number of digits
    // app.playNumberGame(6)
}
