package ro.jademy.carrental;

import ro.jademy.carrental.cars.Car;
import ro.jademy.carrental.cars.DisplaysSorted;
import ro.jademy.carrental.cars.components.body.BodyKitType;
import ro.jademy.carrental.cars.components.body.ColorType;
import ro.jademy.carrental.cars.components.engine.FuelType;
import ro.jademy.carrental.cars.components.gearbox.GearBoxType;
import ro.jademy.carrental.cars.manufacturers.dacia.LoganStandard;
import ro.jademy.carrental.cars.manufacturers.opel.AstraH;
import ro.jademy.carrental.cars.manufacturers.opel.AstraK;
import ro.jademy.carrental.cars.specs.CarSpec;
import ro.jademy.carrental.cars.specs.Make;
import ro.jademy.carrental.cars.specs.State;
import ro.jademy.carrental.persons.Customer;
import ro.jademy.carrental.persons.Salesman;
import ro.jademy.carrental.treasury.Treasury;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

import static ro.jademy.carrental.cars.specs.CarSpec.STATE;
import static ro.jademy.carrental.cars.specs.State.*;

public class Shop {
    private ArrayList<Salesman> salesmens = new ArrayList<>();
    private ArrayList<Car> allCars = new ArrayList<>();
    private Salesman salesmanInUse;
    private boolean exitApp = false;
    private Treasury treasury = new Treasury();

    private Scanner scanString = new Scanner(System.in);
    private Scanner scanInt = new Scanner(System.in);

    //------------------- SHOP MEMBERS ----------------------//

    private void generateSalesmas() {
        salesmens.add(new Salesman("Gigi", "Muschi", "user1", "1234"));
        salesmens.add(new Salesman("Ion", "Ion", "user2", "4321"));
        salesmens.add(new Salesman("Vasile", "Vrajitorul", "user3", "1111"));
    }

    private void generateCars() {
        allCars.add(new LoganStandard("123", ColorType.BLACK, GearBoxType.MANUAL, 2015, 1000));
        allCars.add(new LoganStandard("234", ColorType.WHITE, GearBoxType.AUTOMATIC, 2018, 1500));
        allCars.add(new LoganStandard("345", ColorType.RED, GearBoxType.MANUAL, 2016, 1100));
        allCars.add(new LoganStandard("111", ColorType.DARKBLUE, GearBoxType.MANUAL, 2011, 500));
        allCars.add(new LoganStandard("222", ColorType.SILVER, GearBoxType.MANUAL, 2012, 600));
        allCars.add(new AstraK("abc", ColorType.SILVER, GearBoxType.MANUAL, 2017, 2000));
        allCars.add(new AstraK("qwe", ColorType.BLACK, GearBoxType.MANUAL, 2018, 2200));
        allCars.add(new AstraK("zxc", ColorType.YELLOW, GearBoxType.MANUAL, 2016, 1800));
        allCars.add(new AstraK("wer", ColorType.BLUE, GearBoxType.MANUAL, 2018, 2200));
        allCars.add(new AstraK("dsa", ColorType.RED, GearBoxType.MANUAL, 2018, 2200));
        allCars.add(new AstraH("LLL", ColorType.RED, GearBoxType.SWITCHABLE, 2018, 2500));
    }

    //----------------------- LOGIN --------------------------//

    private void loginMenu() {
        boolean loginSuccessfull;
        do {
            System.out.println("Username:");
            String username = scanString.nextLine();
            System.out.println("Password:");
            String password = scanString.nextLine();
            loginSuccessfull = login(username, password);
        } while (!loginSuccessfull);
    }

