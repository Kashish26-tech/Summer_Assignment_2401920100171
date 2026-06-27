// Q1 - Interface
interface Test {
    int square(int n);
}

class Arithmetic implements Test {
    public int square(int n) {
        return n * n;
    }
}

// Q2 - Outer and Inner Class
class Outer {
    void display() {
        System.out.println("Display method of Outer class");
    }

    class Inner {
        void display() {
            System.out.println("Display method of Inner class");
        }
    }
}

// Q3 - Point Class
class Point {
    private int x, y;

    public Point() {
        x = 0;
        y = 0;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void display() {
        System.out.println("Point = (" + x + ", " + y + ")");
    }
}

// Q4 - Box and Box3D
class Box {
    int length, breadth;

    Box(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    int area() {
        return length * breadth;
    }
}

class Box3D extends Box {
    int height;

    Box3D(int length, int breadth, int height) {
        super(length, breadth);
        this.height = height;
    }

    int volume() {
        return length * breadth * height;
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {

        // Q1
        System.out.println("Q1:");
        Arithmetic a = new Arithmetic();
        System.out.println("Square of 5 = " + a.square(5));

        // Q2
        System.out.println("\nQ2:");
        Outer out = new Outer();
        out.display();
        Outer.Inner in = out.new Inner();
        in.display();

        // Q3
        System.out.println("\nQ3:");
        Point p = new Point();
        p.display();
        p.setXY(10, 20);
        p.display();

        // Q4
        System.out.println("\nQ4:");
        Box3D b = new Box3D(10, 5, 4);
        System.out.println("Area = " + b.area());
        System.out.println("Volume = " + b.volume());
    }
}
