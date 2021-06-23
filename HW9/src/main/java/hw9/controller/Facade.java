package hw9.controller;

import hw9.model.*;

import hw9.view.DefaultDisplay;
import hw9.view.IDisplay;
import java.util.List;

/**
 * Facade is a design pattern act as a center for varies class to interact with each other. It helps
 * to manage activities of our system. For example, add new Todo into our Todo list.
 * And update the todos.csv file using writer class. It has display method which utilize toDos data
 * structure to print current todo list.
 * Display also takes Options class that will have combined filter or sorted requirement to display
 *
 */
public class Facade {
    IReader reader;
    TodoList todoList;
    IWriter writer;
    IDisplay display;

    /**
     * Constructor for a Facade object.
     * @param options - an Option object parsed from commandline input.
     * @throws ReadFileException - thrown when an Option or a Todo object failed to build.
     * @throws ParseException - thrown when an Option or a Todo object failed to build.
     * @throws java.text.ParseException - thrown when an Option or a Todo object failed to build.
     */
    public Facade(Options options) throws ReadFileException, ParseException, java.text.ParseException {
        //initialization
        if (options.getPath() != null){
            reader = new Reader(options.getPath());
        }
        List<List<String>> inputCSV = reader.getInputFile();
        todoList = new TodoList(inputCSV);
        writer = new Writer(options.getPath(), todoList);
        // add, complete, display
        if (options.getAddTodo() != null) {
            this.addTodo(options);
        }
        if (options.getCompleteToDo() != null) {
            this.completeTodo(options);
        }
        display = new DefaultDisplay(todoList.getTodoList());
        display = display.decorate(options);
        display.display();
    }

    /**
     * Add a todo corresponding to the commandline input.
     * @param options - an Option object parsed from commandline input.
     * @throws ParseException - thrown when an Option or a Todo object failed to build.
     * @throws java.text.ParseException  - thrown when an Option or a Todo object failed to build.
     */
    public void addTodo(Options options) throws ParseException, java.text.ParseException{
        int id;
        id = this.todoList.getTodoList().size() + 1;
        Todo todo = TodoGenerator.generateTodo(options);
        todo.setId(id);
        this.todoList.addTodo(todo);
        writer.update(this.todoList);
    }

    /**
     * Complete a Todo object.
     * @param options - an Option object parsed from commandline input.
     * @throws ParseException - thrown when an Option object failed to build.
     */
    public void completeTodo(Options options) throws ParseException {
        if (options.getCompleteToDo() != null){
            String[] idList = options.getCompletedIds().split(" ");
            for (int i = 0; i < idList.length; i++) {
                int id = Integer.parseInt(idList[i]);
                completeHelper(id-1);
            }
        }
        writer.update(todoList);
    }

    /**
     * Helper method to verify whether a given id is valid for completing.
     * @param id - a given id, represented as Integer.
     * @throws ParseException - thrown when the id is not valid.
     */
    private void completeHelper(int id) throws ParseException {
        int temp = id + 1;
        if (id < 0 || id > this.todoList.getTodoList().size()) {
            throw new IllegalArgumentException("Task with id: " + temp + " does not exist");
        }
        if (this.todoList.getTodoList().get(id).getCompleted()) {
            System.out.println("id: " + temp + " is already completed");
        } else {
            this.todoList.getTodoList().get(id).setCompleted();
        }
    }

    /**
     * Display all todos based on the commandline input.
     */
    public void display() {
        display.display();
    }

}