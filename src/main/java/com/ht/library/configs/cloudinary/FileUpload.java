package com.ht.library.configs.cloudinary;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileUpload {
  String uploadFile(MultipartFile multipartFile, String directory) throws IOException;
}
