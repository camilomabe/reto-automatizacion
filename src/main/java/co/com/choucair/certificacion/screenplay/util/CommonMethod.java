package co.com.choucair.certificacion.screenplay.util;

import net.serenitybdd.screenplay.Performable;

public class CommonMethod {

    public static int cleanValue(String priceProductOne, String priceProductTwo) {
        return (Integer.parseInt(clearPeso(priceProductOne)) + (Integer.parseInt(clearPeso(priceProductTwo))));
    }

    private static String clearPeso(String totalPrice) {
        totalPrice = totalPrice.replaceAll("[^\\w+]", "");
        return totalPrice;
    }

    public static Performable waitSeconds(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
