package example;

import javax.inject.Singleton;

@Singleton
public class Employee {

    private  int id;
    private String name;

    public int getId() {  // metodo de obtenci{on }
        return id;
    }

    public void setId(int id) { //metodo de actualizacion 
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee(int id, String name) {  // definiciion de metodo constructor para asignar las clases con varios parametros 
        this.id = id;
        this.name = name;
    }

    public Employee() {
    }
}