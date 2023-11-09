package edu.unicauca.APIRestTravelAgencyServer.acces;

import co.unicauca.travelagency.commons.domain.Customer;
import java.util.List;

/**
 * Interface del respositorio de clientes
 * @author Libardo Pantoja
 */
public interface ICustomerRepository {
    /**
     * Busca un Customer por su cedula
     * @param id cedula del cliente
     * @return  objeto de tipo Customer
     */
    
    public Customer findCustomer(String id);
    public List<Customer> listCustomers();
    public String createCustomer(Customer customer);
    public String updateUser(Customer customer);

}
