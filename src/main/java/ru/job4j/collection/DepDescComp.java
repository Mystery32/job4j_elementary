package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;

public class DepDescComp implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        var s3 = s1.split("/");
        var s4 = s2.split("/");

        if (s3.length == 1 || s4.length == 1) {
            if ((s3.length > 1 || s4.length > 1) && s3[0].equals(s4[0])) {
                return s1.compareTo(s2);
            }
            return s2.compareTo(s1);
        } else if ((s3.length > 1 && s4.length > 1) && s3[0].equals(s4[0])) {
            if ((s3.length > 2 && s4.length > 2) && s3[1].compareTo(s4[1]) == 0) {
                return s3[2].compareTo(s4[2]);
            }
            return s3[1].compareTo(s4[1]);
        } else {
            return s2.compareTo(s1);
        }
    }
}

