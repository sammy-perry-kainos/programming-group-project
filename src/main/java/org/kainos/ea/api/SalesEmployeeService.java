package org.kainos.ea.api;

import org.kainos.ea.cli.SalesRequest;
import org.kainos.ea.client.FailedToCreateSalesException;
import org.kainos.ea.client.InvalidSalesEmployeeException;
import org.kainos.ea.core.SalesEmployeeValidator;
import org.kainos.ea.db.SalesDao;

import java.sql.SQLException;

public class SalesEmployeeService {

    private SalesDao salesDao;
    private SalesEmployeeValidator salesEmployeeValidator;
    public SalesEmployeeService(SalesDao salesDao, SalesEmployeeValidator salesEmployeeValidator){
        this.salesDao = salesDao;
        this.salesEmployeeValidator = salesEmployeeValidator;
    }

    public int createSales(SalesRequest employee) throws FailedToCreateSalesException, InvalidSalesEmployeeException {
        try{
            String validation = salesEmployeeValidator.isValidSalesEmployee(employee);

            if(validation != null){
                throw new InvalidSalesEmployeeException(validation);
            }

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