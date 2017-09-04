package api;

import io.dropwizard.jersey.validation.Validators;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import org.junit.Test;

import javax.validation.Validator;

public class ToggleTagRequestTest {
    private final Validator validator = Validators.newValidator();

    @Test
    public void testValid() {
        ToggleTagRequest req = new ToggleTagRequest();
        req.receipt_id = 1;
        assertThat(validator.validate(req), empty());
    }
}
