package hr.unizd.myToDoApp.mvcappmyToDoApp.Repository;

import hr.unizd.myToDoApp.mvcappmyToDoApp.Model.ToDoItem;

import java.util.List;
import java.util.Optional;

public interface ToDoRepository {

    List<ToDoItem> fetchAll();

    Optional<ToDoItem> fetchDetails(Integer id);

    boolean create(ToDoItem item);

    void edit(ToDoItem item);

    void delete(Integer id);


}
