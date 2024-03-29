<div align="center">
  <img src="img/javafx.png" height="50px" style="display: inline-block; margin-left: auto; margin-right: auto;">
  <img src="img/snake.png" height="50px" style="display: inline-block; margin-left: auto; margin-right: auto;">
  <img src="img/mysql.png" height="50px" style="display: inline-block; margin-left: auto; margin-right: auto;">

# Snake
</div>

I made a version of the game "snake" when I was in school, and now I'm studying computer science, I've tried again and this is the result.

## Features
### Game Modes
In my project I have implemented three different modes with different difficulty levels / different levels of speed.
  - Easy: Time to sleep between movement in millis: 200
  - Medium: Time to sleep between movement in millis: 150
  - Hard: Time to sleep between movement in millis: 100
  - "Modus" where the speed increase (time to sleep between movement in millis goes down).

There's a menu interface where you can change the game mode or difficulty.

### Settings
You have a setting section, where you can change the volume of the music.

### High Score
If you break the high score the game will overwrite the old score and you can enter your name.

## MySQL
I have a MYSQL database running via Docker, in which the highest score achieved for the individual modes and difficulty are stored, as well as th name of the player.The game pulls the highscore from the database and if a player should break the score, a window appears in which the player can enter their name and the name and score will be overwritten in the database.


## Technologies used
- Java
- Javafx
- MYSQL-Database
- Docker



## Photos
<img src="img/Game.png" width="400">
<img src="img/Name.png" width="400">
<img src="img/Menu.png" width="400">