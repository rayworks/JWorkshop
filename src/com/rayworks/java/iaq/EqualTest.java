package com.rayworks.java.iaq;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


/**
 * Created by Shirley on 6/26/16.
 */
public class EqualTest {

    public static final class PhoneNumber {
        private final short areaCode;
        private final short prefix;
        private final short lineNumber;

        public PhoneNumber(int areaCode, int prefix,
                           int lineNumber) {
            rangeCheck(areaCode, 999, "area code");
            rangeCheck(prefix, 999, "prefix");
            rangeCheck(lineNumber, 9999, "line number");

            this.areaCode = (short) areaCode;
            this.prefix = (short) prefix;
            this.lineNumber = (short) lineNumber;
        }

        private static void rangeCheck(int arg, int max,
                                       String name) {
            if (arg < 0 || arg > max)
                throw new IllegalArgumentException(name + ": " + arg);
        }

        @Override
        public boolean equals(Object o) {
            if (o == this)
                return true;
            if (!(o instanceof PhoneNumber))
                return false;
            PhoneNumber pn = (PhoneNumber) o;
            return pn.lineNumber == lineNumber
                    && pn.prefix == prefix
                    && pn.areaCode == areaCode;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + areaCode;
            result = 31 * result + prefix;
            result = 31 * result + lineNumber;

            super.hashCode();
            return result;
        }
    }

    public static void main(String[] args) {
        Map<PhoneNumber, String> m = new HashMap<PhoneNumber, String>();
        m.put(new PhoneNumber(707, 867, 5309), "Jenny");

        System.out.println("Map initialized size == " + m.size());

        String value = m.get(new PhoneNumber(707, 867, 5309));

        System.out.println("value retrieved: " + value);
    }
}
