package se.distansakademin.ccwapp;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import se.distansakademin.models.Car;
import se.distansakademin.repositories.CarRepository;

import java.io.IOException;

@WebServlet(name="CarsServlet", urlPatterns = {"/cars"})
public class CarsServlet extends HttpServlet {

    private CarRepository repository = new CarRepository();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String make = request.getParameter("make");
        String model = request.getParameter("model");

        var action = request.getParameter("action");
        action = (action == null) ? "create" : action;

        var car = new Car(make, model);



        if(action.equals("create")){
            repository.insert(car);
        }
        else if(action.equals("update")){

            var idString = request.getParameter("id");
            var id = Long.parseLong(idString);
            car.setId(id);

            repository.update(car);
        } else if (action.equals("delete")) {

            var idString = request.getParameter("id");
            var id = Long.parseLong(idString);

            repository.delete(id);
        }


        response.sendRedirect(request.getContextPath() + "/cars");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        var action = request.getParameter("action");
        action = (action == null) ? "index" : action;

        if (action.equals("create")){
            showCreateCarForm(request, response);
        }
        else if(action.equals("update")){
            showUpdateCarForm(request, response);
        }
        else{
            listCars(request, response);
        }

    }

    private void listCars(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var cars = repository.getAllCars();
        request.setAttribute("cars", cars);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/cars/index.jsp");

        dispatcher.forward(request, response);
    }

    private void showCreateCarForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/cars/create.jsp");

        dispatcher.forward(request, response);
    }

    private void showUpdateCarForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        var idString = request.getParameter("id");

        var id = Long.parseLong(idString);

        var car = repository.getCarById(id);

        request.setAttribute("car", car);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/cars/update.jsp");

        dispatcher.forward(request, response);
    }
}
