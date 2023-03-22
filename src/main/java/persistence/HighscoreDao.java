package persistence;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Objects;

public class HighscoreDao {
    static final String url = "jdbc:mysql://localhost/SnakeScore";
    //static final String url = "/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin";
    static final String user = "snake";
    static final String password = "snake";
    private String nameHighscoretraeger;
    private static final String load =null;
    private static final String a = null;

    public static HighscoreData saveHighscoreToDatabase(int gameModus, String nameHighscoretraeger, int score){
        HighscoreData highscoreData = new HighscoreData();
        if(highscoreData.getDatabase() == 0){
            try {
                Connection connection = DriverManager.getConnection(url, user, password);
                String sql = null;
                if (gameModus == 1){
                    sql = "INSERT INTO Highscore (`NameEasy`, `ScoreEasy`) VALUES (?,?)";
                }else if (gameModus == 2){
                    sql = "INSERT INTO Highscore (`NameMedium`, `ScoreMedium`) VALUES (?,?)";
                }else if (gameModus == 3){
                    sql = "INSERT INTO Highscore (`NameHard`, `ScoreHard`) VALUES (?,?)";
                }else if (gameModus == 4){
                    sql = "INSERT INTO Highscore (`NameSpeedUp`, `ScoreSpeedUp`) VALUES (?,?)";
                }
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1,nameHighscoretraeger);
                statement.setInt(2, score);
                statement.execute();
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error, no connection to database. Please change arg  to use local savefile");
            }
        }else {
            try {
                /*String nameEasy = null;
                String nameMedium = null;
                String nameHard = null;
                String nameSpeedUp = null;
                int scoreEasy = Integer.parseInt(null);
                int scoreMedium = Integer.parseInt(null);
                int scoreHard = Integer.parseInt(null);
                int scoreSpeedUp = Integer.parseInt(null);*/
                BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/cmi/IdeaProjects/Snake/src/main/java/game/SaveFile.txt",true));
               // HighscoreData highscoreData = null;
                highscoreData = new HighscoreData();
                if (gameModus == 1){
                    highscoreData.setScoreEasy(score);
                    highscoreData.setNameEasy(nameHighscoretraeger);
                    return highscoreData;
                }else if (gameModus == 2){
                    highscoreData.setScoreEasy(score);
                    highscoreData.setNameEasy(nameHighscoretraeger);
                    return highscoreData;
                }else if (gameModus == 3){
                    highscoreData.setScoreEasy(score);
                    highscoreData.setNameEasy(nameHighscoretraeger);
                    return highscoreData;
                }else if (gameModus == 4){
                    highscoreData.setScoreEasy(score);
                    highscoreData.setNameEasy(nameHighscoretraeger);
                    return highscoreData;
                }
                bw.write(highscoreData.getScoreEasy());
                bw.newLine();
                bw.write(highscoreData.getNameEasy());
                bw.newLine();
                bw.write(String.valueOf(highscoreData.getScoreMedium()));
                bw.newLine();
                bw.write(highscoreData.getNameMedium());
                bw.newLine();
                bw.write(String.valueOf(highscoreData.getScoreHard()));
                bw.newLine();
                bw.write(highscoreData.getNameHard());
                bw.newLine();
                bw.write(String.valueOf(highscoreData.getNameHard()));
                bw.newLine();
                bw.write(highscoreData.getNameSpeedUp());
                bw.close();
            }catch (Exception e2){
                System.out.println("Error, could not save data in savefile");
            }
        }
        return null;
    }
    /*public static HighscoreData saveHighscoreToLocal(int spielModus, String nameHighscoretraeger, String nameEasy, String nameMedium, String nameHard, String nameSpeedUp, int score, int scoreEasy, int scoreMedium, int scoreHard, int scoreSpeedUp){
    try {
        BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/cmi/IdeaProjects/Snake/src/main/java/game/SaveFile.txt",true));
        HighscoreData highscoreData = null;
        highscoreData = new HighscoreData();
        if (spielModus == 1){
           highscoreData.setScoreEasy(score);
           highscoreData.setNameEasy(nameHighscoretraeger);
           return highscoreData;
        }else if (spielModus == 2){
            highscoreData.setScoreEasy(score);
            highscoreData.setNameEasy(nameHighscoretraeger);
            return highscoreData;
        }else if (spielModus == 3){
            highscoreData.setScoreEasy(score);
            highscoreData.setNameEasy(nameHighscoretraeger);
            return highscoreData;
        }else if (spielModus == 4){
            highscoreData.setScoreEasy(score);
            highscoreData.setNameEasy(nameHighscoretraeger);
            return highscoreData;
        }
        bw.write(String.valueOf(scoreEasy));
        bw.newLine();
        bw.write(nameEasy);
        bw.newLine();
        bw.write(String.valueOf(scoreMedium));
        bw.newLine();
        bw.write(nameMedium);
        bw.newLine();
        bw.write(String.valueOf(scoreHard));
        bw.newLine();
        bw.write(nameHard);
        bw.newLine();
        bw.write(String.valueOf(scoreSpeedUp));
        bw.newLine();
        bw.write(nameSpeedUp);
        bw.close();
    }catch (Exception e2){
        System.out.println("Error");
    }*/
    /*final String key = "Save_Data";
    Preferences prefs = Preferences.userNodeForPackage(HighscoreDao.class);
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try{
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(a);
        prefs.putByteArray(key, baos.toByteArray());
    }catch (IOException ie){
        System.out.println("Error");    }
        return null;
    }*/
    public static HighscoreData loadHighscoreFromDatabase(int spielModus){
        HighscoreData highscoreData = new HighscoreData();
        String columLabelName = null;
        String columLabelScore = null;
        if(highscoreData.getDatabase() == 1){
            try(Connection connection = DriverManager.getConnection(url, user, password)) {
                String sql = null;
                if (spielModus == 1){
                    sql = "SELECT * FROM Highscore";
                    columLabelName = "NameEasy";
                    columLabelScore = "ScoreEasy";
                }else if (spielModus == 2){
                    sql = "SELECT * FROM Highscore";
                    columLabelName = "NameMedium";
                    columLabelScore = "ScoreMedium";
                }else if (spielModus == 3){
                    sql = "SELECT * FROM Highscore";
                    columLabelName = "NameHard";
                    columLabelScore = "ScoreHard";
                }else if (spielModus == 4){
                    sql = "SELECT * FROM Highscore";
                    columLabelName = "NameSpeedUp";
                    columLabelScore = "ScoreSpeedUp";
                }
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(sql);
                if(result.next()) {
                    highscoreData.setName(result.getString(columLabelName));
                    highscoreData.setScore(result.getInt(columLabelScore));
                }
            } catch (SQLException e){
                System.out.println("Error, no connection to database. Please change arg to use local savefile");
            }
            return highscoreData;
        }else{
            try{
                highscoreData = new HighscoreData();
                String path = "/Users/cmi/IdeaProjects/Snake/src/main/java/game/SaveFile.txt";
                highscoreData.setScoreEasy(Integer.parseInt(Files.readAllLines(Paths.get(path)).get(1)));
                highscoreData.setNameEasy(Files.readAllLines(Paths.get(path)).get(2));
                highscoreData.setScoreMedium(Integer.parseInt(Files.readAllLines(Paths.get(path)).get(3)));
                highscoreData.setNameMedium(Files.readAllLines(Paths.get(path)).get(4));
                highscoreData.setScoreHard(Integer.parseInt(Files.readAllLines(Paths.get(path)).get(5)));
                highscoreData.setNameHard(Files.readAllLines(Paths.get(path)).get(6));
                highscoreData.setScoreSpeedUp(Integer.parseInt(Files.readAllLines(Paths.get(path)).get(7)));
                highscoreData.setNameSpeedUp(Files.readAllLines(Paths.get(path)).get(8));
                if (spielModus == 1){
                    highscoreData.setScore(Integer.parseInt(Files.readAllLines(Paths.get(path)).get(2)));
                    highscoreData.setName(Files.readAllLines(Paths.get(path)).get(1));

                }else if (spielModus == 2){
                    highscoreData.setScore(Integer.parseInt(Files.readAllLines(Paths.get(path)).get(4)));
                    highscoreData.setName(Files.readAllLines(Paths.get(path)).get(3));

                }else if (spielModus == 3){
                    highscoreData.setScore(Integer.parseInt(Files.readAllLines(Paths.get(path)).get(6)));
                    highscoreData.setName(Files.readAllLines(Paths.get(path)).get(5));

                }else if (spielModus == 4){
                    highscoreData.setScore(Integer.parseInt(Files.readAllLines(Paths.get(path)).get(8)));
                    highscoreData.setName(Files.readAllLines(Paths.get(path)).get(7));

                }
            }catch (Exception e) {
                System.out.println("Error, could not load savefile");
            }
            return highscoreData;
        }
    }
    /*public static HighscoreData loadHighscoreFromLocal(int spielModus){
        HighscoreData highscoreData = null;
        try{
            highscoreData = new HighscoreData();
            String path = "/Users/cmi/IdeaProjects/Snake/src/main/java/game/SaveFile.txt";
            highscoreData.setScoreEasy(Integer.parseInt(Files.readAllLines(Paths.get(path)).get(1)));
            highscoreData.setNameEasy(Files.readAllLines(Paths.get(path)).get(2));
            highscoreData.setScoreMedium(Integer.parseInt(Files.readAllLines(Paths.get(path)).get(3)));
            highscoreData.setNameMedium(Files.readAllLines(Paths.get(path)).get(4));
            highscoreData.setScoreHard(Integer.parseInt(Files.readAllLines(Paths.get(path)).get(5)));
            highscoreData.setNameHard(Files.readAllLines(Paths.get(path)).get(6));
            highscoreData.setScoreSpeedUp(Integer.parseInt(Files.readAllLines(Paths.get(path)).get(7)));
            highscoreData.setNameSpeedUp(Files.readAllLines(Paths.get(path)).get(8));
            if (spielModus == 1){
                highscoreData.setScore(Integer.parseInt(Files.readAllLines(Paths.get(path)).get(2)));
                highscoreData.setName(Files.readAllLines(Paths.get(path)).get(1));

            }else if (spielModus == 2){
                highscoreData.setScore(Integer.parseInt(Files.readAllLines(Paths.get(path)).get(4)));
                highscoreData.setName(Files.readAllLines(Paths.get(path)).get(3));

            }else if (spielModus == 3){
                highscoreData.setScore(Integer.parseInt(Files.readAllLines(Paths.get(path)).get(6)));
                highscoreData.setName(Files.readAllLines(Paths.get(path)).get(5));

            }else if (spielModus == 4){
                highscoreData.setScore(Integer.parseInt(Files.readAllLines(Paths.get(path)).get(8)));
                highscoreData.setName(Files.readAllLines(Paths.get(path)).get(7));

            }
        }catch (Exception e) {
            System.out.println("Error");
        }
        return highscoreData;
    }*/

    public static void deleteHighscoreFromDatabase(int gameMode, int bestscore){
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String sql = null;
            if (gameMode == 1){
                sql = "DELETE FROM Highscore WHERE ScoreEasy = ?";
            }else if (gameMode == 2){
                sql = "DELETE FROM Highscore WHERE ScoreMedium = ?";
            }else if (gameMode == 3){
                sql = "DELETE FROM Highscore WHERE ScoreHard = ?";
            }else if (gameMode == 4){
                sql = "DELETE FROM Highscore WHERE ScoreSpeedUp = ?";
            }
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, bestscore);
            statement.execute();
            connection.close();
        }catch (SQLException e){
            System.out.println("Error, could not delete data");
        }
    }


    public void namePlayer(int spielModus, int score){
        nameHighscoretraeger = JOptionPane.showInputDialog(null, "Please enter your name");
        saveHighscoreToDatabase(spielModus, nameHighscoretraeger, score);
    }

    public String getNameHighscoretraeger() {
        return nameHighscoretraeger;
    }

    public void setNameHighscoretraeger(String nameHighscoretraeger) {
        this.nameHighscoretraeger = nameHighscoretraeger;
    }
}
