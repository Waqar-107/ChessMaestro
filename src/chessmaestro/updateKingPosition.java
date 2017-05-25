package chessmaestro;

public class updateKingPosition
{
    
    
    public static void whiteKingFinder()
    {
        int[][] boardForKing=Main_chess.board;
        for(int x=0;x<8;x++)
        {
            for(int y=0;y<8;y++)
            {
                if(boardForKing[x][y]==-5)
                {
                    Main_chess.currentPositionWhite_I=x;
                    Main_chess.currentPositionWhite_J=y;
                    return;
                }
            }
        }
    }
    
    
    public static void blackKingFinder()
    {
        int[][] boardForKing=Main_chess.board;
        for(int x=0;x<8;x++)
        {
            for(int y=0;y<8;y++)
            {
                if(boardForKing[x][y]==5)
                {
                    Main_chess.currentPositionBlack_I=x;
                    Main_chess.currentPositionBlack_J=y;
                    return;
                }
            }
        }
    }  
    
}