    private boolean login(String username, String password) {

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

    private void logOut() {
        salesmanInUse.setLoggedIn(false);
        System.out.println("Successfully logged out.");
    }

    //-------------------- MENU FRAMES -----------------------//

    private void showMenu() {

        System.out.println(" -----------------------------------------------");
        System.out.println("|    Welcome to the Jademy Car Rental Service   |");
        System.out.println(" -----------------------------------------------");
        System.out.println();
        System.out.println("                    MAIN MENU                   ");
        System.out.println("1. List cars");
        System.out.println("2. Rent car");
        System.out.println("3. Check car status");
        System.out.println("4. Treasury");
        System.out.println("5. Add/remove car");
        System.out.println("6. Logout");
        System.out.println("7. Exit");
        answerMenu();
    }

    private void showListCarsMenu() {
        System.out.println("                    LIST CARS                   ");
        System.out.println("1. List all cars");
        System.out.println("2. List available cars");
        System.out.println("3. List rented cars");
        System.out.println("4. List service cars");
        System.out.println("5. Main menu");
        answerListCarsMenu();
    }

    private void showSortMenu() {
        System.out.println("\n                   SORT MENU                    ");
        System.out.println("1. Make");
        System.out.println("2. Body");
        System.out.println("3. Budget");
        System.out.println("4. Year");
        System.out.println("5. Fuel");
        System.out.println("6. Transmission");
        System.out.println("7. Back to previous menu\n");
        answerSortMenu();
    }

    private void showSortMake() {
        System.out.println("\n                 SORT BY MAKE                  ");
        List<Make> sortedMakeValues = Make.getSorteddList();
        for (int i = 0; i < sortedMakeValues.size(); i++) {
            System.out.println((i + 1) + ". " + sortedMakeValues.get(i).getName());
        }
        answerSortMake(sortedMakeValues);
        showAfterListing();
    }

    private void showSortModel() {
        System.out.println("\n                SORT BY MODEL                   ");
        System.out.println("1. Sedan");
        System.out.println("2. Coupe");
        System.out.println("3. Hatchback");
        System.out.println("4. Convertible");
        System.out.println("5. Wagon");
        System.out.println("6. SUV");
        answerSortModel();
        showAfterListing();
    }

    private void showSortBudget() {
        System.out.println("\n                SORT BY BUDGET                  ");
        System.out.println("1. Less than 10000");
        System.out.println("2. Between 10000 and 20000");
        System.out.println("3. More than 20000");
        answerSortBudget();
        showAfterListing();
    }

    private void showSortYear() {

        // TODO: ADD CALENDAR
        // MAKE CAR YEAR ATTRIBUTE A DATE?

        answerSortYear();
        showAfterListing();
    }

    private void showSortFuel() {
        System.out.println("\n1. Gasoline");
        System.out.println("2. Diesel");
        System.out.println("3. Electric");
        System.out.println("4. Mix");
        answerSortFuel();
        showAfterListing();
    }

    private void showSortTransmission() {
        System.out.println("\n1. Automatic");
        System.out.println("2. Manual");
        System.out.println("3. Switchable");
        answerSortTransmission();
        showAfterListing();
    }

    private void showAfterListing() {
        System.out.println("1. List cars menu");
        System.out.println("2. Main menu");
        answerAfterListing();
    }

    //------------------- MENU FUNCTIONS ---------------------//

    private void answerMenu() {
        int answer = scanInt.nextInt();
        switch (answer) {
            case 1:
                showListCarsMenu();
                break;
            case 2:
                rentCarMenu();
                break;
            case 3:
                checkCarStatus();
                break;
            case 4:
                showTreasuryMenu();
                break;
            case 5:

                //TODO: ADD/REMOVE CAR FROM SHOP

                break;
            case 6:
                logOut();
                break;
            case 7:
                exitApp(true);
                break;
            default:
                System.out.println("Incorrect input, try again.");
                break;
        }
    }

    private void answerListCarsMenu() {
        String answer = scanString.nextLine();
        switch (answer) {
            case "1":
                listAllCarsFromAList(allCars);
                showSortMenu();
                break;
            case "2":
                filterCars(STATE, AVAILABLE.getName());
                showSortMenu();
                break;
            case "3":
                filterCars(STATE, RENTED.getName());
                showSortMenu();
                break;
            case "4":
                filterCars(STATE, SERVICE.getName());
                break;
            case "5":
                showMenu();
                break;
            default:
                System.out.println("Incorrect input, please try again.");
                answerListCarsMenu();
        }
    }

    private void answerSortMenu() {
        String answer = scanString.nextLine();
        switch (answer) {
            case "1":
                showSortMake();
                break;
            case "2":
                showSortModel();
                break;
            case "3":
                showSortBudget();
                break;
            case "4":
                showSortYear();
                break;
            case "5":
                showSortFuel();
                break;
            case "6":
                showSortTransmission();
                break;
            case "7":
                showListCarsMenu();
                break;
            default:
                System.out.println("Incorrect input, try again.");
                answerSortMenu();
        }
    }

    private void answerSortMake(List<Make> sortedMakeValues) {
        String answer = scanString.nextLine();
        for (int i = 0; i < sortedMakeValues.size(); i++) {
            String j = sortedMakeValues.indexOf(sortedMakeValues.get(i)) + 1 + "";
            if (sortedMakeValues.get(i).getName().equalsIgnoreCase(answer)
                    || sortedMakeValues.get(i).getName().toLowerCase().contains(answer.toLowerCase())
                    || j.equals(answer)) {
                filterCars(CarSpec.MAKE, sortedMakeValues.get(i).getName());
                showSortMenu();
            }
        }
        System.out.println("Incorrect input, try again.");
        answerSortMake(sortedMakeValues);
    }

    private void answerSortModel() {
        String answer = scanString.nextLine();
        switch (answer) {
            case "1":
                filterCars(CarSpec.BODY, BodyKitType.SEDAN.getName());
                break;
            case "2":
                filterCars(CarSpec.BODY, BodyKitType.COUPE.getName());
                break;
            case "3":
                filterCars(CarSpec.BODY, BodyKitType.HATCHBACK.getName());
                break;
            case "4":
                filterCars(CarSpec.BODY, BodyKitType.CONVERTIBLE.getName());
                break;
            case "5":
                filterCars(CarSpec.BODY, BodyKitType.WAGON.getName());
                break;
            case "6":
                filterCars(CarSpec.BODY, BodyKitType.SUV.getName());
                break;
            default:
                System.out.println("Incorrect input, try again.");
                //answerSortMake();
        }

    }

    private void answerSortBudget() {

        // TODO: ADD SORTING BY BUDGET
        // @Think of a better way to represent car price

        String answer = scanString.nextLine();
        switch (answer) {
            case "1":
                break;
            case "2":
                break;
            case "3":
                break;
            default:
                answerSortBudget();
        }
    }

    private void answerSortYear() {

        // TODO: TO IMPLEMENT

    }

    private void answerSortFuel() {
        String answer = scanString.nextLine();
        switch (answer) {
            case "1":
                filterCars(CarSpec.FUEL, FuelType.GASOLINE.getName());
                break;
            case "2":
                filterCars(CarSpec.FUEL, FuelType.DIESEL.getName());
                break;
            case "3":
                filterCars(CarSpec.FUEL, FuelType.ELECTRIC.getName());
                break;
            case "4":
                filterCars(CarSpec.FUEL, FuelType.MIX.getName());
                break;
            default:
                System.out.println("Incorrect input, try again.");
                answerSortFuel();
        }
    }

    private void answerSortTransmission() {
        String answer = scanString.nextLine();
        switch (answer) {
            case "1":
                filterCars(CarSpec.TRANSMISSION, GearBoxType.AUTOMATIC.getName());
                break;
            case "2":
                filterCars(CarSpec.TRANSMISSION, GearBoxType.MANUAL.getName());
                break;
            case "3":
                filterCars(CarSpec.TRANSMISSION, GearBoxType.SWITCHABLE.getName());
                break;
            default:
                System.out.println("Incorrect input, try again.");
                answerSortTransmission();
        }
    }

    private void answerAfterListing() {
        String answer = scanString.nextLine();
        switch (answer) {
            case "1":
                showListCarsMenu();
                break;
            case "2":
                showMenu();
                break;
            default:
                System.out.println("Incorrect input, please try again.");
        }
    }

    //---------------- CAR RENTAL AND TREASURY ----------------//

    private void rentCarMenu() {
        System.out.println("             CAR RENT MENU               ");
        System.out.println("1. Rent car");
        System.out.println("2. Calculate price");
        System.out.println("3. Main menu");
        int answer = scanInt.nextInt();
        switch (answer) {
            case 1:
                rentCar();
                break;
            case 2:
                calculatePrice();
                break;
            case 3:
                showMenu();
                break;
            default:
                System.out.println("Incorrect input, try again.");
                rentCarMenu();
                break;
        }
    }

    private void rentCar() {
        boolean carRented = false;
        System.out.println("Insert chassis number:");
        String chassisNo = scanString.nextLine();
        for (Car car : allCars) {
            if (car.getChassisNo().equals(chassisNo) && car.getState().equals(State.AVAILABLE)) {
                System.out.println("Insert customer first name:");
                String firstName = scanString.nextLine();
                System.out.println("Insert customer last name:");
                String lastName = scanString.nextLine();
                setCarState(car, State.RENTED);
                Customer customer = new Customer(firstName, lastName);
                car.addCustomerToCar(customer);
                treasury.addPayment(customer, car.getPrice());
                System.out.println("Car successfully rented");
                carRented = true;
            }
        }
        if (!carRented) {
            System.out.println("No car found or car not available, try again.");
            System.out.println("1. Main menu");
            System.out.println("2. Try another chassis");
            int answer = scanInt.nextInt();
            switch (answer) {
                case 1:
                    showMenu();
                    break;
                default:
                    rentCar();
            }
        }
    }

    private void showTreasuryMenu() {
        System.out.println("Money in basement(^.^)" + treasury.getMoney());
    }

    private void calculatePrice() {
        // TODO: apply a discount to the base price of a car based on the number of rental days
        // TODO: document the implemented discount algorithm

        // TODO: for a more difficult algorithm, change this method to include date intervals and take into account
        //       weekdays and national holidays in which the discount should be smaller

        // Q: what should be the return type of this method?
        System.out.println("Insert chassis no:");
        String chassisNo = scanString.nextLine();
        for (Car car : allCars) {
            if (car.getChassisNo().equals(chassisNo)) {
                setCarState(car, State.RENTED);
                BigDecimal amount = car.getPrice();
                listCarsFrame();
                car.showCar();
                System.out.println("\nPrice: " + amount.intValue());
                setCarState(car, State.AVAILABLE);
            }
        }


    }

    //--------------- FILTERS AND SHOP FUNCTIONS --------------//

    private void exitApp(boolean exitApp) {
        this.exitApp = exitApp;
    }

    private void listAllCarsFromAList(ArrayList<Car> cars) {
        System.out.println();
        listCarsFrame();
        for (Car car : cars) {
            car.showCar();
            System.out.println();
        }
        System.out.println();
    }

    private void listCarsFrame() {
        int maxStringSize = 14;
        ArrayList<String> args = new ArrayList<>();
        args.add("CHASSIS NO");
        args.add("MAKE");
        args.add("BODY");
        args.add("ENGINE");
        args.add("FUEL");
        args.add("DOORS");
        args.add("GEARBOX");
        args.add("YEAR");
        args.add("STATUS");
        args.add("PRICE/DAY");
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

    private void filterCars(CarSpec carSpec, String filterValue) {
        ArrayList<Car> carList = new ArrayList<>();
        for (Car car : allCars) {
            if (car.getFilter(carSpec).equals(filterValue)) {
                carList.add(car);
            }
        }
        listAllCarsFromAList(carList);
        if (carList.isEmpty()) {
            System.out.println("There are cars to display meeting the criteria.");
        }

    }

    private Date setADate() {
        System.out.println("Insert day:");
        int day = scanString.nextInt();
        System.out.println("Insert month:");
        int month = scanString.nextInt();
        System.out.println("Insert year:");
        int year = scanString.nextInt();
        Calendar cal = new GregorianCalendar();
        cal.set(year, month - 1, day);
        return cal.getTime();
    }

    private void checkCarStatus() {
        System.out.println("Insert chassis number:");
        String chassisNo = scanString.nextLine();
        for (Car car : allCars) {
            if (car.getChassisNo().equals(chassisNo)) {
                listCarsFrame();
                car.showCar();
                if (car.getState().equals(State.RENTED) || car.getState().equals(State.SERVICE)) {
                    SimpleDateFormat dateFormatter = new SimpleDateFormat("EEEE, MMMM d, yyyy");
                    System.out.println("\n" + car.getState().getName());
                    System.out.println("\nStarting date: " + dateFormatter.format(car.getState().getStartDate()) +
                            "\nEnding date: " + dateFormatter.format(car.getState().getEndDate()));
                }
                System.out.println();
            }
        }
    }

    private void setCarState(Car car, State state) {

        if (state.equals(State.AVAILABLE)) {
            car.changeCarState(state, null, null);
        }
        Date startDate = setADate();
        System.out.println("1. Number of days");
        System.out.println("2. End date");
        int answers = scanInt.nextInt();
        switch (answers) {
            case 1:
                System.out.println("Insert number of days:");
                int numberOfDays = scanString.nextInt();
                car.changeCarState(state, startDate, numberOfDays);
                break;
            case 2:
                Date endDate = setADate();
                car.changeCarState(state, startDate, endDate);
                break;
            default:
                setCarState(car, state);
        }
    }

    public void run() {
        generateSalesmas();
        generateCars();
        do {
            loginMenu();
            do {
                showMenu();
            } while (salesmanInUse.getLoggedIn() && !exitApp);
        } while (!exitApp);


    }

    //----------------------- TESTS ----------------------------//

    //DYNAMIC MENU AND ANSWERS

    /**
     * private void showSortList() {
     * System.out.println("\nSelect an action from below:");
     * for (int i = 0; i <= carSpecs.size() + 1; i++) {
     * if (i == carSpecs.size() + 1) {
     * System.out.println(i + ". Return to previous menu");
     * } else {
     * System.out.println(i + ". " + carSpecs.get(i));
     * }
     * }
     * System.out.println();
     * <p>
     * }
     * <p>
     * private void answerSort(ArrayList<CarSpec> carSpecs) {
     * Integer answer = scanString.nextInt();
     * for (int i = 0; i <= carSpecs.size() + 1; i++) {
     * for(CarSpec c : CarSpec.values()) {
     * <p>
     * }
     * }
     * }
     */

    private void showSortList(DisplaysSorted sorted) {
        sorted.printList();
    }
}
