package com.andantonyan.apitester.common;


import com.fasterxml.jackson.databind.util.StdDateFormat;

import java.io.Serial;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class RFC3339DateFormat extends DateFormat {
    @Serial
    private static final long serialVersionUID = 1L;
    private static final TimeZone TIMEZONE_Z = TimeZone.getTimeZone("UTC");

    private final StdDateFormat fmt = new StdDateFormat()
            .withTimeZone(TIMEZONE_Z)
            .withColonInTimeZone(true);

    public RFC3339DateFormat() {
        this.calendar = new GregorianCalendar();
        this.numberFormat = new DecimalFormat();
    }

    @Override
    public Date parse(String source) {
        return parse(source, new ParsePosition(0));
    }

    @Override
    public Date parse(String source, ParsePosition pos) {
        return fmt.parse(source, pos);
    }

    @Override
    public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
        return fmt.format(date, toAppendTo, fieldPosition);
    }

    @Override
    public Object clone() {
        return super.clone();
    }
}