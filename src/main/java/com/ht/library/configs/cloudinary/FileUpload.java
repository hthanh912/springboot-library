package com.ht.library.configs.cloudinary;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface FileUpload {
  String uploadFile(MultipartFile multipartFile, String fileName, String directory) throws IOException;
  String uploadFile(Object file, String fileName, String directory, Map<String, Object> options) throws IOException;
}
