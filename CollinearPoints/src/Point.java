import java.util.*;
import edu.princeton.cs.algs4.StdDraw;

public class Point implements Comparable<Point> {

    private final int x;     // x-coordinate of this point
    private final int y;     // y-coordinate of this point

    public Point(int x, int y) { // constructs the point (x,y)
        this.x = x;
        this.y = y;
    }

    public void draw() { // draws the point
        for (int i = -50; i <= 50; i++) {
            for (int j = -50; j <= 50; j++) {
                StdDraw.point(x+i, y+j);
            }
        }
    }

    public void drawTo(Point that) { // draws the line segment from this point to that point
        StdDraw.line(this.x, this.y, that.x, that.y);
    }


    public int compareTo(Point that) { // comparing y-coordinates, if tied than x-coordinate breaks it
        if(y  > that.y){
            return 1;
        }
        else if(y == that.y){
            if (x > that.x){
                return 1;
            }
            return -1;
        }
        else {
            return -1;
        }
    }

    public double slopeTo(Point that) { // the slope between this point and that point
        if(x==that.x){
            if(y==that.y){
                return Double.NEGATIVE_INFINITY; // if (x0,y0) and (x,y) are equal
            }
            return Double.POSITIVE_INFINITY; // if vertical
        }
        else if(y==that.y){
            return 0; // if the line is horizontal
        }
        return ((that.y - y) / (that.x - x)); // slope point form
    }

    public Comparator<Point> slopeOrder() { // using slope order compares two points by slopes
        return new SlopeOrder();
    }

    /* if this doesn't work change line 63 and 64 to p.slopeTo(a) and p.slopeTo(b)
    this requires:
    public ____ (Point P){
        this.p = p;
    }
     */

    private class SlopeOrder implements Comparator<Point>{
        public int compare(Point a, Point b){
            double slopeToA = slopeTo(a);
            double slopeToB = slopeTo(b);
            if (slopeToA < slopeToB) return -1; // maybe change the if statement to slopeToA - slopeToB < 0
            if (slopeToB < slopeToA) return 1; // maybe change the if statement to slopeToB - slopeToA < 0
            return 0;
        }

    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
    public static void main(String[] args) {
        Point a = new Point(3,5);
        Point b = new Point(6,10);
        Point c = new Point(3,15);
        Comparator<Point> comp = c.slopeOrder();
        System.out.println(comp.compare(a,b));
    }
}
