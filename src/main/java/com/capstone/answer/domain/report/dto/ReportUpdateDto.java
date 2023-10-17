package com.capstone.answer.domain.report.dto;


import java.util.Optional;

public record ReportUpdateDto(
        Optional<Long> reportId,
        Optional<String> title,
        Optional<String> content,
        Optional<Float> latitude,
        Optional<Float> longitude,
        Optional<String> plant,
        Optional<String> disease
) {
}