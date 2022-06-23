package org.nagarro;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public final class CurrencyTable {


  private CurrencyTable() {
  }

  private static final Map<ConversionElement, BigDecimal> CONVERSION_ELEMENT_BIG_DECIMAL_MAP = new HashMap();


  static {
    init();
  }

  public static void addConversionElement(ConversionElement convertedValue, BigDecimal conversionValue) {
    CONVERSION_ELEMENT_BIG_DECIMAL_MAP.put(convertedValue, conversionValue);
  }

  public static BigDecimal getValue(ConversionElement element) {
    //TODO: Validate key exists
    return CONVERSION_ELEMENT_BIG_DECIMAL_MAP.get(element);
  }


  private static void init(){
    CurrencyTable table = new CurrencyTable();

    table.addConversionElement(new ConversionElement(/*from*/Currency.EUR,/*to*/Currency.USD), BigDecimal.valueOf(1.05D));
    table.addConversionElement(new ConversionElement(/*from*/Currency.USD,/*to*/Currency.EUR), BigDecimal.valueOf(0.95));
    table.addConversionElement(new ConversionElement(/*from*/Currency.EUR,/*to*/Currency.KRW), BigDecimal.valueOf(1368.82));
    table.addConversionElement(new ConversionElement(/*from*/Currency.KRW,/*to*/Currency.EUR), BigDecimal.valueOf(0.00073));
    table.addConversionElement(new ConversionElement(/*from*/Currency.USD,/*to*/Currency.KRW), BigDecimal.valueOf(1299.71));
    table.addConversionElement(new ConversionElement(/*from*/Currency.KRW,/*to*/Currency.USD), BigDecimal.valueOf(0.00077));

  }
}
