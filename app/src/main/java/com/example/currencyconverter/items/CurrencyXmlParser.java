package com.example.currencyconverter.items;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.util.ArrayList;
import java.io.StringReader;

public class CurrencyXmlParser {
    private ArrayList<Currency> currencies;

    public CurrencyXmlParser() {
        currencies = new ArrayList<>();
    }

    public ArrayList<Currency> getUsers() {
        return currencies;
    }

    public boolean parse(String xmlData) {
        boolean status = true;
        Currency currentCurrency = null;
        boolean inEntry = false;
        String textValue = "";

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            xpp.setInput(new StringReader(xmlData));
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {

                String tagName = xpp.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if ("Valute".equalsIgnoreCase(tagName)) {
                            inEntry = true;
                            currentCurrency = new Currency();
                        }
                        break;
                    case XmlPullParser.TEXT:
                        textValue = xpp.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        if (inEntry) {
                            if ("Valute".equalsIgnoreCase(tagName)) {
                                currencies.add(currentCurrency);
                                inEntry = false;
                            } else if ("NumCode".equalsIgnoreCase(tagName)) {
                                currentCurrency.setNumCode(Integer.parseInt(textValue));
                            } else if ("CharCode".equalsIgnoreCase(tagName)) {
                                currentCurrency.setCharCode(textValue);
                            } else if ("Nominal".equalsIgnoreCase(tagName)) {
                                currentCurrency.setNominal(Integer.parseInt(textValue));
                            } else if ("Name".equalsIgnoreCase(tagName)) {
                                currentCurrency.setName(textValue);
                            } else if ("Value".equalsIgnoreCase(tagName)) {
                                textValue = textValue.replace(',', '.');
                                currentCurrency.setValue(Float.parseFloat(textValue));
                            }
                        }
                        break;
                    default:
                }
                eventType = xpp.next();
            }
        } catch (Exception e) {
            status = false;
            e.printStackTrace();
        }
        return status;
    }
}