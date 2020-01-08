
import java.security.SecureRandom;

1
import java.util.Scanner;


//this class will create a game grid and let the user try and reach the far right side without hitting a 1
public class GameGrid_Test {

    public static void main(String[] args) {

        //creates the object of game grid.
        GameGrid_Test oGameGrid = new GameGrid_Test();
        //runs the game grid
        oGameGrid.GameGrid_Test ();


    }
        //method that tests the game grid
        public void GameGrid_Test(){
            //sets what the dementions of the grid
            int  [][] aiGrid = new int[10][10];
            //creats the random variable
            SecureRandom oGameGrid =  new SecureRandom();
            //sets the change of the wall
            int iChanceOfWall = 25;
             int iTemp;
             //creates a new object that holds the link list
            LinkedList oLinkedList = new LinkedList();







            //loops through the grid assigning 1s and 0s randomly with a 90 percent chance to be 0s and 20 percent to be 1a
            for (int i = 0; i < aiGrid.length; i++) {

            for (int j = 0; j < aiGrid[0].length; j++) {

                //randomly get number between 0 and 99.
                // then tile 0 if below wall change, and 1 if over
                iTemp = oGameGrid.nextInt(100);
                    if (iTemp < iChanceOfWall) {

                    aiGrid[i][j] = 1;
                     } else {
                    aiGrid[i][j] = 0;
                     }

                }
             }


            //sets the row and col to 0 so that each will be able to loop through the correct spaces
            int iUserRow = 0;
            int iUserCol = 0;
            Boolean down = true;
            //sets the starting point of the grid to 0
            aiGrid[0][0] = 0;
            //creats a new scan object
            Scanner scan = new Scanner(System.in);

            //whale statment that will loop untill the customer reaches the right and win or fail hitting a 1
            while (aiGrid[iUserRow][iUserCol] < 1 ) {
                if ( iUserRow < 9 ) {
                    System.out.println("Plese enter a number:");
                    System.out.println("Below 5: Down");
                    System.out.println("Above 5 Right:");
                    int input = scan.nextInt();

                    if (input < 5) {
                        aiGrid[iUserRow][iUserCol] = 9;
                        //assigns the link list object the grid numbers as it loops. this one is the row
                        oLinkedList.addNode(iUserRow, iUserCol);
                        iUserRow++;
                    }
                    else if (input >5 ){
                            aiGrid[iUserRow][iUserCol] = 9;
                        //assigns the link list object the grid numbers as it loops. this one is the col
                        oLinkedList.addNode(iUserRow, iUserCol);
                            iUserCol++;
                    }
                    else if (iUserRow >= 9  )
                    {
                        aiGrid[iUserRow][iUserCol] = 1;

                    }
                }
                else{
                    aiGrid[iUserRow][iUserCol] = 9;
                    System.out.println("congradualtions you won");
                    printGrid(aiGrid);
                }
            }
            int iCount = 0;
            //loops through the linklist assigning the positions the number 5
            while (oLinkedList.headNode !=null){
               int yPos = oLinkedList.headNode.yPosition;
              int xPos = oLinkedList.removeHeadNode().xPosition;
              aiGrid[xPos][yPos] = 5;
                //counts number of turns
              iCount++;




            }
            if (iUserCol < 9) {
                printGrid(aiGrid);
                System.out.println("sorry you lost");
                System.out.println("The 5 is your path through the grid and you hit a wall (1)");
                System.out.println("The number of turns you have taken is: "+(iCount));

            }
            else{
                printGrid(aiGrid);
                System.out.println("Congradulations you won");
                System.out.println("The number of turns you have taken is: "+(iCount));
            }

        }

    //this is a method that will print out the contense of the array
    public void printGrid(int [][] aiGrid){
        for (int j = 0; j < aiGrid.length; j++){

            for (int i = 0; i < aiGrid[0].length; i++){
                System.out.print(" "+ aiGrid[j][i]);
            }
            System.out.println();

        }


    }
}
