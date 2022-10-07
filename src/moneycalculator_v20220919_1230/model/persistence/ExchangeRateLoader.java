package moneycalculator_v20220919_1230.model.persistence;

import moneycalculator_v20220919_1230.model.Currency;
import moneycalculator_v20220919_1230.model.ExchangeRate;

public interface ExchangeRateLoader {
    public ExchangeRate ExchangeRateLoader(Currency from, Currency to);
}
