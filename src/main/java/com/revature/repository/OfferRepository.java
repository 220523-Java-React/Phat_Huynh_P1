package com.revature.repository;

import com.revature.controller.OfferController;
import com.revature.model.*;
import com.revature.util.ConnectionUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OfferRepository implements DAO<Offer> {
    private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);

    public Offer create(Offer offer) {
//          String sql = "update offers set offer = ? where id = ?";
        String sql = "insert into offers(id, offers, make, model, year, color, price) values(?,?,?,?,?,?,?)";

        try (Connection connection = ConnectionUtility.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, offer.getId());
            stmt.setInt(2, offer.getOffer());
            stmt.setString(3, offer.getMake());
            stmt.setString(4, offer.getModel());
            stmt.setInt(5, offer.getYear());
            stmt.setString(6, offer.getColor());
            stmt.setInt(7, offer.getPrice());

            int success = stmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Offer updateOffer(Offer offer) {
        String sql = "update offers set offers = ?, username = ?, status = ? where id = ?";
//        String sql = "insert into offers(id, offers, make, model, year, color, price) values(?,?,?,?,?,?,?)";

        try (Connection connection = ConnectionUtility.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, offer.getOffer());
            stmt.setString(2, offer.getUserName());
            stmt.setInt(3, offer.getStatus().ordinal());
            stmt.setInt(4, offer.getId());

            int success = stmt.executeUpdate();
            if(success !=0){
                return getById(offer.getId());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    public List<Offer> getAllByStatus(Status status) {
        List<Offer> offers = new ArrayList<>();
        String sql = "select * from offers where status = ?";

        try (Connection connection = ConnectionUtility.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, status.ordinal());

            ResultSet results = stmt.executeQuery();

            while (results.next()) {
                offers.add(new Offer()
                        .setId(results.getInt("id"))
                        .setOffer(results.getInt("offers"))
                        .setMake(results.getString("make"))
                        .setModel(results.getString("model"))
                        .setYear(results.getInt("year"))
                        .setColor(results.getString("color"))
                        .setPrice(results.getInt("price"))
                        .setUserName(results.getString("username"))
                                .setStatus(Status.values()[results.getInt("status")])

                );
            }
        } catch (SQLException e) {
            logger.warn(e.getMessage());
        }
        return offers;
    }

    public List<Offer> getAll(){
        List<Offer> offers = new ArrayList<>();
        String sql = "select * from offers";

        try (Connection connection = ConnectionUtility.getConnection()){
           PreparedStatement stmt = connection.prepareStatement(sql);

            ResultSet results = stmt.executeQuery();

            while(results.next()){
                offers.add(new Offer()
                        .setId(results.getInt("id"))
                        .setOffer(results.getInt("offers"))
                        .setMake(results.getString("make"))
                        .setModel(results.getString("model"))
                        .setYear(results.getInt("year"))
                        .setColor(results.getString("color"))
                        .setPrice(results.getInt("price"))
                        .setUserName(results.getString("username"))
                                .setStatus(Status.values()[results.getInt("status")])

                );


            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return offers;
    }

    @Override
    public Offer getById(int id) {
        return null;
    }


    public Offer getByUserName(String userName) {

        String sql = "select * from offers where username = ?";
        try(Connection connection = ConnectionUtility.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, userName);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                // build return the user and return it
                return new Offer()
                        .setId(rs.getInt("id"))
                        .setOffer(rs.getInt("offers"))
                        .setMake(rs.getString("make"))
                        .setModel(rs.getString("model"))
                        .setYear(rs.getInt("year"))
                        .setColor(rs.getString("color"))
                        .setPrice(rs.getInt("price"))
                        .setUserName(rs.getString("username"));

            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }



    @Override
    public Offer update(Offer offer) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
