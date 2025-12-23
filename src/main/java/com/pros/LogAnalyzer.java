package com.pros;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LogAnalyzer {

    public static void main(String[] args) {
        List<RequestLog> logs = Arrays.asList(
                new RequestLog("AuthService", 120, 200),
                new RequestLog("AuthService", 150, 500),
                new RequestLog("PaymentService", 200, 200),
                new RequestLog("PaymentService", 180, 200),
                new RequestLog("OrderService", 300, 404),
                new RequestLog("OrderService", 250, 200)
        );


    }
}

class RequestLog {
    private final String serviceName;
    private final int responseTimeMs;
    private final int status;

    // constructor, getters
     RequestLog(String serviceName, int responseTimeMs, int status) {
        this.serviceName = serviceName;
        this.responseTimeMs = responseTimeMs;
        this.status = status;
    }

    public String getServiceName() {
        return serviceName;
    }

    public int getResponseTimeMs() {
        return responseTimeMs;
    }

    public int getStatus() {
        return status;
    }
}
