package Service;

import Model.Restaurant;

import java.util.List;

public interface RestaurantService {

    Restaurant getRestaurant(int restId);

    List<Restaurant> getAllRestaurants(String search);

    void deleteRestaurantById(int restId);

    Restaurant updateRestaurant(Restaurant restaurant);

    Restaurant addRestaurant(Restaurant restaurant);
}
