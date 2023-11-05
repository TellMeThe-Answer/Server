package com.capstone.answer.domain.report.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReportUpdateDto {

    private Long reportId;
    private String title;
    private String content;
    private float latitude;
    private float longitude;
    private String plant;
    private String disease;
}
