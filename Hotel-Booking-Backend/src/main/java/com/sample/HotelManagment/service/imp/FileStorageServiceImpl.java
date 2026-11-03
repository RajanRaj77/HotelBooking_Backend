
package com.sample.HotelManagment.service.imp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.sample.HotelManagment.service.FileStorageService;

@Service
public class FileStorageServiceImpl implements FileStorageService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Override
    public String saveFile(MultipartFile file) {

        if (file == null || file.isEmpty()) {
            return null;
        }

        try {
            // Create upload directory
            Path uploadPath = Paths.get(uploadDir)
                    .toAbsolutePath().normalize();

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // Get original filename
            String originalName = StringUtils.cleanPath(
                    file.getOriginalFilename() == null
                    ? ""
                    : file.getOriginalFilename()
            );

            // Get file extension
            String extension = "";
            int dotIndex = originalName.lastIndexOf(".");

            if (dotIndex > 0) {
                extension = originalName.substring(dotIndex);
            }

            // Generate unique filename
            String fileName = UUID.randomUUID() + extension;

            // Create complete file path
            Path filePath = uploadPath.resolve(fileName);

            // Save file
            try (var inputStream = file.getInputStream()) {
                Files.copy(
                    inputStream,
                    filePath,
                    StandardCopyOption.REPLACE_EXISTING
                );
            }

            return fileName;

        } catch (IOException e) {
            throw new RuntimeException("Failed to store file", e);
        }
    }

    @Override
    public void deleteFile(String fileName) {

        if (fileName == null || fileName.isBlank()) {
            return;
        }

        try {
            Path uploadPath = Paths.get(uploadDir)
                    .toAbsolutePath().normalize();

            // Prevent path traversal
            Path filePath = uploadPath.resolve(
                    Paths.get(fileName).getFileName()
            ).normalize();

            if (!filePath.startsWith(uploadPath)) {
                throw new RuntimeException("Invalid file path");
            }

            Files.deleteIfExists(filePath);

        } catch (IOException e) {
            throw new RuntimeException("Unable to delete file", e);
        }
    }
}
