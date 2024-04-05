import java.util.*;

public class AssignmentRunner {

    public static void main(String[] args) {

        // Start here
        Scanner input = new Scanner(System.in);

        ArrayList<Assignment> list = new ArrayList<Assignment>();
        System.out.println("Please enter an assignment name (exit to quit): ");
        String name = input.nextLine();
        while (!name.equalsIgnoreCase("exit")) {
            System.out.println("Please enter the available points: ");
            double availablePoints = input.nextDouble();
            input.nextLine();
            System.out.println("Please enter the earned points: ");
            double earnedPoints = input.nextDouble();
            input.nextLine();
            System.out.println("Is this a (t)est or (p)roject: ");
            String testOrProject = input.nextLine();
            if (testOrProject.equalsIgnoreCase("t")) {
                System.out.println("Please enter the test date: ");
                String testDate = input.nextLine();
                Test test = new Test(name, availablePoints, earnedPoints, testDate);
                list.add(test);
            } else if (testOrProject.equalsIgnoreCase("p")) {
                System.out.println("Please enter the due date: ");
                String projectDate = input.nextLine();
                System.out.println("Group project? true or false: ");
                boolean groups = input.nextBoolean();
                input.nextLine();
                Project project = new Project(name, availablePoints, earnedPoints, projectDate, groups);
                list.add(project);
            }
            System.out.println("Please enter an assignment name (exit to quit): ");
            name = input.nextLine();
        } 
        System.out.println("Your average: " + average(list));
    }

    public static double average(ArrayList<Assignment> assignments) {
        double earned = 0;
        double available = 0;
       for (int i = 0; i < assignments.size(); i++) {
           earned += assignments.get(i).getEarnedPoints();
           available += assignments.get(i).getAvailablePoints();
       }
       return (earned / available) * 100;
    }
}