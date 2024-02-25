# MAD - Exercise 01
## Tasks
* Watch the Kotlin Crashcourse Video in Moodle or complete the tutorials **[Introduction to programming in Kotlin](https://developer.android.com/courses/pathways/android-basics-compose-unit-1-pathway-1)** and **[Kotlin fundamentals](https://developer.android.com/courses/pathways/android-basics-compose-unit-2-pathway-1
)**.
* Answer the questions inside this Readme.md file and push it to your repository.
* Submit your coding solution of the Number Guessing Game inside the repository.
* Submit the link to your repository in Moodle.

## Questions
### Describe how Kotlin handles null safety. What are nullable types and non-null types in Kotlin? (0,5 points)

<span style="color:blue">Provide your answer here! </span>
> Note: you can also use code snippets to illustrate your answer. 

Non-Null Types: All types in Kotlin are defined to be non-nullable, meaning a null value cannot be assigned to it. 
For example, if one tries to assign or return null for a non-nullable type, it shall throw a compilation error.
```kotlin
val a: String = "Hello" // non-null type
// a = null // Compilation error
```

Nullable Types: If there is a possibility that a variable can store a null value, it must be explicitly declared using an appendix of a question mark (?) at the type. 
This causes Kotlin to check for null before using the variable; thus, it prevents NPE at runtime.

```kotlin 
// example code snippet
val a: String = "value" // non-null type
```

### What are lambda expressions and higher order functions in Kotlin? Why would you store a function inside a variable? (0,5 points)

<span style="color:blue">Provide your answer here!</span>

Lambda Expressions: Lambda expressions are a concise way of representing functions that can be passed around as values. 
Lambda expressions are defined using curly braces { } and can have optional parameters (defined before ->) and a body (after ->). 
They are particularly useful for creating quick implementations of interfaces with a single method (functional interfaces) and for passing logic as arguments to higher-order functions.

```kotlin 
val sum = { x: Int, y: Int -> x + y }
println(sum(1, 2)) // Outputs 3
```

Higher Order Functions: These are functions that can accept functions as arguments and/or produce functions as output. 
They are a powerful concept that allows for more abstract and concise code, especially for operations that require transformations, filters, or other operations on collections.

```kotlin
fun operateOnTwoNumbers(x: Int, y: Int, operation: (Int, Int) -> Int): Int = operation(x, y)
val result = operateOnTwoNumbers(5, 3, sum) // Using the sum lambda as an argument
```

Storing a function in a variable is useful for several reasons:

- **Reusability:** You can define a piece of logic once and reuse it in multiple places.
- **Flexibility:** Storing the functions in variables makes it possible to be able to pass them as arguments to other functions, hence allowing for dynamic behavior based on the functions passed.
- **Abstraction:** It allows for higher levels of abstraction, making your code more readable and maintainable by encapsulating operations as functions that can be passed around.

### Provide a solution for the following number guessing game inside `App.kt`. (3 points)

## Number Guessing Game in Kotlin
The game is a simple number guessing game. The task is to generate a random, max 9-digit, number. The number must **not contain repeating digits**. Valid digits are 1-9.
Ask the user to guess the max 9-digit number. The game is finished when the user guesses the correct digits in the correct order.
In each round, the user gets feedback about the number of correct digits and the number of correct digits in the correct position.
The output should be in the format "n:m", where "n" is the number of digits guessed correctly regardless of their position, 
and "m" is the number of digits guessed correctly at their correct position. Here are some examples:

This example shows the game flow with 4-digits to guess (the default argument)

Generated number: 8576
-	User input: 1234, Output: 0:0
-	User input: 5678, Output: 4:1
-	User input: 5555, Output: 1:1
-	User input: 3586, Output: 3:2
-	User input: 8576, Output: 4:4 -> user wins

Take a look into the provided code structure in `src/main/kotlin/App.kt`. Implement the following methods (lambda expressions):
- _playNumberGame(digitsToGuess: Int = 4)_ (1 point): The main game loop that handles user input and game state. Make use of _generateRandomNonRepeatingNumber_ and _checkUserInputAgainstGeneratedNumber_ here. This function also utilizes a default argument 
- _generateRandomNonRepeatingNumber_ (1 point): A lambda expression that generates a random number with non-repeating digits of a specified length.
- _checkUserInputAgainstGeneratedNumber_ (1 point): A lambda expression that compares the user's input against the generated number and provides feedback.

``CompareResult.kt`` This class is a data structure which helps with bundling the result of the comparison of the user input and the generated number. Look at the toSting() and use it in your output.

Run the project with `./gradlew run` and test your implementation with the provided tests in `src/test/kotlin/AppTest.kt` with `./gradlew test`.

# Project Structure
The project is structured into two main Kotlin files:

**App.kt**: Contains the main game logic and functions.

**AppTest.kt**: Contains unit tests for the various functions in App.kt.

