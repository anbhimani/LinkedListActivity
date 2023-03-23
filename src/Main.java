import org.junit.Assert;
import org.junit.ComparisonFailure;

public class Main {
    private static int score = 0;
    private static int tests = 0;

    public static void main(String[] args) {
        CustomLinkedList mt = new CustomLinkedList();

        // Insertion and toString
        mt.addNode(5);
        mt.addNode(7);
        mt.addNode(10);
        check("Insertion and toString", "5, 7, 10", mt.toString());

        // Mid-point insertion
        mt.addToPos(1, 22);
        check("Mid-point insertion", "5, 22, 7, 10", mt.toString());

        // Tail insertion
        mt.addToPos(3, 50);
        check("Tail insertion", "5, 22, 7, 50, 10", mt.toString());

        // Head insertion
        mt.addToHead(1);
        check("Head insertion", "1, 5, 22, 7, 50, 10", mt.toString());

        // Check reverse output
        check("Reverse output", "10, 50, 7, 22, 5, 1", mt.reverseOutput());

        // Check mid-point deletion
        mt.delete(7);
        check("Mid-point deletion", "1, 5, 22, 50, 10", mt.toString());

        // Head deletion
        mt.delete(1);
        check("Head deletion", "5, 22, 50, 10", mt.toString());

        // Tail deletion
        mt.delete(10);
        check("Tail deletion", "5, 22, 50", mt.toString());

        // Insertion and toString test 2
        mt.addNode(33);
        mt.addNode(44);
        mt.addNode(77);
        mt.changeData(50,100);
        check("Mid-point change", "5, 22, 100, 33, 44, 77", mt.toString());

        mt.changeData(5,6);
        check("Head change", "6, 22, 100, 33, 44, 77", mt.toString());

        mt.changeData(77,88);
        check("Tail change", "6, 22, 100, 33, 44, 88", mt.toString());

        check("Insertion and toString test 2", "6, 22, 100, 33, 44, 88", mt.toString());

        // Check reverse output 2
        check("Reverse output test 2", "88, 44, 33, 100, 22, 6", mt.reverseOutput());


        System.out.println("\nFinal Score:" + score + "/" + tests);
    }

    public static void check(String test, String expected, String actual){
        tests += 1;
        try {
            Assert.assertEquals(expected, actual);
            System.out.println("✓   " + test + " passed.");
            score += 1;
        }
        catch (ComparisonFailure e){
            System.out.println("x   " + test + " failed.");
        }
    }
}