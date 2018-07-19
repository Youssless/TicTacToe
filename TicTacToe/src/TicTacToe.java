
// holds the methods and fields needed to play tic-tac-toe
public class TicTacToe
{
    private CellValue.cellValue[][] board; // 2d array for the board
    private final int ROWS = 3; // number of rows
    private final int COLUMNS = 3; // number of columns

    private int row; // row the player chose to place either a naught or a cross
    private int column; // column the player chose to place either a nought or a cross
    private int count = 0; // counts the number of moves
    private int turn = 0; // turn player 1 is '1' and player 2 is '2'

    private CellValue.cellValue empty = CellValue.cellValue.EMPTY; // EMPTY value " "
    private CellValue.cellValue naught = CellValue.cellValue.O; // O value "O"
    private CellValue.cellValue cross = CellValue.cellValue.X; // X value "X"

    // default constructor
    public TicTacToe()
    {
        board = new CellValue.cellValue[ROWS][COLUMNS];

        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                board[i][j] = empty;
            }
        }
    }

    // draws the board
    public void drawBoard()
    {
        drawHeader();
        System.out.println();
        for (int i = 0; i < board.length; i++)
        {
            System.out.print(i + " ");
            for (int j = 0; j < board[i].length; j++)
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // labels the columns from 0 - 2
    private void drawHeader()
    {
        for (int i = 0; i < board.length; i++)
        {
            System.out.print(" " + i + " ");
        }
    }

    // places the cell type (depending on the player) on the board and moves count incremented
    public void placeCellValue()
    {
        if (turn == 1)
        {
            board[row][column] = cross;
            count++;
        }

        if (turn == 2)
        {
            board[row][column] = naught;
            count++;
        }
    }

    // returns string depending on the turn
    public String turnType()
    {
        String player = " ";

        if (turn == 1)
            player = "Player X";
        else if (turn == 2)
            player = "Player O";

        return player;
    }

    // when called if turn is 1 then go to the next turn
    public int turn()
    {
        if(turn == 1)
            return (turn = 2);
        else if (turn == 2);
            return (turn = 1);
    }

    // tests whether the game should exit or not depending if won or drawn
    public boolean isExit()
    {
        boolean exit;

        int playerWon = 0;
        String message = " ";

        if (hasWon(cross) == true || hasWon(naught) == true)
        {
            if (turn == 2) // player X is player 1 but before this happens turn goes to 2
                message = "\nPlayer X has WON!\n";
            else if (turn == 1) // player O is player 2 but before this happens turn goes to 1
                message = "\nPlayer O has WON!\n";

            System.out.println(message);
            exit = true;
        }
        else if (isDraw() == true)
        {
            System.out.println("\nDRAW!\n");
            exit = true;
        }
        else
            exit = false;

        return exit;
    }

    // tests if the cell already contains a cellValue returns true if so
    public boolean isOverlapped()
    {
        if (turn == 1)
        {
            if (board[row][column] == naught)
                return true;
        }

        if (turn == 2)
        {
            if (board[row][column] == cross)
                return true;
        }

        return false;
    }

    // tests whether the player has won or not
    private boolean hasWon(CellValue.cellValue cellValue)
    {
        return (board[row][0] == cellValue && board[row][1] == cellValue && board[row][2] == cellValue || // check horizontally
                board[0][column] == cellValue && board[1][column] == cellValue && board[2][column] == cellValue || // check vertically
                board[0][0] == cellValue && board[1][1] == cellValue && board[2][2] == cellValue || // check diagonally from (0, 0)
                board[2][0] == cellValue && board[1][1] == cellValue && board[0][2] == cellValue); // check diagonally form (2, 0)
    }

    // tests whether the game is a draw or not
    private boolean isDraw()
    {
        if (count == 9 && hasWon(cross) == false)// when all the moves have been made and the last player to move hasn't won
            return true; // then true is returned
        else
            return false;
    }


    public void setRow(int row) {
        this.row = row;
    }


    public void setColumn(int column) {
        this.column = column;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }
}
