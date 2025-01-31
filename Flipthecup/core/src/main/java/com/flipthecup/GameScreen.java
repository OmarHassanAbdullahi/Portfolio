package com.flipthecup; // Defines the package for the game

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class GameScreen implements Screen { // Implements the game screen
    final FlipTheCup game; // Reference to the main game class
    private Texture cupImage; // Texture for the cup image
    private BitmapFont font; // Font for displaying text
    private OrthographicCamera camera; // Camera for rendering the game world
    private int score = 0; // Player's score
    private float gameTime = 30f; // Total game time in seconds
    private boolean gameOver = false; // Flag to check if the game is over
    private boolean paused = false; // Flag to check if the game is paused
    private float rotation = 0; // Rotation angle of the cup
    private float cupX = 300; // X position of the cup
    private float cupY = 100; // Y position of the cup
    private float initialY = 100; // Initial Y position of the cup
    private boolean flipping = false; // Flag to check if the cup is flipping
    private float flipTime = 0; // Timer for tracking flip duration
    private final float flipDuration = 1f; // Duration of a flip animation
    private float scale = 0.3f; // Scaling factor for the cup image
    private FlipValidator flipValidator; // Flip validation logic
    private HighScore highScore; // High score tracker

    public GameScreen(final FlipTheCup game) { // Constructor for the game screen
        this.game = game;
        font = new BitmapFont(); // Initialize the font
        cupImage = new Texture("cup.png"); // Load the cup texture
        camera = new OrthographicCamera(); // Create an orthographic camera
        camera.setToOrtho(false, 800, 480); // Set camera dimensions
        flipValidator = new FlipValidator(); // Initialize the flip validator
        highScore = new HighScore(); // Initialize the high score tracker
    }

    @Override
    public void render(float delta) { // The main rendering loop
        // Check for pause key press (P)
        if (Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.P)) {
            paused = !paused;
        }
        // Check for quit key press (Q) to return to the main menu
        if (Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.Q)) {
            game.setScreen(new MainMenuScreen(game));
        }

        if (paused) { // If the game is paused, render the pause menu
            renderPauseMenu();
            return;
        }

        camera.update(); // Update the camera
        game.batch.setProjectionMatrix(camera.combined); // Apply camera projection matrix

        // Clear the screen with a dark blue background
        Gdx.gl.glClearColor(0, 0, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (gameOver) { // If the game is over, render the game over menu
            renderGameOverMenu();
            return;
        }

        if (gameTime > 0) { // Decrease game time
            gameTime -= delta;
        } else { // If time runs out, end the game
            gameTime = 0;
            gameOver = true;
        }

        // Check for flip action when the space key is pressed
        if (Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.SPACE) && !flipping && gameTime > 0) {
            flipping = true;
            flipTime = 0;
        }

        if (flipping) { // Handle flipping animation
            flipTime += delta;

            if (flipTime > flipDuration) { // If flip animation is complete
                flipping = false;

                // Validate the flip
                if (flipValidator.isValidFlip(rotation, cupY, initialY)) {
                    score++; // Increase score for a valid flip
                    System.out.println("Valid landing! Score: " + score);
                } else {
                    System.out.println("Invalid landing. No points.");
                }

                // Reset rotation and position
                rotation = 0;
                cupY = initialY;
            }

            // Calculate flip animation (parabolic motion)
            float progress = flipTime / flipDuration;
            float heightFactor = 4 * progress * (1 - progress); // Creates a parabola
            cupY = initialY + heightFactor * 150; // Adjusts cup height based on progress
            rotation = progress * 720; // Rotates the cup up to 720 degrees
        }

        // Begin drawing
        game.batch.begin();
        // Draw the cup with rotation and scaling applied
        game.batch.draw(cupImage, cupX, cupY, (cupImage.getWidth() / 2) * scale, (cupImage.getHeight() / 2) * scale,
            cupImage.getWidth() * scale, cupImage.getHeight() * scale, 1, 1, rotation, 0, 0,
            cupImage.getWidth(), cupImage.getHeight(), false, false);
        // Display score and time
        font.draw(game.batch, "Score: " + score, 10, 470);
        font.draw(game.batch, "Time: " + (int) gameTime, 10, 440);
        game.batch.end();
    }

    private void renderPauseMenu() { // Displays the pause menu
        game.batch.begin();
        font.draw(game.batch, "Game Paused", 300, 300);
        font.draw(game.batch, "Press P to Resume", 300, 250);
        font.draw(game.batch, "Press Q to Return to Main Menu", 300, 200);
        game.batch.end();
    }

    private void renderGameOverMenu() { // Displays the game over menu
        game.batch.begin();
        font.draw(game.batch, "Game Over!", 100, 300);
        font.draw(game.batch, "1. Play Again", 100, 260);
        font.draw(game.batch, "2. Main Menu", 100, 220);
        game.batch.end();

        // Check if the player chooses to play again or return to the main menu
        if (Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.NUM_1)) {
            highScore.updateScore(score); // Update high score
            game.setScreen(new GameScreen(game)); // Restart the game
        } else if (Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.NUM_2)) {
            highScore.updateScore(score); // Update high score
            game.setScreen(new MainMenuScreen(game)); // Return to main menu
        }
    }

    @Override
    public void resize(int width, int height) {} // Handles window resizing

    @Override
    public void show() {} // Called when the screen becomes visible

    @Override
    public void pause() {} // Handles game pause

    @Override
    public void resume() {} // Handles game resume

    @Override
    public void hide() {} // Called when the screen is no longer visible

    @Override
    public void dispose() { // Clean up resources
        font.dispose();
        cupImage.dispose();
    }
}
