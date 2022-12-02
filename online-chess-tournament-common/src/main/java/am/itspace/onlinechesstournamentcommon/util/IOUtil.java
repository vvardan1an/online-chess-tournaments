package am.itspace.onlinechesstournamentcommon.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

@Component
@Slf4j
public class IOUtil {

    public byte[] getAllBytesByUrl(String fileUrl) throws IOException {
        log.info("request to get image");
        try {
            URL url = new URL(fileUrl);
            try (InputStream inputStream = url.openStream()) {
                log.info("image successfully taken");
                return inputStream.readAllBytes();
            }
        } catch (IOException e) {
            log.error("fail to get image");
            throw new IOException("Exception was thrown during IO operations with URL: " + fileUrl, e);
        }
    }
}
