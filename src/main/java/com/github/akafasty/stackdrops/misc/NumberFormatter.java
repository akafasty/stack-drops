package com.github.akafasty.stackdrops.misc;

import lombok.experimental.UtilityClass;

import java.text.NumberFormat;
import java.util.Locale;

@UtilityClass
public class NumberFormatter {

    private final NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.forLanguageTag("pt-BR"));

    /**
     *
     * @param value to be formatted
     * @return value formatted (2.000.000)
     */
    public String numberFormat(double value) {

        numberFormat.setMaximumFractionDigits(1);

        return numberFormat.format(value);

    }

}
