package Controller;

import Model.Restaurant;
import Service.RestaurantService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration("classpath:spring/spring-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class RestaurantControllerTest {

    @Autowired
    private RestaurantService restaurantService;

    @Test
    public void getAllRestaurant() throws Exception {
        List<Restaurant> list = restaurantService.getAllRestaurants("search");
        System.out.println(list.size());
    }

    @Test
    public void addRestaurant() throws Exception {
        System.out.println(restaurantService.addRestaurant(new Restaurant("Europe")));

    }

    @Test
    public void deleteRestaurant() throws Exception {
        restaurantService.deleteRestaurantById(1);

    }

    @Test
    public void updateRestaurant() throws Exception {
        System.out.println(restaurantService.updateRestaurant(new Restaurant(0, "Astoria")));

    }

}