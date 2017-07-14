/**
 * Design a Tic-tac-toe game that is played between two players on a n col n grid.

 You may assume the following rules:

 A move is guaranteed to be valid and is placed on an empty block.
 Once a winning condition is reached, no more moves is allowed.
 A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.


 Given n = 3, assume that player 1 is "X" and player 2 is "O" in the board.

 TicTacToe toe = new TicTacToe(3);

 toe.move(0, 0, 1); -> Returns 0 (no one wins)
 |X| | |
 | | | |    // Player 1 makes a move at (0, 0).
 | | | |

 toe.move(0, 2, 2); -> Returns 0 (no one wins)
 |X| |O|
 | | | |    // Player 2 makes a move at (0, 2).
 | | | |

 toe.move(2, 2, 1); -> Returns 0 (no one wins)
 |X| |O|
 | | | |    // Player 1 makes a move at (2, 2).
 | | |X|

 toe.move(1, 1, 2); -> Returns 0 (no one wins)
 |X| |O|
 | |O| |    // Player 2 makes a move at (1, 1).
 | | |X|

 toe.move(2, 0, 1); -> Returns 0 (no one wins)
 |X| |O|
 | |O| |    // Player 1 makes a move at (2, 0).
 |X| |X|

 toe.move(1, 0, 2); -> Returns 0 (no one wins)
 |X| |O|
 |O|O| |    // Player 2 makes a move at (1, 0).
 |X| |X|

 toe.move(2, 1, 1); -> Returns 1 (player 1 wins)
 |X| |O|
 |O|O| |    // Player 1 makes a move at (2, 1).
 |X|X|X|


 * Created by Mellon on 5/17/16.
 */
//Java O(1) solution
class TicTacToe {
    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;

    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
    }

    public int move(int row, int col, int player) {
        int toAdd = player == 1 ? 1 : -1;

        rows[row] += toAdd;
        cols[col] += toAdd;
        if (row == col) {
            diagonal += toAdd;
        }

        if (col == (cols.length - row - 1)) {
            antiDiagonal += toAdd;
        }

        int size = rows.length;
        if (Math.abs(rows[row]) == size ||
                Math.abs(cols[col]) == size ||
                Math.abs(diagonal) == size ||
                Math.abs(antiDiagonal) == size) {
            return player;
        }

        return 0;

    }
}


public class L348_DesignTic_Tac_Toe {
    public static void main(String[] args) {
//        TicTacToe toe = new TicTacToe(3);
//        System.out.println(toe.move(0, 0, 1));
//        System.out.println(toe.move(0, 2, 2));
//        System.out.println(toe.move(2, 2, 1));
//        System.out.println(toe.move(1, 1, 2));
//        System.out.println(toe.move(2, 0, 1));
//        System.out.println(toe.move(1, 0, 2));
//        System.out.println(toe.move(2, 1, 1));


        TicTacToe toe = new TicTacToe(2);
        System.out.println(toe.move(0, 0, 2));
        System.out.println(toe.move(0, 1, 1));
        System.out.println(toe.move(1, 1, 2));
    }
}

