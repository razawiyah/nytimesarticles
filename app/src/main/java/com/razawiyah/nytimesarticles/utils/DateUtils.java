package com.razawiyah.nytimesarticles.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

    // Private constructor to prevent instantiation
    private DateUtils() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static String formatPublishedDate(String originalDate) {
        // Define the possible input date formats
        String[] inputFormats = {
                "yyyy-MM-dd'T'HH:mm:ssXXX", // Example: "2024-06-06T00:01:30-04:00"
                "yyyy-MM-dd"               // Example: "2024-06-03"
        };
        // Define the desired output date format
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());

        Date date = null;
        for (String inputFormat : inputFormats) {
            try {
                date = new SimpleDateFormat(inputFormat, Locale.getDefault()).parse(originalDate);
                break; // If parsing is successful, exit the loop
            } catch (ParseException e) {
                // Continue to the next format if parsing fails
            }
        }

        // If none of the formats worked, return the original date string
        if (date == null) {
            return originalDate;
        }

        // Format the date object to the desired output format
        return outputFormat.format(date);
    }
}



