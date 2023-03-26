package hr.unizd.myToDoApp.mvcappmyToDoApp.Service;

import hr.unizd.myToDoApp.mvcappmyToDoApp.Model.ToDoItem;
import hr.unizd.myToDoApp.mvcappmyToDoApp.dto.ToDoItemCreateForm;
import hr.unizd.myToDoApp.mvcappmyToDoApp.dto.ToDoItemEditForm;

import java.util.List;

public interface ToDoItemService {

    List<ToDoItem> fetchAll();

    ToDoItem fetchDetails(Integer id);

    List<ToDoItem> create(ToDoItemCreateForm toDoItemCreateForm);

    List<ToDoItem> edit(ToDoItemEditForm toDoItemEditForm);

    List<ToDoItem> delete(Integer id);


}
