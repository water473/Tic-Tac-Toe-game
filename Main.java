import java.util.Scanner;
public class Main {
    public static char[][] board = new char[3][3];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                board[i][j] = ' ';
            }
        }
        System.out.println();
        System.out.println("This is the game of Tic Tac Toe");
        System.out.println("You will be playing against the computer");
        System.out.println();
        printBoard();


        boolean gameWon = false;
        while(!gameWon){

            playerTurn();
            System.out.println();
            System.out.println();
            if(checkWinner()){
                System.out.println("YOU WIN!!!!!!!!!!");
                printBoard();
                break;
            }

            if(checkDraw()){
                System.out.println("DRAW :(");
                break;
            }

            System.out.println();
            computerMove();
            printBoard();
            if(checkWinner()){
                System.out.println("YOU LOSE !!!!!!!");
                break;
            }

            if(checkDraw()){
                System.out.println("DRAW :(");
                break;
            }

        }
    }

    public static void playerTurn(){
        Scanner sc = new Scanner(System.in);
        int x = 0;
        int y = 0;
        boolean valid = false;
        boolean validOnBoard = false;
        while(!validOnBoard){
            while(!valid){
                System.out.println("Enter X coordinate for your move: ");
                x = sc.nextInt();
                System.out.println("Enter Y coordinate for your move: ");
                y = sc.nextInt();
                if(x<=3 && x>=1 && y<=3 && y>=1){
                    valid = true;
                    break;
                }
                System.out.println("Invalid coordinates! Make sure x and y is <=3 and >=1");
            }
            if(!checkBoard(x, y)){
                System.out.println("This move has already been made!");
                valid = false;
            }
            else{
                validOnBoard = true;
            }
        }

        board[x-1][y-1] = 'X';
        System.out.println();
    }

    public static void computerMove(){
        boolean valid = false;
        while(!valid){
            int x = (int)(Math.random()*3)+0;
            int y = (int)(Math.random()*3)+0;
            if(checkBoard(x+1, y+1)){
                board[x][y] = 'O';
                valid = true;
            }
        }
    }

    public static boolean checkBoard(int x, int y){
        if(board[x-1][y-1] == 'X' || board[x-1][y-1] == 'O'){
            return false;
        }
        return true;
    }

    public static boolean checkDraw(){
        for(char[] x: board){
            for(char y: x){
                if (y == ' '){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkWinner(){
        if(board[0][0] == board[0][1] && board[0][1] == board[0][2] && (board[0][0] == 'X' || board[0][0] == 'O')){
            return true;
        }
        if(board[1][0] == board[1][1] && board[1][1] == board[1][2] && (board[1][0] == 'X' || board[1][0] == 'O')){
            return true;
        }
        if(board[2][0] == board[2][1] && board[2][1] == board[2][2] && (board[2][0] == 'X' || board[2][0] == 'O')){
            return true;
        }
        if(board[0][0] == board[1][0] && board[1][0] == board[2][0] && (board[0][0] == 'X' || board[0][0] == 'O')){
            return true;
        }
        if(board[0][1] == board[1][1] && board[1][1] == board[2][1] && (board[0][1] == 'X' || board[0][1] == 'O')){
            return true;
        }
        if(board[0][2] == board[1][2] && board[1][2] == board[2][2] && (board[0][2] == 'X' || board[0][2] == 'O')){
            return true;
        }
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && (board[0][0] == 'X' || board[0][0] == 'O')){
            return true;
        }
        if(board[0][2] == board[1][1] && board[1][1] == board[2][0] && (board[0][2] == 'X' || board[0][2] == 'O')){
            return true;
        }
        return false;
    }
    public static void printBoard(){
        System.out.println("   1   2   3");
        System.out.println("1|" + board[0][0] + "\t | " + board[0][1] + "  | " + board[0][2]);
        System.out.println("--------------");
        System.out.println("2|" + board[1][0] + "\t | " + board[1][1] + "  | " + board[1][2]);
        System.out.println("--------------");
        System.out.println("3|" + board[2][0] + "\t | " + board[2][1] + "  | " + board[2][2]);
    }
}
