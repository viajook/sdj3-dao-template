package via.sdj3.distributedobjectsexample.dao;

import via.sdj3.distributedobjectsexample.model.Drink;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class DrinkDao implements DaoApi<Drink>{
    // in memory storage
    private List<Drink> drinks = new ArrayList<>();

    public DrinkDao() {
        drinks.add(new Drink("Ginger Lemon", "Hot ginger lemon tea", 25.25, 10));
        drinks.add(new Drink("CapuChocoLate", "Tasty chocolate drink", 32.50, 5));
    }

    @Override
    public Optional<Drink> get(long id) {
        return Optional.ofNullable(drinks.get((int) id));
        // to use the stream api, assuming you have id field in the model
        // return drinks.stream().filter(d -> d.getId().equals(id)).findFirst());
    }

    @Override
    public List<Drink> getAll() {
        return drinks;
    }

    @Override
    public void save(Drink drink) {
        drinks.add(drink);
    }

    @Override
    public boolean update(long id, Drink updated) {
        if (updated == null){
            return false;
        }
        else {
            Optional<Drink> drink = get(id);
            drink.ifPresent(original ->
            { original.setName(updated.getName());
                original.setDescription(updated.getDescription());
                original.setUnitPrice(updated.getUnitPrice());
                original.setQuantity(updated.getQuantity());});

            return drink.isPresent();
        }
    }

    @Override
    public void delete(Drink drink) {
        drinks.remove(drink);
    }

    @Override
    public void update(Drink drink, String[] params, double price, int qty) {
        drink.setName(Objects.requireNonNull(params[0], "Name cannot be null"));
        drink.setDescription(params[1]);
        drink.setUnitPrice(price);
        drink.setQuantity(qty);
    }
}
