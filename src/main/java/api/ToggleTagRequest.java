package api;
import org.hibernate.validator.constraints.NotEmpty;

public class ToggleTagRequest {
    @NotEmpty
    public int receipt_id;
}
