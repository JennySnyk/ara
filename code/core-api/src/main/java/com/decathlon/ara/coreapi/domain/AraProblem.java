package com.decathlon.ara.coreapi.domain;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

@Entity
public class AraProblem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ara_problem_id")
    @SequenceGenerator(name = "ara_problem_id", sequenceName = "ara_problem_id", allocationSize = 1)
    private Long id;

    private String name;
    private String description;

    private String defectCode;

    private String pattern;

    @CreatedBy
    private String createdBy;

    @CreatedDate
    private LocalDateTime createdDatetime;

    @OneToMany
    private List<AraProblemHistory> scenarioResults = Collections.emptyList();

    @OneToMany
    private Set<AraTag> tags = Collections.emptySet();

    protected Long getId() {
        return id;
    }

    protected String getName() {
        return name;
    }

    protected String getDescription() {
        return description;
    }

    protected String getDefectCode() {
        return defectCode;
    }

    protected String getPattern() {
        return pattern;
    }

    protected String getCreatedBy() {
        return createdBy;
    }

    protected LocalDateTime getCreatedDatetime() {
        return createdDatetime;
    }

    protected List<AraProblemHistory> getScenarioResults() {
        return scenarioResults;
    }

    protected Set<AraTag> getTags() {
        return tags;
    }
}
