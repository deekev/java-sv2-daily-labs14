package day01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderService {

    private List<Order> orders = new ArrayList<>();


    public void saveOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrderByStatus(String status) {
        return orders
                .stream()
                .filter(order -> order.getStatus().equals(status))
                .collect(Collectors.toList());
    }

    public long getNumberOfOrdersByStatus(String status) {
        return orders
                .stream()
                .filter(order -> order.getStatus().equals(status))
                .count();
    }

    public List<Order> getOrdersBetweenDates(LocalDate first, LocalDate second) {
        return orders
                .stream()
                .filter(order -> order.getOrderDate().isAfter(first)
                        && order.getOrderDate().isBefore(second))
                .collect(Collectors.toList());
    }

    public boolean isOrderWithLessProduct(int numberOfProducts) {
        return orders
                .stream()
                .anyMatch(order -> order.getProducts().size() < numberOfProducts);
    }

    public Order getOrderWithMostProduct() {
        return orders
                .stream()
                .max(Comparator.comparingInt(o -> o.getProducts().size()))
                .orElseThrow(() -> new IllegalStateException("List is empty."));

    }

    public List<Order> getOrdersWithCategoryOfProduct(String category) {
        return orders
                .stream()
                .filter(order -> order.getProducts().stream()
                        .anyMatch(product -> product.getCategory().equals(category)))
                .collect(Collectors.toList());
    }
}
