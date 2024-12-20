# NGuess

This project is a number guessing game implemented in Java, created as a collaborative group effort. The game demonstrates our ability to design, implement, and optimize a simple interactive application. It features multiple difficulty levels, user input validation, and basic game logic, providing a fun and engaging experience for players.

## Features

- Four levels of difficulty: Each with a different range for the randomly generated number:
  - Easy: Guess a number between 1 and 20.
  - Medium: Guess a number between 1 and 99.
  - Hard: Guess a number between 100 and 999.
  - Expert: Guess a number between 1000 and 9999.
  
- User Interaction: The user enters guesses, and the game provides feedback on whether the guess is too high, too low, or correct.
  
- Game Continuity: The game continues until the player guesses the correct number, with the program displaying the total number of attempts made.

- Clean User Interface: The program communicates with the player through clear text prompts, making it easy to follow.

## Purpose

The goal of this project was to:
- Build a working Java application with an emphasis on logic and user interaction.
- Explore Java's basic control structures like loops, conditionals, and random number generation.
- Demonstrate our ability to work as a team, contributing different pieces of the project in a collaborative environment.

## How to Play

1. Run the Java program.
2. Choose a difficulty level by entering a corresponding number:
   - 1 for Easy
   - 2 for Medium
   - 3 for Hard
   - 4 for Expert
3. The program generates a random number based on the selected difficulty.
4. The player enters guesses, and the game provides feedback (too high, too low, or correct).
5. The game continues until the correct number is guessed, at which point the total number of attempts is displayed.

## Technical Requirements

- Java Version: Java 8 or higher
- Libraries/Tools Used: Java Standard Library (No external libraries were used)
- Programming Concepts: 
  - Random number generation
  - Loops and conditionals
  - User input handling
  - Input validation (for ensuring numeric input)
  
## Installation and Running

1. Ensure you have Java 8 or higher installed on your machine. You can check the Java version with:
   ```bash
   java -version
