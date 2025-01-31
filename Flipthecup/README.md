# 🎮 Flip The Cup - A Physics-Based Cup Flipping Game

## 📝 Overview
**Flip The Cup** is an interactive physics-based game where players attempt to flip a cup successfully onto a surface. The goal is to execute a perfect flip by timing the jump and landing the cup upright. The game incorporates rotation mechanics, scoring, a high-score system, and a pause menu.

## 🚀 Features
- **Realistic Flipping Mechanics**: The cup rotates dynamically, and landing upright earns points.
- **High Score System**: Tracks the highest score and last game score.
- **Pause and Resume**: Players can pause the game at any time.
- **Game Over & Restart**: Play multiple rounds and improve your skills.
- **Main Menu & High Score Display**: View scores and navigate game modes easily.

## 🎮 Controls
- **`Space`** - Flip the cup
- **`P`** - Pause/Resume
- **`Q`** - Return to Main Menu
- **`1`** - Start a new game from the main menu
- **`2`** - View High Scores
- **`3`** - Exit the game

## 🏆 Game Mechanics
- The cup flips when the **space key** is pressed.
- If the cup **lands upright**, the player gains points.
- The game lasts **30 seconds**; the goal is to get as many successful flips as possible.
- If the cup lands incorrectly, **no points are awarded**.
- The **High Score System** stores the best and last scores in a JSON file.

## 📜 Code Structure

### `FlipTheCup.java`
- The main entry point of the game, responsible for setting up the game screen.

### `GameScreen.java`
- Handles the core gameplay loop, rendering graphics, tracking time, and managing game logic.

### `FlipValidator.java`
- Validates if the cup landed correctly based on rotation and position.

### `HighScore.java`
- Manages high score tracking, saving scores to `score_data.json`.

### `MainMenuScreen.java`
- Displays the main menu and handles navigation between game modes.

### `score_data.json`
- Stores the **high score** and **last score** in a simple JSON format.

## 🛠️ Technologies Used
- **LibGDX** - Game development framework for rendering and input handling.
- **Java** - Core programming language for logic and game flow.
- **JSON** - Used to save and retrieve high scores.



## 🔥 Future Improvements
- **More Flip Variations**: Add different flip types with increased difficulty.
- **New Game Modes**: Time challenges, endless mode, or multiplayer competitions.
- **Better Graphics & Sound**: Enhanced animations and sound effects.
- **Mobile Support**: Implement touch-based flipping mechanics.

## 🎯 How to Play
1. **Run the game** using `FlipTheCup.java`
2. **Press `1` in the main menu** to start playing.
3. **Press `Space` to flip the cup** and try to land it upright.
4. **Keep flipping** and score as many points as possible before time runs out.
5. **Check your high score** after the game ends.

## 📌 Installation & Setup
1. **Install Java** (JDK 8+)

## 👨‍💻 Developer Notes
This game was built using LibGDX and follows an object-oriented programming approach. It incorporates proper screen management, file handling, and game loop mechanics. The FlipValidator class ensures that the physics are correctly validated for successful flips.

## 🎉 Enjoy flipping the cup and beating your high score! 🚀


