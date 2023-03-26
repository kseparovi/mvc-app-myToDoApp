package hr.unizd.myToDoApp.mvcappmyToDoApp.Service;

import hr.unizd.myToDoApp.mvcappmyToDoApp.Model.ToDoItem;
import hr.unizd.myToDoApp.mvcappmyToDoApp.Repository.ToDoRepository;
import hr.unizd.myToDoApp.mvcappmyToDoApp.dto.ToDoItemCreateForm;
import hr.unizd.myToDoApp.mvcappmyToDoApp.dto.ToDoItemEditForm;
import hr.unizd.myToDoApp.mvcappmyToDoApp.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ToDoItemServiceImpl implements ToDoItemService {

    private final ToDoRepository toDoItemRepository;


    @Autowired
    public ToDoItemServiceImpl(ToDoRepository toDoItemRepository) {
        this.toDoItemRepository = toDoItemRepository;
    }


    public List<ToDoItem> fetchAll() {
        return toDoItemRepository.fetchAll();
    }

    public ToDoItem fetchDetails(Integer id) {
        Optional<ToDoItem> toDoItemOptional = toDoItemRepository.fetchDetails(id);
        if (toDoItemOptional.isEmpty()) {
            throw new EntityNotFoundException("Item with id " + id + " not found!");
        }

        return toDoItemOptional.get();
    }

    public List<ToDoItem> create(ToDoItemCreateForm toDoItemCreateForm) {
        List<ToDoItem> toDoList = toDoItemRepository.fetchAll();

        ToDoItem newItem = new ToDoItem();
        newItem.setId(toDoList.size() + 1);
        newItem.setName(toDoItemCreateForm.getName());
        newItem.setDescription(toDoItemCreateForm.getDescription());

        toDoItemRepository.create(newItem);

        return toDoItemRepository.fetchAll();
    }

    public List<ToDoItem> edit(ToDoItemEditForm toDoItemEditForm) {
        ToDoItem item = fetchDetails(toDoItemEditForm.getId());
        item.setName(toDoItemEditForm.getName());
        item.setDescription(toDoItemEditForm.getDescription());
        item.setCompleted(toDoItemEditForm.getCompleted());
        toDoItemRepository.edit(item);

        return toDoItemRepository.fetchAll();
    }

    public List<ToDoItem> delete(Integer id) {
        toDoItemRepository.delete(id);
        return toDoItemRepository.fetchAll();
    }

}
