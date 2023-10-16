package com.capstone.answer.domain.report.entity;


import com.capstone.answer.domain.BaseTimeEntity;
import com.capstone.answer.domain.image.Image;
import com.capstone.answer.domain.member.Member;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "report")
@Getter
public class Report extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "report_id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 40)
    private String title;

    @Lob
    @Column(nullable = false)
    private String content;

    @Column(length = 20)
    private float latitude;

    @Column(length = 20)
    private float longitude;

    @Column(nullable = false, length = 40)
    private String plant;

    @Column(nullable = false, length = 40)
    private String disease;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "report", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> imageLink = new ArrayList<>();


    // 신고 생성
    public static Report createReport(Report report, Member member) {

        return Report.builder()
                .title(report.title)
                .content(report.content)
                .latitude(report.latitude)
                .longitude(report.longitude)
                .plant(report.plant)
                .disease(report.disease)
                .member(member)
                .build();
    }

//    public void update(String title, String content) {
//        this.title = title;
//        this.content = content;
//    }

//
//    // 제목 업데이트
//    public void updateTitle(String title){
//        this.title = title;
//    }
//    // 위치 업데이트
//    public void updateLatitude(float latitude){
//        this.latitude = latitude;
//    }
//
//    public void updateLongitude(float longitude){this.longitude = longitude;}
//    // 본문 업데이트
//    public void updateContent(String content){
//        this.content = content;
//    }
//    // 식물이름 업데이트
//    public void updatePlant(String plant){
//        this.plant = plant;
//    }
//    // 병해 업데이트
//    public void updateDisease(String disease){
//        this.disease = disease;
//    }

}