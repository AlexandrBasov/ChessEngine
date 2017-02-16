package com.alex.chess.util;

import java.util.HashMap;
import java.util.Map;

public class MapCoordinates {

    public static final Map<Integer, String> INDEX_TO_ROW = new HashMap<>();

    public static final Map<Integer, String> INDEX_TO_COLUMN = new HashMap<>();

    public static final Map<String, Integer> ROW_TO_INDEX = new HashMap<>();

    public static final Map<String, Integer> COLUMN_TO_INDEX = new HashMap<>();

    static {
        INDEX_TO_ROW.put(0, "8");
        INDEX_TO_ROW.put(1, "7");
        INDEX_TO_ROW.put(2, "6");
        INDEX_TO_ROW.put(3, "5");
        INDEX_TO_ROW.put(4, "4");
        INDEX_TO_ROW.put(5, "3");
        INDEX_TO_ROW.put(6, "2");
        INDEX_TO_ROW.put(7, "1");

        INDEX_TO_COLUMN.put(0, "a");
        INDEX_TO_COLUMN.put(1, "b");
        INDEX_TO_COLUMN.put(2, "c");
        INDEX_TO_COLUMN.put(3, "d");
        INDEX_TO_COLUMN.put(4, "e");
        INDEX_TO_COLUMN.put(5, "f");
        INDEX_TO_COLUMN.put(6, "g");
        INDEX_TO_COLUMN.put(7, "h");

        ROW_TO_INDEX.put("8", 0);
        ROW_TO_INDEX.put("7", 1);
        ROW_TO_INDEX.put("6", 2);
        ROW_TO_INDEX.put("5", 3);
        ROW_TO_INDEX.put("4", 4);
        ROW_TO_INDEX.put("3", 5);
        ROW_TO_INDEX.put("2", 6);
        ROW_TO_INDEX.put("1", 7);

        COLUMN_TO_INDEX.put("a", 0);
        COLUMN_TO_INDEX.put("b", 1);
        COLUMN_TO_INDEX.put("c", 2);
        COLUMN_TO_INDEX.put("d", 3);
        COLUMN_TO_INDEX.put("e", 4);
        COLUMN_TO_INDEX.put("f", 5);
        COLUMN_TO_INDEX.put("g", 6);
        COLUMN_TO_INDEX.put("h", 7);
    }

}
