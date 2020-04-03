package br.com.otta.numbersconverter.model;

import java.util.Arrays;

public enum ItemType {
    UNKNOWN(0),
    ROMAN(1),
    ARABIC(2);
    
    private int id;

    private ItemType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static ItemType get(int id) {
        return Arrays.stream(values())
                .filter(item -> item.getId() == id)
                .findFirst().orElse(ItemType.UNKNOWN);
    }
}
