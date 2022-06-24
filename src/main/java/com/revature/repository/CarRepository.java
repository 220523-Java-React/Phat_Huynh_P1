package com.revature.repository;

import com.revature.model.Car;

import com.revature.util.ConnectionUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarRepository implements DAO<Car> {

    @Override
    public Car create(Car car) {

        String sql = "insert into cars(make, model, color, year, price) values(?,?,?,?,?)";

        try(Connection connection = ConnectionUtility.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, car.getMake());
            stmt.setString(2,car.getModel());
            stmt.setString(3,car.getColor());
            stmt.setInt(4,car.getYear());
            stmt.setInt(5,car.getPrice());

            int success = stmt.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Car> getAll(){
        List<Car> cars = new ArrayList<>();
        String sql = "select * from cars";

        try(Connection connection = ConnectionUtility.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);

            ResultSet results = stmt.executeQuery();

            while(results.next()){

                cars.add(new Car()
                                .setId(results.getInt("id"))
                        .setMake(results.getString("make"))
                        .setModel(results.getString("model"))
                        .setColor(results.getString("color"))
                        .setYear(results.getInt("year"))
                        .setPrice(results.getInt("price")));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return cars;
    }

    @Override
    public Car getById(int id) {
        return null;
    }

    @Override
    public Car update(Car car) {return null;}

    @Override
    public boolean deleteById(int id) {return false;}
}
