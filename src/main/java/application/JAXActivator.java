package application;

import com.kumuluz.ee.cors.annotations.CrossOrigin;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@CrossOrigin(supportedMethods = "GET, POST, PUT, DELETE, HEAD")
@ApplicationPath("")
@OpenAPIDefinition(info = @Info(
        title = "Rekeningrijden | Facturen API",
        version = "0.0.1")
)
public class JAXActivator extends Application {
    // Left empty intentionally
}