package com.example.Blood_Conn.service;

import com.example.Blood_Conn.models.BloodDonor;
import com.example.Blood_Conn.repository.BloodDonorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BloodDonorService {
    @Autowired
    private BloodDonorRepository donorRepository;

    public List<BloodDonor> getAllDonors(String keyword) {
        if (keyword != null && !keyword.isEmpty()) {
            return donorRepository.findAllByBloodGroupContaining(keyword);
        } else {
            return donorRepository.findAll();
        }
    }
    public void deleteDonorById(String id) {
        Optional<BloodDonor> donorOptional = donorRepository.findById(Integer.valueOf(id));

        if (donorOptional.isPresent()) {
            donorRepository.delete(donorOptional.get());
        } else {
            throw new EntityNotFoundException("Donor not found with ID: " + id);
        }
    }

    public void deleteDonors(List<String> ids) {
        for (String id : ids) {
            deleteDonorById(id);
        }
    }
    public BloodDonor get(Integer id){
        Optional<BloodDonor> result = donorRepository.findById(id);
        return result.get();
    }
    public void saveDonor(BloodDonor donor) {
        donorRepository.save(donor);
    }
    public void delete(Integer id){
        donorRepository.deleteById(id);
    }
}
