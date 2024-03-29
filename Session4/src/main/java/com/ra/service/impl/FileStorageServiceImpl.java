package com.ra.service.impl;

import com.ra.service.FileStorageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileStorageServiceImpl implements FileStorageService {
    private ServletContext context;
    public FileStorageServiceImpl(ServletContext context) {
        this.context = context;
    }

    @Override
    public String upload(MultipartFile file) {
        String uploadFolder = "/uploads/";
        String path = context.getRealPath("/WEB-INF/") + uploadFolder;
        File folder = new File(path);
        if (!folder.exists()) folder.mkdir();
        if (!file.isEmpty()) {
            Path fileUpload = Paths.get(path + file.getOriginalFilename());
            try {
                Files.write(fileUpload, file.getBytes());
                return uploadFolder + file.getOriginalFilename();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
}
