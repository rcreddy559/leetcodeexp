package com.utils;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

public class CommonUtils {
        public static List<Employee> getEmployees() {
                List<Employee> employees = new ArrayList<>();
                Random random = new Random(); // For generating random data

                String[] firstNames = { "John", "Jane", "David", "Sarah", "Michael", /* ... add more names */ "Ashley",
                                "Kevin", "Jessica", "William", "Elizabeth" };
                String[] lastNames = { "Doe", "Smith", "Lee", "Johnson", "Williams", /* ... add more names */ "Brown",
                                "Davis", "Garcia", "Rodriguez", "Wilson" };
                String[] cities = { "New York", "Los Angeles", "Chicago", "Houston", "Phoenix",
                                /* ... add more cities */ "Philadelphia", "San Antonio", "San Diego", "Dallas",
                                "San Jose" };
                String[] states = { "NY", "CA", "IL", "TX", "AZ", /* ... add more states */ "PA", "TX", "CA", "TX",
                                "CA" };
                String[] countries = { "USA", "Canada", "UK", "Germany", "France", /* ... add more countries */ "Japan",
                                "China", "India", "Brazil", "Australia" };
                String[] streets = { "Main St", "1st Ave", "2nd St", "3rd Ave", "Park Ave", "Maple Dr", "Oak St",
                                "Pine Ln", "Willow Rd", "Cedar Ct" };

                String[] departments = Arrays.stream(Department.values()).map(Enum::name).toArray(String[]::new);

                for (int i = 1; i <= 10; i++) {
                        // Generate random data for each employee
                        String employeeId = "E" + String.format("%03d", i); // Formats like E001, E002, etc.
                        String firstName = firstNames[random.nextInt(firstNames.length)];
                        String lastName = lastNames[random.nextInt(lastNames.length)];
                        String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@example.com";
                        String phoneNumber = String.format("%03d-%03d-%04d", random.nextInt(1000), random.nextInt(1000),
                                        random.nextInt(10000));
                        // Random
                        // department
                        String position = "Position " + i; // Or generate random positions
                        double salary = 50000 + random.nextInt(50000); // Salary between 50k and 100k
                        Date hireDate = new Date(System.currentTimeMillis()
                                        - (long) random.nextInt(365 * 5 * 24 * 60 * 60 * 10)); // Hired within the
                                                                                               // last 5 years
                        boolean isActive = random.nextBoolean();

                        List<Address> addresses = new ArrayList<>();
                        Address address = new Address();
                        address.setHouseNo(random.nextInt(1000) + 1); // House number between 1 and 1000
                        address.setPincode(random.nextInt(900000) + 100000); // Pincode between 100000 and 999999
                        address.setStreet(streets[random.nextInt(streets.length)]);
                        address.setCity(cities[random.nextInt(cities.length)]);
                        address.setState(states[random.nextInt(states.length)]);
                        address.setCountry(countries[random.nextInt(countries.length)]);
                        addresses.add(address);

                        Employee employee = new Employee(employeeId, firstName, lastName, email, phoneNumber,
                                        departments[random.nextInt(5)], position, salary, hireDate, isActive,
                                        addresses);
                        employees.add(employee);
                }

                // Print the employee data (or do whatever you need with it)

                System.out.println("Total Employees inserted : " + employees.size());
                return employees;
        }

        public static List<Integer> getListOfIntegers() {
                return List.of(90901, 2456, 3111, 45644, 7865, 906, 67, 568, 339, 103);
        }

        public static List<String> getListOfElements() {
                List<String> list = new ArrayList<>();
                list.add("A");
                list.add("B");
                list.add("C");
                list.add("D");
                list.add("E");
                list.add("F");

                return list;
        }
}
