package hr.unizd.myToDoApp.mvcappmyToDoApp.Controller;

import hr.unizd.myToDoApp.mvcappmyToDoApp.Model.ToDoItem;
import hr.unizd.myToDoApp.mvcappmyToDoApp.Service.ToDoItemService;
import hr.unizd.myToDoApp.mvcappmyToDoApp.dto.ToDoItemCreateForm;
import hr.unizd.myToDoApp.mvcappmyToDoApp.dto.ToDoItemEditForm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ToDoListController {

    private final ToDoItemService toDoItemService;

    //konstruktor
    @Autowired
    public ToDoListController(ToDoItemService toDoItemService) {

        this.toDoItemService = toDoItemService;

    }
    @GetMapping("todo")
    public String fetchALl(Model model) {
        model.addAttribute("toDoItemList", toDoItemService.fetchAll());
        return "toDoListTemplate";
    }


    @GetMapping("/todo/{id}")
    public String fetchDetails(Model model, @PathVariable Integer id){
        ToDoItem todoitem = toDoItemService.fetchDetails(id);
        model.addAttribute("toDoItem", todoitem);

        return "itemTemplate";

    }
    @GetMapping("todo/create")
    public String fetchCreateForm(Model model){
        model.addAttribute("item", new ToDoItem());
        return "toDoItemCreateTemplate";


    }

    @PostMapping("/todo")
    public String create(@ModelAttribute(name="item")@Valid ToDoItemCreateForm item, BindingResult validationResult){
        if (validationResult.hasErrors()) {
            return "toDoItemCreateTemplate";
        }

        toDoItemService.create(item);

        return "redirect:/todo";


    }

    @GetMapping("todo/edit/{id}")
    public String fetchEditForm(Model model, @PathVariable Integer id) {
        ToDoItem item = toDoItemService.fetchDetails(id);
        model.addAttribute("item", item);

        return "toDoItemEditTemplate";

    }
    @PostMapping("/todo/edit")
    public String edit(@ModelAttribute(name="item") @Valid ToDoItemEditForm item, BindingResult validationResult) {
        if (validationResult.hasErrors()) {
            return "toDoItemEditTemplate";
        }

        toDoItemService.edit(item);

        return "redirect:/todo";
    }

    @GetMapping("/todo/delete/{id}")
    public String delete(@PathVariable Integer id) {
        toDoItemService.delete(id);

        return "redirect:/todo";
    }






}
