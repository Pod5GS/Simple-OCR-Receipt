package api;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class CreateReceiptRequest {
    @NotEmpty
    public String merchantName;

    @NotNull
    @Min(0)
    public BigDecimal value;
}
