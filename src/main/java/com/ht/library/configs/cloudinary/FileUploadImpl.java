package com.ht.library.configs.cloudinary;

import com.cloudinary.Cloudinary;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class FileUploadImpl implements FileUpload{

  private final Cloudinary cloudinary;

  @Override
  public String uploadFile(MultipartFile multipartFile, String fileName, String directory) throws IOException {
    return uploadFile(multipartFile, fileName, directory, null);
  }

  @Override
  public String uploadFile(Object object, String fileName, String directory, Map<String, Object> options) throws IOException {
    var defaultOptions =  Map.of(
                "public_id", fileName,
                "folder", "bookery/" + directory
        );
    Map<String, Object> mergedOption = new HashMap<>();
    mergedOption.putAll(defaultOptions);
    if (options != null) {
      mergedOption.putAll(options);
    }

    // Object is MultipartFile or Url string
    var ref = object instanceof MultipartFile ? ((MultipartFile) object).getBytes() : object;

    return cloudinary.uploader()
        .upload(ref, mergedOption)
          .get("public_id")
          .toString();
  }

}
