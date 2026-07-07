package CoreJava;

import java.util.*;
import java.util.stream.*;


public class StreamMasterclass {

    // --- DOMAIN OBJECTS ---
    static class Order {
        String id;
        double amount;
        String status; // "COMPLETED", "PENDING", "FAILED"
        String customerTier; // "PLATINUM", "GOLD", "REGULAR"
        List<String> items; // List of item names in this order

        public Order(String id, double amount, String status, String customerTier, List<String> items) {
            this.id = id;
            this.amount = amount;
            this.status = status;
            this.customerTier = customerTier;
            this.items = items;
        }
        public String getId() { return id; }
        public double getAmount() { return amount; }
        public String getStatus() { return status; }
        public String getCustomerTier() { return customerTier; }
        public List<String> getItems() { return items; }
    }

    public static void main(String[] args) {
        // Mock Production Data for testing
        List<Order> orders = Arrays.asList(
            new Order("O1", 1200.50, "COMPLETED", "PLATINUM", Arrays.asList("Laptop", "Mouse")),
            new Order("O2", 450.00, "PENDING", "GOLD", Arrays.asList("Keyboard", "HDMI Cable")),
            new Order("O3", 89.90, "COMPLETED", "REGULAR", Arrays.asList("Mousepad")),
            new Order("O4", 2500.00, "COMPLETED", "PLATINUM", Arrays.asList("Monitor", "Desk Chair")),
            new Order("O5", 15.00, "FAILED", "REGULAR", Arrays.asList("USB Drive")),
            new Order("O6", 600.00, "PENDING", "GOLD", Arrays.asList("Headphones", "Mic"))
        );

        System.out.println("====== LEVEL 1: FILTERING & TRANSFORMATION ======");
        System.out.println("Q1 (Completed Order IDs): " + q1_getCompletedOrderIds(orders));
        System.out.println("Q2 (High Value Orders): " + q2_getHighValueOrders(orders));
        System.out.println("Q3 (Distinct Tiers): " + q3_getDistinctCustomerTiers(orders));
        System.out.println("Q4 (First Failed Order ID): " + q4_getFirstFailedOrderId(orders));
        System.out.println("Q5 (Check If Any Pending): " + q5_hasAnyPendingOrders(orders));

        System.out.println("\n====== LEVEL 2: MATH & AGGREGATIONS ======");
        System.out.println("Q6 (Total Revenue): " + q6_getTotalCompletedRevenue(orders));
        System.out.println("Q7 (Highest Order Amount): " + q7_getHighestOrderAmount(orders));
        System.out.println("Q8 (Average Order Amount): " + q8_getAverageOrderAmount(orders));
        System.out.println("Q9 (Count Failed Orders): " + q9_countFailedOrders(orders));

        System.out.println("\n====== LEVEL 3: ADVANCED GROUPING & REDUCTIONS ======");
        System.out.println("Q10 (Group by Status): " + q10_groupOrdersByStatus(orders));
        System.out.println("Q11 (Partition by Value): " + q11_partitionHighValueOrders(orders));
        System.out.println("Q12 (Revenue by Tier): " + q12_getTotalRevenueByCustomerTier(orders));
        System.out.println("Q13 (Order Count by Tier): " + q13_getOrderCountByCustomerTier(orders));

        System.out.println("\n====== LEVEL 4: THE ARCHITECT TESTS (FLATMAP & STRINGS) ======");
        System.out.println("Q14 (All Unique Items Sold): " + q14_getAllUniqueItemsSold(orders));
        System.out.println("Q15 (Joined Order IDs): " + q15_getJoinedOrderIdsWithComma(orders));
    }

    // ==========================================
    // LEVEL 1: FILTERING & TRANSFORMATION
    // ==========================================

    // Q1: Get a List of Order IDs for all orders whose status is "COMPLETED"
    public static List<String> q1_getCompletedOrderIds(List<Order> orders) {
        return orders.stream().filter(x->"COMPLETED".equals(x.getStatus())).map(x->x.id).collect(Collectors.toList());
    }

