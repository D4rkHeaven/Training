package lopatin;

import lombok.extern.slf4j.Slf4j;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Optional;

@Slf4j
public class Doomsday {
    /**
     * Generates date of doomsday based on startDate
     *
     * @param startDate initial value for N and M count
     */
    public void generate(Long startDate) {
        try {
            String stringDate = Optional
                    .ofNullable(String.format("%04d", startDate))
                    .orElse(String.format("%04d", 0));
            int n = Integer.parseInt(stringDate.substring(0, 2).replaceAll("\\D", ""));
            int m = Integer.parseInt(stringDate.substring(2, 4).replaceAll("\\D", ""));
            ZonedDateTime doomsdayDate = ZonedDateTime.now(ZoneId.of("America/Los_Angeles")).plusMonths(n).plusDays(m);
            log.info("The end is coming at {}", DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).format(doomsdayDate));
        } catch (NumberFormatException e) {
            log.error("Incorrect input time.");
        }
    }
}
