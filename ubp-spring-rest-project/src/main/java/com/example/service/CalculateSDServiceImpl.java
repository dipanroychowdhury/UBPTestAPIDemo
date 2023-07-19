package com.example.service;

import com.example.exception.ResourceNotFoundException;
import com.example.model.VectorDetails;
import com.example.repository.CalculateSDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculateSDServiceImpl implements CalculateSDService{

    @Autowired
    private CalculateSDRepository calculateSDRepository;

    @Override
    public VectorDetails getVectorsById(Integer vectorId) throws ResourceNotFoundException {
        return calculateSDRepository.findById(vectorId)
                .orElseThrow(() -> new ResourceNotFoundException("VectorDetails", "id", vectorId));
    }

    @Override
    public List<VectorDetails> getAllVectors() {

        return calculateSDRepository.findAll();
    }



    public double calculateSD(double numArray[])
    {
        double sum = 0.0, standardDeviation = 0.0;
        int length = numArray.length;

        for(double num : numArray) {
            sum += num;
        }

        double mean = sum/length;

        System.out.format("Mean = %.6f\n ", mean);

        for(double num: numArray) {
            standardDeviation += Math.pow(num - mean, 2);
        }

        return Math.sqrt(standardDeviation/length);
    }
}
