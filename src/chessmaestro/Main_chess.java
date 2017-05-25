package chessmaestro;

import java.util.ArrayList;
import javafx.scene.image.ImageView;

public class Main_chess 
{
    //initial of the board.
    //7:pawn, 1:rook, 2:bishop, 3:knight, 4:queen, 5:king, 0:empty, the positive integers for black and vice versa
    
    public static int[][] board={ {1,3,2,4,5,2,3,1},
                           {7,7,7,7,7,7,7,7},
                           {0,0,0,0,0,0,0,0},
                           {0,0,0,0,0,0,0,0},
                           {0,0,0,0,0,0,0,0},
                           {0,0,0,0,0,0,0,0},
                           {-7,-7,-7,-7,-7,-7,-7,-7},
                           {-1,-3,-2,-4,-5,-2,-3,-1}};
 
    
    public static int flag=0;   //0 if white's turn else 1
    
    //this is used as a reference to move the piece desired
    public static ImageView Selected=new ImageView();
    
    //the coord and identification int of the selected
    public static int sx,sy,pres;
    
    public static int decider=0;//once placed in a box selected still holds that piece so decider will help to place it once
    
    //contains all the possible moves
    public static ArrayList<Integer> pbmove=new ArrayList<>();
    
    //check status of king
    public static boolean whiteInCheck=false;
    public static boolean blackInCheck=false;
    
    //whereabouts of the kings
    public static int currentPositionWhite_I=7;
    public static int currentPositionWhite_J=4;
    public static int currentPositionBlack_I=0;
    public static int currentPositionBlack_J=4;
    
    // if eligible then save the coordinates for en peasant move
    public static int blackEnpI=-9;
    public static int blackEnpJ=-9;
    public static int whiteEnpI=-9;
    public static int whiteEnpJ=-9;
    
    public static int blackEnpPossI;
    public static int blackEnpPossJ;
    public static int whiteEnpPossI;
    public static int whiteEnpPossJ;
    
    //castling
    //black booleans
    public static boolean blackKingMovedOnce=false;
    public static boolean blackLeftRookMovedOnce=false;
    public static boolean blackRightRookMovedOnce=false;
    
    //black coords
    public static int blackKingMovedOnceI=0;
    public static int blackKingMovedOnceJ=4;
    public static int blackLeftRookMovedOnceI=0;
    public static int blackLeftRookMovedOnceJ=0;
    public static int blackRightRookMovedOnceI=0;
    public static int blackRightRookMovedOnceJ=7;
    
    /*public static int blackLeftRookMovedOnceI=0;
    public static int blackLeftRookMovedOnceJ=0;
    public static int blackRightRookMovedOnceI=0;
    public static int blackRightRookMovedOnceJ=7;*/
    
    //white booleans 
    public static boolean whiteKingMovedOnce=false;
    public static boolean whiteLeftRookMovedOnce=false;
    public static boolean whiteRightRookMovedOnce=false;
    
    //white coords
    public static int whiteKingMovedOnceI=7;
    public static int whiteKingMovedOnceJ=4;
    public static int whiteLeftRookMovedOnceI=7;
    public static int whiteLeftRookMovedOnceJ=0;
    public static int whiteRightRookMovedOnceI=7;
    public static int whiteRightRookMovedOnceJ=7;
    
    
    public static void main(String[] args)
    {
        
    }
}
