package geometry;


public class TriangleArea {

     static int triangleArea2(int x1, int y1, int x2, int y2, int x3, int y3) {
         return (x2-x1)*(y3-y1) - (y2-y1)*(x3-x1);
     }

     static double triangleArea(int x1, int y1, int x2, int y2, int x3, int y3) {
         return (double) Math.abs(triangleArea2(x1,y1,x2,y2,x3,y3)) / 2.0;
     }

    public static void main(String[] args) {

        System.out.println(triangleArea2(0,0, 2, 2, 4, 0));

    }

}
