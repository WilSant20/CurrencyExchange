import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CurrencyConverter {
    private BigDecimal convertedValue;

    public CurrencyConverter(String fromCurrency, String json, BigDecimal amount, String toCurrency)
            throws IOException {
        BigDecimal currencyValue;
        //Instance
        Gson gson = new Gson();

        // Parse the JSON String to a CurrencyResponse object
        CurrencyResponse response = gson.fromJson(json, CurrencyResponse.class);

        // Get the conversion rates map
        Map<String, BigDecimal> conversionRates = response.getConversion_rates();

        // Search for the desired currency in the conversion rates map
        currencyValue = conversionRates.get(toCurrency);

        if (currencyValue != null) {
            this.convertedValue = amount.multiply(currencyValue);
            System.out.println("El valor convertido es: " + convertedValue);
        } else {
            System.out.println("Código de moneda no encontrado.");
        }
    }
    public BigDecimal getConvertedValue() {
        return convertedValue;
    }
}