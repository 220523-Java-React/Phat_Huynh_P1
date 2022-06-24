package com.revature.controller;


import com.revature.model.Offer;

import com.revature.model.Status;
import com.revature.model.User;
import com.revature.service.CarService;
import com.revature.service.OfferService;
import com.revature.util.ConnectionUtility;
import io.javalin.http.Handler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class OfferController {
    OfferService offerService;

    public OfferController() {
        offerService = new OfferService();
    }

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    public Handler getAllOffers = context -> {

        String statusParam = context.queryParam("status");
//         if(identifierParam == null){
//             context.json(offerService.getAllOffers());
//         } else {
//             try{
                 if(statusParam == null){
                     context.json(offerService.getAllOffers());
                 }
                 else{
                     Status status = Status.valueOf(statusParam);
                     context.json(offerService.getAllStatus(status));
                 }

//             } catch (IllegalArgumentException e){
//                 context.status(400);
//             }
//         }


    };

    public Handler updateOffer = context ->{
        Offer offer = context.bodyAsClass(Offer.class);
        offerService.updateOffer(offer);
//
//        if(offer != null){
//            context.status(200).json(offer);
//        } else{
//            context.status(400).result("Could not update the user");
//        }

    };



        public Handler createNewOffer = context -> {
            Offer offer = context.bodyAsClass(Offer.class);
            offerService.createOffer(offer);

        };



}
