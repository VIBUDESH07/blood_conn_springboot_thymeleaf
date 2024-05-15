package com.example.Blood_Conn.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "blood_donor")


public class BloodDonor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="blood_group")
    private String blood_group;
    @Column(name = "blood_id")
    private String blood_id;
    @Column(name = "branch_name")
    private String branch_name;
    @Column(name = "branch_district")
    private String branch_district;
    @Column(name="entry_date")
    private String entry;

    public BloodDonor() {

    }


// Constructors, getters, and setters (similar to the previous example)
}
