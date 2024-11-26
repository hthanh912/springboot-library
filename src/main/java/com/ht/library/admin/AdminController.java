package com.ht.library.admin;

import com.ht.library.user.dto.UserDetailResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    @PostMapping("/import-data")
    public void getUserInfo(@RequestParam("authorJLData") MultipartFile authorJLData, @RequestParam("bookJLData") MultipartFile bookJLData) {
        adminService.importJLData(authorJLData, bookJLData);
    }
}
