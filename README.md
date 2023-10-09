# BattleShip
Let's build a battleship game !!!. this is a simple version for practicing Java, so we haven't built any GUI yet. The game will be played on the terminal command line which will wait for the player to enter a guess (coordinate of ships). the picture below shows an example of game interaction.

![played_example](https://github.com/caunhach/BattleShip/blob/main/scam.png)

## Basic Rules / What we build!!!
- There are 3 dot coms with random names that randomly allocate 3 adjacent pixels of the grid.
- When the player guesses the right coordinate, a prompt will display "hit". "kill" will be printed including the ship's name when all of the composited spaces of the ship are hit. Other cases are "miss".
- Invalid input is not allowed:
  1. inputs must be only size of 2 characters
  2. the coordinate must be located within the boundary.
  3. After the end of the game only the start/exit command is allowed.
  So, When we receive the invalid arguments, the prompt will wait until it receives the right format!
- the program will let you put the coordinate with a limited try (2 * size times). the player will win if they can destroy all ships with less than the amount of tries.

## Preparation / Plan
We have 3 classes
- GameLauncher class: launches the game, prints game instructions, and lets the program exit when exit status is false (player types "exit").
- Game class: holds every resource we use in the game (ex. ship, coordinates)
- StartGame class: conduct the game and handle errors that would happen!
