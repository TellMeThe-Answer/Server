package com.capstone.answer.domain.report.service;

import com.capstone.answer.domain.member.Member;
import com.capstone.answer.domain.member.repository.MemberRepository;
import com.capstone.answer.domain.report.dto.ReportUpdateDto;
import com.capstone.answer.domain.report.entity.Report;
import com.capstone.answer.domain.report.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;
    private final MemberRepository memberRepository;

    /**
     * 신고추가
     */
    @Override
    public Report addReport(Report report, String memberEmail) {

        Member member = memberRepository.findReportByEmail(memberEmail);

        Report inputReport = Report.createReport(report, member);
        return reportRepository.save(inputReport);
    }

    /**
     * 게시글 업데이트
     */
    @Override
    public void updateReport(ReportUpdateDto reportUpdateDto) throws Exception{
        reportUpdateDto.reportId().orElseThrow(()-> new Exception("게시글 아이디가 없습니다.")); // 인자에 게시글
        Report findReport = reportRepository.findById(reportUpdateDto.reportId().get()).orElseThrow(()-> new Exception("존재하지 않는 회원입니다."));
        reportUpdateDto.content().ifPresent(findReport::updateContent);
        reportUpdateDto.title().ifPresent(findReport::updateTitle);
        reportUpdateDto.longitude().ifPresent(findReport::updateLongitude);
        reportUpdateDto.latitude().ifPresent(findReport::updateLatitude);
        reportUpdateDto.plant().ifPresent(findReport::updatePlant);
        reportUpdateDto.disease().ifPresent(findReport::updateDisease);
        reportRepository.save(findReport);
    }

    @Override
    public void deleteReport(Long reportId) {
        reportRepository.findById(reportId).ifPresentOrElse(
                report -> reportRepository.delete(report),
                () -> new Exception("존재하지 않는 게시글입니다.")
        );
    }

    @Override
    public void getReportInfo(Long reportId) {

    }

    @Override
    public void getReportList(Long memberId) {

    }
}
