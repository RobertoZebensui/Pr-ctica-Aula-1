package moneycalculator_v20220919_1230.model.persistance.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import moneycalculator_v20220919_1230.model.Currency;
import moneycalculator_v20220919_1230.model.persistence.CurrencyLoader;

public class CurrencyLoaderFile implements CurrencyLoader{
    
    private final String fileName;
    public CurrencyLoaderFile(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Currency> loadCurrencies() {
        
        List<Currency> list = new ArrayList<>();
        // ...
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(this.fileName)));
            while (true){
                String line = reader.readLine();
                if ( line == null) break;
                list.add(currencyOf(line));
            }
            
            reader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("CurrencyLoaderFile :: loadCurrencies, " + ex.getMessage());
            return null;
        } catch (IOException ex){
            System.out.println("CurrencyLoaderFile :: loadCurrencies, IO, " + ex.getMessage());
            return null;
        }
        return list;
    }
    /*
    @Override
    public List<ExchangeRate> loadExchangeRates() {
        String fileName = "";
        List<ExchangeRate> list = new ArrayList<>();
        //...
        return list;
    }
    */

    private Currency currencyOf(String line) {
           String [] split = line.split(",");
           return new Currency(split[1],split[0],split[2]);
    }

    
}
