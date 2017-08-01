package geometry;


public class LinesIntersection {

    final double EPS = 1e-6;

    class Point {
        double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public Point(Point a, Point b) {
            x = b.x - a.x;
            y = b.y - a.y;
        }

        double length() {
            return Math.sqrt(x * x + y * y );
        }

        void normalize() {
            double coef = length();
            x /= coef;
            y /= coef;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    class Line {
        double a, b, c;

        public Line(Point a, Point b) {
            this.a = b.y - a.y;
            this.b = a.x - b.x;
            this.c = -(this.a * a.x + this.b * a.y);
        }

        public Line(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        double dist(Point p) {
            return a * p.x + b * p.y + c;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            } else if (!(other instanceof Line)) {
                return false;
            } else {
                Line otherLine = (Line) other;
                return  Math.abs(det(this.a, this.b, otherLine.a, otherLine.b)) < EPS &&
                        Math.abs(det(this.a, this.c, otherLine.a, otherLine.c)) < EPS &&
                        Math.abs(det(this.b, this.c, otherLine.b, otherLine.c)) < EPS;
            }
        }

        @Override
        public String toString() {
            return "Line:{" +
                    a + "a + " +
                    b + "b + " +
                    c + " = 0}";
        }
    }

    double det(double a, double b, double c, double d) {
        return a*d - b*c;
    }

    Point linesIntersection(Line l1, Line l2) {
        double d = det(l1.a, l1.b, l2.a, l2.b);

        if (Math.abs(d) < EPS) {
            return null;
        }

        double x = -det(l1.c, l1.b, l2.c, l2.b) / d;
        double y = -det(l1.a, l1.c, l2.a, l2.c) / d;

        return new Point(x, y);
    }

    boolean isLinesParaller(Line l1, Line l2) {
        return Math.abs(det(l1.a, l1.b, l2.a, l2.b)) < EPS;
    }

    void test() {
        Point p1 = new Point(10, 10);
        Point p2 = new Point(1,1);
        Point p3 = new Point(2, 0);

        Line l1 = new Line(p1, p2);
        Line l2 = new Line(p2, p3);

        System.out.println(linesIntersection(l1, l2));

        Line l4 = new Line(new Point(0,0), new Point(2, 2));
        System.out.println(isLinesParaller(l1, l4));
        System.out.println(l1.equals(l4));

    }

    public static void main(String[] args) {
        new LinesIntersection().test();
    }

}
