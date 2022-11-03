package com.bits.dbms.assignment.pharmacy.service;

import com.bits.dbms.assignment.pharmacy.entity.Offer;
import com.bits.dbms.assignment.pharmacy.repository.OfferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;

    @Override
    @Transactional
    public Offer saveOffer(Offer offer) {
        offer.setCreated_on(offer.getCreated_on());
        offer.setModified_on(new Date());
        return offerRepository.save(offer);
    }

    @Override
    @Transactional
    public List<Offer> getAll() {
        return offerRepository.findAll();
    }
}
