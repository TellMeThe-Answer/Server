package com.capstone.answer.domain.report.service;

import com.capstone.answer.domain.report.dto.ReportUpdateDto;
import com.capstone.answer.domain.report.entity.Report;

public interface ReportService {

    // 신고 추가
    Report addReport(Report report, String memberEmail);

    // 신고 수정
    void updateReport(ReportUpdateDto reportUpdateDto) throws Exception;

    // 신고 삭제
    void deleteReport(Long reportId);

    // 유저에 대한 신고아이디 조회

    // 신고아이디로 신고내역 조회
    void getReportInfo(Long reportId);

    // 신고 내역 조회
    void getReportList(Long memberId);

    // 마커 신고 내역 조회


    // 신고아이디로 이미지 조회
}
