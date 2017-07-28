package MyBatis;

import Model.Restaurant;
import Repository.RestaurantMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class AppTest {

    public static void main(String[] args)
    {
        SqlSessionFactory factory;
        RestaurantMapper mapper;

        try(Reader reader = Resources.getResourceAsReader("postgreSQL/myBatis-config.xml")) {
            factory = new SqlSessionFactoryBuilder().build(reader);
            mapper = factory.openSession().getMapper(RestaurantMapper.class);
            Restaurant restaurant = mapper.getRestaurant(1);
            System.out.println(restaurant);
            mapper.addRestaurant(new Restaurant("343434343"));
            List<Restaurant> list = mapper.getAllRestaurants();
            for (Restaurant rest : list)
            {
                System.out.println(rest);
            }
            mapper.updateRestaurant(new Restaurant( 0,"sda"));
            System.out.println(mapper.getRestaurant(0));
        }catch (IOException e){
            System.out.println(e);
        }



    }
}
