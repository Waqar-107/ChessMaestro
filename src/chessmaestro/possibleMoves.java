package chessmaestro;

import java.util.*;

public class possibleMoves {

    public static ArrayList<Integer> moves = new ArrayList<Integer>();

    //---------------------------------------------------------------------------------------------
    public static ArrayList<Integer> knight(int i, int j)
    {
        int a = i;
        int b = j;
        
        //total 8 types of move possible
        int[] m = {a + 2, b + 1, a + 2, b - 1, a - 2, b + 1, a - 2, b - 1, a + 1, b + 2, a + 1, b - 2, a - 1, b + 2, a - 1, b - 2};

        //----------------------------------------------------------------start of if
        //white's turn to move
        if (Main_chess.flag == 0)
        {
            for(int k =0;k<16;k += 2)
            {
                if (m[k]<8 && m[k]>=0 && m[k+1]<8 && m[k+1]>=0 && Main_chess.board[m[k]][m[k + 1]] != 5 && Main_chess.board[m[k]][m[k + 1]] >= 0 && moveIfKingSafe.kingIsSafe(i, j, m[k], m[k+1], -3)==true)
                {
                    moves.add(m[k]);
                    moves.add(m[k + 1]);
                }
            }
        } //----------------------------------------------------------------end of if
        //----------------------------------------------------------------start of else
        //black's turn to move
        else {
            for (int k = 0; k < 16; k += 2)
            {
                if (m[k]<8 && m[k]>=0 && m[k+1]<8 && m[k+1]>=0 && Main_chess.board[m[k]][m[k + 1]] !=-5 && Main_chess.board[m[k]][m[k + 1]] <= 0 && moveIfKingSafe.kingIsSafe(i, j, m[k], m[k+1], 3)==true)
                {
                    moves.add(m[k]);
                    moves.add(m[k + 1]);
                }
            }
        }
        //----------------------------------------------------------------end of else
        return moves;
    }
    //---------------------------------------------------------------------------------------------

    
    
