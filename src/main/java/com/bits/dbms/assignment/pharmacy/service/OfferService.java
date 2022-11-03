package com.bits.dbms.assignment.pharmacy.service;

import com.bits.dbms.assignment.pharmacy.entity.Offer;
import com.bits.dbms.assignment.pharmacy.entity.Product;

import java.util.List;

public interface OfferService {
    Offer saveOffer(Offer offer);
    List<Offer> getAll();
}
