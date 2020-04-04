package br.com.otta.numbersconverter.model.api;

import java.util.Objects;

public class ConverterResponse {
    private String originalValue;
    private String convertedValue;

    public ConverterResponse() {
        // Construtor padrão necessário para Serialização.
    }

    public ConverterResponse(String originalValue, String convertedValue) {
        this.originalValue = originalValue;
        this.convertedValue = convertedValue;
    }

    public String getOriginalValue() {
        return originalValue;
    }

    public void setOriginalValue(String originalValue) {
        this.originalValue = originalValue;
    }

    public String getConvertedValue() {
        return convertedValue;
    }

    public void setConvertedValue(String convertedValue) {
        this.convertedValue = convertedValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(convertedValue, originalValue);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConverterResponse)) {
            return false;
        }
        ConverterResponse other = (ConverterResponse) obj;
        return Objects.equals(convertedValue, other.convertedValue)
                && Objects.equals(originalValue, other.originalValue);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ConvertResponse [originalValue=");
        builder.append(originalValue);
        builder.append(", convertedValue=");
        builder.append(convertedValue);
        builder.append("]");
        return builder.toString();
    }
}
