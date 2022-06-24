package com.revature.service;


import com.revature.model.Offer;
import com.revature.model.Status;
import com.revature.model.User;
import com.revature.repository.OfferRepository;

import java.util.List;

public class OfferService {

    OfferRepository offerRepository;

    public OfferService(){offerRepository = new OfferRepository();}
    public OfferService(OfferRepository offerRepository){this.offerRepository = offerRepository;}

    public Offer createOffer(Offer offer) {return offerRepository.create(offer);}
    public List<Offer> getAllOffers() {return offerRepository.getAll();}

    public Offer getByUserName (String userName) {return offerRepository.getByUserName(userName);
    }


    public List<Offer> getAllStatus(Status status){return offerRepository.getAllByStatus(status);}
    public Offer updateOffer(Offer offer){
        return offerRepository.updateOffer(offer);
    }



}
