package module7;

import module4.homework1.Currency;

import java.util.*;

import static module4.homework1.Currency.*;

/**
 * Created by Igor on 12.04.2017.
 */
public class MainList {

    public static void main(String[] args) {
        List<Order> randomList = createRandomListOfOrders(10, 200, 1000);

        if (randomList == null) System.exit(0);

        System.out.println("Random list without order");
        randomList.forEach(System.out::println);

        System.out.println("Random list with reversed price order");
        Set<Order> treeSet = new TreeSet<>(randomList);
        treeSet.forEach(System.out::println);

        List<Order> customList = createCustomListOfOrders();

        System.out.println("Custom list with natural price order and natural city order");
        Collections.sort(customList, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                int priceComparingResult = o1.getPrice() - o2.getPrice();

                return priceComparingResult == 0 ? o1.getUser().getCity().compareTo(o2.getUser().getCity())
                        : priceComparingResult;
            }
        });
        customList.forEach(System.out::println);

        System.out.println("Custom list with natural itemName, ShopIdentificator and User city order");
        Collections.sort(customList, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                int itemNameComparingResult = o1.getItemName().compareTo(o2.getItemName());

                if (itemNameComparingResult != 0) return itemNameComparingResult;

                int shopIdentificatorComparingResult = o1.getShopIdentificator().compareTo(o2.getShopIdentificator());

                return shopIdentificatorComparingResult == 0 ?
                        o1.getUser().getCity().compareTo(o2.getUser().getCity())
                        : shopIdentificatorComparingResult;
            }
        });
        customList.forEach(System.out::println);

        deleteDuplicatesAndPrintResult(customList).forEach(System.out::println);
        deleteWithPriceLessThenAndPrintResult(customList, 1500).forEach(System.out::println);

        System.out.println("Separate lists by Currency");
        separateListByCurrency(randomList).forEach(orders -> {
            System.out.println("-------------------------------------------------------------------------------------");
            orders.forEach(System.out::println);
        });

        System.out.println("Separate lists by city");
        separateListByUniqCity(customList).forEach((key, orders) -> {
            System.out.println("List of " + key);
            orders.forEach(System.out::println);
            System.out.println("-------------------------------------------------------------------------------------");
        });

    }

    private static Map<String, List<Order>> separateListByUniqCity(List<Order> orders) {
        Map<String, List<Order>> resultMap = new TreeMap<>();
        String city;
        for (Order order : orders) {
            city = order.getUser().getCity();
            List<Order> list = resultMap.get(city);
            if (list == null) {
                list = new ArrayList<Order>();
                resultMap.put(city, list);
            }
            list.add(order);
        }

        return resultMap;
    }

    private static List<List<Order>> separateListByCurrency(List<Order> list) {
        List<List<Order>> result = new ArrayList<>();
        List<Order> uahList = new ArrayList<>();
        List<Order> usdList = new ArrayList<>();
        List<Order> eurList = new ArrayList<>();
        list.forEach(order -> {
            switch (order.getCurrency()) {
                case UAH:
                    uahList.add(order);
                    break;
                case USD:
                    usdList.add(order);
                    break;
                case EUR:
                    eurList.add(order);
                    break;
                default:
                    break;
            }
        });
        result.add(uahList);
        result.add(usdList);
        result.add(eurList);
        return result;
    }

    private static <T> Set<T> deleteDuplicatesAndPrintResult(List<T> list) {
        System.out.println("Deleted duplicates");
        return new HashSet<>(list);
    }

    private static List<Order> deleteWithPriceLessThenAndPrintResult(List<Order> list, int price) {
        System.out.println("Deleted orders with price less than " + price);
        List<Order> resultList = new ArrayList<>();
        for (Order order : list) {
            if (order.getPrice() < price) resultList.add(order);
        }
        return resultList;
    }


    private static List<Order> createRandomListOfOrders(int size, int maxPriceAndMinBalance, int maxBalance) {
        if (maxPriceAndMinBalance > maxBalance) {
            System.out.println("maxPriceAndMinBalance(" + maxPriceAndMinBalance + ") can't be greater than maxBalance("
                    + maxBalance + ")");
            return null;
        }

        List<Order> result = new ArrayList<>();
        Random random = new Random();


        for (int i = 0; i < size; i++) {
            int randomPrice = random.nextInt(maxPriceAndMinBalance);
            int randomBalance = random.nextInt((maxBalance - maxPriceAndMinBalance) + 1) + maxPriceAndMinBalance;
            Currency randomCurrency = values()[random.nextInt(values().length)];

            result.add(new Order(randomPrice, randomCurrency, "Item" + i, "ShopIdentificator" + i,
                    new User("First name" + i, "Last name" + i, "City" + i, randomBalance)));
        }

        return result;
    }

    private static List<Order> createCustomListOfOrders() {
        List<Order> orders = new ArrayList<>();

        User user1 = new User("Tanya", "Kysla", "Kyiv", 20000);
        User user2 = new User("Pavel", "Rosovskiy", "Kharkiv", 15000);
        User user3 = new User("Vladimir", "Burtsev", "Dnepropetrovsk", 2050);
        User user4 = new User("Andrey", "Ponomarenko", "Kyiv", 3200);
        User user5 = new User("Gingembre", "Guillaume", "Lviv", 4500);
        User user6 = new User("Maryna", "Kontar", "Lviv", 3200);
        User user7 = new User("Andrey", "Berezin", "Kharkiv", 20000);
        User user8 = new User("Alexandr", "Driga", "Kyiv", 15000);
        User user9 = new User("Denis", "Ivashkov", "Rivne", 2050);
        User user10 = new User("Vitalii", "Proskura", "Rivne", 2050);


        orders.add(new Order(50, USD, "Slippers yellow model 345 s.41", "Otto", user1));
        orders.add(new Order(1500, UAH, "Shoes blue model 345 s.41", "Miraton", user6));
        orders.add(new Order(1100, UAH, "Bag model 45", "Ardo", user3));
        orders.add(new Order(1500, UAH, "Shoes blue model 345 s.41", "Outlet", user2));
        orders.add(new Order(55, USD, "Dress yellow model 04 S", "Otto", user5));
        orders.add(new Order(1500, UAH, "Shoes blue model 345 s.41", "Miraton", user4));
        orders.add(new Order(48, USD, "T-shirt model 25 L", "Oggi", user8));
        orders.add(new Order(15, USD, "Cap model 12", "Oggi", user7));
        orders.add(new Order(48, USD, "T-shirt model 25 L", "Oggi", user8));
        orders.add(new Order(100, UAH, "Pork meet", "Silpo", user10));

        return orders;
    }

}
