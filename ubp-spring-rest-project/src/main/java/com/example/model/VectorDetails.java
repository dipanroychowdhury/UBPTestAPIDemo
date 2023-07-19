package com.example.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "vectordemo")
@EntityListeners(AuditingEntityListener.class)
public class VectorDetails {

    @Id
    @Column(name = "VectorId", nullable = false)
    private int vectorId;
    @Column(name = "VectorValues", nullable = false)
    private String vectorValues;
    @Column(name = "createdBy", nullable = false)
    private String createdBy;

    public int getVectorId() {
        return vectorId;
    }

    public void setVectorId(int vectorId) {
        this.vectorId = vectorId;
    }

    public String getVectorValues() {
        return vectorValues;
    }

    public void setVectorValues(String vectorValues) {
        this.vectorValues = vectorValues;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
