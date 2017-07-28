package Service;

import Model.Restaurant;
import Repository.RestaurantMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration("classpath:spring/spring-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class RestaurantServiceImplTest {

    @Autowired
    private RestaurantMapper restaurantMapper;

    @Test
    public void getRestaurant() throws Exception {
        System.out.println(restaurantMapper.getRestaurant(0));
    }

    @Test
    public void getAllRestaurants() throws Exception {
        List<Restaurant> list = restaurantMapper.getAllRestaurants();
        System.out.println(list.size());
    }

    @Test
    public void deleteRestaurantById() throws Exception {
        restaurantMapper.deleteRestaurantById(0);
    }

    @Test
    public void updateRestaurant() throws Exception {
        restaurantMapper.updateRestaurant(new Restaurant(0, "UU5UU"));
        System.out.println(restaurantMapper.getRestaurant(0));
    }

    @Test
    public void addRestaurant() throws Exception {
        restaurantMapper.addRestaurant(new Restaurant("BBBB"));
    }

}