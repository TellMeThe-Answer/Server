package com.capstone.answer.domain.report.entity;

import com.capstone.answer.domain.BaseTimeEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "image")
@Getter
public class Image extends BaseTimeEntity {

    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long imageId;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "report_id")
    private Report report;

    @Column(name = "image_Link")
    private String imageLink;

    public void updateImageLink(String imageLink){
        this.imageLink = imageLink;
    }
}

