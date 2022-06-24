package unit.service;

import com.revature.model.Car;

import java.util.List;

import com.revature.service.CarService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CarServiceTest {
    List<Car> mockList = Mockito.mock(List.class);
    @Test
    public void whenGivenFlashcardObjectCreateNewFlashcardDoesNotThrowAnException(){
        Car car = new Car();
        CarService service = new CarService();

        // we've turned our service invocation into an executable that can be called by the assertion
        Assertions.assertDoesNotThrow(() -> service.createNewCar(car));
    }

    @Test
    public void whenGetAllCarsIsCalledReturnsListOfCars(){

        CarService carService = new CarService();
        Assertions.assertDoesNotThrow(() -> carService.getAllCars());
    }


}
