package com.example.controller;

import com.example.exception.ResourceNotFoundException;
import com.example.model.VectorDetails;
import com.example.service.CalculateSDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CalculateSDController {

    @Autowired
    private CalculateSDService calculateSDService;

    /**
     * Get all vectors list.
     *
     * @return the list
     */
    @GetMapping("/vectors")
    public List<VectorDetails> getAllVectors() {
        return calculateSDService.getAllVectors();
    }

    /**
     * Gets vectors by id.
     *
     * @param vectorId the vector id
     * @return the vectors by id
     * @throws ResourceNotFoundException the resource not found exception
     */
    @GetMapping("/vectors/{id}")
    public ResponseEntity<VectorDetails> getVectorsById(@PathVariable(value = "id") Integer vectorId)
            throws ResourceNotFoundException {
        VectorDetails vectorDetails = calculateSDService.getVectorsById(vectorId);
        return ResponseEntity.ok().body(vectorDetails);
    }

}
