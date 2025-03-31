package com.example.test;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamsDemo {
    public static void main(String[] args) {
        //Immutable list, allows nulls.
        var immutableList = Stream.of("red", "green", null).toList();
//        immutableList.add("yellow");
        System.out.println(immutableList);

        //Modifiable list, allowing nulls.
        var modifiableList = Stream.of("red", "green", null)
                .collect(Collectors.toList());
        modifiableList.add("yellow");
        modifiableList.set(2,"orange");
        System.out.println(modifiableList);

        record Product (String name,
                        String category,
                        int price){ };

        Stream<Product> products = Stream.of(
                new Product("Laptop", "Electronics", 1000),
                new Product("TV", "Electronics", 1500),
                new Product("Sofa", "Furniture", 700),
                new Product("Table", "Furniture", 300),
                new Product("Lamp", "Home Decor", 50)
        );

        // Grouping products by category
//        Map<String, List<Product>> groupProductsByCategory =
//                products.collect(Collectors.groupingBy(Product::category));
//        System.out.println(groupProductsByCategory);

        // Aggregation: Calculating the total price
//        Map<String, Integer> totalPriceByCategory =
//                products.collect(Collectors.groupingBy(Product::category, Collectors.summingInt(Product::price)));
//        System.out.println(totalPriceByCategory);

        // Aggregation: Counting and average of products by category
       // Average
//        Map<String, Double> averagePriceByCategory =
//                products.collect(Collectors.groupingBy
//                        (Product::category,
//                                Collectors.averagingInt(Product::price)));
//        System.out.println(averagePriceByCategory);
        // Count
//        Map<String, Long> countByCategory =
//                products.collect(Collectors.groupingBy
//                        (Product::category,
//                                Collectors.counting()));
//        System.out.println(countByCategory);

        // Filtering: Products with price greater than 50
//        var filteredProducts = products.filter(product -> product.price > 50).toList();
//        System.out.println(filteredProducts);

        // Mapping: Extracting product names
//        var productNames = products.map(Product::name).toList();
//        System.out.println(productNames);

        // Partitioning: Separate products into expensive and cheap
//        var partitionedProducts = products.collect(
//                Collectors.partitioningBy(product -> product.price > 1000)
//        );
//        System.out.println(partitionedProducts);

        // Using SummaryStatistics for product prices
        // Sum, Average, Min, Max, Count (5 metrics)
        Map<String, IntSummaryStatistics> summaryStatisticsByCategory =
                products.collect(Collectors.groupingBy
                        (Product::category,
                                Collectors.summarizingInt(Product::price)));
        System.out.println(summaryStatisticsByCategory);

    }
}
