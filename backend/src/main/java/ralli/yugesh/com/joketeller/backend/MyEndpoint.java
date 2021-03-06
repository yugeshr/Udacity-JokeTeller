package ralli.yugesh.com.joketeller.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;

import ralli.yugesh.com.javajokelibrary.JokeSupplier;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.joketeller.com.yugesh.ralli",
                ownerName = "backend.joketeller.com.yugesh.ralli",
                packagePath = ""
        )
)
public class MyEndpoint {

    @ApiMethod(name = "getJokeService")
    public MyBean getJokeService(){
        MyBean response = new MyBean();
        response.setData(JokeSupplier.jokeShow());
        return response;
    }
    /** A simple endpoint method that takes a name and says Hi back*/
    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {
        MyBean response = new MyBean();
        response.setData(JokeSupplier.jokeShow());
        return response;
    }

}
