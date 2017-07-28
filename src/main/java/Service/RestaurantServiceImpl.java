package Service;

import Repository.RestaurantMapper;
import Model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    private RestaurantMapper restaurantMapper;

//    @Autowired
//    public RestaurantServiceImpl(RestaurantMapper restaurantMapper) {
//        this.restaurantMapper = restaurantMapper;
//    }

    public void setRestaurantMapper(RestaurantMapper restaurantMapper) {
        this.restaurantMapper = restaurantMapper;
    }
//
//    public RestaurantMapper getRestaurantMapper() {
//        return restaurantMapper;
//    }

    @Transactional
    public Restaurant getRestaurant(int restId) {
        return this.restaurantMapper.getRestaurant(restId);
    }

    @Transactional
    public List<Restaurant> getAllRestaurants(String search) {
        return restaurantMapper.getAllRestaurants();
    }

    @Transactional
    public void deleteRestaurantById(int restId) {
        restaurantMapper.deleteRestaurantById(restId);
    }

    @Transactional
    public Restaurant updateRestaurant(Restaurant restaurant) {
        restaurantMapper.updateRestaurant(restaurant);
        return restaurant;
    }

    @Transactional
    public Restaurant addRestaurant(Restaurant restaurant) {
            restaurantMapper.addRestaurant(restaurant);
            return restaurant;
    }
}
