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
    private ArrayList<Car> allCars = new ArrayList<>();
    private Salesman salesmanInUse;
    private boolean exitApp = false;
    private Scanner scan = new Scanner(System.in);

    private void generateSalesmas() {
        salesmens.add(new Salesman("Gigi", "Muschi", "user1", "1234"));
        salesmens.add(new Salesman("Ion", "Ion", "user2", "4321"));
        salesmens.add(new Salesman("Vasile", "Vrajitorul", "user3", "1111"));
    }

    private void generateCars() {
        allCars.add(new LoganStandard("123", ColorType.BLACK, GearBoxType.MANUAL, 2015, new BigDecimal(10000)));
        allCars.add(new LoganStandard("234", ColorType.WHITE, GearBoxType.AUTOMATIC, 2018, new BigDecimal(15000)));
        allCars.add(new LoganStandard("345", ColorType.RED, GearBoxType.MANUAL, 2016, new BigDecimal(11000)));
        allCars.add(new LoganStandard("111", ColorType.DARKBLUE, GearBoxType.MANUAL, 2011, new BigDecimal(5000)));
        allCars.add(new LoganStandard("222", ColorType.SILVER, GearBoxType.MANUAL, 2012, new BigDecimal(6000)));
        allCars.get(1).setIsCarRented(true);
        allCars.get(4).setIsCarRented(true);
    }

    private boolean login(String username, String password) {
        // TODO: implement a basic user login
        for (Salesman salesman : salesmens) {
            if (username.equals(salesman.getUsername()) && password.equals(salesman.getPassword())) {
                System.out.println(username + " successfully logged in.");
                salesmanInUse = salesman;
                salesmanInUse.setLoggedIn(true);
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

    private void logOut() {
        salesmanInUse.setLoggedIn(false);
        System.out.println("Successfully logged out.");
    }

    private void setExitApp (boolean exitApp) {
        this.exitApp = exitApp;
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

    private void anwerMenu () {
        String answer = scan.nextLine();
        switch (answer) {
            case "1":
                listAllCarsFromAList(allCars);
                showListMenuOptions();
                break;
            case "2":
                listAvailableCars();
                showListMenuOptions();
                break;
            case "3":
                listRentedCars();
                showListMenuOptions();
                break;
            case "4":
                System.out.println("Checking income.");
                break;
            case "5":
                logOut();
                break;
            case "6":
                setExitApp(true);
                break;
            default:
                System.out.println("Incorrect input, try again.");
        }
    }

    private void listAvailableCars() {
        ArrayList<Car> availableCars = new ArrayList<>();
        for(Car car : allCars) {
            if(car.getCarRented()) {
                availableCars.add(car);
            }
        }
        listAllCarsFromAList(availableCars);
    }

    private void listRentedCars() {
        ArrayList<Car> rentedCars = new ArrayList<>();
        for(Car car : allCars) {
            if(!car.getCarRented()) {
                rentedCars.add(car);
            }
        }
        listAllCarsFromAList(rentedCars);
    }

    private void listAllCarsFromAList(ArrayList<Car> cars) {
        listCarsFrame();
        for (Car car : cars) {
            car.showCar();
            System.out.println();
        }
    }

    private void listCarsFrame() {
        int maxStringSize = 14;
        ArrayList<String> args = new ArrayList<>();
        args.add("ChassisNo");
        args.add("Make");
        args.add("Model");
        args.add("Engine Model");
        args.add("Fuel");
        args.add("Body");
        args.add("Doors");
        args.add("Gearbox");
        args.add("Year");
        args.add("Rented");
        args.add("Price");
        for (String str : args) {
            if (maxStringSize > str.length()) {
                String emptySpace = "";
                for (int i = 0; i < maxStringSize - str.length(); i++) {
                    emptySpace = emptySpace + " ";
                }
                System.out.printf("%s" + emptySpace, str);
            } else {
                System.out.printf("%s", str);
            }
        }
        System.out.println();
    }

    private void showListMenuOptions() {

        System.out.println("Select an action from below:");
        System.out.println("1. Filter by make");
        System.out.println("2. Filter by model");
        System.out.println("3. Filter by budget");
        // TODO: add additional filter methods based on car specs

        System.out.println("4. Back to previous menu");
        answerListMenuOptions();
    }

    private void answerListMenuOptions() {
        String answer = scan.nextLine();
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
        do {
            loginMenu();
            do {
                showMenu();
                anwerMenu();
            } while (salesmanInUse.getLoggedIn() && !exitApp);
        }while (!exitApp);
    }
}
