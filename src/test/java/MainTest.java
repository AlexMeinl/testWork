import Controller.RestaurantController;
import Model.Restaurant;
import Service.RestaurantService;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Collection;
import java.util.List;

public class MainTest{

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("spring/spring-config.xml");
        ctx.refresh();

        RestaurantService restaurantService = ctx.getBean(RestaurantService.class);
        //List<Restaurant> list = restaurantService.getAllRestaurants();
        System.out.println(restaurantService.getRestaurant(0));
        RestaurantController restaurantController = ctx.getBean(RestaurantController.class);
        Collection<Restaurant> list = restaurantController.getAllRestaurant("search");
        System.out.println(list.size());
    }

}