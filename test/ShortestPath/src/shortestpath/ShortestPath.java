/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package shortestpath;
/**
 *
 * @author Bryan M
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class ShortestPath {

static int game[][], helper[][];
static Queue <Point> move = new LinkedList<Point>();
static int n;

static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {

    n = grid.length;
    game = new int[n][n];
    helper = new int[n][n];

    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(grid[i].charAt(j) == '.')
                game[i][j] = 100;
            else game[i][j] = -1;
        }
    }

    Point start = new Point(startX, startY);
    move.add(start);
    game[startX][startY] = 0;
    while(!move.isEmpty()){
        Point current = move.remove();
        if(helper[current.x][current.y] == 0){
            helper[current.x][current.y] = 1;
            moveGenerator(current);
        }
    }

    return game[goalX][goalY];

}

public static void moveGenerator(Point p){

    int x = p.x;
    int y = p.y;
    int value = game[x][y];
    for(int i=x; i<n && game[i][y]!=-1;i++){
        addStep(i,y,value);
        move.add(new Point(i,y));
    }
    for(int i=x; i>=0 && game[i][y]!=-1;i--){
        addStep(i,y,value);
        move.add(new Point(i,y));
    }
    for(int i=y; i<n && game[x][i]!=-1;i++){
        addStep(x,i,value);
        move.add(new Point(x,i));
    }
    for(int i=y; i>=0 && game[x][i]!=-1;i--){
        addStep(x,i,value);
        move.add(new Point(x,i));
    }
}

public static void addStep(int x, int y, int value){

    if(game[x][y] > value+1)
            game[x][y] = value+1;
}

public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    String[] grid = new String[n];
    for(int grid_i = 0; grid_i < n; grid_i++){
        grid[grid_i] = in.next();
    }
    int startX = in.nextInt();
    int startY = in.nextInt();
    int goalX = in.nextInt();
    int goalY = in.nextInt();
    int result = minimumMoves(grid, startX, startY, goalX, goalY);
    System.out.println(result);
    in.close();
}

}

class Point{

int x,y;

Point(int x,int y){
    this.x = x;
    this.y = y;
}

}