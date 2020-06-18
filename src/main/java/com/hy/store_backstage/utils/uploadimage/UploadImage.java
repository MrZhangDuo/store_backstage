package com.hy.store_backstage.utils.uploadimage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class UploadImage {
    private Integer code;
    private String message;
    private String filename;

}
