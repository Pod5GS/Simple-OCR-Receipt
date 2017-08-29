import controllers.HelloWorldController;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.server.session.SessionHandler;

public class SimpleApplication extends Application<Configuration> {
    public static void main(String[] args) throws Exception {
        new SimpleApplication().run(args);
    }

    @Override
    public void run(Configuration cfg, Environment env) {
        // This configures Jersey to support sesions.
        env.servlets().setSessionHandler(new SessionHandler());


        // Register all Controllers below.  Don't forget 
        // you need class and method @Path annotations!
        env.jersey().register(new HelloWorldController());
    }
}
