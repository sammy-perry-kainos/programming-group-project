package org.kainos.ea.api;

import org.kainos.ea.cli.SalesRequest;
import org.kainos.ea.client.FailedToCreateSalesException;
import org.kainos.ea.db.SalesDao;

import java.sql.SQLException;

public class SalesEmployeeService {
    private SalesDao salesDao = new SalesDao();

    public int createSales(SalesRequest employee) throws FailedToCreateSalesException{
        try{
            int id = salesDao.createSalesEmployee(employee);

            if(id == -1){
                throw new FailedToCreateSalesException();
            }

            return id;
        }catch(SQLException e){
            System.err.println(e.getMessage());

            throw new FailedToCreateSalesException();
        }
    }
}
