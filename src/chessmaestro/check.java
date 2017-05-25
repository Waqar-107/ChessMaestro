package chessmaestro;

public class check
{
    //king-5, queen=4, bishop=2,knight=3,pawn=7,rook=1.
    //initialy the count will be 0, if unsafe from any piece count will increment 
    
    
    public static boolean danger(int i,int j,int[][] board)
    {
        int count=0;
        int[][] tempBoard=new int[8][8];
        
        for(int x=0;x<8;x++)
        {
            for(int y=0;y<8;y++)
            {
                tempBoard[x][y]=board[x][y];
            }
        }
        
        int a,b;
        
        //safety of white king. when flag is 1, black has made a move and we require to check whtes safety
        if(Main_chess.flag==0)
        {
            //-------------------------------------------------------------------------------------
            //safety from a pawn
            a=i;b=j;
            if(a-1<8 && a-1>=0 && b-1<8 && b-1>=0 && tempBoard[a-1][b-1]==7)
                count++;
            if(a-1<8 && a-1>=0 && b+1<8 && b+1>=0 && tempBoard[a-1][b+1]==7)
                count++;
            //-------------------------------------------------------------------------------------
            
            
            
            //-------------------------------------------------------------------------------------
            //safety from knight
            int[] knMoves={a + 2, b + 1, a + 2, b - 1, a - 2, b + 1, a - 2, b - 1, a + 1, b + 2, a + 1, b - 2, a - 1, b + 2, a - 1, b - 2};
            for(int x=0;x<16;x+=2)
            {
                if(knMoves[x]<8 && knMoves[x]>=0 && knMoves[x+1]<8 && knMoves[x+1]>=0 && tempBoard[knMoves[x]][knMoves[x+1]]==3)
                    count++;
            }
            //-------------------------------------------------------------------------------------
           
            
            
            //-------------------------------------------------------------------------------------
            //safety from rook and queen. queen is the union of rook and bishop so it will be checked with both of them
           //upwards
            a=i;a--;
            b=j;
            while(a>=0)
            {
                if(tempBoard[a][b]==0)            //empty so continue the search
                {
                    a--;
                    continue;
                }
                
                else if(tempBoard[a][b]<0)      //same side found guarding the king, safe so break 
                    break;
                
                else if(tempBoard[a][b]==4 || tempBoard[a][b]==1)   //rook or queen found
                {
                    count++;
                    break;
                }
                
                else if((tempBoard[a][b]!=4 || tempBoard[a][b]!=1) && tempBoard[a][b]>0)    //black but not rook or queen
                    break;
            }
            
            //downwards
            a=i;
            a++;
            b=j;
            while(a<8)
            {
                if(tempBoard[a][b]==0)            //empty so continue the search
                {
                    a++;
                    continue;
                }
                
                else if(tempBoard[a][b]<0)      //same side found guarding the king, safe so break 
                    break;
                
                else if(tempBoard[a][b]==4 || tempBoard[a][b]==1)   //rook or queen found
                {
                    count++;
                    break;
                }
                
                else if((tempBoard[a][b]!=4 || tempBoard[a][b]!=1) && tempBoard[a][b]>0)    //black but not rook or queen
                    break;
            }
            
            //rightwards
            a=i;
            b=j;
            b++;
            while(b<8)
            {
                if(tempBoard[a][b]==0)            //empty so continue the search
                {
                    b++;
                    continue;
                }
                
                else if(tempBoard[a][b]<0)      //same side found guarding the king, safe so break 
                    break;
                
                else if(tempBoard[a][b]==4 || tempBoard[a][b]==1)   //rook or queen found
                {
                    count++;
                    break;
                }
                
                else if((tempBoard[a][b]!=4 || tempBoard[a][b]!=1) && tempBoard[a][b]>0)    //black but not rook or queen
                    break;
            }
            
            //leftwards
            a=i;
            b=j;
            b--;
            while(b>=0)
            {
                if(tempBoard[a][b]==0)            //empty so continue the search
                {
                    b--;
                    continue;
                }
                
                else if(tempBoard[a][b]<0)      //same side found guarding the king, safe so break 
                    break;
                
                else if(tempBoard[a][b]==4 || tempBoard[a][b]==1)   //rook or queen found
                {
                    count++;
                    break;
                }
                
                else if((tempBoard[a][b]!=4 || tempBoard[a][b]!=1) && tempBoard[a][b]>0)    //black but not rook or queen
                    break;
            }
            //-------------------------------------------------------------------------------------
            
            
            
            //-------------------------------------------------------------------------------------
            //safety from bishop and queen
           //up-left
            a=i;a--;
            b=j;b--;
            while(a>=0 && b>=0)
            {
                if(tempBoard[a][b]==0)            //empty so continue the search
                {
                    a--;
                    b--;
                    continue;
                }
                
                else if(tempBoard[a][b]<0)      //same side found guarding the king, safe so break 
                    break;
                
                else if(tempBoard[a][b]==4 || tempBoard[a][b]==2)   //bishop or queen found
                {
                    count++;
                    break;
                }
                
                else if((tempBoard[a][b]!=4 || tempBoard[a][b]!=2) && tempBoard[a][b]>0)    //black but not rook or queen
                    break;
            }
            
            //up-right
            a=i;a--;
            b=j;b++;
            while(a>=0 && b<8)
            {
                if(tempBoard[a][b]==0)            //empty so continue the search
                {
                    a--;
                    b++;
                    continue;
                }
                
                else if(tempBoard[a][b]<0)      //same side found guarding the king, safe so break 
                    break;
                
                else if(tempBoard[a][b]==4 || tempBoard[a][b]==2)   //bishop or queen found
                {
                    count++;
                    break;
                }
                
                else if((tempBoard[a][b]!=4 || tempBoard[a][b]!=2) && tempBoard[a][b]>0)    //black but not rook or queen
                    break;
            }
            
            //down-left
            a=i;a++;
            b=j;b--;
            while(a<8 && b>=0)
            {
                if(tempBoard[a][b]==0)            //empty so continue the search
                {
                    a++;
                    b--;
                    continue;
                }
                
                else if(tempBoard[a][b]<0)      //same side found guarding the king, safe so break 
                    break;
                
                else if(tempBoard[a][b]==4 || tempBoard[a][b]==2)   //bishop or queen found
                {
                    count++;
                    break;
                }
                
                else if((tempBoard[a][b]!=4 || tempBoard[a][b]!=2) && tempBoard[a][b]>0)    //black but not rook or queen
                    break;
            }
            
            //down-right
            a=i;a++;
            b=j;b++;
            while(b<8 && a<8)
            {
                if(tempBoard[a][b]==0)            //empty so continue the search
                {
                    a++;
                    b++;
                    continue;
                }
                
                else if(tempBoard[a][b]<0)      //same side found guarding the king, safe so break 
                    break;
                
                else if(tempBoard[a][b]==4 || tempBoard[a][b]==2)   //bishop or queen found
                {
                    count++;
                    break;
                }
                
                else if((tempBoard[a][b]!=4 || tempBoard[a][b]!=2) && tempBoard[a][b]>0)    //black but not rook or queen
                    break;
            }
            //-------------------------------------------------------------------------------------
            //System.out.println("bishop count: "+count);
        }
        
        //safety of black king
        else
        {
            //-------------------------------------------------------------------------------------
            //safety from a pawn
            a=i;b=j;
            if(a+1<8 && a+1>=0 && b-1<8 && b-1>=0 && tempBoard[a+1][b-1]==-7)
                count++;
            if(a+1<8 && a+1>=0 && b+1<8 && b+1>=0 && tempBoard[a+1][b+1]==-7)
                count++;
            //-------------------------------------------------------------------------------------
            
            
            
            //-------------------------------------------------------------------------------------
            //safety from knight
            int[] knMoves={a + 2, b + 1, a + 2, b - 1, a - 2, b + 1, a - 2, b - 1, a + 1, b + 2, a + 1, b - 2, a - 1, b + 2, a - 1, b - 2};
            for(int x=0;x<16;x+=2)
            {
                if(knMoves[x]<8 && knMoves[x]>=0 && knMoves[x+1]<8 && knMoves[x+1]>=0 && tempBoard[knMoves[x]][knMoves[x+1]]==-3)
                    count++;
            }
            //-------------------------------------------------------------------------------------
            
            
            
            //-------------------------------------------------------------------------------------
            //safety from rook and queen. queen is the union of rook and bishop so it will be checked with both of them
           //upwards
            a=i;a--;
            b=j;
            while(a>=0)
            {
                if(tempBoard[a][b]==0)            //empty so continue the search
                {
                    a--;
                    continue;
                }
                
                else if(tempBoard[a][b]>0)      //same side found guarding the king, safe so break 
                    break;
                
                else if(tempBoard[a][b]==-4 || tempBoard[a][b]==-1)   //rook or queen found
                {
                    count++;
                    break;
                }
                
                else if((tempBoard[a][b]!=-4 || tempBoard[a][b]!=-1) && tempBoard[a][b]<0)    //white but not rook or queen
                    break;
            }
            
            //downwards
            a=i;
            a++;
            b=j;
            while(a<8)
            {
                if(tempBoard[a][b]==0)            //empty so continue the search
                {
                    a++;
                    continue;
                }
                
                else if(tempBoard[a][b]>0)      //same side found guarding the king, safe so break 
                    break;
                
                else if(tempBoard[a][b]==-4 || tempBoard[a][b]==-1)   //rook or queen found
                {
                    count++;
                    break;
                }
                
                else if((tempBoard[a][b]!=-4 || tempBoard[a][b]!=-1) && tempBoard[a][b]<0)    //white but not rook or queen
                    break;
            }
            
            //rightwards
            a=i;
            b=j;
            b++;
            while(b<8)
            {
                if(tempBoard[a][b]==0)            //empty so continue the search
                {
                    b++;
                    continue;
                }
                
                else if(tempBoard[a][b]>0)      //same side found guarding the king, safe so break 
                    break;
                
                else if(tempBoard[a][b]==-4 || tempBoard[a][b]==-1)   //rook or queen found
                {
                    count++;
                    break;
                }
                
                else if((tempBoard[a][b]!=-4 || tempBoard[a][b]!=-1) && tempBoard[a][b]<0)    //white but not rook or queen
                    break;
            }
            
            //leftwards
            a=i;
            b=j;
            b--;
            while(b>=0)
            {
                if(tempBoard[a][b]==0)            //empty so continue the search
                {
                    b--;
                    continue;
                }
                
                else if(tempBoard[a][b]>0)      //same side found guarding the king, safe so break 
                    break;
                
                else if(tempBoard[a][b]==-4 || tempBoard[a][b]==-1)   //rook or queen found
                {
                    count++;
                    break;
                }
                
                else if((tempBoard[a][b]!=-4 || tempBoard[a][b]!=-1) && tempBoard[a][b]<0)    //white but not rook or queen
                    break;
            }
            //-------------------------------------------------------------------------------------
            
            
            
            //-------------------------------------------------------------------------------------
            //safety from bishop and queen
           //up-left
            a=i;a--;
            b=j;b--;
            while(a>=0 && b>=0)
            {
                if(tempBoard[a][b]==0)            //empty so continue the search
                {
                    a--;
                    b--;
                    continue;
                }
                
                else if(tempBoard[a][b]>0)      //same side found guarding the king, safe so break 
                    break;
                
                else if(tempBoard[a][b]==-4 || tempBoard[a][b]==-2)   //bishop or queen found
                {
                    count++;
                    break;
                }
                
                else if((tempBoard[a][b]!=-4 || tempBoard[a][b]!=-2) && tempBoard[a][b]<0)    //white but not rook or queen
                    break;
            }
            
            //up-right
            a=i;a--;
            b=j;b++;
            while(a>=0 && b<8)
            {
                if(tempBoard[a][b]==0)            //empty so continue the search
                {
                    a--;
                    b++;
                    continue;
                }
                
                else if(tempBoard[a][b]>0)      //same side found guarding the king, safe so break 
                    break;
                
                else if(tempBoard[a][b]==-4 || tempBoard[a][b]==-2)   //bishop or queen found
                {
                    count++;
                    break;
                }
                
                else if((tempBoard[a][b]!=-4 || tempBoard[a][b]!=-2) && tempBoard[a][b]<0)    //black but not rook or queen
                    break;
            }
            
            //down-left
            a=i;a++;
            b=j;b--;
            while(a<8 && b>=0)
            {
                if(tempBoard[a][b]==0)            //empty so continue the search
                {
                    a++;
                    b--;
                    continue;
                }
                
                else if(tempBoard[a][b]>0)      //same side found guarding the king, safe so break 
                    break;
                
                else if(tempBoard[a][b]==-4 || tempBoard[a][b]==-2)   //bishop or queen found
                {
                    count++;
                    break;
                }
                
                else if((tempBoard[a][b]!=-4 || tempBoard[a][b]!=-2) && tempBoard[a][b]<0)    //black but not rook or queen
                    break;
            }
            
            //down-right
            a=i;a++;
            b=j;b++;
            while(b<8 && a<8)
            {
                if(tempBoard[a][b]==0)            //empty so continue the search
                {
                    a++;
                    b++;
                    continue;
                }
                
                else if(tempBoard[a][b]>0)      //same side found guarding the king, safe so break 
                    break;
                
                else if(tempBoard[a][b]==-4 || tempBoard[a][b]==-2)   //bishop or queen found
                {
                    count++;
                    break;
                }
                
                else if((tempBoard[a][b]!=-4 || tempBoard[a][b]!=-2) && tempBoard[a][b]<0)    //black but not rook or queen
                    break;
            }
            //-------------------------------------------------------------------------------------
            
        }
        
        //count=0 means safe, false means not in check
        if(count==0)
            return false;
        else          
            return true;
    }
}
