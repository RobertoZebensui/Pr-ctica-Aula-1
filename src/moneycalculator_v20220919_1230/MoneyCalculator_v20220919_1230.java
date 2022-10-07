package moneycalculator_v20220919_1230;

import java.util.ArrayList;
import java.util.List;
import moneycalculator_v20220919_1230.model.Currency;
import moneycalculator_v20220919_1230.model.ExchangeRate;
import moneycalculator_v20220919_1230.model.persistance.file.CurrencyLoaderFile;
import moneycalculator_v20220919_1230.model.persistence.CurrencyLoader;
import moneycalculator_v20220919_1230.model.persistence.rest.ExchangeRateLoaderWebService;

public class MoneyCalculator_v20220919_1230 {

    public static void main(String[] args) {
        CurrencyLoaderFile currencyLoader = new CurrencyLoaderFile("currencies");
        List<Currency> listCurrencies = currencyLoader.loadCurrencies();
        for(Currency currency : listCurrencies){
            System.out.println(currency.getCode() + " - "+ currency.getName() + " - " + currency.getSymbol());
        }
        
        ExchangeRateLoaderWebService erlws = new ExchangeRateLoaderWebService();
        for (Currency currencyFrom : listCurrencies) {
            for (Currency currencyTo : listCurrencies) {
                if (!currencyFrom.getCode().equals(currencyTo.getCode())){
                    ExchangeRate exchangeRate = erlws.ExchangeRateLoader(currencyFrom, currencyTo);
                    System.out.println(exchangeRate.getFrom().getCode() + 
                            " - " +
                            exchangeRate.getTo().getCode()+
                            ": " + 
                            exchangeRate.getRate());
                }
            }
        }
    }
    
}
