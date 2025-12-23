package com.pros;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

public class TopNStreamDemo {

    public static void main(String[] args) {
        List<ServiceMethod> serviceList = Arrays.asList(
                new ServiceMethod("MRI Scan", "MR-001", 300.00),
                new ServiceMethod("Blood Test", "BT-101", 45.00),
                new ServiceMethod("Dental Checkup", "DC-202", 80.00),
                new ServiceMethod("Annual Physical", "AP-303", 150.00),
                new ServiceMethod("Genetic Screening", "GS-404", 450.00)
        );
        /*
         * Scenario: You are developing a microservice for the "Discover Your Provider (DYP)" project.
         * You have a list of service methods (ServiceMethod) used by providers,
         * and you need to find the names of the 3 most expensive services offered.
          */
        serviceList.stream()
                .sorted((s1, s2) -> Double.compare(s2.getCost(), s1.getCost()))
                .limit(3)
                .map(ServiceMethod::getName)
                .forEach(System.out::println);
    }
}

@Setter
@Getter
@AllArgsConstructor
class ServiceMethod {
    private String name;
    private String code;
    private double cost;

}
