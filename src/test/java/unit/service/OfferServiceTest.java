package unit.service;

import com.revature.model.Offer;
import com.revature.service.OfferService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OfferServiceTest {

    @Test
    public void whenGivenOfferObjectCreateNewOfferDoesNotThrowAnException(){
        Offer offer = new Offer();
        OfferService service = new OfferService();
        Assertions.assertDoesNotThrow(() -> service.createOffer(offer));
    }

    @Test
    public void whenGetAllOffersIsCalledReturnsListOfOffers(){
        OfferService service = new OfferService();
        Assertions.assertDoesNotThrow( () -> service.getAllOffers());
    }
}
