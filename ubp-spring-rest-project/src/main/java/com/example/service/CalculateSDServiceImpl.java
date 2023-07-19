package com.example.service;

import com.example.exception.ResourceNotFoundException;
import com.example.model.VectorDetails;
import com.example.repository.CalculateSDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
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

    @Override
    public Double calculateSD(String vectors) {
        String[] strSplit = vectors.split("|");
        List<String> vectorList = new ArrayList<String>(Arrays.asList(strSplit));
        Double standardDeviation = calculateSD(toDoubleArray(vectorList));
        return null;
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

    public static double[] toDoubleArray(List<String> stringArray) {
        if (stringArray == null) {
            return null;
        }
        double[] result = new double[stringArray.size()];
        for (int i = 0; i < stringArray.size(); i++) {
            try {
                if (stringArray.get(i) != null) {
                    result[i] = Double.parseDouble(stringArray.get(i));
                } else {
                    result[i] = 0.0;
                }
            } catch (Exception e) {
                e.printStackTrace();
                result[i] = 0;
            }
        }
        return result;
    }
}
