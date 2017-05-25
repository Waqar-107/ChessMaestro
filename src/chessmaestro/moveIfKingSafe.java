package chessmaestro;

public class moveIfKingSafe
{
    public static boolean kingIsSafe(int pi,int pj,int ni,int nj,int x)
    {
        int[][] temp=new int[8][8];
        
        for(int r=0;r<8;r++)
          {
              for(int s=0;s<8;s++)
              {
                   temp[r][s]=Main_chess.board[r][s];
              }
          }
        
        boolean safety;
        
        if(Main_chess.flag==0)
        {    
            temp[ni][nj]=x;
            temp[pi][pj]=0;
  
            updateKingPosition.whiteKingFinder();
            if(check.danger(Main_chess.currentPositionWhite_I, Main_chess.currentPositionWhite_J,temp)==false)
                safety=true;
            else
                safety=false;
            
            temp[ni][nj]=0;
            temp[pi][pj]=x;
      
        }
        
        else
        {
            temp[ni][nj]=x;
            temp[pi][pj]=0;
            
            updateKingPosition.blackKingFinder();
            if(check.danger(Main_chess.currentPositionBlack_I, Main_chess.currentPositionBlack_J,temp)==false)
                safety=true;
            else
                safety=false;
           
            temp[ni][nj]=0;
            temp[pi][pj]=x;

        }
        
        return safety;
    }
}