    //---------------------------------------------------------------------------------------------
    public static ArrayList<Integer> rook(int i, int j)
    {
        int a = i;
        int b = j;
        
        //black
        if (Main_chess.flag == 1)
        {
            //upwards
            a=i;a--;
            b=j;
            while (a>=0 && b>=0 && a < 8 && b < 8 && Main_chess.board[a][b] <= 0 && Main_chess.board[a][b]!=-5)
            {
                if(Main_chess.board[a][b]<0 && moveIfKingSafe.kingIsSafe(i, j,a,b,2)==true)
                {
                    moves.add(a);
                    moves.add(b);
                    break;
                }
                
                if(Main_chess.board[a][b]>0)
                    break;
                
                if(moveIfKingSafe.kingIsSafe(i, j,a,b,2)==true)
                {
                    moves.add(a);
                    moves.add(b);
                }
                
                a--;
            }

            //downwards
            a = i;a++;
            b = j;
            while (a>=0 && b<8 && a < 8 && b >= 0 && Main_chess.board[a][b] <= 0 && Main_chess.board[a][b]!=-5)
            {
                 if(Main_chess.board[a][b]<0 && moveIfKingSafe.kingIsSafe(i, j,a,b,2)==true)
                {
                    moves.add(a);
                    moves.add(b);
                    break;
                }
                
                if(Main_chess.board[a][b]>0)
                    break;
                
                if(moveIfKingSafe.kingIsSafe(i, j,a,b,2)==true)
                {
                    moves.add(a);
                    moves.add(b);
                }
                
                a++;
            }

            //leftwards
            a = i;
            b = j;b--;
            while (a>=0 && b<8 && a < 8 && b >= 0 && Main_chess.board[a][b] <= 0 && Main_chess.board[a][b]!=-5)
            {
                 if(Main_chess.board[a][b]<0 && moveIfKingSafe.kingIsSafe(i, j,a,b,2)==true)
                {
                    moves.add(a);
                    moves.add(b);
                    break;
                }
                
                if(Main_chess.board[a][b]>0)
                    break;
                
                if(moveIfKingSafe.kingIsSafe(i, j,a,b,2)==true)
                {
                    moves.add(a);
                    moves.add(b);
                }
                
                b--;
            }

            //rightwards
            a = i;
            b = j;b++;
            while (a>=0 && b<8 && a < 8 && b >= 0 && Main_chess.board[a][b] <= 0 && Main_chess.board[a][b]!=-5)
            {
                 if(Main_chess.board[a][b]<0 && moveIfKingSafe.kingIsSafe(i, j,a,b,2)==true)
                {
                    moves.add(a);
                    moves.add(b);
                    break;
                }
                
                if(Main_chess.board[a][b]>0)
                    break;
                
                if(moveIfKingSafe.kingIsSafe(i, j,a,b,2)==true)
                {
                    moves.add(a);
                    moves.add(b);
                }
               
                b++;
            }
            
        } 
        
        //white's turn
        else
        {
            //upwards
            a=i;a--;
            b=j;
            while (a>=0 && b<8 && a < 8 && b >= 0 && Main_chess.board[a][b] >= 0 && Main_chess.board[a][b]!=5)
            {
                if(Main_chess.board[a][b]>0 && moveIfKingSafe.kingIsSafe(i, j,a,b,-2)==true)
                {
                    moves.add(a);
                    moves.add(b);
                    break;
                }
                
                if(Main_chess.board[a][b]<0)
                    break;
                
                if(moveIfKingSafe.kingIsSafe(i, j,a,b,-2)==true)
                {
                    moves.add(a);
                    moves.add(b);
                }
                
                a--;
            }

            //downwards
            a = i;a++;
            b = j;
            while (a>=0 && b<8 && a < 8 && b >= 0 && Main_chess.board[a][b] >= 0 && Main_chess.board[a][b]!=5)
            {
                 if(Main_chess.board[a][b]>0 && moveIfKingSafe.kingIsSafe(i, j,a,b,-2)==true)
                {
                    moves.add(a);
                    moves.add(b);
                    break;
                }
                
                if(Main_chess.board[a][b]<0)
                    break;
                
                if(moveIfKingSafe.kingIsSafe(i, j,a,b,-2)==true)
                {
                    moves.add(a);
                    moves.add(b);
                }
                
                a++;
            }

            //leftwards
            a = i;
            b = j;b--;
            while (a>=0 && b<8 && a < 8 && b >= 0 && Main_chess.board[a][b] >= 0 && Main_chess.board[a][b]!=5)
            {
                 if(Main_chess.board[a][b]>0 && moveIfKingSafe.kingIsSafe(i, j,a,b,-2)==true)
                {
                    moves.add(a);
                    moves.add(b);
                    break;
                }
                
                if(Main_chess.board[a][b]<0)
                    break;
                
                if(moveIfKingSafe.kingIsSafe(i, j,a,b,-2)==true)
                {
                    moves.add(a);
                    moves.add(b);
                }
                
                b--;
            }

            //rightwards
            a = i;
            b = j;b++;
            while (a>=0 && b<8 && a < 8 && b >= 0 && Main_chess.board[a][b] >= 0 && Main_chess.board[a][b]!=5)
            {
                 if(Main_chess.board[a][b]>0 && moveIfKingSafe.kingIsSafe(i, j,a,b,-2)==true)
                {
                    moves.add(a);
                    moves.add(b);
                    break;
                }
                
                if(Main_chess.board[a][b]<0)
                    break;
                
                if(moveIfKingSafe.kingIsSafe(i, j,a,b,-2)==true)
                {
                    moves.add(a);
                    moves.add(b);
                }
               
                b++;
            }
        }

        return moves;
    }
    //----------------------------------------------------------------------------------------------------

