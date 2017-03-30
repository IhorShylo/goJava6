package module8;

import java.util.*;

/**
 * Created by Igor on 30.03.2017.
 */
public class IManageSystemImpl implements IManageSystem<Food> {

    private static Map<Food, Double> database = new HashMap<>();
    private static final Double DEFAULT_PRICE = 0.0;


    @Override
    public Food save(Food obj, double price) {
        database.put(obj, price);
        return obj;
    }

    @Override
    public Food save(Food obj) {
        database.put(obj, DEFAULT_PRICE);
        return obj;
    }

    @Override
    public void delete(Food obj) {
        Double removed = database.remove(obj);

        if (removed != null)
            System.out.println("Object " + obj + " with price " + removed + " was successfully removed");
        else System.out.println("Object " + obj + " wasn't removed");
    }

    @Override
    public void deleteById(int id) {
        boolean isIdFound = false;
        for (Iterator<Map.Entry<Food, Double>> it = database.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<Food, Double> entry = it.next();
            if (entry.getKey().getId() == id) {
                it.remove();
                isIdFound = true;
            }
        }

        if (isIdFound) System.out.println("Object with id = " + id + " was successfully removed");
        else System.out.println("Object with id = " + id + " wasn't removed");
    }

    @Override
    public Food get(int id) {
        for (Map.Entry<Food, Double> entry : database.entrySet()) {
            if (entry.getKey().getId() == id) {
                System.out.println("Object with id = " + id + " not find in db");
                return entry.getKey();
            }
        }
        return null;
    }

    @Override
    public Double getPrice(Food obj) {
        Double price = database.get(obj);
        if (price == null) {
            System.out.println("Price not found. Return default price");
            return DEFAULT_PRICE;
        }
        return price;
    }

    @Override
    public Set<Food> getProducts() {
        return database.keySet();
    }

    @Override
    public List<Double> getPrices() {
        return new ArrayList<Double>(database.values());
    }

    public void printProductsSortedByName() {
        System.out.println("Database products sorted by name:");
        List<Map.Entry<Food, Double>> entries = new ArrayList<>(database.entrySet());
        Collections.sort(entries, (o1, o2) -> o1.getKey().getName().compareTo(o2.getKey().getName()));
        for (Map.Entry<Food, Double> entry : entries) {
            System.out.format("%s with price = %.3f%n", entry.getKey(), entry.getValue());
        }
    }

    public void printProductsSortedByPrice() {
        System.out.println("Database products sorted by price:");
        List<Map.Entry<Food, Double>> entries = new ArrayList<>(database.entrySet());
        Collections.sort(entries, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        for (Map.Entry<Food, Double> entry : entries) {
            System.out.format("%s with price = %.3f%n", entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void printUnsortedProducts() {
        System.out.println("Unsorted database products:");
        for (Map.Entry<Food, Double> entry : database.entrySet()) {
            System.out.format("%s with price = %.3f%n", entry.getKey(), entry.getValue());
        }
    }
}
