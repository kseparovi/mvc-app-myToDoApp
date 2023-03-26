package hr.unizd.myToDoApp.mvcappmyToDoApp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ToDoItemEditForm {

    @NotNull
    private Integer id;

    @Size(min = 2, max = 30, message = "Name should have at least 2 chars")
    private String name;

    @NotEmpty(message = "Item is not allowed to be empty")
    private String description;

    @NotNull
    private boolean completed;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
