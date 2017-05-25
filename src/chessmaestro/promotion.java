package chessmaestro;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class promotion
{
    static int type=0;
    public static Stage window=new Stage();

    public static int display()
    {
        int width=55,height=55;
        //window.initModality(Modality.APPLICATION_MODAL);
        
        Image pb_rook = new Image("/Rook-B55.png", width, height, true, true, true);
        Image pb_bishop = new Image("/Bishop-B55.png", width, height, true, true, true);
        Image pb_knight = new Image("/Knight-B55.png", width, height, true, true, true);
        Image pb_queen = new Image("/Queen-B55.png", width, height, true, true, true);
        
        Image pw_rook = new Image("/Rook-W55.png", width, height, true, true, true);
        Image pw_bishop = new Image("/Bishop-W55.png", width, height, true, true, true);
        Image pw_knight = new Image("/Knight-W55.png", width, height, true, true, true);
        Image pw_queen = new Image("/Queen-W55.png", width, height, true, true, true);
        
        ImageView ir=new ImageView();
        ir.setLayoutX(width*0);
        ir.setLayoutY(0);
        
        ImageView ib=new ImageView();
        ib.setLayoutX(width*1);
        ib.setLayoutY(0);
        
        ImageView ik=new ImageView();
        ik.setLayoutX(width*2);
        ik.setLayoutY(0);
        
        ImageView iq=new ImageView();
        iq.setLayoutX(width*3);
        iq.setLayoutY(0);
        
        if(Main_chess.flag==0)
        {
            ir.setImage(pw_rook);
            ib.setImage(pw_bishop);
            ik.setImage(pw_knight);
            iq.setImage(pw_queen);
        }
        
        else
        {
            ir.setImage(pb_rook);
            ib.setImage(pb_bishop);
            ik.setImage(pb_knight);
            iq.setImage(pb_queen);            
        }
        
        ir.setOnMouseClicked(e->
        {System.out.println("click");
            if(Main_chess.flag==0)
                type=-1;
            else
                type=1;
            
            window.close();
                  
        });
        
        ik.setOnMouseClicked(e->
        {
            if(Main_chess.flag==0)
                type=-3;
            else
                type=3;
            
            window.close();
        });
        
        ib.setOnMouseClicked(e->
        {
            if(Main_chess.flag==0)
                type=-2;          
            else
                type=2;
            
            window.close();
        });
        
        iq.setOnMouseClicked(e->
        {
            if(Main_chess.flag==0)
                type=-4;   
            else
                type=4;
            
            window.close();
        });
        
        Rectangle bg=new Rectangle(width*4, height);
        bg.setFill(Color.LIGHTBLUE);
        
        Pane root2=new Pane();
        root2.setMinSize(width*4, height);
        root2.getChildren().add(bg);
        root2.getChildren().add(ir);
        root2.getChildren().add(ib);
        root2.getChildren().add(ik);
        root2.getChildren().add(iq);
        
        Scene sc=new Scene(root2,width*4,height);
        window.setScene(sc);
        window.showAndWait();
        
       
        return type;
    }     
    
   
}
