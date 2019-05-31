package acceptance.tdd.rocks.hooks;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public enum World {

    INSTANCE;

    public String castToNull(String string) {

        return (string.isEmpty() || string.equals("null")) ?
                null :
                string;
    }

    public String[] castToNull(String[] string) {

        return (string.length == 1) ?
                null :
                string;
    }

    public Object castToInteger(String string) {

        return (StringUtils.isNumeric(string)) ?
                NumberUtils.toInt(string) :
                string;
    }
}