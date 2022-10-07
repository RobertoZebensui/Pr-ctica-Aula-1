package moneycalculator_v20220919_1230.model.persistence;

import java.util.List;
import moneycalculator_v20220919_1230.model.Currency;
import moneycalculator_v20220919_1230.model.ExchangeRate;

public interface CurrencyLoader {
    public List<Currency> loadCurrencies();
    //public List<ExchangeRate> loadExchangeRates();
    
}
