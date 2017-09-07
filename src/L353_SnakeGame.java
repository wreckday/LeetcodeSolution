import java.util.*;

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

/*
这道题让我们设计一个贪吃蛇的游戏，这是个简化版的，但是游戏规则还是保持不变，蛇可以往上下左右四个方向走，吃到食物就会变长1个，
如果碰到墙壁或者自己的躯体，游戏就会结束。我们需要一个一维数组来保存蛇身的位置，由于蛇移动的过程的蛇头向前走一步，蛇尾也跟着往前，
中间的躯体还在原来的位置，所以移动的结果就是，蛇头变到新位置，去掉蛇尾的位置即可
* */
class SnakeGame {
    //2D position info is encoded to 1D and stored as two copies
    Set<Integer> set; // this copy is good for fast loop-up for eating body case
    Deque<Integer> body; // this copy is good for updating tail
    int score;
    int[][] food;
    int foodIndex;
    int width;
    int height;

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        set = new HashSet<>();
        set.add(0); //intially at [0][0]
        body = new LinkedList<>();
        body.offerLast(0);
    }

    public int move(String direction) {
        //case 0: game already over: do nothing
        if (score == -1) {
            return -1;
        }

        // compute new head
        int rowHead = body.peekFirst() / width;
        int colHead = body.peekFirst() % width;
        switch (direction) {
            case "U" : rowHead--;
                break;
            case "D" : rowHead++;
                break;
            case "L" : colHead--;
                break;
            default :  colHead++;
        }
        int head = rowHead * width + colHead;

        //case 1: out of boundary or eating body
        set.remove(body.peekLast()); // new head is legal to be in old tail's position, remove from set temporarily
        if (rowHead < 0 || rowHead == height || colHead < 0 || colHead == width || set.contains(head)) {
            return score = -1;
        }

        // add head for case2 and case3
        set.add(head);
        body.offerFirst(head);

        //case2: eating food, keep tail, add head
        if (foodIndex < food.length && rowHead == food[foodIndex][0] && colHead == food[foodIndex][1]) {
            set.add(body.peekLast()); // old tail does not change, so add it back to set
            foodIndex++;
            return ++score;
        }

        //case3: normal move, remove tail, add head
        body.pollLast();
        return score;
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