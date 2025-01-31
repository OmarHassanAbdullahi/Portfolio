package com.flipthecup; // Defines the package for the game

import com.badlogic.gdx.Game; // Imports the Game class from libGDX
import com.badlogic.gdx.graphics.g2d.SpriteBatch; // Imports SpriteBatch for rendering 2D graphics

public class FlipTheCup extends Game { // Main class extending Game
    public SpriteBatch batch; // A SpriteBatch instance to draw graphics

    @Override
    public void create() { // This method is called when the game starts
        SpriteBatch batch = new SpriteBatch(); // Creates a new SpriteBatch instance
        this.batch = batch; // Assigns the instance to the class variable (redundant declaration)

        setScreen(new MainMenuScreen(this)); // Sets the initial screen to the main menu
    }

    @Override
    public void render() { // The render() method is called to update the game
        super.render(); // Calls the render method of the Game class to handle screen rendering
    }

    @Override
    public void dispose() { // The dispose() method is used to release resources when the game is closed
        batch.dispose(); // Releases memory used by the SpriteBatch
        getScreen().dispose(); // Releases resources of the current screen
    }
}
