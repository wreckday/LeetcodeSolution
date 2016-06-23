import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 Design a Snake game that is played on a device with screen size = width col height. Play the game online if you are not familiar with the game.

 The snake is initially positioned at the top left corner (0,0) with length = 1 unit.

 You are given a list of food's positions in row-column order. When a snake eats the food, its length and the game's score both increase by 1.

 Each food appears one by one on the screen. For example, the second food will not appear until the first food was eaten by the snake.

 When a food does appear on the screen, it is guaranteed that it will not appear on a block occupied by the snake.

 Example:
 Given width = 3, height = 2, and food = [[1,2],[0,1]].

 Snake snake = new Snake(width, height, food);

 Initially the snake appears at position (0,0) and the food at (1,2).

 |S| | |
 | | |F|

 snake.move("R"); -> Returns 0

 | |S| |
 | | |F|

 snake.move("D"); -> Returns 0

 | | | |
 | |S|F|

 snake.move("R"); -> Returns 1 (Snake eats the first food and right after that, the second food appears at (0,1) )

 | |F| |
 | |S|S|

 snake.move("U"); -> Returns 1

 | |F|S|
 | | |S|

 snake.move("L"); -> Returns 2 (Snake eats the second food)

 | |S|S|
 | | |S|

 snake.move("U"); -> Returns -1 (Game over because snake collides with border)

 *
 *
 * Created by Mellon on 6/8/16.
 */
class SnakeGame {
    int width;
    int height;
    int col;
    int row;
    int[][] food;
    List<List<Integer>> body;
    int foodIndex;
    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        body = new ArrayList<>();
        body.add(Arrays.asList(0, 0));
        col =0;
        row =0;
        this.width = width;
        this.height = height;
        this.food = food;
        this.foodIndex=0;
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        switch (direction){
            case "R": col++;
                break;
            case "L": col--;
                break;
            case "U": row--;
                break;
            case "D": row++;
                break;
        }

        if(isValid()){
            body.add(0, Arrays.asList(col, row));
            if(foodIndex<food.length && row ==food[foodIndex][0] && col ==food[foodIndex][1]){
                foodIndex=foodIndex+1;
            }else {
                body.remove(body.size()-1);
            }
        } else
            return -1;
        return foodIndex;
    }

    private boolean isValid(){
        if(col <0|| row <0|| col >=width|| row >=height)
            return false;
        // check head to body is not valid except to tail
        for(int i=0;i<body.size()-1;i++){
            if(col ==body.get(i).get(0)&& row ==body.get(i).get(1))
                return false;
        }
        return true;
    }
}

public class L353_SnakeGame {

    public static void main(String[] args){
//        int width = 3, height = 2;
//        int[][] food = {{1, 2}, {0, 1}};
//        SnakeGame snake = new SnakeGame(width, height, food);
//        System.out.println(snake.move("R"));
//        System.out.println(snake.move("D"));
//        System.out.println(snake.move("R"));
//        System.out.println(snake.move("U"));
//        System.out.println(snake.move("L"));
//        System.out.println(snake.move("U"));

        int width = 3, height = 3;
        int[][] food = {{2, 0},{0, 0}, {0, 2}, {0, 1}, {2, 2}, {0, 1}};
        SnakeGame snake = new SnakeGame(width, height, food);
        System.out.println("1: "+snake.move("D"));
        System.out.println("2: "+snake.move("D"));
        System.out.println("3: "+snake.move("R"));
        System.out.println("4: "+snake.move("U"));
        System.out.println("5: "+snake.move("U"));
        System.out.println("6: "+snake.move("L"));
        System.out.println("7: "+snake.move("D"));
        System.out.println("8: "+snake.move("R"));

        System.out.println("9: "+snake.move("R"));
        System.out.println("10: "+snake.move("U"));
        System.out.println("11: "+snake.move("L"));
        System.out.println("12: "+snake.move("L"));

        System.out.println("10: "+snake.move("D"));
        System.out.println("11: "+snake.move("R"));
        System.out.println("12: "+snake.move("U"));
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */