import controllers.HelloWorldController;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;

public class SimpleApplication extends Application<Configuration> {
    public static void main(String[] args) throws Exception {
        new SimpleApplication().run(args);
    }

    @Override
    public void run(Configuration cfg, Environment env) {
        env.jersey().register(new HelloWorldController());
    }
}