    public static ArrayList<Integer> bishop(int i, int j)
    {
        int a;
        int b;
        
        //black's turn
        if (Main_chess.flag == 1)
        {
            //right-down
            a=i;a++;
            b=j;b++;
            while (a < 8 && b < 8 && Main_chess.board[a][b] <= 0 && Main_chess.board[a][b]!=-5)
            {
                if(Main_chess.board[a][b]<0 && moveIfKingSafe.kingIsSafe(i, j,a,b,2)==true)
                {
                    moves.add(a);
                    moves.add(b);
                    break;
                }
                
                if(Main_chess.board[a][b]>0)
                    break;
                
                if(moveIfKingSafe.kingIsSafe(i, j,a,b,2)==true)
                {
                    moves.add(a);
                    moves.add(b);
                }
                
                a++;
                b++;
            }

            //left-down
            a = i;
            b = j;
            a++;
            b--;
            while (a < 8 && b >= 0 && Main_chess.board[a][b] <= 0 && Main_chess.board[a][b]!=-5)
            {
                 if(Main_chess.board[a][b]<0 && moveIfKingSafe.kingIsSafe(i, j,a,b,2)==true)
                {
                    moves.add(a);
                    moves.add(b);
                    break;
                }
                
                if(Main_chess.board[a][b]>0)
                    break;
                
                if(moveIfKingSafe.kingIsSafe(i, j,a,b,2)==true)
                {
                    moves.add(a);
                    moves.add(b);
                }
                
                a++;
                b--;
            }

            //left-up
            a = i;
            b = j;
            a--;
            b--;
            while (a >= 0 && b >= 0 && Main_chess.board[a][b] <= 0 && Main_chess.board[a][b]!=-5)
            {
                 if(Main_chess.board[a][b]<0 && moveIfKingSafe.kingIsSafe(i, j,a,b,2)==true)
                {
                    moves.add(a);
                    moves.add(b);
                    break;
                }
                
                if(Main_chess.board[a][b]>0)
                    break;
                
                if(moveIfKingSafe.kingIsSafe(i, j,a,b,2)==true)
                {
                    moves.add(a);
                    moves.add(b);
                }
                
                a--;
                b--;
            }

            //right-up
            a = i;
            b = j;
            a--;
            b++;
            while (a >= 0 && b < 8 && Main_chess.board[a][b] <= 0 && Main_chess.board[a][b]!=-5)
            {
                 if(Main_chess.board[a][b]<0 && moveIfKingSafe.kingIsSafe(i, j,a,b,2)==true)
                {
                    moves.add(a);
                    moves.add(b);
                    break;
                }
                
                if(Main_chess.board[a][b]>0)
                    break;
                
                if(moveIfKingSafe.kingIsSafe(i, j,a,b,2)==true)
                {
                    moves.add(a);
                    moves.add(b);
                }
                
                a--;
                b++;
            }
        } //white's turn
        else {
            a = i;
            b = j;

            //right-down
            a++;
            b++;
            while (a < 8 && b < 8 && Main_chess.board[a][b] >= 0 && Main_chess.board[a][b]!=5)
            {
                 if(Main_chess.board[a][b]>0 && moveIfKingSafe.kingIsSafe(i, j,a,b,-2)==true)
                {
                    moves.add(a);
                    moves.add(b);
                    break;
                }
                
                if(Main_chess.board[a][b]<0)
                    break;
                
                if(moveIfKingSafe.kingIsSafe(i, j,a,b,-2)==true)
                {
                    moves.add(a);
                    moves.add(b);
                }
                
                a++;
                b++;
            }

            //left-down
            a = i;
            b = j;
            a++;
            b--;
            while (a < 8 && b >= 0 && Main_chess.board[a][b] >= 0 && Main_chess.board[a][b]!=5)
            {
                 if(Main_chess.board[a][b]>0 && moveIfKingSafe.kingIsSafe(i, j,a,b,-2)==true)
                {
                    moves.add(a);
                    moves.add(b);
                    break;
                }
                
                if(Main_chess.board[a][b]<0)
                    break;
                
                if(moveIfKingSafe.kingIsSafe(i, j,a,b,-2)==true)
                {
                    moves.add(a);
                    moves.add(b);
                }
                
                a++;
                b--;
            }

            //left-up
            a = i;
            b = j;
            a--;
            b--;
            while (a >= 0 && b >= 0 && Main_chess.board[a][b] >= 0 && Main_chess.board[a][b]!=5)
            {
                 if(Main_chess.board[a][b]>0 && moveIfKingSafe.kingIsSafe(i, j,a,b,-2)==true)
                {
                    moves.add(a);
                    moves.add(b);
                    break;
                }
                
                if(Main_chess.board[a][b]<0)
                    break;
                
                if(moveIfKingSafe.kingIsSafe(i, j,a,b,-2)==true)
                {
                    moves.add(a);
                    moves.add(b);
                }
                
                a--;
                b--;
            }

            //right-up
            a = i;
            b = j;
            a--;
            b++;
            while (a >= 0 && b < 8 && Main_chess.board[a][b] >= 0 && Main_chess.board[a][b]!=5)
            {       
                 if(Main_chess.board[a][b]>0 && moveIfKingSafe.kingIsSafe(i, j,a,b,-2)==true)
                {
                    moves.add(a);
                    moves.add(b);
                    break;
                }
                
                if(Main_chess.board[a][b]<0)
                    break;
                
                if(moveIfKingSafe.kingIsSafe(i, j,a,b,-2)==true)
                {
                    moves.add(a);
                    moves.add(b);
                }
                
                a--;
                b++;
            }
        }
       
        return moves;
    }
    //----------------------------------------------------------------------------------------------------

    
    
