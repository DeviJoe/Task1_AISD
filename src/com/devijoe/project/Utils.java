package com.devijoe.project;

import java.util.List;

public class Utils {

    public static int findMaxLengthOfLine (List<StringBuilder> list) {
        int max = 0;

        for (int i=0; i<list.size(); i++) {
            if (list.get(i).length() > max) {
                max = list.get(i).length();
            }
        }

        return max;
    }
}
