package com.example.service;

import com.example.model.VectorDetails;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CalculateSDService {

    VectorDetails getVectorsById (Integer vectorId);
    List<VectorDetails> getAllVectors();
    Double calculateSD(String vectors);
}
