package persistence;

import java.sql.*;

import static actions.Main.nameHighscoretraeger;
import static game.Snake.bestscore;
import static game.Snake.SqlBedingung;

public class HighscoreDao {
    static String url = "jdbc:mysql://localhost/SnakeScore";
    static String user = "snake";
    static String password = "snake";
    public static void saveHighscoreToDatabase(){
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String sql = null;
            if (SqlBedingung == 1){
                sql = "INSERT INTO HighscoreLeicht (`Name`, `Score`) VALUES (?,?)";
            }else if (SqlBedingung == 2){
                sql = "INSERT INTO HighscoreMittel (`Name`, `Score`) VALUES (?,?)";
            }else if (SqlBedingung == 3){
                sql = "INSERT INTO HighscoreSchwer (`Name`, `Score`) VALUES (?,?)";
            }else if (SqlBedingung == 4){
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

    public static void loadHighscoreFromDatabase(){
        try{
            Connection connection = DriverManager.getConnection(url, user, password);
            String sql = null;
            if (SqlBedingung == 1){
                sql = "SELECT * FROM HighscoreLeicht";
            }else if (SqlBedingung == 2){
                sql = "SELECT * FROM HighscoreMittel";
            }else if (SqlBedingung == 3){
                sql = "SELECT * FROM HighscoreSchwer";
            }else if (SqlBedingung == 4){
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
    public static void updateHighscoreFromDatabase(){
        try {
            Connection connection = DriverManager.getConnection(url, user,password);
            String sql = "UPDATE Highscore SET 'Name'=?,'Score'=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nameHighscoretraeger);
            statement.setInt(2, bestscore);
            statement.executeUpdate(sql);
            connection.close();

        }catch(SQLException e){
            System.out.println("Error");
        }
    }
    public static void deleteHighscoreFromDatabase(){
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String sql = null;
            if (SqlBedingung == 1){
                sql = "DELETE FROM HighscoreLeicht WHERE Score = ?";
            }else if (SqlBedingung == 2){
                sql = "DELETE FROM HighscoreMittel WHERE Score = ?";
            }else if (SqlBedingung == 3){
                sql = "DELETE FROM HighscoreSchwer WHERE Score = ?";
            }else if (SqlBedingung == 4){
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
}
