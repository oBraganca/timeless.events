package com.timeless.events.service.impl;

import com.timeless.events.dto.entity.tier.TierRequest;
import com.timeless.events.dto.entity.tier.TierResponse;
import com.timeless.events.handler.exceptions.AlreadyExistsException;
import com.timeless.events.handler.exceptions.NotFoundException;
import com.timeless.events.model.EventCategory;
import com.timeless.events.model.Tier;
import com.timeless.events.repository.ITierRepository;
import com.timeless.events.service.ITierService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class TierServiceImpl implements ITierService {
    private final ITierRepository iTierRepository;

    TierServiceImpl(ITierRepository iTierRepository){
        this.iTierRepository = iTierRepository;
    }


    @Override
    public void createTier(TierRequest tierRequest) throws Exception {
        Tier tier = iTierRepository.findByTitle(tierRequest.getTitle());

        if(tier != null){
            throw new AlreadyExistsException("Title");
        }

        iTierRepository.save(Tier.builder()
                .title(
                        tierRequest.getTitle()
                ).build());

    }

    @Override
    public List<TierResponse> getAllTiers() {
        return iTierRepository.findAllTierDTO();
    }

    @Override
    public TierResponse getTierById(UUID id) throws Exception {
        Optional<Tier> optionalTier = iTierRepository.findById(id);

        if(!optionalTier.isPresent()){
            throw new NotFoundException("Id");
        }

        return new TierResponse(
                optionalTier.get().getId(),
                optionalTier.get().getTitle()
        );
    }

    @Override
    public void updateTier(UUID id, TierRequest tierRequest) throws Exception {
        Optional<Tier> optionalTier = iTierRepository.findById(id);

        if(!optionalTier.isPresent()){
            throw new NotFoundException("Id");
        }

        Tier tier = iTierRepository.findByTitleAndIdNot(tierRequest.getTitle(), id);
        if(tier != null){
            throw new AlreadyExistsException("Title");
        }

        tier = optionalTier.get();

        tier.setTitle(tierRequest.getTitle());

        iTierRepository.save(tier);
    }

    @Override
    public void deleteTier(UUID id) throws Exception {
        Optional<Tier> optionalTier = iTierRepository.findById(id);

        if(!optionalTier.isPresent()){
            throw new NotFoundException("Id");
        }

        iTierRepository.deleteById(id);
    }
}
