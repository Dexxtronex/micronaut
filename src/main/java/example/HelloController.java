
package example;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.validation.Validated;
import io.reactivex.Single;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.HttpStatus;

import javax.validation.constraints.NotBlank;


@Controller("/")
@Validated
public class HelloController { // creamos un controllador para acceder a diferentes rutas

    // el proceso de Get nos define que ingresaremos por peticion get la cual tendrá la ruta hello e ingresará un parametro
    @Get(uri = "/hello/{name}", produces = MediaType.TEXT_PLAIN)
    public Single<String> hello(@NotBlank String name) {
        return Single.just("Hello contenido" + name + "!"); // retornará un texto String en plano de un mensaje + el valor de la variable 
    }
    @Get(uri = "/prueba/{name}", produces = MediaType.TEXT_PLAIN)
    public Single<String> prueba(@NotBlank String name) {
        return Single.just("Hello desde prueba" + name + "!");
    }
    @Get("/employee")
    public Employee getEmployee() {  // definimos un metodo que nos devuelva un json, para esto declaramos una clase llamada EMployee el cual 
    //contiene los datos a mapear
        return new Employee(101,"Michael Dex");
    }
    @Get("/employee/{name}")   // el mismo proceso del json pero ahora ingresaremos un parametro el cual se va a ingresar y mostrar  como json 
    public Employee getEmployee(@NotBlank String name) {
        return new Employee(101,""+name+"");
    }

    @Get("/message")
    public String message() {
        return "Welcome to javatechie";
    }
}
