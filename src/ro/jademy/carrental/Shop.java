package ro.jademy.carrental;

import ro.jademy.carrental.cars.Car;
import ro.jademy.carrental.cars.components.body.ColorType;
import ro.jademy.carrental.cars.components.gearbox.GearBoxType;
import ro.jademy.carrental.cars.dacia.LoganStandard;
import ro.jademy.carrental.persons.Salesman;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
    private ArrayList<Salesman> salesmens = new ArrayList<>();
    private ArrayList<Car> availableCars = new ArrayList<>();
    private ArrayList<Car> rentedCars = new ArrayList<>();
    private Scanner scan = new Scanner(System.in);

    private void generateSalesmas() {
        salesmens.add(new Salesman("Gigi", "Muschi", "user1", "1234"));
        salesmens.add(new Salesman("Ion", "Ion", "user2", "4321"));
        salesmens.add(new Salesman("Vasile", "Vrajitorul", "user3", "1111"));
    }

    private void generateCars() {
        availableCars.add(new LoganStandard("123", ColorType.BLACK, GearBoxType.MANUAL, 2015, new BigDecimal(1000)));
        availableCars.add(new LoganStandard("234", ColorType.WHITE, GearBoxType.AUTOMATIC, 2018, new BigDecimal(1000)));
        availableCars.add(new LoganStandard("345", ColorType.RED, GearBoxType.MANUAL, 2016, new BigDecimal(1000)));
    }

    private boolean login(String username, String password) {
        // TODO: implement a basic user login
        for (Salesman salesman : salesmens) {
            if (username.equals(salesman.getUsername()) && password.equals(salesman.getPassword())) {
                System.out.println(username + " successfully logged in.");
                return true;
            }
        }
        System.out.println("Wrong username or password , try again.");
        return false;
    }

    private void loginMenu() {
        boolean loginSuccessfull;
        do {
            System.out.println("Username:");
            String username = scan.nextLine();
            System.out.println("Password:");
            String password = scan.nextLine();
            loginSuccessfull = login(username, password);
        } while (!loginSuccessfull);
    }

    private void showMenu() {

        System.out.println(" -----------------------------------------------");
        System.out.println("|    Welcome to the Jademy Car Rental Service   |");
        System.out.println(" -----------------------------------------------");
        System.out.println();
        System.out.println("                    MAIN MENU                   ");
        System.out.println("1. List all cars");
        System.out.println("2. List available cars");
        System.out.println("3. List rented cars");
        System.out.println("4. Check income");
        System.out.println("5. Logout");
        System.out.println("6. Exit");
    }

    private void listAllCars() {
        for (Car car : availableCars) {
            car.showCar();
            System.out.println();
        }
    }

    private void listMenuFrame() {

    }

    private void showListMenuOptions() {

        System.out.println("Select an action from below:");
        System.out.println("1. Filter by make");
        System.out.println("2. Filter by model");
        System.out.println("3. Filter by budget");
        // TODO: add additional filter methods based on car specs

        System.out.println("4. Back to previous menu");

    }

    private void calculatePrice(int numberOfDays) {
        // TODO: apply a discount to the base price of a car based on the number of rental days
        // TODO: document the implemented discount algorithm

        // TODO: for a more difficult algorithm, change this method to include date intervals and take into account
        //       weekdays and national holidays in which the discount should be smaller

        // Q: what should be the return type of this method?
    }

    public void run() {
        generateSalesmas();
        generateCars();
        loginMenu();
        showMenu();
        listAllCars();
}
}
