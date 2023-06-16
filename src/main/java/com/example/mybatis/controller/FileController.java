package com.example.mybatis.controller;

import com.example.mybatis.request.FileRequest;
import org.apache.commons.io.FilenameUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/file")
@RestController
public class FileController {

    @PostMapping(value = "/",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadFile(@RequestPart("file") MultipartFile file) {
        String string = file.getOriginalFilename();
        String extension = FilenameUtils.getExtension(string);
        System.out.println( extension );
        return ResponseEntity.status(HttpStatus.OK).body(string);
    }
}
