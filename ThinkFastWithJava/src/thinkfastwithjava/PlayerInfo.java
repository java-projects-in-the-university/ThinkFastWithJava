/**
 * This class brings the player information stored in the database and store the information in the database
 */

package thinkfastwithjava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.*;


/**
 *
 * @author Basma ALI DI: 433013617 
 */
public class PlayerInfo {
    
    protected String playetName;
    protected int Beginner;
    protected int Meduim;
    protected int Advanced;
    protected int playerPoints;
    protected Level levels;
    JavaGameFrame2 j = new JavaGameFrame2() ;
    String[] tutorialLines = {"Welcome player to our first game ever.", 
        "In this game you will know how good you are in Java",
        "Programming. ",
        "All you have to do is to find errors in the code that we will ",
        "provide gladly and specially for you, ",
        "you will write your answers in text Fields then click next so",
        "another code will appear",
        " Note* : you only write the symbol of the error or the missing part ",
        "and nothing else...  like this  ;   and  {  and so on.",
        "Each Question has two Answers and each Answer has two points.",
        "Don't worry you can repeat The level you are playing if you didn't ",
        "achieve the right points",
        "And yes we forgot to tell you about the most important thing",
        " There is time running while you are playing so try to answer ",
        "quickly.",
        "Here is a last Advice from us :",
        "Relax and don't  panic, you will get it"};
  /**
     * Set the value of playetName
     *
     * @param playetName new value of playetName
     */
    public void setPlayerName(String playetName) {
        this.playetName = playetName;
    }
    
    /**
     * Set the value of Beginner
     *
     * @param Beginner new value of Beginner
     */
    public void setBeginner(int Beginner) {
        this.Beginner = Beginner;
    }
     /**
     * Set the value of Meduim
     *
     * @param Meduim new value of Meduim
     */
    public void setMeduim(int Meduim) {
        this.Meduim = Meduim;
    }
     /**
     * Set the value of Advanced
     *
     * @param Advanced new value of Advanced
     */
    public void setAdvanced(int Advanced) {
        this.Advanced = Advanced;
    }

    /**
     * Set the value of playerPoints
     *
     * @param playerPoints new value of playerPoints
     */
    public void setPlayerPoints(int playerPoints) {
        this.playerPoints = playerPoints;
    }
    
     /**
     * Set the value of levels
     *
     * @param  levels new value of leves
     */
    public void setLevels(Level levels) {
        this.levels = levels;
    }
    /**
     * Get the value of playetName
     *
     * @return the value of playetName
     */
    public String getPlayerName() {
        return playetName;
    }
    
    /**
     * Get the value of Beginner
     *
     * @return the value of Beginner
     */
    public int getBeginner() {
        return Beginner;
    }
    /**
     * Get the value of Meduim
     *
     * @return the value of Meduim
     */
    public int getMeduim() {
        return Meduim;
    }
    /**
     * Get the value of Advanced
     *
     * @return the value of Advanced
     */
    public int getAdvanced() {
        return Advanced;
    }

    /**
     * Get the value of playerPoints
     *
     * @return the value of playerPoints
     */
    public int getPlayerPoints() {
        return playerPoints;
    }


    /**
     * Get the value of levels
     *
     * @return the value of levels
     */
    public Level getLevels() {
        return levels;
    }
    

    
    /**
     * Is the name of the player is
     * @param PlayerName of Player
     * @return exist 
     */
    
