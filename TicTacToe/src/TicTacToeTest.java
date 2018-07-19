import java.util.Scanner;

public class TicTacToeTest
{
    TicTacToe game = new TicTacToe(); // TicTacToe object

    public static void main(String[] args)
    {
        menu();
    }

    private static void printMenu()
    {
        System.out.printf("%4s%n", "TIC-TAC-TOE\n"); // heading
        System.out.printf("%2s%n", "1.Start Game");
        System.out.printf("%2s%n", "2.Rules");
        System.out.printf("%2s%n", "0.Exit");
    }

    private static void menu()
    {
        boolean exit = false;
        Scanner input = new Scanner(System.in);
        TicTacToeTest game = new TicTacToeTest();

        while (!exit)
        {
            printMenu();
            System.out.print("Choice: ");
            int choice = input.nextInt();

            switch (choice)
            {
                case 1:
                    game.playGame();
                    exit = true; // once the game is finished exit
                    break;
                case 2:
                    // rules
                    System.out.println();
                    System.out.println("Player 1 is X and Player 2 is O");
                    System.out.println("Once a player gets 3 X's or 3 O's horizontally, vertically or diagonally then the player wins and the game exits");
                    System.out.println();
                    break;
                case 0:
                    exit = true;
                    break;
                    default:
                        System.out.println("Invalid choice try again");
                        break;
            }
        }
    }

    private void playGame()
    {
        System.out.println();
        game.drawBoard(); // draws an empty board
        game.setTurn(1); // set the turn to 1

        if (game.getTurn() == 1 || game.getTurn() == 2) // turn must be equal to 1 or 2
        {
            while (game.isExit() == false) // keep playing until the game has won or dawn
            {
                game.turnType();
                prompt(); // input row and column

                while (game.isOverlapped() == true) // keeps looping if the space chosen is already filled
                {
                    System.out.println();
                    System.out.println("Illegal move, cannot place an X or an O when the space is filled"); // error message
                    System.out.println("Try again");
                    game.turnType(); // prints the turn type
                    prompt(); // input row and column
                    game.drawBoard(); // draws board
                }

                if (game.isOverlapped() == false) // once isOverlapped is false place X or O and switch the turns
                {
                    game.placeCellValue(); // places X or O in the specified position
                    game.drawBoard(); // draws board
                    game.turn(); // swaps turn
                }

            }
        }
    }

    private void prompt()
    {
        Scanner input = new Scanner(System.in);

        System.out.println("\n" + game.turnType());
        // prompt the user to enter the row and column
        System.out.print("Row: ");
        game.setRow(input.nextInt());
        System.out.print("Column: ");
        game.setColumn(input.nextInt());
    }
}
