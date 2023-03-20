package persistence;

public class HighscoreData {

    private String name;
    private int score;
    private String nameEasy;
    private String nameMedium;
    private String nameHard;
    private String nameSpeedUp;
    private int scoreEasy;
    private int scoreMedium;
    private int scoreHard;
    private int scoreSpeedUp;
    private String database;
    public static String getDatabase() {return database;}
    public void  setDatabase(String database) {this.database = database;}
    public String getName() {return name; }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getNameEasy(){return nameEasy; }
    public void setNameEasy(String nameEasy){this.nameEasy = nameEasy;}
    public String getNameMedium(){return nameMedium; }
    public void setNameMedium(String nameEasy){this.nameMedium = nameMedium;}
    public String getNameHard(){return nameHard; }
    public void setNameHard(String nameHard){this.nameHard = nameHard;}
    public String getNameSpeedUp(){return nameSpeedUp; }
    public void setNameSpeedUp(String nameEasy){this.nameSpeedUp = nameSpeedUp;}
    public int getScoreEasy() {return scoreEasy;}
    public void setScoreEasy(int scoreEasy){this.scoreEasy = scoreEasy;}
    public int getScoreMedium() {return scoreMedium;}
    public void setScoreMedium(int scoreMedium){this.scoreMedium = scoreMedium;}
    public int getScoreHard(int scoreHard){return scoreHard;}
    public void setScoreHard(int scoreEasy){this.scoreHard = scoreHard;}
    public int getScoreSpeedUp() {return scoreSpeedUp;}
    public void setScoreSpeedUp(int scoreSpeedUp){this.scoreSpeedUp = scoreSpeedUp;}

}
