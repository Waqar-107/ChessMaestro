/*this class calculates if any of the pieces have any move or not
in the GUI this is called when the king is in check, if the king is not 
in check and there is no moves, then it will be called stalemate and if in check
it will be checkmate.
*/

package chessmaestro;

import java.util.*;

public class CheckMate
{
    public static int whiteCheckMate()
    {
        possibleMoves.moves.clear();
        int count=0;
        ArrayList<Integer> tempMoves;
        
        for(int x=0;x<8;x++)
        {
            for(int y=0;y<8;y++)
            {
                if(Main_chess.board[x][y]==-1)
                {
                    tempMoves=possibleMoves.rook(x, y);
                    count+=tempMoves.size();
                    tempMoves.clear();
                    possibleMoves.moves.clear();
                }
                
                else if(Main_chess.board[x][y]==-2)
                {
                    tempMoves=possibleMoves.bishop(x, y);
                    count+=tempMoves.size();
                    tempMoves.clear();
                    possibleMoves.moves.clear();
                }
                
                else if(Main_chess.board[x][y]==-3)
                {
                    tempMoves=possibleMoves.knight(x, y);
                    count+=tempMoves.size();
                    tempMoves.clear();
                    possibleMoves.moves.clear();
                }
                
                else if(Main_chess.board[x][y]==-4)
                {
                    tempMoves=possibleMoves.queen(x, y);
                    count+=tempMoves.size();
                    tempMoves.clear();
                    possibleMoves.moves.clear();
                }
                
                else if(Main_chess.board[x][y]==-5)
                {
                    tempMoves=possibleMoves.king(x, y);
                    count+=tempMoves.size();
                    tempMoves.clear();
                    possibleMoves.moves.clear();
                }
                
               else if(Main_chess.board[x][y]==-7)
                {
                    tempMoves=possibleMoves.pawn(x, y);
                    count+=tempMoves.size();
                    tempMoves.clear();
                    possibleMoves.moves.clear();
                }
            }
        }
        
        return count;
    }
    
     public static int blackCheckMate()
    {
         possibleMoves.moves.clear();
         int count=0;
        ArrayList<Integer> tempMoves;
        
        for(int x=0;x<8;x++)
        {
            for(int y=0;y<8;y++)
            {
                if(Main_chess.board[x][y]==1)
                {
                    tempMoves=possibleMoves.rook(x, y);
                    count+=tempMoves.size();
                    tempMoves.clear();
                    possibleMoves.moves.clear();
                }
                
                else if(Main_chess.board[x][y]==2)
                {
                    tempMoves=possibleMoves.bishop(x, y);
                    count+=tempMoves.size();
                    tempMoves.clear();
                    possibleMoves.moves.clear();
                }
                
                else if(Main_chess.board[x][y]==3)
                {
                    tempMoves=possibleMoves.knight(x, y);
                    count+=tempMoves.size();
                    tempMoves.clear();
                    possibleMoves.moves.clear();
                }
                
                else if(Main_chess.board[x][y]==4)
                {
                    tempMoves=possibleMoves.queen(x, y);
                    count+=tempMoves.size();
                    tempMoves.clear();
                    possibleMoves.moves.clear();
                }
                
                else if(Main_chess.board[x][y]==5)
                {
                    tempMoves=possibleMoves.king(x, y);
                    count+=tempMoves.size();
                    tempMoves.clear();
                    possibleMoves.moves.clear();
                }
                
               else if(Main_chess.board[x][y]==7)
                {
                    tempMoves=possibleMoves.pawn(x, y);
                    count+=tempMoves.size();
                    tempMoves.clear();
                    possibleMoves.moves.clear();
                }
            }
        }
        
        return count;
    }
}
