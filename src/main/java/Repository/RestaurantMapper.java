package Repository;

import Model.Restaurant;

import java.util.List;

public interface RestaurantMapper {

    Restaurant getRestaurant(int restId);

    List<Restaurant> getAllRestaurants();

    void deleteRestaurantById(int restId);

    void updateRestaurant(Restaurant restaurant);

    void addRestaurant(Restaurant restaurant);
}
