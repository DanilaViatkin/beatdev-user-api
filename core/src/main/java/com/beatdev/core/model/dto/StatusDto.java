package com.beatdev.core.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusDto {
    private Long userId;
    private String currentStatus;
    private String previousStatus;
}
