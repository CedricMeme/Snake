package persistence;

import java.sql.*;

import static actions.Main.nameHighscoretraeger;
import static game.Snake.bestscore;

public class HighscoreDao {
    static String url = "jdbc:mysql://localhost/SnakeScore";
    static String user = "snake";
    static String password = "snake";
    public static void saveHighscoreToDatabase(){
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String sql = "INSERT INTO Highscore (`Name`, `Score`, `Startbedingung`) VALUES (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nameHighscoretraeger);
            statement.setInt(2, bestscore);
            statement.setInt(3,1);
            statement.execute();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error");
        }
    }
}
