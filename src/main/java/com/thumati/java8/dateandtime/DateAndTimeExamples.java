package com.thumati.java8.dateandtime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;

public class DateAndTimeExamples {
    public static void main(String[] args) {
        Clock clock = Clock.systemDefaultZone();
        System.out.println("Clock : "+clock);
        long mills = clock.millis();
        System.out.println("Milliseconds : "+mills);

        Instant instant = clock.instant();
        System.out.println("Instant : "+instant);
        Date legacyDate = Date.from(instant);
        System.out.println("Legacy Date : "+legacyDate);

        System.out.println(ZoneId.getAvailableZoneIds());
        //prints all available timezone ids
        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");
        System.out.println(zone1.getRules());
        System.out.println(zone2.getRules());

        // ZoneRules[currentStandardOffset=+01:00]
        // ZoneRules[currentStandardOffset=-03:00]

        LocalTime localTime = LocalTime.now();
        LocalDate localDate = LocalDate.now();
        System.out.println("LocalTime : "+localTime);
        System.out.println("LocalDate : "+localDate);

        DateTimeFormatter germanFormatter =
                DateTimeFormatter
                        .ofLocalizedDate(FormatStyle.MEDIUM)
                        .withLocale(Locale.GERMAN);

        LocalDate xmas = LocalDate.parse("24.12.2014", germanFormatter);
        System.out.println(xmas);   // 2014-12-24
    }
}
