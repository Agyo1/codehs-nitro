import java.util.*;

public class CarTester
{
    public static void main(String[] args)
    {
        // Start here
        ArrayList<Car> list = new ArrayList<Car>();

        System.out.println("Please enter a car model name(exit to quit): ");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        while (!name.equalsIgnoreCase("exit")) {
            System.out.println("Is this car electric? (y or n) ");
            String electric = input.nextLine();
            if (electric.equalsIgnoreCase("n")) {
                System.out.println("How many miles per gallon: ");
                String mpg = input.nextLine();
                Car car = new Car(name, mpg);
                list.add(car);
            } else {
                ElectricCar eCar = new ElectricCar(name);
                list.add(eCar);
            }
            System.out.println("Please enter a car model name(exit to quit): ");
            name = input.nextLine();
        }
        for (Car car : list) {
            System.out.println("Car: " + car.getModel());
            System.out.println("MPG: " + car.getMPG() + "\n");
        }
    }
}