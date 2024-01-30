package david.summernoteEditor.controller;

import david.summernoteEditor.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

@Slf4j
@RequiredArgsConstructor
@Controller
public class ImageController
{
    private final FileService fileService;

    @ResponseBody
    @PostMapping("/images")
    public String uploadImage(@RequestParam("file") MultipartFile file) throws IOException
    {
        return "/images/" + fileService.saveFile(file);
    }

    @ResponseBody
    @GetMapping("/images/{serverFileName}")
    public Resource downloadImage(@PathVariable String serverFileName) throws MalformedURLException
    {
        String fullPath = fileService.createFullPath(serverFileName);
        return new UrlResource("file:"+fullPath);
    }
}
