/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package co.unicauca.products.cliente;

/**
 *
 * @author santiago nieto <santiagonietu@unicauca.edu.co>
 * @author Ledy astudillo <lmastudillo@unicauca.edu.co>
 */
public class ClienteMain {

    public static void main(String[] args) {
        // CREANDO UN ESTUDIANTE
        NewJerseyClient jersey = new NewJerseyClient();
        String rta = jersey.create_JSON(new Product(5, "Nevera Lg", 4000000d));
        System.out.println("Rta " + rta);

        // BUSCANDO UN PRODUCTO
        Product product = jersey.findById(Product.class, "1");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getPrice());

        // PROBAR LOS DEMAS SERVICIOS
        //crear servicio remove
        rta = jersey.remove("1");
        System.out.println("Rta " + rta);

        //crear servicio put
        rta = jersey.update_JSON(new Product(5, "Patineta", 40500d));
        System.out.println("Rta " + rta);

        //Obtener todos los productos        
        Product[] products = jersey.findAll(Product[].class);
        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i].getId() + ", " + products[i].getName() + ", " + products[i].getPrice());
        }
    }
}
