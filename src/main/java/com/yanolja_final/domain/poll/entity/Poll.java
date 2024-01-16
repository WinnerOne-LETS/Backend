package com.yanolja_final.domain.poll.entity;

import com.yanolja_final.global.common.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Poll extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 50, nullable = false)
    private String aName;

    @Column(length = 50, nullable = false)
    private String aHashtag;

    @Column(length = 100, nullable = false)
    private String aQuestion;

    @Column(nullable = false)
    private Integer aCount = 0;

    @Column(length = 50, nullable = false)
    private String bName;

    @Column(length = 50, nullable = false)
    private String bHashtag;

    @Column(length = 100, nullable = false)
    private String bQuestion;

    @Column(nullable = false)
    private Integer bCount = 0;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "pollId")
    private List<PollAnswer> pollAnswers;

    public void incrementACount() {
        this.aCount++;
    }

    public void incrementBCount() {
        this.bCount++;
    }
}
