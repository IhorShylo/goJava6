package module8;

import java.util.Random;

/**
 * Created by Igor on 30.03.2017.
 */

public class Main {
    public static IManageSystem<Food> system = new IManageSystemImpl();

    public static void main(String[] args) {
        Food gamburger = new Food("Gamburger", Country.USA, 2);
        Food borsch = new Food("Borsch", Country.UKRAINE, 7);
        Food pelmeni = new Food("Hren", Country.RUSSIA, 3);
        Food legysha4ieLapki = new Food("Legysha4ie Lapki", Country.FRANCE, 4);
        Food banana = new Food("Banana", Country.BRAZIL, 30);
        Food pizza = new Food("Pizza", Country.ITALY, 5);

        system.save(gamburger);
        saveProductsWithRandomPrices(borsch, pelmeni, legysha4ieLapki, banana, pizza);

        system.printUnsortedProducts();

        system.printProductsSortedByName();
        system.printProductsSortedByPrice();


        system.delete(gamburger);
        system.deleteById(3);

        System.out.println("Getted product by id " + system.get(1));

        System.out.println("Getted price by obj " + system.getPrice(new Food()));


    }


    private static void saveProductsWithRandomPrices(Food... products){
        Random random = new Random();
        for(Food product: products){
            system.save(product, random.nextDouble() * 100);
        }
    }
}
