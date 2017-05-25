/***********************ChessMaestro***********************
*****************@author:Waqar Hassan Khan *****************
*************************1505107***************************
*********************Dept. of CSE, BUET*********************/

package chessmaestro;

import java.io.*;
import java.util.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ChessMaestro extends Application 
{
    int click=0;
    ArrayList<Integer> temp=new ArrayList<Integer>();
    
    @Override
    public void start(Stage primaryStage)
    {
        Image openingScreen=new Image("/opening.jpg");
        ImageView opscr=new ImageView(openingScreen);
        
        Text name=new Text(110,100,"ChessMaestro");
        name.setFill(Color.AZURE.brighter());
        name.setFont(Font.font(50));
        
        Text prompt=new Text(160,200,"Click to Play!!!");
        prompt.setFill(Color.AZURE.brighter());
        prompt.setFont(Font.font(30));
        
        Pane root0=new Pane();
        root0.getChildren().add(opscr);
        root0.getChildren().add(name);
        root0.getChildren().add(prompt);
        
        opscr.setOnMouseClicked(e->
        {
            mainGameplay(primaryStage);
        });
        
        Scene s=new Scene(root0, 500, 500);
        primaryStage.setScene(s);
        primaryStage.setTitle("ChessMaestro");
        primaryStage.show();
        
    }
    
        
    public void mainGameplay(Stage primaryStage)
    {
        int dx_piece = 55;
        int dy_piece = 55;
        int i,j;
        


        //------------------------------------------------------------------------------------------------
        //----------------------------------------------------------------start of declaration of images
        //-------------------board
        Image chessBg = new Image("/chess_bg.png", 500, 500, true, true, true);     

        //BLACK
        Image b_rook = new Image("/Rook-B55.png", dx_piece, dy_piece, true, true, true);
        Image b_bishop = new Image("/Bishop-B55.png", dx_piece, dy_piece, true, true, true);
        Image b_knight = new Image("/Knight-B55.png", dx_piece, dy_piece, true, true, true);
        Image b_king = new Image("/King-B55.png", dx_piece, dy_piece, true, true, true);
        Image b_queen = new Image("/Queen-B55.png", dx_piece, dy_piece, true, true, true);
        Image b_pawn = new Image("/Pawn-B55.png", dx_piece, dy_piece, true, true, true);

        //WHITE
        Image w_rook = new Image("/Rook-W55.png", dx_piece, dy_piece, true, true, true);
        Image w_bishop = new Image("/Bishop-W55.png", dx_piece, dy_piece, true, true, true);
        Image w_knight = new Image("/Knight-W55.png", dx_piece, dy_piece, true, true, true);
        Image w_king = new Image("/King-W55.png", dx_piece, dy_piece, true, true, true);
        Image w_queen = new Image("/Queen-W55.png", dx_piece, dy_piece, true, true, true);
        Image w_pawn = new Image("/Pawn-W55.png", dx_piece, dy_piece, true, true, true);
        //----------------------------------------------------------------end of declaration of images
        //------------------------------------------------------------------------------------------------

        
        
        //------------------------------------------------------------------------------------------------
        //----------------------------------------------------------------start of declaration of imageViews and the rectangular board
        Pane root = new Pane();
        int pdx = 55; int pdy = 55;
        int stx = 30;int sty = 30;
        
        
        Text str=new Text("white's turn to move");
        str.setLayoutX(150);
        str.setLayoutY(15);
        str.setFont(Font.font(15));
        str.setFill(Color.AZURE);
        
        Text isitCheck=new Text("none is in check");
        isitCheck.setLayoutX(350);
        isitCheck.setLayoutY(15);
        isitCheck.setFont(Font.font(15));
        isitCheck.setFill(Color.AZURE);
       
        

        //----------------------------------------------------------------------------------------
        ImageView bg = new ImageView();
        bg.setImage(chessBg);
        //---------------------------------------board started
        //8*8  grids for the board  
        Rectangle[][] rr = new Rectangle[8][8];
        for (i = 0; i < 8; i++)
        {
            for (j = 0; j < 8; j++)
            {
                rr[i][j] = new Rectangle(stx + pdx * j, sty + pdy * i, pdx, pdy);

                if ((j + 1) % 2 != 0)
                {
                    rr[i][j].setFill(Color.rgb(239, 228, 176));
                } 
                
                else
                {
                    rr[i][j].setFill(Color.rgb(15, 117, 30));
                }
            }

            i++;
            for (j = 0; j < 8; j++)
            {
                rr[i][j] = new Rectangle(stx + pdx * j, sty + pdy * i, pdx, pdy);
               
                if ((j + 1) % 2 != 0)
                {
                    rr[i][j].setFill(Color.rgb(15, 117, 30));
                }
                
                else
                {
                    rr[i][j].setFill(Color.rgb(239, 228, 176));
                }
            }
        }
        
        //this will handle the movement of pieces
        Rectangle[][] uplayer=new Rectangle[8][8];
        for(i=0;i<8;i++)
        {
            for(j=0;j<8;j++)
            {
                uplayer[i][j]=new  Rectangle(stx + pdx * j, sty + pdy * i, pdx, pdy);
                uplayer[i][j].setFill(Color.rgb(180,14,22));
                uplayer[i][j].setOpacity(0);
            }   
        }    
        //----------------------------------------board finished

        
        
        //----------------------------------------imageView of pieces starts.
        //----------------------------------------black starts
        ImageView lb_rook = new ImageView(b_rook);
        lb_rook.setLayoutX(stx + pdx * 0);
        lb_rook.setLayoutY(sty + pdy * 0);

        ImageView lb_bishop = new ImageView(b_bishop);
        lb_bishop.setLayoutX(stx + pdx * 2);
        lb_bishop.setLayoutY(sty + pdy * 0);

        ImageView lb_knight = new ImageView(b_knight);
        lb_knight.setLayoutX(stx + pdx * 1);
        lb_knight.setLayoutY(sty + pdy * 0);

        ImageView lbr_queen = new ImageView(b_queen);
        lbr_queen.setLayoutX(stx + pdx * 3);
        lbr_queen.setLayoutY(sty + pdy * 0);

        ImageView lbr_king = new ImageView(b_king);
        lbr_king.setLayoutX(stx + pdx * 4);
        lbr_king.setLayoutY(sty + pdy * 0);

        ImageView rb_rook = new ImageView(b_rook);
        rb_rook.setLayoutX(stx + pdx * 7);
        rb_rook.setLayoutY(sty + pdy * 0);

        ImageView rb_bishop = new ImageView(b_bishop);
        rb_bishop.setLayoutX(stx + pdx * 5);
        rb_bishop.setLayoutY(sty + pdy * 0);

        ImageView rb_knight = new ImageView(b_knight);
        rb_knight.setLayoutX(stx + pdx * 6);
        rb_knight.setLayoutY(sty + pdy * 0);

        ImageView b1_pawn = new ImageView(b_pawn);
        b1_pawn.setLayoutX(stx + pdx * 0);
        b1_pawn.setLayoutY(sty + pdy * 1);

        ImageView b2_pawn = new ImageView(b_pawn);
        b2_pawn.setLayoutX(stx + pdx * 1);
        b2_pawn.setLayoutY(sty + pdy * 1);

        ImageView b3_pawn = new ImageView(b_pawn);
        b3_pawn.setLayoutX(stx + pdx * 2);
        b3_pawn.setLayoutY(sty + pdy * 1);

        ImageView b4_pawn = new ImageView(b_pawn);
        b4_pawn.setLayoutX(stx + pdx * 3);
        b4_pawn.setLayoutY(sty + pdy * 1);

        ImageView b5_pawn = new ImageView(b_pawn);
        b5_pawn.setLayoutX(stx + pdx * 4);
        b5_pawn.setLayoutY(sty + pdy * 1);

        ImageView b6_pawn = new ImageView(b_pawn);
        b6_pawn.setLayoutX(stx + pdx * 5);
        b6_pawn.setLayoutY(sty + pdy * 1);

        ImageView b7_pawn = new ImageView(b_pawn);
        b7_pawn.setLayoutX(stx + pdx * 6);
        b7_pawn.setLayoutY(sty + pdy * 1);

        ImageView b8_pawn = new ImageView(b_pawn);
        b8_pawn.setLayoutX(stx + pdx * 7);
        b8_pawn.setLayoutY(sty + pdy * 1);
        //----------------------------------------black ends

        //----------------------------------------white starts
        ImageView lw_rook = new ImageView(w_rook);
        lw_rook.setLayoutX(stx + pdx * 0);
        lw_rook.setLayoutY(sty + pdy * 7);

        ImageView lw_bishop = new ImageView(w_bishop);
        lw_bishop.setLayoutX(stx + pdx * 2);
        lw_bishop.setLayoutY(sty + pdy * 7);

        ImageView lw_knight = new ImageView(w_knight);
        lw_knight.setLayoutX(stx + pdx * 1);
        lw_knight.setLayoutY(sty + pdy * 7);

        ImageView lwr_queen = new ImageView(w_queen);
        lwr_queen.setLayoutX(stx + pdx * 3);
        lwr_queen.setLayoutY(sty + pdy * 7);

        ImageView lwr_king = new ImageView(w_king);
        lwr_king.setLayoutX(stx + pdx * 4);
        lwr_king.setLayoutY(sty + pdy * 7);

        ImageView rw_rook = new ImageView(w_rook);
        rw_rook.setLayoutX(stx + pdx * 7);
        rw_rook.setLayoutY(sty + pdy * 7);

        ImageView rw_bishop = new ImageView(w_bishop);
        rw_bishop.setLayoutX(stx + pdx * 5);
        rw_bishop.setLayoutY(sty + pdy * 7);

        ImageView rw_knight = new ImageView(w_knight);
        rw_knight.setLayoutX(stx + pdx * 6);
        rw_knight.setLayoutY(sty + pdy * 7);

        ImageView w1_pawn = new ImageView(w_pawn);
        w1_pawn.setLayoutX(stx + pdx * 0);
        w1_pawn.setLayoutY(sty + pdy * 6);

        ImageView w2_pawn = new ImageView(w_pawn);
        w2_pawn.setLayoutX(stx + pdx * 1);
        w2_pawn.setLayoutY(sty + pdy * 6);

        ImageView w3_pawn = new ImageView(w_pawn);
        w3_pawn.setLayoutX(stx + pdx * 2);
        w3_pawn.setLayoutY(sty + pdy * 6);

        ImageView w4_pawn = new ImageView(w_pawn);
        w4_pawn.setLayoutX(stx + pdx * 3);
        w4_pawn.setLayoutY(sty + pdy * 6);

        ImageView w5_pawn = new ImageView(w_pawn);
        w5_pawn.setLayoutX(stx + pdx * 4);
        w5_pawn.setLayoutY(sty + pdy * 6);

        ImageView w6_pawn = new ImageView(w_pawn);
        w6_pawn.setLayoutX(stx + pdx * 5);
        w6_pawn.setLayoutY(sty + pdy * 6);

        ImageView w7_pawn = new ImageView(w_pawn);
        w7_pawn.setLayoutX(stx + pdx * 6);
        w7_pawn.setLayoutY(sty + pdy * 6);

        ImageView w8_pawn = new ImageView(w_pawn);
        w8_pawn.setLayoutX(stx + pdx * 7);
        w8_pawn.setLayoutY(sty + pdy * 6);
        //----------------------------------------white ends     

        ImageView[] black = {b1_pawn, b2_pawn, b3_pawn, b4_pawn, b5_pawn, b6_pawn, b7_pawn, b8_pawn,
            lb_rook,lb_knight, lb_bishop,lbr_queen, lbr_king, rb_bishop, rb_knight,rb_rook};

        ImageView[] white = {w1_pawn, w2_pawn, w3_pawn, w4_pawn, w5_pawn, w6_pawn, w7_pawn, w8_pawn,
            lw_rook,lw_knight,lw_bishop,lwr_queen, lwr_king,rw_bishop, rw_knight, rw_rook};
        
        int[] whitePosition={6,0,6,1,6,2,6,3,6,4,6,5,6,6,6,7,7,0,7,1,7,2,7,3,7,4,7,5,7,6,7,7};
        int[] blackPosition={1,0,1,1,1,2,1,3,1,4,1,5,1,6,1,7,0,0,0,1,0,2,0,3,0,4,0,5,0,6,0,7};
        

        //----------------------------------------imageView of pieces ends.
        //----------------------------------------------------------------------------------------
        
        

        //-----------------------------------------------------------------------------------------
        //----------------------------------------------------------------start of children
        //initial roots->get the children!!!
        //--------------background
        root.getChildren().add(bg);
        root.getChildren().add(str);
        root.getChildren().add(isitCheck);
        //--------------
        //--------------board
        for (i = 0; i < 8; i++) {
            for (j = 0; j < 8; j++) {
                root.getChildren().add(rr[i][j]);
            }
        }
        //--------------
        //--------------pieces
        for (i = 0; i < 16; i++) {
            root.getChildren().add(black[i]);
            root.getChildren().add(white[i]);
        }
        //--------------
        //--------------uplayer
        for (i = 0; i < 8; i++) {
            for (j = 0; j < 8; j++) {
                root.getChildren().add(uplayer[i][j]);
            }
        }
        //--------------
        //----------------------------------------------------------------end of children
        //-----------------------------------------------------------------------------------------

        
        
        //-----------------------------------------------------------------------------------------
        //rectangle controller
        for(i=0;i<8;i++)
        {
            for(j=0;j<8;j++)
            {
                uplayer[i][j].setOnMouseClicked(e->
                {
                    //print the array
                    System.out.println("Array:");
                    for(int x=0;x<8;x++)
                    {
                        for(int y=0;y<8;y++)
                        {
                            System.out.print(Main_chess.board[x][y]+" ");
                        }System.out.println();
                    }
                    
                    int xi=(int) ((e.getY()-stx)/pdx);
                    int yj=(int) ((e.getX()-sty)/pdy);
                    int idx=0;boolean inside=false;
                    
                    for(int l=0;l<temp.size();l+=2)
                    {
                       uplayer[temp.get(l)][temp.get(l+1)].setOpacity(0);
                    }
                    
                    
                    //piece needs to be selected
                    //white
                    if (Main_chess.flag == 0)
                    {
                        if (Main_chess.board[xi][yj] < 0)
                        {
                            temp.clear();
                            temp = showAndMove(xi, yj);
                            Main_chess.pbmove=showAndMove(xi, yj);
                            
                            for (int l = 0; l < temp.size(); l += 2)
                            {
                                uplayer[temp.get(l)][temp.get(l + 1)].setOpacity(0.55);
                                System.out.println(temp.get(l) + "  " + temp.get(l + 1));
                            }
                                
                            Main_chess.sx=xi;
                            Main_chess.sy=yj;
                            Main_chess.pres=Main_chess.board[Main_chess.sx][Main_chess.sy];
                            Main_chess.decider=0;
                            
                            idx=0;
                            for(int w=0;w<32;w+=2)
                              {
                                 if(whitePosition[w]==xi && whitePosition[w+1]==yj)
                                  {
                                       Main_chess.Selected=white[idx];
                                       idx=0;
                                       break;
                                  }                    
                                  idx++;
                              }                
                        }
                        else if(Main_chess.board[xi][yj] >= 0 && Main_chess.decider==0)
                        {                       
                             //capture a black or move
                            //check if the click is valid
                            for(int x=0;x<Main_chess.pbmove.size();x+=2)
                             {
                                 if(xi==Main_chess.pbmove.get(x) && yj==Main_chess.pbmove.get(x+1))
                                 {
                                     inside=true;
                                     break;
                                 }
                             }

                            if(inside)
                            {
                                idx=0;
                                for(int l=0;l<32;l+=2)
                                {
                                    if(blackPosition[l]==xi && blackPosition[l+1]==yj)
                                    {
                                        black[idx].setLayoutX(1000);
                                        black[idx].setLayoutY(1000);
                                        blackPosition[l]=-9;blackPosition[l+1]=-9;
                                        break;
                                    }
                                    idx++;
                                }
                                
                                //update white
                                for(int w=0;w<32;w+=2)
                                {
                                    if(whitePosition[w]==Main_chess.sx && whitePosition[w+1]==Main_chess.sy)
                                    {
                                        whitePosition[w]=xi;
                                        whitePosition[w+1]=yj;
                                        break;
                                    }                    
                                }
                                
                               
                                //move the pieces
                               Main_chess.Selected.setLayoutX(stx+pdx*yj);
                               Main_chess.Selected.setLayoutY(sty+pdy*xi);
                               
                                //en peasant move
                                if(xi==Main_chess.whiteEnpPossI && yj==Main_chess.whiteEnpPossJ)
                                {
                                    idx=0;                
                                    for(int w=0;w<32;w+=2)
                                    {
                                        if(blackPosition[w]==Main_chess.blackEnpI && blackPosition[w+1]==Main_chess.blackEnpJ && Main_chess.blackEnpI!=-9 && Main_chess.blackEnpJ!=-9)
                                        {
                                            blackPosition[w]=-9;
                                            blackPosition[w+1]=-9;
                                            black[idx].setLayoutX(1000);
                                            black[idx].setLayoutY(1000);
                                            Main_chess.board[Main_chess.blackEnpI][Main_chess.blackEnpJ]=0;
                                            break;
                                        }         
                                        idx++;
                                    }
                                   
                                }
                                
                                Main_chess.blackEnpI=-9;Main_chess.blackEnpJ=-9;
                               
                                //promotion of white pawn
                                if(xi==0 && Main_chess.pres==-7)
                                {                   
                                    int Type=promotion.display();
                                    System.out.println("promotion of white "+Type);

                                    Main_chess.pres=Type;
                                    if(Type==-1)
                                        Main_chess.Selected.setImage(w_rook);
                                    else if(Type==-2)
                                        Main_chess.Selected.setImage(w_bishop);
                                    else if(Type==-3)
                                        Main_chess.Selected.setImage(w_knight);
                                    else if(Type==-4)
                                        Main_chess.Selected.setImage(w_queen);
                                }
                                
                                //eligibility for en peasant-white
                                if(Main_chess.pres==-7 && Main_chess.sx==6 && xi==4)
                                {
                                    Main_chess.whiteEnpI=xi;Main_chess.whiteEnpJ=yj;
                                    System.out.println("black enp: "+xi+" "+yj);
                                }
                                 
                                //update array
                                Main_chess.board[Main_chess.sx][Main_chess.sy]=0;
                                Main_chess.board[xi][yj]=Main_chess.pres;
                                
                                //-------------------------------------------------------white-castling
                                //left rook
                                if(yj==2 && Main_chess.sy==4 && Main_chess.pres==-5 && Main_chess.whiteKingMovedOnce==false && Main_chess.whiteLeftRookMovedOnce==false)
                                {
                                    int rook_dstJ=3;
                                    int rook_dstI=7;
                                    
                                    //initially the left white rook is in white[8], coords are in whitePosition[16] and whitePosition[17]
                                    white[8].setLayoutY(stx+pdx*rook_dstI);
                                    white[8].setLayoutX(sty+pdy*rook_dstJ);
                                    whitePosition[16]=rook_dstI;whitePosition[17]=rook_dstJ;
                                    Main_chess.board[7][0]=0;
                                    Main_chess.board[7][3]=-1; 
                                }
                                
                                //right rook
                                if(yj==6 && Main_chess.sy==4 && Main_chess.pres==-5 && Main_chess.whiteKingMovedOnce==false && Main_chess.whiteRightRookMovedOnce==false)
                                {
                                    int rook_dstJ=5;
                                    int rook_dstI=7;
                                    
                                    //initially the left white rook is in white[8], coords are in whitePosition[30] and whitePosition[31]
                                    white[15].setLayoutY(stx+pdx*rook_dstI);
                                    white[15].setLayoutX(sty+pdy*rook_dstJ);
                                    whitePosition[30]=rook_dstI;whitePosition[31]=rook_dstJ;
                                    Main_chess.board[7][7]=0;
                                    Main_chess.board[7][5]=-1;
                                }
                                
                                                                
                                //if any of the foolowings are moved then castling will be no more valid
                                if(Main_chess.board[7][0]!=-1 || Main_chess.board[7][4]!=-5 || Main_chess.board[7][7]!=-1)
                                {
                                    Main_chess.whiteKingMovedOnce=true;
                                    Main_chess.whiteLeftRookMovedOnce=true;
                                    Main_chess.whiteRightRookMovedOnce=true;
                                }
                                //-------------------------------------------------------white-castling
                                
                                
                                //white king safety which is need to change the checkStatus Text
                                updateKingPosition.whiteKingFinder();
                                if(check.danger(Main_chess.currentPositionWhite_I, Main_chess.currentPositionWhite_J,Main_chess.board))
                                    isitCheck.setText("white's in check");
                                else
                                    isitCheck.setText("none is in check");
                          
                                //stalemate and checkmate
                                boolean whiteSt=WhiteStalemate();
                                Main_chess.flag=1;               
                                
                                if(BlackStalemate() || whiteSt)
                                {
                                    System.out.println("Stalemate and check status:"+check.danger(Main_chess.currentPositionBlack_I,Main_chess.currentPositionBlack_J,Main_chess.board));
                                    StaleMateScreen(primaryStage);
                                }
                                
                                updateKingPosition.blackKingFinder();

                                int ki=Main_chess.currentPositionBlack_I;
                                int kj=Main_chess.currentPositionBlack_J;System.out.println("black king: "+ki+" "+kj);
                                if(check.danger(ki, kj,Main_chess.board)==true)
                                {
                                    Main_chess.blackInCheck=true;
                                    isitCheck.setText("black's in check");
                                    System.out.println("Black in check, and have "+CheckMate.blackCheckMate()+" moves");
                                    if(CheckMate.blackCheckMate()==0)
                                    {
                                        System.out.println("BLACK LOSE!!!!");
                                        WhiteWins(primaryStage);
                                    }

                                }

                                else
                                {
                                    System.out.println("black king is safe");
                                    isitCheck.setText("none is in check");
                                    Main_chess.blackInCheck=false;
                                }
                                
                                Main_chess.decider=1;
                                Main_chess.Selected=null;
                                str.setText("black's turn");
                            }       
                        }
                    }
                    
                    
                    //black's turn
                    else if (Main_chess.flag == 1)
                    {
                        //-------------------------------------------
                        //choose a black piece to move
                        if (Main_chess.board[xi][yj] > 0)
                        {
                            temp.clear();
                            temp = showAndMove(xi, yj);
                            Main_chess.pbmove=showAndMove(xi,yj);
                            for (int l = 0; l < temp.size(); l += 2)
                            {
                                uplayer[temp.get(l)][temp.get(l + 1)].setOpacity(0.55);
                            }
                            
                             Main_chess.sx=xi;
                             Main_chess.sy=yj;
                             Main_chess.pres=Main_chess.board[Main_chess.sx][Main_chess.sy];
                             Main_chess.decider=0;
                             
                             for(int w=0;w<32;w+=2)
                              {
                                if(blackPosition[w]==xi && blackPosition[w+1]==yj)
                                 {
                                    Main_chess.Selected=black[idx];
                                     idx=0;
                                     break;
                                  }                    
                                 idx++;
                              }
                        }
                        //-------------------------------------------
                                         
                        //-------------------------------------------
                        //select a cell to move the piece
                        else if(Main_chess.board[xi][yj] <= 0 && Main_chess.decider==0)
                        {
                             //captue a white or move
                            for(int x=0;x<Main_chess.pbmove.size();x+=2)
                             {
                                 if(xi==Main_chess.pbmove.get(x) && yj==Main_chess.pbmove.get(x+1))
                                 {
                                     inside=true;
                                     break;
                                 }
                             }

                            if(inside)
                            {
                                idx=0;
                                for(int l=0;l<32;l+=2)
                                {
                                    if(whitePosition[l]==xi && whitePosition[l+1]==yj)
                                    {
                                        white[idx].setLayoutX(1000);
                                        white[idx].setLayoutY(1000);
                                        whitePosition[l]=-9;whitePosition[l+1]=-9;
                                    }
                                    idx++;
                                }
                                
                                //update black
                                for(int w=0;w<32;w+=2)
                                {
                                    if(blackPosition[w]==Main_chess.sx && blackPosition[w+1]==Main_chess.sy)
                                    {
                                        blackPosition[w]=xi;
                                        blackPosition[w+1]=yj;
                                        break;
                                    }                    
                                }
                                
                                //move piece
                                Main_chess.Selected.setLayoutX(stx+pdx*yj);
                                Main_chess.Selected.setLayoutY(sty+pdy*xi);
                                
                                //-------------------------------------------------------black-castling
                                //left rook
                                if(yj==2 && Main_chess.sy==4 && Main_chess.pres==5 && Main_chess.blackKingMovedOnce==false && Main_chess.blackLeftRookMovedOnce==false )
                                {
                                    int rook_dstJ=3;
                                    int rook_dstI=0;
                                    
                                    //initially the left black rook is in black[8], coords are in blackPosition[16] and blackPosition[17]
                                    black[8].setLayoutY(stx+pdx*rook_dstI);
                                    black[8].setLayoutX(sty+pdy*rook_dstJ);
                                    blackPosition[16]=rook_dstI;blackPosition[17]=rook_dstJ;
                                    Main_chess.board[0][0]=0;
                                    Main_chess.board[0][3]=1; 
                                }
                                
                                //right rook
                                if(yj==6 && Main_chess.sy==4 && Main_chess.pres==5 && Main_chess.blackKingMovedOnce==false && Main_chess.blackRightRookMovedOnce==false)
                                {
                                    int rook_dstJ=5;
                                    int rook_dstI=0;
                                    
                                    //initially the right black rook is in black[15], coords are in blackPosition[30] and blackPosition[31]
                                    black[15].setLayoutY(stx+pdx*rook_dstI);
                                    black[15].setLayoutX(sty+pdy*rook_dstJ);
                                    blackPosition[30]=rook_dstI;blackPosition[31]=rook_dstJ;
                                    Main_chess.board[0][7]=0;
                                    Main_chess.board[0][5]=1;
                                }
                                
                                                                
                                //if any of the foolowings are moved then castling will be no more valid
                                if(Main_chess.board[0][0]!=1 || Main_chess.board[0][4]!=5 || Main_chess.board[0][7]!=1)
                                {
                                    Main_chess.blackKingMovedOnce=true;
                                    Main_chess.blackLeftRookMovedOnce=true;
                                    Main_chess.blackRightRookMovedOnce=true;
                                }
                                //-------------------------------------------------------black-castling
                                
                                //en peasant move
                                if(xi==Main_chess.blackEnpPossI && yj==Main_chess.blackEnpPossJ && Main_chess.whiteEnpI!=-9 && Main_chess.whiteEnpJ!=-9)
                                {
                                    idx=0;                
                                    for(int w=0;w<32;w+=2)
                                    {
                                        if(whitePosition[w]==Main_chess.whiteEnpI && whitePosition[w+1]==Main_chess.whiteEnpJ)
                                        {
                                            whitePosition[w]=-9;
                                            whitePosition[w+1]=-9;
                                            white[idx].setLayoutX(1000);
                                            white[idx].setLayoutY(1000);
                                            Main_chess.board[Main_chess.whiteEnpI][Main_chess.whiteEnpJ]=0;
                                            break;
                                        }         
                                        idx++;
                                    }
                                }
                                
                                Main_chess.whiteEnpI=-9;Main_chess.whiteEnpJ=-9;
                       
                                //promotion of black pawn
                                if(xi==7 && Main_chess.pres==7)
                                {
                                    int Type=promotion.display();
                                    System.out.println("promotion of black "+Type);

                                    Main_chess.pres=Type;
                                    if(Type==1)
                                        Main_chess.Selected.setImage(b_rook);
                                    else if(Type==2)
                                        Main_chess.Selected.setImage(b_bishop);
                                    else if(Type==3)
                                        Main_chess.Selected.setImage(b_knight);
                                    else if(Type==4)
                                        Main_chess.Selected.setImage(b_queen);
                                }
                                
                                
                                //update array
                                Main_chess.board[Main_chess.sx][Main_chess.sy]=0;
                                Main_chess.board[xi][yj]=Main_chess.pres;
                                
                                //eligibility for en peasant-black
                                if(Main_chess.pres==7 && Main_chess.sx==1 && xi==3)
                                {
                                    Main_chess.blackEnpI=xi;Main_chess.blackEnpJ=yj;
                                    System.out.println("black enp: "+xi+" "+yj);
                                }
                                
                                //black king safety
                                updateKingPosition.blackKingFinder();
                                if(check.danger(Main_chess.currentPositionBlack_I, Main_chess.currentPositionBlack_J, Main_chess.board))
                                    isitCheck.setText("black's in check");
                                else
                                    isitCheck.setText("none is in check");
          
                                //stalemate and checkmate
                                boolean blSt=BlackStalemate();
                                Main_chess.flag=0;
                                
                                if(WhiteStalemate() || blSt)
                                {
                                    System.out.println("Stalemate and check status:"+check.danger(Main_chess.currentPositionBlack_I,Main_chess.currentPositionBlack_J,Main_chess.board));                                   
                                    StaleMateScreen(primaryStage);
                                }
                                
                                updateKingPosition.whiteKingFinder();

                                int ki=Main_chess.currentPositionWhite_I;
                                int kj=Main_chess.currentPositionWhite_J;System.out.println("whiteking: "+ki+" "+kj);
                                if(check.danger(ki, kj,Main_chess.board)==true)
                                {
                                    Main_chess.whiteInCheck=true;
                                    isitCheck.setText("white's in check");
                                    System.out.println("white in check, others have "+CheckMate.whiteCheckMate()+" moves");
                                    if(CheckMate.whiteCheckMate()==0)
                                    {
                                        System.out.println("WHITE LOSE!!!!");
                                        BlackWins(primaryStage);
                                    }
                                }

                                else
                                {
                                    System.out.println("white is safe.");
                                    isitCheck.setText("none is in check");
                                    Main_chess.whiteInCheck=false;
                                }        
                                
                                Main_chess.decider=1;
                                Main_chess.Selected=null;
                                str.setText("white's turn");
                            }       
                        }
                       //-------------------------------------------selected black piece moved
                    }   
                    
                });
            }
        }
        //-----------------------------------------------------------------------------------------
        
        
        
        //-----------------------------------------------------------------------------------------
        
        Scene scene = new Scene(root, 500, 500);

        primaryStage.setResizable(false);
        primaryStage.setTitle("ChessMaestro");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public ArrayList<Integer> showAndMove(int i, int j)
    {
        int xi, yj, wh;
        ArrayList<Integer> mv = null;

        xi = i;
        yj = j;

        
        wh = Main_chess.board[xi][yj];
        possibleMoves.moves.clear();
        
        if (wh == 7 || wh == -7) {
            mv = possibleMoves.pawn(xi, yj);
        } else if (wh == 1 || wh == -1) {
            mv = possibleMoves.rook(xi, yj);
        } else if (wh == 2 || wh == -2) {
            mv = possibleMoves.bishop(xi, yj);
        } else if (wh == 3 || wh == -3) {
            mv = possibleMoves.knight(xi, yj);
        } else if (wh == 4 || wh == -4) {
            mv = possibleMoves.queen(xi, yj);
        } else if (wh == 5 || wh == -5) {
            mv = possibleMoves.king(xi, yj);
        }

        return mv;
    }
    
    //when there is no move available and you are not in check
    public boolean WhiteStalemate()
    {
        updateKingPosition.whiteKingFinder();
        int ki=Main_chess.currentPositionWhite_I;
        int kj=Main_chess.currentPositionWhite_J;
        
        int count=CheckMate.whiteCheckMate();
        
        if(check.danger(ki, kj, Main_chess.board)==false && count==0)
            return true;
        else
            return false;
    }
    
    public boolean BlackStalemate()
    {
        updateKingPosition.blackKingFinder();
        int ki=Main_chess.currentPositionBlack_I;
        int kj=Main_chess.currentPositionBlack_J;
        
        int count=CheckMate.blackCheckMate();
        
        if(check.danger(ki, kj, Main_chess.board)==false && count==0)
            return true;
        else
            return false;
    }
    
    public void BlackWins(Stage s)
    {
        Image sl=new Image("/slytherin2.jpg",500,500,true,true,true);
        ImageView slytherin=new ImageView(sl);
        
        Text winner=new Text(165, 200,"CheckMate!!!\n\nBlack Wins!!!");
        winner.setFill(Color.AZURE);
        winner.setFont(Font.font(30));
        
        
        Pane root3=new Pane();
        Scene closing=new Scene(root3,500,500);
        
        root3.getChildren().add(slytherin);
        root3.getChildren().add(winner);
        
        s.setScene(closing);
        s.show();
    }
    
    public void WhiteWins(Stage s)
    {
        Image sl=new Image("/gryffindor2.jpg",500,500,true,true,true);
        ImageView slytherin=new ImageView(sl);
        
        Text winner=new Text(165, 200,"CheckMate!!!\n\nWhite Wins!!!");
        winner.setFill(Color.AZURE);
        winner.setFont(Font.font(30));
        
        
        Pane root3=new Pane();
        Scene closing=new Scene(root3,500,500);
        
        root3.getChildren().add(slytherin);
        root3.getChildren().add(winner);
        
        s.setScene(closing);
        s.show();
        
    }

    
    public void StaleMateScreen(Stage s)
    {
        Image rv=new Image("/raven2.jpg",500,500,true,true,true);
        ImageView ravenclaw=new ImageView(rv);
        
        Text winner=new Text(165, 200,"StaleMate!!!");
        winner.setFill(Color.AZURE);
        winner.setFont(Font.font(30));
        
        
        Pane root3=new Pane();
        Scene closing=new Scene(root3,500,500);
        
        root3.getChildren().add(ravenclaw);
        root3.getChildren().add(winner);
        
        s.setScene(closing);
        s.show();
    }
}