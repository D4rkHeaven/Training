package lopatin;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
public class SausageUtil {
    /**
     * Reads file and decodes strings to sausages
     *
     * @param filePath to file with encoded sausages
     */
    public void fileRead(String filePath) {
        filePath = Optional.ofNullable(filePath).orElseGet(String::new);
        try {
            List<Sausage> sausages = Files.lines(Paths.get(filePath))
                    .map(Base64.getDecoder()::decode)
                    .map(String::new)
                    .map(line -> Arrays.stream(line.split(","))
                            .map(elem -> elem.split("=")[1]).collect(Collectors.toList()))
                    .map(Sausage::new)
                    .collect(Collectors.toList());
            log.info("Generated list of sausages: {}", sausages);
        } catch (IOException e) {
            log.error("File read error ", e);
        }
    }
}
