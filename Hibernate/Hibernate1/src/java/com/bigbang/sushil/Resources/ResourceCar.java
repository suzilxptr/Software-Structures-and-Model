import com.bigbang.sushil.Car;
import com.bigbang.sushil.DataProvider;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


/**
 *
 * @author The BigBang
 */
@Path("car")
public class ResourceCar{

   
   

    public ResourceCar() {
    }

  
    @GET
    @Produces("application/xml")
    public List<Car> getXml() {
        return DataProvider.getCars();
    }

    /**
     * Sub-resource GET method for {id}
     */
    @GET
    @Produces("application/xml")
    @Path("{personName}")
    public List<Car> getCarsByPersonName(@PathParam("personName") String personName) {
        return (List<Car>) DataProvider.getCarsByPersonName(personName);
    }
    
    @GET
    @Produces("application/xml")
    @Path("priceLessThan/{price}")
    public List<Car> getCarsLessThanPrice(@PathParam("price") String price) {
        return DataProvider.getCarsByLessThanPrice(Double.parseDouble(price));
    }

    /**
     * PUT method for updating or creating an instance of CarResource
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    
}
