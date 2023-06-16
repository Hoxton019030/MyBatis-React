package com.example.mybatis.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class FileRequest {
    MultipartFile fileName;
}
