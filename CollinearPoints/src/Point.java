import java.util.*;
import edu.princeton.cs.algs4.StdDraw;

public class Point implements Comparable<Point> {

    private final int x;     // x-coordinate of this point
    private final int y;     // y-coordinate of this point

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw() {
        for (int i = -50; i <= 50; i++) {
            for (int j = -50; j <= 50; j++) {
                StdDraw.point(x+i, y+j);
            }
        }
    }

    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    public double slopeTo(Point that) {
        if(x==that.x){
            if(y==that.y){
                return Double.NEGATIVE_INFINITY;
            }
            return Double.POSITIVE_INFINITY;
        }
        else if(y==that.y){
            return 0;
        }
        return ((that.y - y) / (that.x - x));
    }

    public int compareTo(Point that) {
        /* YOUR CODE HERE */
    }

    public Comparator<Point> slopeOrder() {
        /* YOUR CODE HERE */
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}