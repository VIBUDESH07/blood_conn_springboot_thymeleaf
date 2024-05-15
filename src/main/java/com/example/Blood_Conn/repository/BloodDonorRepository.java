package com.example.Blood_Conn.repository;

import com.example.Blood_Conn.models.BloodDonor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BloodDonorRepository extends JpaRepository<BloodDonor, Integer> {
    @Query("SELECT p FROM BloodDonor p WHERE p.blood_group LIKE %?1%")
    public List<BloodDonor> findAllByBloodGroupContaining(String keyword);

    // Additional methods if needed
}
