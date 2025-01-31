# Card Game - Blackjack Simplified

## Overview
This is a simplified version of the card game Blackjack implemented in Python. The game allows a player to compete against an NPC, where the goal is to reach a score as close to 21 as possible without exceeding it. The game includes dynamic decision-making for both the player and the NPC.

## Features
- **Card Deck Simulation**: A deck of 52 cards where values include numeric cards, face cards (as 10), and aces (which can be 1 or 11).
- **Player and NPC Logic**:
  - The player decides whether to draw a card or hold.
  - The NPC automatically draws cards until its score reaches at least 17.
- **Score Calculation**: Aces dynamically adjust value (1 or 11) to avoid exceeding 21.
- **Winner Determination**:
  - Player wins if their score is closer to 21 than the NPC’s.
  - NPC wins in case of a tie or if the player exceeds 21.

## How to Play
1. Run the program in a Python environment.
2. The player will be prompted to draw a card (`Yes`) or hold (`No`).
3. The NPC plays automatically based on its internal logic.
4. The game concludes with the winner and final scores displayed.

## Example Gameplay
```plaintext
Player drew card: 8
Player drew card: 10
Player's score: 18
Do you want to draw a card or hold? (yes/no): no
NPC: 9
NPC: 8
NPC's score: 17
Player's final score: 18
NPC's final score: 17
Player wins!
```

