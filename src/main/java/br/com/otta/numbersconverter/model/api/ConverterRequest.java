package br.com.otta.numbersconverter.model.api;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import br.com.otta.numbersconverter.model.ItemType;

public class ConverterRequest {
    @NotNull(message = "Informe um tipo de conversão.")
    private ItemType itemType;
    @NotNull(message = "Informe um valor para converter.")
    private String userInput;

    public ConverterRequest() {
        // Construtor padrão necessário para Serialização.
    }

    public ConverterRequest(ItemType itemType, String userInput) {
        this.itemType = itemType;
        this.userInput = userInput;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemType, userInput);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConverterRequest)) {
            return false;
        }
        ConverterRequest other = (ConverterRequest) obj;
        return itemType == other.itemType && Objects.equals(userInput, other.userInput);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ConverterRequest [itemType=");
        builder.append(itemType);
        builder.append(", userInput=");
        builder.append(userInput);
        builder.append("]");
        return builder.toString();
    }
}
