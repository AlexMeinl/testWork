package Controller;

import Model.Restaurant;
import Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Collection<Restaurant> getAllRestaurant(String search) {
        return restaurantService.getAllRestaurants(search);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.addRestaurant(restaurant);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteRestaurant(@RequestBody Restaurant restaurant) {
        restaurantService.deleteRestaurantById(restaurant.getId());
        return "delete";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseBody
    public String updateRestaurant(@RequestBody Restaurant restaurant) {
        restaurantService.updateRestaurant(restaurant);
        return "update";
    }
}
