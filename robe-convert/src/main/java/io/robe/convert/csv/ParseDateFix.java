package io.robe.convert.csv;

import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.ift.DateCellProcessor;
import org.supercsv.util.CsvContext;

import java.util.Date;
import java.util.Locale;

/**
 * Provides a parser for Date. This is a kind of fix for {@link org.supercsv.cellprocessor.ParseDate}.
 */
public class ParseDateFix extends ParseDate {

    /**
     * Constructs a new <tt>ParseDate</tt> processor which converts a String to a Date using the supplied date format.
     * This constructor uses non-lenient Date interpretation.
     *
     * @param dateFormat the date format to use
     * @throws NullPointerException if dateFormat is null
     */
    public ParseDateFix(String dateFormat) {
        super(dateFormat);
    }

    /**
     * Constructs a new <tt>ParseDate</tt> processor which converts a String to a Date using the supplied date format.
     *
     * @param dateFormat the date format to use
     * @param lenient    whether date interpretation is lenient
     * @throws NullPointerException if dateFormat is null
     */
    public ParseDateFix(String dateFormat, boolean lenient) {
        super(dateFormat, lenient);
    }

    /**
     * Constructs a new <tt>ParseDate</tt> processor which converts a String to a Date using the supplied date format
     * and Locale.
     *
     * @param dateFormat the date format to use
     * @param lenient    whether date interpretation is lenient
     * @param locale     the Locale used to parse the date
     * @throws NullPointerException if dateFormat or locale is null
     */
    public ParseDateFix(String dateFormat, boolean lenient, Locale locale) {
        super(dateFormat, lenient, locale);
    }

    /**
     * Constructs a new <tt>ParseDate</tt> processor which converts a String to a Date using the supplied date format,
     * then calls the next processor in the chain. This constructor uses non-lenient Date interpretation.
     *
     * @param dateFormat the date format to use
     * @param next       the next processor in the chain
     * @throws NullPointerException if dateFormat or next is null
     */
    public ParseDateFix(String dateFormat, DateCellProcessor next) {
        super(dateFormat, next);
    }

    /**
     * Constructs a new <tt>ParseDate</tt> processor which converts a String to a Date using the supplied date format,
     * then calls the next processor in the chain.
     *
     * @param dateFormat the date format to use
     * @param lenient    whether date interpretation is lenient
     * @param next       the next processor in the chain
     * @throws NullPointerException if dateFormat or next is null
     */
    public ParseDateFix(String dateFormat, boolean lenient, DateCellProcessor next) {
        super(dateFormat, lenient, next);
    }

    /**
     * Constructs a new <tt>ParseDate</tt> processor which converts a String to a Date using the supplied date format
     * and Locale, then calls the next processor in the chain.
     *
     * @param dateFormat the date format to use
     * @param lenient    whether date interpretation is lenient
     * @param locale     the Locale used to parse the date
     * @param next       the next processor in the chain
     * @throws NullPointerException if dateFormat, locale, or next is null
     */
    public ParseDateFix(String dateFormat, boolean lenient, Locale locale, DateCellProcessor next) {
        super(dateFormat, lenient, locale, next);
    }

    @Override
    public Object execute(Object value, CsvContext context) {
        validateInputNotNull(value, context);

        // FIX: If it is already Date forward it.
        final Date result;
        if (value instanceof Date) {
            result = (Date) value;
            return next.execute(result, context);
        } else {
            return super.execute(value, context);
        }
    }
}
