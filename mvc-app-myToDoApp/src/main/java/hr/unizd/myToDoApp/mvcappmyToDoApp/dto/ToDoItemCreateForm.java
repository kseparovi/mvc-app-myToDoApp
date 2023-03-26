package hr.unizd.myToDoApp.mvcappmyToDoApp.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class ToDoItemCreateForm {


    @Size(min = 2, max = 30, message = "Name should have at least 2 characters")
    private String name;

    @NotEmpty(message = "Item is not allowed to be empty")
    private String description;

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
}
