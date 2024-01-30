package david.summernoteEditor.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@Service
public class FileService
{
    @Value("${file.dir}")
    private String defaultPath;

    public String saveFile(MultipartFile file) throws IOException
    {
        String clientFileName = file.getOriginalFilename();
        String serverFileName = createServerFileName(clientFileName);

        file.transferTo(new File(createFullPath(serverFileName)));
        return serverFileName;
    }

    public String createFullPath(String serverFileName)
    {
        return defaultPath + serverFileName;
    }

    private static String createServerFileName(String clientFileName)
    {
        String extension = extractExtension(clientFileName);
        String uuid = UUID.randomUUID().toString();
        return uuid + "." + extension;
    }

    private static String extractExtension(String clientFileName)
    {
        int indexOfDot = clientFileName.indexOf(".");
        return clientFileName.substring(indexOfDot + 1);
    }
}
