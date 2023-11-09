package edu.unicauca.APIRestTravelAgencyServer.services;



import co.unicauca.travelagency.commons.domain.Customer;
import co.unicauca.travelagency.commons.infra.JsonError;
import co.unicauca.travelagency.commons.infra.Utilities;
import edu.unicauca.APIRestTravelAgencyServer.acces.ICustomerRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Servicio de clientes. Da acceso a la lógica de negocio
 *
 * @author Libardo, Julio
 */
@Service
public class CustomerService {

    /**
     * Repositorio de clientes
     */
    @Autowired
    ICustomerRepository repo;

    /**
     * Constructor parametrizado. Hace inyeccion de dependencias
     *
     * @param repo repositorio de tipo ICustomerRepository
     */
    public CustomerService(ICustomerRepository repo) {
        this.repo = repo;
    }

    /**
     * Buscar un cliente
     *
     * @param id cedula
     * @return objeto tipo Customer
     */
    public synchronized Customer findCustomer(String id) {
        return repo.findCustomer(id);
    }
    
    /**
     * Obtener los clientes
     */
    

    /**
     * Crea un nuevo customer. Aplica validaciones de negocio
     *
     * @param customer cliente
     * @return devuelve la cedula del customer creado
     */
    public synchronized String createCustomer(Customer customer) {
       List<JsonError> errors = new ArrayList<>();
  
        // Validaciones y reglas de negocio
        if (customer.getId().isEmpty() || customer.getFirstName().isEmpty()
                || customer.getLastName().isEmpty() || customer.getEmail().isEmpty()
                || customer.getGender().isEmpty()) {
           errors.add(new JsonError("400", "BAD_REQUEST","id, nombres, apellidos, email y género son obligatorios. "));
        }
        
        if (!customer.getEmail().contains("@")){
            errors.add(new JsonError("400", "BAD_REQUEST","Email debe tener una @. "));
        }
        
        if(!(customer.getGender().equalsIgnoreCase("M") || customer.getGender().equalsIgnoreCase("F"))){
            errors.add(new JsonError("400", "BAD_REQUEST","Sexo debo ser M o F. "));
        }      
        
        if(!Utilities.isNumeric(customer.getMobile())){
            errors.add(new JsonError("400", "BAD_REQUEST","Teléfono móvil debe contener sólo dígitos "));
            
        }
        // Que no esté repetido
        
        Customer customerSearched = this.findCustomer(customer.getId());
        if (customerSearched != null){
            errors.add(new JsonError("400", "BAD_REQUEST","La cédula ya existe. "));
        }
       /* 
       if (!errors.isEmpty()) {
            Gson gson = new Gson();
            String errorsJson = gson.toJson(errors);
            return errorsJson;
        }*/
        return repo.createCustomer(customer);
    }

    public String updateUser(Customer customer) {
        return repo.updateUser(customer);
    }

    public synchronized List<Customer> listCustomers() {
        return repo.listCustomers();
    }
   
}
