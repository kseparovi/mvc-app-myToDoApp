package hr.unizd.myToDoApp.mvcappmyToDoApp.Repository;

import hr.unizd.myToDoApp.mvcappmyToDoApp.Model.ToDoItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ToDoMemoryRepository implements ToDoRepository{

    private List<ToDoItem> toDoItemList = new ArrayList<>(
            List.of(
                    new ToDoItem(1, "Prosetat psa", "Ici u pseci park", false),
                    new ToDoItem(2, "Ici na trening", "Nece se salo samo otopit", true),
                    new ToDoItem(3, "Uciti Web", "Napraviti aplikaciju bez po beda", true)

            )
    );

    public List<ToDoItem> fetchAll() {
        return toDoItemList;
    }

    public Optional<ToDoItem> fetchDetails(Integer id) {
        return toDoItemList.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
    }

    public boolean create(ToDoItem item) {
        return toDoItemList.add(item);
    }

    public void edit(ToDoItem newToDoItem) {
        int listIndex = fetchObjectListIndex(newToDoItem.getId());
        toDoItemList.set(listIndex, newToDoItem);
    }

    public void delete(Integer id) {
        int listIndex = fetchObjectListIndex(id);
        toDoItemList.remove(listIndex);
    }

    private Integer fetchObjectListIndex(Integer id) {
        int index = -1;

        for (int i = 0; i < toDoItemList.size(); i++) {
            if (toDoItemList.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }

        return index;
    }







}
