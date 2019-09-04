/*
 *This class is used to bring the game level
 */
package thinkfastwithjava;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author Reeam saleh
 */
public class Level {
    
    protected int levelNum ;
    protected String levelName;
    protected int maxPoints;
    protected Vector<Questions>questions;
    protected Vector<PlayerInfo>playerInfo;
    
    
    /**
     * 
     */
    public Level() {
      questions =new Vector<Questions>();
      playerInfo =new Vector<PlayerInfo>();
    }
    
     /**
     * Set the value of levelNum
     *
     * @param levelNum new value of levelNum
     */
    public void setLevelNum(int levelNum) {
        this.levelNum = levelNum;
    }

    /**
     * Set the value of levelName
     *
     * @param levelName new value of levelName
     */
    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
    
    /**
     * Set the value of maxPoints
     *
     * @param maxPoints new value of maxPoints
     */
    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }
    
     /**
     * Get the value of levelName
     *
     * @return the value of levelName
     */
    public String getLevelName() {
        return levelName;
    } 
    
     /**
     * Get the value of levelNum
     *
     * @return the value of levelNum
     */
    public int getLevelNum() {
        return levelNum;
    }
    
    
    /**
     * Get the value of maxPoints
     *
     * @return the value of maxPoints
     */
    public int getMaxPoints() {
        return maxPoints;
    }
    
    /**
     * Add an object from a type of Question to vector
     * @param questions of level
     */
    public void addQuestions(Questions questions){
        this.questions.add(questions);
     
    }
    
    /**
     * Add an object from a type of PlayerInfo to vector
     * @param playerInfo of player
     */
    public void addPlayerInfo(PlayerInfo playerInfo){
        this.playerInfo.add(playerInfo);
     
    }
    /**
     * Bring-level information
     * @param LevelNum of level
     * @return object of  Level 
     */
    
    public static Level loadLevelInfo(int LevelNum){
        Connection con = null;
        PreparedStatement s = null;
        ResultSet rs = null;
        Level level=new Level();
         try{
             con = Connect.getConnection();
             String select = "SELECT * FROM think_fast_with_java.levels WHERE LevelNum = ?;";
             s = con.prepareStatement(select);
             s.setInt(1, LevelNum);
             rs = s.executeQuery();
              if(rs.next()){ 
                 level.setLevelNum(LevelNum);
                 level.setLevelName(rs.getString("LevelName"));
                 level.setMaxPoints(rs.getInt("maxPoints"));
                 Vector<Questions> sList= Questions.loadQuestionInfo(LevelNum);
                  if(sList != null){
                     for(Questions q : sList){
                        level.addQuestions(q);
                        q.setLevel(level);
                     }       
                 }
           }
       }
           catch(Exception e){
               e.printStackTrace();
           }
           finally{
               if(rs != null) try{rs.close();}catch(Exception e){e.printStackTrace();}
               if(s != null) try{s.close();}catch(Exception e){e.printStackTrace();}
               if(con != null) try{con.close();}catch(Exception e){e.printStackTrace();}
           }        
        return level;  
  }
    
    
}

