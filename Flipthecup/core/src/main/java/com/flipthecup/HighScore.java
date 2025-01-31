package com.flipthecup; // Defines the package for the game

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle; // Used for reading and writing files
import com.badlogic.gdx.utils.Json; // Utility for handling JSON serialization
import com.badlogic.gdx.utils.JsonWriter; // Utility for writing JSON data

public class HighScore { // Class for managing high scores
    private int highscore; // Stores the highest score achieved
    private int lastScore; // Stores the most recent score
    private static final String FILE_NAME = "score_data.json"; // Filename for storing scores

    public HighScore() { // Constructor loads saved scores when the game starts
        load();
    }

    public void updateScore(int newScore) { // Updates the high score if a new record is set
        lastScore = newScore;
        if (newScore > highscore) { // If the new score is higher, update the high score
            highscore = newScore;
        }
        save(); // Save updated scores to file
    }

    public int getHighscore() { // Returns the highest score
        return highscore;
    }

    public int getLastScore() { // Returns the most recent score
        return lastScore;
    }

    public String showHighScore() { // Returns a formatted string of scores
        return "High Score: " + highscore + " Last Score: " + lastScore;
    }

    private void load() { // Loads high scores from the JSON file
        FileHandle file = Gdx.files.local(FILE_NAME); // Get the file handle
        if (file.exists()) { // Check if the file exists
            Json json = new Json(); // Create a JSON parser
            ScoreData data = json.fromJson(ScoreData.class, file); // Deserialize the JSON file into a ScoreData object
            highscore = data.highscore; // Load the high score from the file
            lastScore = data.lastScore; // Load the last recorded score from the file
        }
    }

    private void save() { // Saves high scores to the JSON file
        Json json = new Json(); // Create a JSON handler
        json.setOutputType(JsonWriter.OutputType.json); // Set output type to JSON format
        FileHandle file = Gdx.files.local(FILE_NAME); // Get the file handle for saving
        ScoreData data = new ScoreData(); // Create a new ScoreData object
        data.highscore = highscore; // Store the current high score
        data.lastScore = lastScore; // Store the last score
        file.writeString(json.prettyPrint(data), false); // Write the data to the file in a readable format
    }

    private static class ScoreData { // Inner class for storing score data in JSON format
        public int highscore;
        public int lastScore;
    }
}
