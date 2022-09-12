package persistence;

import javax.swing.*;
import java.sql.*;
import static game.Snake.bestscore;
import static game.Snake.spielModus;

public class HighscoreDao {
    static String url = "jdbc:mysql://localhost/SnakeScore";
    static String user = "snake";
    static String password = "snake";
    public String nameHighscoretraeger;
    public void saveHighscoreToDatabase(){
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String sql = null;
            if (spielModus == 1){
                sql = "INSERT INTO HighscoreLeicht (`Name`, `Score`) VALUES (?,?)";
            }else if (spielModus == 2){
                sql = "INSERT INTO HighscoreMittel (`Name`, `Score`) VALUES (?,?)";
            }else if (spielModus == 3){
                sql = "INSERT INTO HighscoreSchwer (`Name`, `Score`) VALUES (?,?)";
            }else if (spielModus == 4){
                sql = "INSERT INTO HighscoreModus (`Name`, `Score`) VALUES (?,?)";
            }
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nameHighscoretraeger);
            statement.setInt(2, bestscore);
            statement.execute();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error");
        }
    }

    public void loadHighscoreFromDatabase(){
        try{
            Connection connection = DriverManager.getConnection(url, user, password);
            String sql = null;
            if (spielModus == 1){
                sql = "SELECT * FROM HighscoreLeicht";
            }else if (spielModus == 2){
                sql = "SELECT * FROM HighscoreMittel";
            }else if (spielModus == 3){
                sql = "SELECT * FROM HighscoreSchwer";
            }else if (spielModus == 4){
                sql = "SELECT * FROM HighscoreModus";
            }
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                nameHighscoretraeger = result.getString("Name");
                bestscore = result.getInt("Score");
            }
            connection.close();
        }catch (SQLException e){
            System.out.println("Error");
        }
    }
    public void deleteHighscoreFromDatabase(){
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String sql = null;
            if (spielModus == 1){
                sql = "DELETE FROM HighscoreLeicht WHERE Score = ?";
            }else if (spielModus == 2){
                sql = "DELETE FROM HighscoreMittel WHERE Score = ?";
            }else if (spielModus == 3){
                sql = "DELETE FROM HighscoreSchwer WHERE Score = ?";
            }else if (spielModus == 4){
                sql = "DELETE FROM HighscoreModus WHERE Score = ?";
            }
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,bestscore);
            statement.execute();
            connection.close();
        }catch (SQLException e){
            System.out.println("Error");
        }
    }
    public void namePlayer(){
        nameHighscoretraeger = JOptionPane.showInputDialog(null, "Bitte Namen eingeben");
    }
}
