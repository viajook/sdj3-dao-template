package via.sdj3.distributedobjectsexample;

import via.sdj3.distributedobjectsexample.dao.DaoApi;
import via.sdj3.distributedobjectsexample.dao.DrinkDao;
import via.sdj3.distributedobjectsexample.model.Drink;

import java.util.Optional;

public class DaoDemo {
    private static DaoApi<Drink> drinkDao;

    public static void main(String[] args) {
        drinkDao = new DrinkDao();
        // print all drinks: name, price
        drinkDao.getAll().forEach(drink -> System.out.println(
                drink.getName() +", "+ drink.getUnitPrice()));

        // get a drink given an id
        Drink d1 = getDrink(0);
        System.out.println(d1.getName() + ", " + d1.getUnitPrice() + " Qty: " + d1.getQuantity());
        drinkDao.update(0, new Drink(d1.getName(), d1.getDescription(), d1.getUnitPrice(), 50));
        System.out.println(">>>>> After updating stock");
        Drink ud1 = getDrink(0);
        System.out.println(ud1.getName() + ", " + ud1.getUnitPrice() + " Qty: " + ud1.getQuantity());

    }

    private static Drink getDrink(long id) {
        Optional<Drink> drink = drinkDao.get(id);
        return drink.orElseGet(() ->
                new Drink("Default drink", "no description", 0.00, 0));
    }
}
