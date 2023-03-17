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

### Setup Server
To setup a MySQl-Server via Docker you have to do the following:
- Setup Docker
  - First you have to create an account on https://hub.docker.com
  - Then you have to download Docker for your operating system
  - Now you can run Docker
- Create an image/Server
  - You have to open a terminal or command line
  - You have login with your Docker-account with the command line "docker login"
    - You will be asked to enter your username and password you create on the dockerhub website
  - Now we can use the `run` command `docker run --name some-mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql` which run the container if it exist on or else download it.
  - `some-sql` is the name of the image and can be changed as well as the password `my-secret-pw`
    - You can also download the image via the Docker pull command you can find on their website  
  - When the installation of the image is finished you can check the status witch "docker ps"
- Now you should connect with the image via MySQL-Workbench and Java
## Technologies used
- Java
- Javafx
- MYSQL-Database
- Docker



## Photos
<img src="img/Game.png" width="400">
<img src="img/Name.png" width="400">
<img src="img/Menu.png" width="400">