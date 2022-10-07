
package moneycalculator_v20220919_1230.model.persistance.bd;

import java.util.ArrayList;
import java.util.List;
import moneycalculator_v20220919_1230.model.Currency;
import moneycalculator_v20220919_1230.model.ExchangeRate;
import moneycalculator_v20220919_1230.model.persistence.CurrencyLoader;

public class CurrencyLoaderBD implements CurrencyLoader{

    @Override
    public List<Currency> loadCurrencies() {
        String connectString = "IP:PORT:SID";
        List<Currency> list = new ArrayList<>();
        
        //...
        
        return list;
    }
    /*
    @Override
    public List<ExchangeRate> loadExchangeRates() {
        String connectString = "IP:PORT:SID";
        List<ExchangeRate> list = new ArrayList<>();
        //...
        return list;
    }
*/
}