    public boolean isPlayerExist(String PlayerName){
        boolean exist = false;
        Connection con = null;
        PreparedStatement s = null;
        ResultSet rs = null;
           try{
                con = Connect.getConnection();
                String select = "SELECT PlayerName FROM think_fast_with_java.player WHERE PlayerName = ?;";
                s = con.prepareStatement(select);
                s.setString(1, PlayerName);
                rs = s.executeQuery();
                if(rs.next()){
                  exist = true;
                  System.out.println("Too Bad This Name is Taken!!");
                }
                else{
                    exist = false;
                    System.out.println("Nice Name!!"); 
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
        return exist;
    }
    
    
    /**
     * this method recorded a new player in the game.
     * @param playerName  of Player
     */
    
    public void savePlayerInfo( String playerName){
        Connection con = null;
        PreparedStatement s = null;
        String query;
           try{
               con = Connect.getConnection();
               if( this.isPlayerExist( playerName)){
                 query = "UPDATE player SET  PlayerName = ? WHERE PlayerName = ? ";
                 System.out.println("PlayerName "+playerName+" is exist ");
               }  
               else {
                query = " INSERT INTO player (PlayerName,Beginner,Meduim,Advanced,PlayerScore,Level) VALUES (?,?,?,?,?,?)";
                System.out.println("PlayerName "+playerName +" NOT exist ");
               }
                // apply query 
                s= con.prepareStatement(query);
                s.setString(1,playerName);
                s.setInt(2, 0);
                s.setInt(3, 0);
                s.setInt(4, 0);
                s.setInt(5,0);
                s.setInt(6,1); 
            int resutl = s.executeUpdate();
            System.out.println(" Result = 1 PlayerName record has been Sucessfully saved ");
          }
          catch (Exception e ){
              System.out.println("Saving one PlayerName record was NOT sucessful");
              e.printStackTrace();
              System.out.println("Nice Name!!"); 
          }
         finally{
               if(s != null) try{s.close();}catch(Exception e){e.printStackTrace();}
               if(con != null) try{con.close();}catch(Exception e){e.printStackTrace();}
          }
     }
    
     /**
      * this method login to the game
      * @param PlayerName of Player
      * @return playerInfo 
      */
     
     public static PlayerInfo loadPlayerInfo(String PlayerName){
        Connection con = null;
        PreparedStatement s = null;
        ResultSet rs = null;
        PlayerInfo playerInfo=new PlayerInfo();
         try{
             con = Connect.getConnection();
             String select = "SELECT * FROM player WHERE PlayerName = ?;";
             s = con.prepareStatement(select);
             s.setString(1,PlayerName);
             rs = s.executeQuery();
             if(rs.next()){
                 playerInfo.setPlayerName(PlayerName);
                 playerInfo.setBeginner(rs.getInt("Beginner"));
                 playerInfo.setMeduim(rs.getInt("Meduim"));
                 playerInfo.setAdvanced(rs.getInt("Advanced"));
                 playerInfo.setPlayerPoints(rs.getInt("PlayerScore"));
                 int LevelNum= rs.getInt("Level");
                 Level le=Level.loadLevelInfo(LevelNum);
                 playerInfo.setLevels(le);
                 System.out.println(rs.getString("PlayerName")); 
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
        return playerInfo;
    }
     

     /**
      * This method  updating the player data
      * @param Beginner of Player
      * @param Meduim of Player
      * @param Advanced of Player
      * @param playerPoints of Player
      * @param level  of Player
      */
     public void updatePlayerInfo(int Beginner,int Meduim,int Advanced,int playerPoints, int level  ) {
        Connection con = null;
        PreparedStatement s = null;
        String query;
        try {
             con = Connect.getConnection();
             query = "UPDATE player SET Beginner=? ,Meduim=? ,Advanced=? ,PlayerScore=? ,Level=? WHERE PlayerName = ? ";
             s = con.prepareStatement(query);
             s.setString(6, this.getPlayerName());
             s.setInt(1,Beginner);
             s.setInt(2,Meduim);
             s.setInt(3,Advanced);
             s.setInt(4,playerPoints);
             s.setInt(5,level);
             int result = s.executeUpdate();
       } 
        catch (Exception e) {
            e.printStackTrace();
        } 
        finally {
            if(s != null)try{s.close();}catch(Exception e){e.printStackTrace();}
            if(con != null)try{con.close();}catch(Exception e){e.printStackTrace();}
        } 
    }
    
    /**
     * This method  deleat the player data
     * @param PlayerName of Player
     */
    
     public void deleatPlayerInfo(String PlayerName){
         Connection con = null;
         PreparedStatement s = null;
         String query;
         try {
            con = Connect.getConnection();
            query = "Delete from think_fast_with_java.player where PlayerName = ? ;";
            s = con.prepareStatement(query);
            s.setString(1,PlayerName);
            int result = s.executeUpdate();
            if (result == 1){
                System.out.print(PlayerName);
            }
            System.out.print(PlayerName);
        } 
        catch (Exception e) {
            e.printStackTrace();
            System.out.print("not done ");
        } 
        finally {
            if(s != null)try{s.close();}catch(Exception e){e.printStackTrace();}
            if(con != null)try{con.close();}catch(Exception e){e.printStackTrace();}
        } 
    } 
     /**
      *  
      * @param gamePoint calculate the result of the player
      * @return nextLevel
      */
     
     public boolean   PlayerScore(int gamePoint){
         boolean nextLevel= false;
         if (levels.levelNum==1){
             Beginner=gamePoint;
         }
         else if(levels.levelNum==2){
             Meduim=gamePoint;
         }
         else if(levels.levelNum==3){
              Advanced=gamePoint;
              System.out.println("Advanced"+Advanced);
         }
         
         if (gamePoint >=(levels.maxPoints*0.75)){
            levels.levelNum=levels.levelNum+1;
            System.out.print(levels.levelNum);
            playerPoints =Beginner+Meduim+Advanced;
            updatePlayerInfo(Beginner,Meduim,Advanced,playerPoints,levels.levelNum );
            return nextLevel  = true;
            
         } 
         System.out.print("levels.levelNum"+levels.levelNum);
         
        playerPoints =Beginner+Meduim+Advanced;
        updatePlayerInfo(Beginner,Meduim,Advanced,playerPoints,levels.levelNum );
        System.out.println("playerPoints"+playerPoints);
        return nextLevel;
     } 
    
    
    /**
     *  write Report to the player in file
     */
     public void writeInfile(){
     try {
            BufferedWriter out = new BufferedWriter(
            new FileWriter("think_fast_with_java.txt"));
            for(String lines:tutorialLines){
            out.write(lines+"\n");
             }
               out.close();
           } catch (IOException e) {e.printStackTrace();}
      }
      
      
      /**
       * Read to trtole on the in File
       * @throws FileNotFoundException  in locetion
       * @throws IOException  printStackTrace
       */
     public void readInFile() throws FileNotFoundException, IOException{
       try (BufferedReader br = new BufferedReader(new FileReader(new File("think_fast_with_java.txt")))) {
       String text = null;
        int lineCount = 0;
        while ((text = br.readLine()) != null && lineCount < 17) {
        //System.out.println(text);
        JavaGameFrame2.TutorialFromFile.append(tutorialLines[lineCount] + " "  + "\n");
        lineCount++;
       }
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
     /**
      * this method Convert int to string
      * @return  info
      */
     public String printScore(){
        String info = ""+this.getPlayerPoints();        
        return info ;
     }
     public String printLevelNum(){
        String info = ""+levels.getLevelNum();        
        return info ;
     }
    
    
}

