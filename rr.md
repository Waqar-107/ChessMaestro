Report on term project: 

ChessMaestro


Project under-
Siddhartha Shankar Das
Lecturer, Department of CSE, BUET.



Project of-
Waqar Hassan Khan
1505107
Level-1, Term-2
Department of CSE, BUET.

Functionality

ChessMaestro is a multiplayer game of chess that can be played in a single pc.

The classes are in single package called ChessMaestro.
The classes used-
1.	ChessMaestro.java 
2.	Main_chess.java 
3.	possibleMoves.java 
4.	promotion.java 
5.	updateKingPosition.java 
6.	moveKingSafely.java 
7.	moveIfKingSafe.java  
8.	CheckMate.java 
9.	Check.java 
The whole project contains approximately 2971 lines of code.

1. ChessMaestro.java
This is the GUI and extends Application. At first there comes a opening screen and by clicking it will launch the actual game.
 
Fig. opening screen

Then comes the main game screen.
 
Here the board has been drawn using Rectangle objects and under it, the background is an image. The pieces are also images of size 55*55 pixels. The board is 440*440 pixel and the whole window is 500*500 pixels.
There is also a layer of transparent Rectangle over the images and the first rectangles. The controls are done detecting mouse click on the transparent rectangle.
When clicked the coordinates are determined and possible moves are shown. Those cells possible to move in will be different in color. This happens when the opacity of the transparent rectangle is increased.
And if any piece is there, its reference is saved and if the next move is on valid place the coordinates are changed, check, checkmate and stalemate are checked.

                   

      

Fig. a) possible moves. B) Stalemate. C) and D) Checkmate

If there is no move left for any of the piece and its king is not in check then it is stalemate. If there is no move left for any of the piece and its king is in check then it is checkmate.

For these, the stage has been passed as a parameter to methods.
Apart from the main() method and the start() method the others are-
1.	mainGameplay- launching the main game screen.
2.	showAndMove- gets the possible moves and give to main game.
3.	WhiteStalemate- checking stalemate for white.
4.	BlackStalemate-  checking stalemate for black.
5.	BlackWins- declaring black has won.
6.	WhiteWins- declaring white has won.
7.	StaleMateScreen- declaring stalemate.

2. Main_chess.java:
The game is based on a 2D array where 0 represents empty cells, positive number for black, negative for black.
7: pawn, 1: rook, 2: bishop, 3: knight, 4: queen, 5: king, 0: empty, the positive integers for black and vice versa
Also have some static variables.

3. possibleMoves.java 
Contains an ArrayList of Integer that contains the possible moves and passes it.
There are 6 methods here
1.	Knight
2.	Rook
3.	Bishop
4.	Queen
5.	King
6.	pawn

Giving the possible moves of each of the criteria. The moves are fixed and it is checked if they will be valid, the safety of the king is also determined for that reason. For each possible move at first the range is checked to avoid ArrayOutOfBoundException and then the previous and next coordinates are sent to moveKingIfSafe() method. This will make a copy of main 2D array, makes the proposed changes in the temporary array and determine if the king remains safe. There are two special moves implemented. En peasant and castling of the king.

     
				Fig. before and after castling

    
					Fig. en-peasant
  

4. promotion.java
Pops up a display that asks the user to promote a pawn into either a knight or a queen or a rook or a bishop

            
              		   Fig. promotion of pawn 

It contains a function that returns an integer. It is called display() and it takes the choice of the user and returns the type of the piece to main GUI.

5. updateKingPosition.java:
Updates the king position. Has two methods, whiteKingFinder and blackKingFinder that finds the coordinates of the white and black king respectively.
It searches the whole array and the methods updates the coordinates of the king. These updates are saved in a static variable which is in Main_chess.java

6. moveKingSafely.java:
Has only one method called kingCanMove which determines that if the king can move or not, king(int i,int j) in possibleMoves class calls this method.

7. moveIfKingSafe.java:
Has one method called kingIsSafe(). If this tells that the move chosen is safe for king it returns true otherwise false. 

8.CheckMate.java:
Checks if there is any valid moves left.
Have two methods blackCheckMate() and whiteCheckMate()

9. Check.java:
Contains a single method danger() that returns false if the king is not in check, otherwise false.


The Incompletes: 
The actual plan was to make the game work in multiple pcs. In order to do that Networking is required. Because of not having sufficient time and lacking of clear concept of Networking, I could not finish the networking part. I also wanted to use Alpha-Beta pruning to make a basic chase engine if there was enough time. Now I intend to learn both Networking and the alpha-beta pruning method to make the project more developed.

Tools used:
The entire work is done on Netbeans IDE. For the Graphical User Interface I have used javaFX. It contains hard code, no drag and drop tools were used.
