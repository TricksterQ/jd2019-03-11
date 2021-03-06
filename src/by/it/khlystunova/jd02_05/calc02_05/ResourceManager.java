package by.it.khlystunova.jd02_05.calc02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;

    private ResourceBundle resourceBundle;

    ResourceManager() {
        Locale locale = Locale.getDefault();
        setLocale(locale);
    }

    String getString(String key){
        return resourceBundle.getString(key);
    }

    void setLocale(Locale locale){
        String baseName = "by.it.khlystunova.jd02_05.calc02_05.res.messages";
        this.resourceBundle = ResourceBundle.getBundle(baseName, locale);
    }


}
