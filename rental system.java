import java.util.ArrayList;
import java.util.List;


  class RentalAgency {
    public static void main(String[] args) {
        
    }
    private String agencyName;
    private List<Customer> customers;
    private List<Car> cars;


    public RentalAgency(String agencyName) {
        this.agencyName = agencyName;
        this.customers = new ArrayList<>();
        this.cars = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void rentCar(String carId, String customerId) {
        Car car = findCarById(carId);
        Customer customer = findCustomerById(customerId);

        if (car == null) {
            System.out.println("Car with ID " + carId + " not found.");
            return;
        }

        if (customer == null) {
            System.out.println("Customer with ID " + customerId + " not found.");
            return;
        }

        if (car.isRented()) {
            System.out.println("Car " + carId + " is already rented.");
            return;
        }

        car.setRented(true);
        System.out.println("Car " + carId + " successfully rented to " + customer.getName());
    }

    private Car findCarById(String carId) {
        for (Car c : cars) {
            if (c.getId().equals(carId)) {
                return c;
            }
        }
        return null;
    }

    private Customer findCustomerById(String customerId) {
        for (Customer c : customers) {
            if (c.getId().equals(customerId)) {
                return c;
            }
        }
        return null;
    }

    public void listCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers registered.");
            return;
        }

        System.out.println("--- Customers ---");
        for (Customer c : customers) {
            System.out.println(c);
        }
    }

    public void listCars() {
        if (cars.isEmpty()) {
            System.out.println("No cars available.");
            return;
        }

        System.out.println("--- Cars ---");
        for (Car c : cars) {
            System.out.println(c);
        }
    }
}

class Car {
    private String id;
    private boolean rented;

    public Car(String id) {
        this.id = id;
        this.rented = false;
    }

    public String getId() {
        return id;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    @Override
    public String toString() {
        return "Car ID: " + id + ", Rented: " + rented;
    }
}

class Customer {
    private String id;
    private String name;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Customer ID: " + id + ", Name: " + name;
    }
}
