package com.flipthecup; // Defines the package for the game

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input; // Handles user input
import com.badlogic.gdx.Screen; // Implements the Screen interface for game screens
import com.badlogic.gdx.graphics.GL20; // Handles OpenGL rendering
import com.badlogic.gdx.graphics.g2d.BitmapFont; // Used for rendering text

public class MainMenuScreen implements Screen { // Main menu screen implementation
    final FlipTheCup game; // Reference to the main game instance
    BitmapFont font; // Font used to display menu text
    private HighScore highScore; // HighScore instance to track scores
    private boolean showingHighScores = false; // Flag to determine if high scores are being displayed

    public MainMenuScreen(final FlipTheCup game) { // Constructor
        this.game = game;
        font = new BitmapFont(); // Initializes the font
        highScore = new HighScore(); // Loads the high score from storage
    }

    @Override
    public void render(float delta) { // The main render method called every frame
        // Clear the screen with a dark blue background
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin(); // Begin drawing elements
        if (!showingHighScores) { // Render either the main menu or the high scores screen
            renderMainMenu();
        } else {
            renderHighScores();
        }
        game.batch.end(); // End drawing elements

        UserInput(); // Handle user input for menu navigation
    }

    private void renderMainMenu() { // Draws the main menu options
        font.draw(game.batch, "Welcome to Flip The Cup!", 100, 300);
        font.draw(game.batch, "1. Play", 100, 250);
        font.draw(game.batch, "2. View High Scores", 100, 200);
        font.draw(game.batch, "3. Exit", 100, 150);
    }

    private void renderHighScores() { // Draws the high score screen
        font.draw(game.batch, "High Scores", 100, 400);
        font.draw(game.batch, highScore.showHighScore(), 100, 350);
        font.draw(game.batch, "Press SPACE to return to Main Menu", 100, 200);
    }

    private void UserInput() { // Handles user input for menu navigation
        if (!showingHighScores) { // If the user is in the main menu
            if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)) { // If '1' is pressed, start the game
                game.setScreen(new GameScreen(game));
            } else if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)) { // If '2' is pressed, show high scores
                showingHighScores = true;
            } else if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_3)) { // If '3' is pressed, exit the game
                Gdx.app.exit();
            }
        } else { // If the user is viewing high scores
            if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) { // If SPACE is pressed, return to main menu
                showingHighScores = false;
            }
        }
    }

    @Override
    public void resize(int width, int height) {} // Called when the window is resized

    @Override
    public void show() {} // Called when this screen is set

    @Override
    public void pause() {} // Called when the game is paused

    @Override
    public void resume() {} // Called when the game is resumed

    @Override
    public void hide() {} // Called when the screen is hidden

    @Override
    public void dispose() { // Clean up resources
        font.dispose(); // Dispose of the font to free memory
    }
}
