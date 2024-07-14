import java.math.BigDecimal;
import java.util.Map;

public class CurrencyResponse {
    private String base_code;
    private Map<String, BigDecimal> conversion_rates;

    public String getBase_code() {
        return base_code;
    }

    public Map<String, BigDecimal> getConversion_rates() {
        return conversion_rates;
    }
}