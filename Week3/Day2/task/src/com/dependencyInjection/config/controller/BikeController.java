package com.dependencyInjection.config.controller;

import com.dependencyInjection.config.beans.DatabaseOperation;
import com.dependencyInjection.config.configg.Config;
import com.dependencyInjection.config.model.Bike;
import com.dependencyInjection.config.model.Car;
import com.dependencyInjection.config.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@Component
public class BikeController implements VehicleController{


    @Autowired
    private DatabaseOperation dbOperation;
    @Override
    public void saveVehicle(Vehicle vehicle) {
        String sql = "INSERT INTO vehicle (type, brand) VALUES (?, ?)";
        try (PreparedStatement pstmt = dbOperation.getCon().prepareStatement(sql)) {
            pstmt.setString(1, ((Bike) vehicle).getType().toString());
            pstmt.setString(2,((Bike) vehicle).getBrand());
            pstmt.executeUpdate();
            System.out.println("Vehicle saved: " + ((Bike) vehicle).getBrand());
        } catch (SQLException e) {
            System.out.println("Error saving vehicle: " + e.getMessage());
        }
    }
}
