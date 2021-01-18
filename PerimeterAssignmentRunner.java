import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int count = 0;
        for (Point currPt : s.getPoints()){
            count++;
        }
        return count;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double totalP = getPerimeter(s);
        double count = getNumPoints(s);
      
        return totalP/count;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double largest=0.0;
        Point prevPoint = s.getLastPoint();
        for (Point currPt : s.getPoints()){
            double currdistance = prevPoint.distance(currPt);
            if (currdistance > largest)
                largest = currdistance;
            prevPoint = currPt;
        }
        return largest;
    }

    public double getLargestX(Shape s) {
        double largestX = 0.0;
        
        for (Point currPt : s.getPoints()){
            int currX = currPt.getX();
            if (currX > largestX){
                largestX = currX;
            }
        }
        
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double largestPerim = 0.0;
        DirectoryResource dr = new DirectoryResource();
        FileResource fr = null;
        for (File f : dr.selectedFiles()) {
            FileResource file = new FileResource(f);
            Shape s = new Shape(file);
            double currPerim = getPerimeter(s);
            if (currPerim > largestPerim){
                largestPerim = currPerim;
            }
    }
        return largestPerim;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double largestPerim = 0.0;
        File largestFile = null;    // replace this code
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currPerim = getPerimeter(s);
            if (currPerim > largestPerim){
                largestPerim = currPerim;
                largestFile = f;
            }
        }
        return largestFile.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int count = getNumPoints(s);
        double averageL = getAverageLength(s);
        double largest = getLargestSide(s);
        double largestX = getLargestX(s);
        System.out.println("START----------------------");
        System.out.println("perimeter = " + length);
        System.out.println("number of points = " + count);
        System.out.println("average length = " + averageL);
        System.out.println("largest side = " + largest);
        System.out.println("largest x = " + largestX);
        System.out.println("Code ran with no errors----------------------");
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double LargestPerim = getLargestPerimeterMultipleFiles();
        System.out.println("largest perim " + LargestPerim);
        
    }

    public void testFileWithLargestPerimeter() {
        // Put code here

        String file = getFileWithLargestPerimeter();
        System.out.println("largest file: "+ file);
        
        
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        //pr.getLargestPerimeterMultipleFiles();
        //pr.getFileWithLargestPerimeter();
        //pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
        
    }
}
