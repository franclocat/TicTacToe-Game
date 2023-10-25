import java.util.*;

public class NewTicTacToe {
    public static void main(String args[]) {
        //create grid
        Scanner scanner = new Scanner(System.in);
        
        String[][] grid = new String[3][3];

        //create a grid an print it 
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("|" + " ");
            for (int j = 0; j < 3; j++) {
                grid[i][j] = " "; 
                System.out.print(grid[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
        /***********************************************************************************/
        /*Prompt the user, print the grid, check for different cases and break if necessary*/
        boolean xWins = false;
        boolean oWins = false;
        boolean not_finished = false;
        boolean draw = false;
        boolean impossible = false;

        String turn = "";
        int turnNum = 0; //double checker for repeated errors

        for (;;) {
            //switch between X and O (also makes an "impossible" case not possible together with the turnNum statement)
            switch (turn) {
                case "O":
                    turn = "X";
                    break;
                case "X":
                    turn = "O";
                    break;
                default:
                    turn = "X";
                    break;
            }
            //Prompt the user and print the wanted grid
            System.out.println("Where do you want to place (row and column)?: ");
            int wantedRow = 0;
            int wantedColumn = 0;

            //check if the input is a String
            if (scanner.hasNextInt() && scanner.hasNextInt()) {
                wantedRow = scanner.nextInt();
                wantedColumn = scanner.nextInt();
            } else {
                System.out.println("You should enter numbers!");
                break;
            }
            //check if the input is in range 3
            if ((wantedRow > 3 && wantedColumn > 3) || (wantedRow > 3 && wantedColumn <= 3) || (wantedColumn > 3 && wantedRow <= 3)) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue; // Use 'continue' to go back to the beginning of the loop
            }

            //check if the cell is occupied
            if (!grid[wantedRow - 1][wantedColumn - 1].equals(" ")) {
                System.out.println("This cell is occupied! Choose another one!");
                
                continue; // Use 'continue' to go back to the beginning of the loop
            }
            //double check if there are repated errors and not changing the turn
            if (turnNum % 2 == 0) {
                    turn = "X";
                } else {
                    turn = "O";
                }
            turnNum += 1;
            /*********************************************************/

            grid[wantedRow - 1][wantedColumn - 1] = turn; //replace the cell wanted cell in the grid with X or O
            System.out.println("---------");
            for (int i = 0; i < 3; i++) {
                System.out.print("|" + " ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(grid[i][j] + " ");
                }
                System.out.println("|");
            }
            System.out.println("---------");
            
            /*********************************************************/
            //check for a winner horizontally, vertically or diagonally
            String fullRow = "";
            String fullColumn = "";
            String ltrDiagonal = "";
            String rtlDiagonal = grid[1][1];

            int xCounter = 0;//for impossible state 
            int oCounter = 0;//for impossible state 
            int sumOfvalues = 0;

            for (int i = 0; i < 3; i++) {
                fullColumn = "";
                fullRow = "";
                fullColumn = grid[0][i] + grid[1][i] + grid[2][i];
                //check for vertical winner
                if (fullColumn.equals("XXX")) { 
                    xWins = true;
                } else if (fullColumn.equals("OOO")) {
                    oWins = true;
                }
                for (int j = 0; j < 3; j++) {
                    fullRow += grid[i][j];
                    //check for horizontal winner
                    if (fullRow.equals("XXX")) { 
                        xWins = true;
                    } else if (fullRow.equals("OOO")) {
                            oWins = true;
                    }
                    //check for diagonal winner
                    if (i == j) {
                        ltrDiagonal += grid[i][j];
                        if (ltrDiagonal.equals("XXX")) {
                            xWins = true;
                        } else if (ltrDiagonal.equals("OOO")) {
                            oWins = true;
                        }
                    } else if ((i == 0 && j == 2) || (i == 2 && j == 0)) {
                        rtlDiagonal += grid[i][j];
                        if (rtlDiagonal.equals("XXX")) {
                            xWins = true;
                        } else if (rtlDiagonal.equals("OOO")) {
                            oWins = true;
                        }
                    }
                    //determine if not finished
                    if (!xWins && !oWins && (grid[i][j].equals("_") || grid[i][j].equals(" "))) {
                        not_finished = true;
                    }
                    //determine if the result is a draw
                    if (grid[i][j].equals("X")) {
                        xCounter++;
                    } else if (grid[i][j].equals("O")) {
                        oCounter++;
                    }
                    sumOfvalues = xCounter + oCounter;
                    if (sumOfvalues == 9 && !xWins && !oWins) {
                        draw = true;
                    }
                }
            }
            /*********************************************************/
            /*break the loop if the game is finished or impossible and print the result*/
            if (xWins) {
                System.out.println("X wins");
                break;
            } else if (oWins) {
                System.out.println("O wins");
                break;
            } else if (draw) {
                System.out.println("Draw");
                break;
            }
            /*********************************************************/
        }
        //end of for(;;) loop
    }
}