    // Q2: Get a List of Order objects where the amount is strictly greater than 500.0
    public static List<Order> q2_getHighValueOrders(List<Order> orders) {
        return orders.stream().filter(x->x.getAmount()>500).collect(Collectors.toList());
    }

    // Q3: Get a Set of all unique (distinct) customer tiers present in the dataset
    public static Set<String> q3_getDistinctCustomerTiers(List<Order> orders) {
        return  orders.stream().map(x->x.getCustomerTier()).collect(Collectors.toSet());
    }

    // Q4: Find the ID of the FIRST order that has a status of "FAILED". 
    // If none exist, return "NOT_FOUND"
    public static String q4_getFirstFailedOrderId(List<Order> orders) {
        return orders.stream().filter(x->"FAILED".equals(x.getStatus())).map(x->x.getId()).findFirst().orElse("NOT_FOUND");
    }

    // Q5: Check if there is AT LEAST ONE order in the list that is "PENDING". Return boolean.
    public static boolean q5_hasAnyPendingOrders(List<Order> orders) {
        return orders.stream().anyMatch(x->"PENDING".equals(x.getStatus()));
    }


    // ==========================================
    // LEVEL 2: MATH & AGGREGATIONS
    // ==========================================

    // Q6: Calculate the total sum of amounts for all orders with a status of "COMPLETED"
    public static double q6_getTotalCompletedRevenue(List<Order> orders) {
        return orders.stream().filter(x->"COMPLETED".equals(x.getStatus())).mapToDouble(Order::getAmount).sum();
    }

    // Q7: Find the maximum order amount in the entire dataset. Return 0.0 if empty.
    public static double q7_getHighestOrderAmount(List<Order> orders) {
        return orders.stream().mapToDouble(Order::getAmount).max().orElse(0.0);
    }

    // Q8: Find the average order amount of all orders. Return 0.0 if empty.
    public static double q8_getAverageOrderAmount(List<Order> orders) {
        return orders.stream().mapToDouble(Order::getAmount).average().orElse(0.0);
    }

    // Q9: Count how many orders have a status of "FAILED"
    public static long q9_countFailedOrders(List<Order> orders) {
        return orders.stream().filter(x->"FAILED".equals(x.getStatus())).count();
    }


    // ==========================================
    // LEVEL 3: ADVANCED GROUPING & REDUCTIONS
    // ==========================================

    // Q10: Group all orders by their status string.
    public static Map<String, List<Order>> q10_groupOrdersByStatus(List<Order> orders) {
        return orders.stream().collect(Collectors.groupingBy(Order::getStatus));
    }

    // Q11: Split the orders into two groups: 'true' for orders > 500.0, 'false' otherwise.
    public static Map<Boolean, List<Order>> q11_partitionHighValueOrders(List<Order> orders) {
        return orders.stream().collect(Collectors.partitioningBy(x->x.getAmount()>500));
    }

    // Q12: Group by customerTier, but calculate the SUM of order amounts for each tier.
    public static Map<String, Double> q12_getTotalRevenueByCustomerTier(List<Order> orders) {
        return orders.stream().collect(Collectors.groupingBy(Order::getCustomerTier,Collectors.summingDouble(Order::getAmount)));
    }

    // Q13: Group by customerTier, but count the NUMBER of orders belonging to each tier.
    public static Map<String, Long> q13_getOrderCountByCustomerTier(List<Order> orders) {
       
        return orders.stream().collect(Collectors.groupingBy(Order::getCustomerTier,Collectors.counting()));
    }


    // ==========================================
    // LEVEL 4: THE ARCHITECT TESTS (FLATMAP & STRINGS)
    // ==========================================

    // Q14: Extract ALL items across ALL orders, and return a Set of unique item names.
    public static Set<String> q14_getAllUniqueItemsSold(List<Order> orders) {
        return orders.stream().flatMap(order -> order.getItems().stream()).collect(Collectors.toSet());
    }

    // Q15: Take all order IDs and join them together into a single String separated by commas.
    // e.g., "O1, O2, O3, O4"
    public static String q15_getJoinedOrderIdsWithComma(List<Order> orders) {
        return orders.stream().map(Order::getId).collect(Collectors.joining(", "));
    }
}