    //---------------------------------------------------------------------------------------------
    public static ArrayList<Integer> pawn(int i, int j)
    {
        int a = i;
        int b = j;
              
        //black
        if (Main_chess.flag == 1)
        {
            //move forward-1 cell
            if (a+1>=0 && a + 1 < 8 && Main_chess.board[a + 1][b] == 0 && moveIfKingSafe.kingIsSafe(i, j,a+1,b,7)==true)
            {
                moves.add(a + 1);
                moves.add(b);
            }

            //move forward-2 cells
            if (a == 1 && Main_chess.board[a+1][b] == 0 && Main_chess.board[a+2][b] == 0 && moveIfKingSafe.kingIsSafe(i, j,a+2,b,7)==true)
            {
                moves.add(a + 2);
                moves.add(b);
            }

            //capture-right
            if (a+1>=0 && b+1>=0 && a + 1 < 8 && b + 1 < 8 && Main_chess.board[a+1][b+1]!=-5 && Main_chess.board[a + 1][b + 1] < 0 && moveIfKingSafe.kingIsSafe(i, j,a+1,b+1,7)==true)
            {
                moves.add(a + 1);
                moves.add(b + 1);
            }

            //capture-left
            if (a+1>=0 && b-1<8 && a + 1 < 8 && b - 1 >= 0 && Main_chess.board[a+1][b-1]!=-5 && Main_chess.board[a + 1][b - 1] < 0 && moveIfKingSafe.kingIsSafe(i, j,a+1,b-1,7)==true)
            {
                moves.add(a + 1);
                moves.add(b - 1);
            }
            
            //en peasant
            if (i==Main_chess.whiteEnpI && (Main_chess.whiteEnpJ+1==j || Main_chess.whiteEnpJ-1==j) && (Main_chess.whiteEnpI+1)>=0 && (Main_chess.whiteEnpI+1)<8 && Main_chess.whiteEnpJ>=0 && Main_chess.whiteEnpJ<8 && moveIfKingSafe.kingIsSafe(i, j,Main_chess.whiteEnpI+1,Main_chess.whiteEnpJ,7)==true && Main_chess.whiteEnpI!=-9 && Main_chess.whiteEnpJ!=-9 && moveIfKingSafe.kingIsSafe(i, j,Main_chess.whiteEnpI+1,Main_chess.whiteEnpJ,-7))
            {
                moves.add(Main_chess.whiteEnpI+1);
                moves.add(Main_chess.whiteEnpJ);
                Main_chess.blackEnpPossI=Main_chess.whiteEnpI+1;
                Main_chess.blackEnpPossJ=Main_chess.whiteEnpJ;
            }
        }
        //white
        else
        {
            //move forward-2 cells
            if (a == 6 && Main_chess.board[a - 1][b]== 0 && Main_chess.board[a - 2][b]== 0 && moveIfKingSafe.kingIsSafe(i, j,a-2,b,-7)==true)
            {
                moves.add(a - 2);
                moves.add(b);
            }
            
            //move forward-1 cell
            if (a-1<8 && a - 1 >= 0 && Main_chess.board[a - 1][b] == 0 && moveIfKingSafe.kingIsSafe(i, j,a-1,b,-7)==true)
            {
                moves.add(a - 1);
                moves.add(b);
            }

            //capture-right
            if (a-1<8 && b+1>=0 && a - 1 >= 0 && b + 1 < 8 && Main_chess.board[a-1][b+1]!=5 && Main_chess.board[a - 1][b + 1] > 0 && Main_chess.board[a-1][b+1]!=-5 && moveIfKingSafe.kingIsSafe(i, j,a-1,b+1,-7)==true)
            {
                moves.add(a - 1);
                moves.add(b + 1);
            }

            //capture-left
            if (a-1<8 && b-1<8 && a - 1 >= 0 && b - 1 >= 0 && Main_chess.board[a-1][b-1]!=5 && Main_chess.board[a - 1][b - 1] > 0 && Main_chess.board[a-1][b-1]!=-5 && moveIfKingSafe.kingIsSafe(i, j,a-1,b-1,-7)==true)
            {
                moves.add(a - 1);
                moves.add(b - 1);
            }

            //en peasant
            if (i==Main_chess.blackEnpI && (Main_chess.blackEnpJ+1==j || Main_chess.blackEnpJ-1==j) && (Main_chess.blackEnpI-1)>=0 && (Main_chess.blackEnpI-1)<8 && Main_chess.blackEnpJ>=0 && Main_chess.blackEnpJ<8 && moveIfKingSafe.kingIsSafe(i, j,Main_chess.blackEnpI-1,Main_chess.blackEnpJ,-7)==true && Main_chess.blackEnpI!=-9 && Main_chess.blackEnpJ!=-9 && moveIfKingSafe.kingIsSafe(i, j,Main_chess.blackEnpI+1,Main_chess.blackEnpJ,7))
            {
                moves.add(Main_chess.blackEnpI-1);
                moves.add(Main_chess.blackEnpJ);
                Main_chess.whiteEnpPossI=Main_chess.blackEnpI-1;
                Main_chess.whiteEnpPossJ=Main_chess.blackEnpJ;
            }
        }

        return moves;
    }

