/**
 * This class is used to bring questions of databases for a particular level
 */
package thinkfastwithjava;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import java.util.Vector;

/**
 *
 * @author Basma ALI DI: 433013617 
 */
class Questions {
    
    protected int QuestionNum;
    protected String QuestionContent;   
    protected String Solution1;
    protected String Solution2;
    protected int gameScore;
    protected Level level;
   
    /**
     * Set the value of QuestionNum
     *
     * @param QuestionNum new value of QuestionNum
     */
    public void setQuestionNum(int QuestionNum) {
        this.QuestionNum = QuestionNum;
    }
    
    /**
     * Set the value of QuestionContent
     *
     * @param QuestionContent new value of QuestionContent
     */
    public void setQuestionContent(String QuestionContent) {
        this.QuestionContent = QuestionContent;
    }

    /**
     * Set the value of Solution1
     *
     * @param Solution1 new value of Solution1
     */
    public void setSolution1(String  Solution1) {
        this.Solution1 = Solution1;
    }
    
    /**
     * Set the value of Solution2
     *
     * @param Solution2 new value of Solution2
     */
    public void setSolution2(String  Solution2) {
        this.Solution2 = Solution2;
    }
    
     /**
     * Set the value of gameScore
     *
     * @param gameScore new value of gameScore
     */
    public void setGameScore(int gameScore) {
        this.gameScore = gameScore;
    }
    
     /**
     * Set the value of level
     *
     * @param level new value of level
     */
    public void setLevel(Level level) {
        this.level = level;
    }
    
    /**
     * Get the value of QuestionNum
     *
     * @return the value of QuestionNum
     */
    public int getQuestionNum() {
        return QuestionNum;
    }
    /**
     * Get the value of QuestionContent
     *
     * @return the value of QuestionContent
     */
    public String getQuestionContent() {
        return QuestionContent;
    }
    
    /**
     * Get the value of Solution1
     *
     * @return the value of Solution1
     */
    public String getSolution1() {
        return Solution1;
    }
    
     /**
     * Get the value of Solution2
     *
     * @return the value of Solution2
     */
    public String getSolution2() {
        return Solution2;
    }
    
    /**
     * Get the value of gameScore
     *
     * @return the value of gameScore
     */
    public int getGameScore() {
        return gameScore;
    }
    
    /**
     * Get the value of level
     *
     * @return the value of level
     */
    public Level getLevel() {
        return level;
    }
     

    
    /**
     * Bring a set of questions in the level
     * @param LevelNum
     * @return  vector of  Questions
     */
    
    public static Vector<Questions> loadQuestionInfo(int LevelNum){
        Connection con = null;
        PreparedStatement s = null;
        ResultSet rs = null;
        int i=0;
        int m=0;
        if(LevelNum == 1){
            i= 10;
            m= 15;
        }
        if(LevelNum==2){
            i= 7;
             m= 14;
        }
        if(LevelNum == 3){
            i=7;
            m=13;  
        }
       
        Vector <Questions> questions=new Vector<Questions>(); 
        try{
             con = Connect.getConnection();
             Random r=new Random();
             int sw;
             for(;i>0;i--){
                sw = r.nextInt(m); 
                if(sw==0){
                   i++;
                }
              String select = "SELECT * FROM think_fast_with_java.questions WHERE LevelNum= ? and QuestionNum =?;";
              s = con.prepareStatement(select);
              s.setInt(1, LevelNum);
              s.setInt(2, sw);
              rs = s.executeQuery();
              while (rs.next()) {
                Questions q=new Questions();
                Level le=new Level();
                le.setLevelNum(rs.getInt("LevelNum"));
                q.setLevel(le);
                q.setQuestionNum(rs.getInt("QuestionNum"));
                q.setQuestionContent(rs.getString("QuestionContent"));
                q.setSolution1(rs.getString("Solution1"));
                q.setSolution2(rs.getString("Solution2"));
                questions.add(q);
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
        return questions;
    }
    /**
     * This is used to calculate the result of the current level and compare answers
     * @param slocin1
     * @param sloccin2
     * @param playerslocin1
     * @param playerslocin2
     * @return 
     */
    
    public int gameScore(String slocin1, String sloccin2,String playerslocin1,String playerslocin2){
      if (playerslocin1.equals(playerslocin2)){
          if(playerslocin1.equals(slocin1)||playerslocin1.equals(sloccin2)){
           gameScore=gameScore+2 ;
           }  
      }
     else{
          if(playerslocin1.equals(slocin1)||playerslocin1.equals(sloccin2)){
           gameScore=gameScore+2 ;
          }
          if((playerslocin2.equals(slocin1))||(playerslocin2.equals(sloccin2))){
           gameScore=gameScore+2 ;  
           } 
      }
    System.out.println(playerslocin1+"_"+gameScore+"_"+slocin1);
     return gameScore;
  }
     

    
}