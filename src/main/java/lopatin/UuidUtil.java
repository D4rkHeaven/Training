package lopatin;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class UuidUtil {
    /**
     * Generates UUID list
     *
     * @return list of UUID
     */
    public List<UUID> generate() {
        return Stream.generate(UUID::randomUUID)
                .limit(10000)
                .collect(Collectors.toList());
    }

    /**
     * Converts UUID list to String list and writes it to file
     *
     * @param filePath path to file
     * @param uuidList UUID list
     */
    public void fileWrite(String filePath, List<UUID> uuidList) {
        filePath = Optional.ofNullable(filePath).orElseGet(String::new);
        List<String> stringList = uuidList.stream()
                .filter(Objects::nonNull)
                .map(UUID::toString)
                .collect(Collectors.toList());
        log.info("Generated list of UUID: {}", stringList);
        try {
            Files.write(Paths.get(filePath), stringList);
        } catch (IOException e) {
            log.error("File write error ", e);
        }
    }

    /**
     * Counts number of UUID in file with value > 100
     *
     * @param filePath path to file
     */
    public void uuidCounter(String filePath) {
        filePath = Optional.ofNullable(filePath).orElseGet(String::new);
        try {
            long count = Files.lines(Paths.get(filePath))
                    .filter(Objects::nonNull)
                    .map(x -> x.replaceAll("\\D", ""))
                    .map(x -> x.chars().map(Character::getNumericValue).sum())
                    .filter(sum -> sum > 100)
                    .count();
            log.info("Number of UUID > 100: {}", count);
        } catch (IOException e) {
            log.error("File write error ", e);
        }
    }
}
