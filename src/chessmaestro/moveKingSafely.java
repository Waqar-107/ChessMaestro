package chessmaestro;

public class moveKingSafely
{
    public static boolean kingCanMove(int i,int j)
    {
        int a=i,b=j;
        int count=0;
        int[][] temp=new int[8][8];
        
        for(int x=0;x<8;x++)
        {
            for(int y=0;y<8;y++)
            {
                temp[x][y]=Main_chess.board[x][y];
            }
        }
        
        //white
        if(Main_chess.flag==0)
        {
            temp[i][j]=5;
            temp[Main_chess.currentPositionWhite_I][Main_chess.currentPositionWhite_J]=0;
            
            //upwards
            a=i;a--;
            b=j;
            while(a>=0 && b>=0 && b<8 && a<8)
            {
                if(temp[a][b]==0)
                {
                    a--;
                    continue;
                }
                
                else if(temp[a][b]==4 || temp[a][b]==1)
                {
                    count++;
                    break;
                }
                
                else
                    break;
            }
            
            //downwards
            a=i;a++;
            b=j;
            while(a>=0 && b>=0 && b<8 && a<8)
            {
                if(temp[a][b]==0)
                {
                    a++;
                    continue;
                }
                
                else if(temp[a][b]==4 || temp[a][b]==1)
                {
                    count++;
                    break;
                }
                
                else
                    break;
            }
            
            //leftwards
            a=i;
            b=j;b--;
            while(a>=0 && b>=0 && b<8 && a<8)
            {
                if(temp[a][b]==0)
                {
                    b--;
                    continue;
                }
                
                else if(temp[a][b]==4 || temp[a][b]==1)
                {
                    count++;
                    break;
                }
                
                else
                    break;
            }
            
            //rightwards
            a=i;
            b=j;b++;
            while(a>=0 && b>=0 && b<8 && a<8)
            {
                if(temp[a][b]==0)
                {
                    b++;
                    continue;
                }
                
                else if(temp[a][b]==4 || temp[a][b]==1)
                {
                    count++;
                    break;
                }
                
                else
                    break;
            }
            
            //right-up
            a=i;a--;
            b=j;b++;
            while(a>=0 && b>=0 && b<8 && a<8)
            {
                if(temp[a][b]==0)
                {
                    a--;
                    b++;
                    continue;
                }
                
                else if(temp[a][b]==4 || temp[a][b]==2)
                {
                    count++;
                    break;
                }
                
                else
                    break;
            }
            
            //right-down
            a=i;a++;
            b=j;b++;
            while(a>=0 && b>=0 && b<8 && a<8)
            {
                if(temp[a][b]==0)
                {
                    a++;b++;
                    continue;
                }
                
                else if(temp[a][b]==4 || temp[a][b]==2)
                {
                    count++;
                    break;
                }
                
                else
                    break;
            }
            
            //left-up
            a=i;a--;
            b=j;b--;
            while(a>=0 && b>=0 && b<8 && a<8)
            {
                if(temp[a][b]==0)
                {
                    a--;b--;
                    continue;
                }
                
                else if(temp[a][b]==4 || temp[a][b]==2)
                {
                    count++;
                    break;
                }
                
                else
                    break;
            }
            
            //left-down
            a=i;a++;
            b=j;b--;
            while(a>=0 && b>=0 && b<8 && a<8)
            {
                if(temp[a][b]==0)
                {
                    a++;
                    b--;
                    continue;
                }
                
                else if(temp[a][b]==4 || temp[a][b]==2)
                {
                    count++;
                    break;
                }
                
                else
                    break;
            }
            
        }
        
        
        //black
        else
        {
            temp[i][j]=-5;
            temp[Main_chess.currentPositionBlack_I][Main_chess.currentPositionBlack_J]=0;
            
            //upwards
            a=i;a--;
            b=j;
            while(a>=0 && b>=0 && b<8 && a<8)
            {
                if(temp[a][b]==0)
                {
                    a--;
                    continue;
                }
                
                else if(temp[a][b]==-4 || temp[a][b]==-1)
                {
                    count++;
                    break;
                }
                
                else
                    break;
            }
            
            //downwards
            a=i;a++;
            b=j;
            while(a>=0 && b>=0 && b<8 && a<8)
            {
                if(temp[a][b]==0)
                {
                    a++;
                    continue;
                }
                
                else if(temp[a][b]==-4 || temp[a][b]==-1)
                {
                    count++;
                    break;
                }
                
                else
                    break;
            }
            
            //leftwards
            a=i;
            b=j;b--;
            while(a>=0 && b>=0 && b<8 && a<8)
            {
                if(temp[a][b]==0)
                {
                    b--;
                    continue;
                }
                
                else if(temp[a][b]==-4 || temp[a][b]==-1)
                {
                    count++;
                    break;
                }
                
                else
                    break;
            }
            
            //rightwards
            a=i;
            b=j;b++;
            while(a>=0 && b>=0 && b<8 && a<8)
            {
                if(temp[a][b]==0)
                {
                    b++;
                    continue;
                }
                
                else if(temp[a][b]==-4 || temp[a][b]==-1)
                {
                    count++;
                    break;
                }
                
                else
                    break;
            }
            
            //right-up
            a=i;a--;
            b=j;b++;
            while(a>=0 && b>=0 && b<8 && a<8)
            {
                if(temp[a][b]==0)
                {
                    a--;b++;
                    continue;
                }
                
                else if(temp[a][b]==-4 || temp[a][b]==-2)
                {
                    count++;
                    break;
                }
                
                else
                    break;
            }
            
            //right-down
            a=i;a++;
            b=j;b++;
            while(a>=0 && b>=0 && b<8 && a<8)
            {
                if(temp[a][b]==0)
                {
                    a++;b++;
                    continue;
                }
                
                else if(temp[a][b]==-4 || temp[a][b]==-2)
                {
                    count++;
                    break;
                }
                
                else
                    break;
            }
            
            //left-up
            a=i;a--;
            b=j;b--;
            while(a>=0 && b>=0 && b<8 && a<8)
            {
                if(temp[a][b]==0)
                {
                    a--;b--;
                    continue;
                }
                
                else if(temp[a][b]==-4 || temp[a][b]==-2)
                {
                    count++;
                    break;
                }
                
                else
                    break;
            }
            
            //left-down
            a=i;a++;
            b=j;b--;
            while(a>=0 && b>=0 && b<8 && a<8)
            {
                if(temp[a][b]==0)
                {
                    a++;b--;
                    continue;
                }
                
                else if(temp[a][b]==-4 || temp[a][b]==-2)
                {
                    count++;
                    break;
                }
                
                else
                    break;
            }
        }
        
        if(count==0)
            return true;
        else
            return false;
    }
}
