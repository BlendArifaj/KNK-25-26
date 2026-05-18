package app;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18n {
    private static Locale locale = Locale.ENGLISH;
    private static String baseName = "i18n.message";

    public static void setLocale(Locale locale){
        I18n.locale = locale;
    }

    public static ResourceBundle getResourceBundle(){
        return ResourceBundle.getBundle(baseName, locale);
    }
}
