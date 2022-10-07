package moneycalculator_v20220919_1230.model.persistence.rest;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import moneycalculator_v20220919_1230.model.Currency;
import moneycalculator_v20220919_1230.model.ExchangeRate;
import moneycalculator_v20220919_1230.model.persistence.ExchangeRateLoader;

public class ExchangeRateLoaderWebService implements ExchangeRateLoader{

    @Override
    public ExchangeRate ExchangeRateLoader(Currency from, Currency to) {
        try {
            return new ExchangeRate(from, to, read(from.getCode(), to.getCode()));
        } catch (IOException ex) {
            System.out.println("ExchangeRateLoaderWebService :: ExchangeRateLoader (IO), "+ ex.getMessage());
            return null;
        }
    }

    private double read(String codeFrom, String codeTo) throws MalformedURLException, IOException {
        String line = read(new URL("https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/"+
                codeFrom +
                "/"+ 
                codeTo+
                ".json"));
        return Double.parseDouble(getStringRateFromJSON(line));
    }

    private String read(URL url) throws IOException {
        InputStream inputStream = url.openStream();
        byte[] buffer = new byte[1024];
        int length = inputStream.read(buffer);
        return new String(buffer, 0, length);
    }

    private String getStringRateFromJSON(String line) {
        String [] split = line.split(",");
        return split[1].substring(split[1].indexOf(":")+ 1, split[1].indexOf("}")- 1);
    }
    
}