    public static ArrayList<Integer> queen(int i, int j) {
        //(rook U bishop=queen)
        int a = i;
        int b = j;
        
        rook(a, b);
        bishop(a, b);
        
        return moves;
    }

    public static ArrayList<Integer> king(int i, int j)
    {
        int a = i;
        int b = j;    
    
        //[(i+1,j) and (i-1,j)], [(i,j+1) and (i,j-1)], [(i+1,j-1) and (i-1,j+1)], [(i+1,j+1) and (i-1,j-1)] 
        int[] m={a+1,b,a-1,b,a,b+1,a,b-1,a+1,b-1,a-1,b+1,a+1,b+1,a-1,b-1};
        
        //white
        if(Main_chess.flag==0)
        {
            for(int k=0;k<16;k+=2)
            {
                if (m[k] < 8 && m[k] >= 0 && m[k + 1] >= 0 && m[k + 1] < 8 && Main_chess.board[m[k]][m[k + 1]] >= 0  && moveKingSafely.kingCanMove(m[k], m[k + 1]) == true && check.danger(m[k], m[k+1],Main_chess.board)==false)
                {
                    //these are the area of black king so white king can't get in here
                    updateKingPosition.blackKingFinder();
                    int x = Main_chess.currentPositionBlack_I;
                    int y = Main_chess.currentPositionBlack_J;System.out.println("kalo::: "+x+" "+y);
                    int[] forbiddenForKing = {x, y, x - 1, y, x - 1, y - 1, x - 1, y + 1, x + 1, y, x + 1, y + 1, x + 1, y - 1, x, y + 1, x, y - 1};
                    boolean ok = true;
                    for (int l = 0; l < 18; l += 2) {
                        if (forbiddenForKing[l] == m[k] && forbiddenForKing[l + 1] == m[k + 1]) {
                            ok = false;
                            break;
                        }
                    }

                    if (ok == true) {System.out.println("ok "+ok);
                        moves.add(m[k]);
                        moves.add(m[k + 1]);
                    }
                }
            } 
            
            //castling-white   
            if(Main_chess.whiteKingMovedOnce==false && Main_chess.whiteLeftRookMovedOnce==false)
            {
                //left rook- king
                if(Main_chess.board[7][3]==0 && Main_chess.board[7][1]==0 && Main_chess.board[7][2]==0 && moveIfKingSafe.kingIsSafe(i, j,i, j-2,-5))
                {
                    moves.add(i);
                    moves.add(j-2);           
                }
                
                //right-rook-king
                if(Main_chess.board[7][6]==0 && Main_chess.board[7][5]==0 && moveIfKingSafe.kingIsSafe(i, j,i, j+2,-5))
                {
                    moves.add(i);
                    moves.add(j+2);
                }
            }          
        }
        
        //black
        else
        {
           for(int k=0;k<16;k+=2)
            {
                if (m[k] < 8 && m[k] >= 0 && m[k + 1] >= 0 && m[k + 1] < 8 && Main_chess.board[m[k]][m[k + 1]] <= 0 &&  moveKingSafely.kingCanMove(m[k], m[k + 1]) == true && check.danger(m[k],m[k+1],Main_chess.board)==false)
                {
                    //these are the area of th ewhite king so forbidden for the black to go
                    updateKingPosition.whiteKingFinder();
                    int x = Main_chess.currentPositionWhite_I;
                    int y = Main_chess.currentPositionWhite_J;System.out.println("sada::: "+x+" "+y);
                    int[] forbiddenForKing = {x, y, x - 1, y, x - 1, y - 1, x - 1, y + 1, x + 1, y, x + 1, y + 1, x + 1, y - 1, x, y + 1, x, y - 1};
                    boolean ok = true;
                    for (int l = 0; l < 18; l += 2) {
                        if (forbiddenForKing[l] == m[k] && forbiddenForKing[l + 1] == m[k + 1]) {
                            ok = false;
                            break;
                        }
                    }

                    if (ok == true) {
                        moves.add(m[k]);
                        moves.add(m[k + 1]);
                    }
                }
        }
           
             //castling-black   
            if(Main_chess.blackKingMovedOnce==false && Main_chess.blackLeftRookMovedOnce==false)
            {
                //left rook- king
                if(Main_chess.board[0][1]==0 && Main_chess.board[0][2]==0 && Main_chess.board[0][3]==0 && moveIfKingSafe.kingIsSafe(i, j,i, j-2,5))
                {
                    moves.add(i);
                    moves.add(j-2);           
                }
                
                //right-rook-king
                if(Main_chess.board[0][6]==0 && Main_chess.board[0][5]==0 && moveIfKingSafe.kingIsSafe(i, j,i, j+2,5))
                {
                    moves.add(i);
                    moves.add(j+2);
                }
            }         
     }
        return moves;
    }
}
