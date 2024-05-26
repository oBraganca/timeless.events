package com.timeless.events.controller.impl;

import com.timeless.events.controller.ITierController;
import com.timeless.events.dto.entity.tier.TierRequest;
import com.timeless.events.dto.entity.tier.TierResponse;
import com.timeless.events.repository.ITierRepository;
import com.timeless.events.service.ITierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Validated
@RestController
@RequestMapping(value = "v1/")
public class TierControllerImpl implements ITierController {
    private final ITierService iTierService;

    @Autowired
    TierControllerImpl(ITierService iTierService){
        this.iTierService = iTierService;
    }

    @Override
    @PostMapping("/tiers")
    public ResponseEntity<Void> createTier(TierRequest tierRequest) throws Exception {
        iTierService.createTier(tierRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/tiers")
    public ResponseEntity<List<TierResponse>> getAllTiers() {
        return new ResponseEntity<>(
                iTierService.getAllTiers(),
                HttpStatus.OK
        );
    }

    @Override
    @GetMapping("/tiers/{id}")
    public ResponseEntity<TierResponse> getTierById(UUID id) throws Exception {
        return new ResponseEntity<>(
                iTierService.getTierById(id),
                HttpStatus.OK
        );
    }

    @Override
    @PutMapping("/tiers/{id}")
    public ResponseEntity<Void> updateTier(UUID id, TierRequest tierRequest) throws Exception {
        iTierService.updateTier(id, tierRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    @DeleteMapping("/tiers/{id}")
    public ResponseEntity<Void> deleteTier(UUID id) throws Exception {
        iTierService.deleteTier(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
