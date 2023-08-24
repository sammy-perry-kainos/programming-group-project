package org.kainos.ea.api;

import org.kainos.ea.cli.DeliveryRequest;
import org.kainos.ea.client.FailedToCreateDeliveryEmployeeeException;
import org.kainos.ea.db.DeliveryDao;

import java.sql.SQLException;

public class DeliveryService {
    private DeliveryDao deliveryDao = new DeliveryDao();

    public int createDeliveryEmployee(DeliveryRequest deliveryRequest) throws FailedToCreateDeliveryEmployeeeException {
        try {
            int id = deliveryDao.createDeliveryEmployee(deliveryRequest);

            if (id == -1) {
                throw new FailedToCreateDeliveryEmployeeeException();
            }
            return id;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return -1;
    }
}
