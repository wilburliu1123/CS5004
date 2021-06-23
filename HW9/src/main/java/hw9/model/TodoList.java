package hw9.model;

import hw9.controller.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents lists of Todo objects.
 */
public class TodoList {
    private List<List<String>> inputFile;
    //private List<ITodo> Todo;
    private List<Todo> todoList;

    /**
     * Constructor for TodoList object.
     * @param inputFile - input csv file
     * @throws ParseException - thrown when failed to build a Todo object
     * @throws java.text.ParseException - thrown when failed to build a Todo object
     */
    public TodoList(List<List<String>> inputFile) throws ParseException, java.text.ParseException {
        this.inputFile = inputFile;
        this.todoList = new ArrayList<>();
        this.inputConverter(inputFile);
    }

    /**
     * Generate Todo objects based on string representation of todos from input file.
     * @param inputFile - input csv file
     * @throws ParseException - thrown when failed to build a Todo object
     * @throws java.text.ParseException - thrown when failed to build a Todo object
     */
    private void inputConverter(List<List<String>> inputFile) throws ParseException, java.text.ParseException {
        if (inputFile.size() > 1) {
            for (int i = 0; i < inputFile.size(); i++) {
                List<String> csvLine = inputFile.get(i);
                Todo todo = TodoGenerator.generateTodo(csvLine);
                this.todoList.add(todo);
            }
        }
    }

    /**
     * Add a Todo object to todoList.
     * @param todo - a todo object to add.
     */
    public void addTodo(Todo todo){
        this.todoList.add(todo);
    }

    public List<Todo> getTodoList() {
        return this.todoList;
    }
/*
    public boolean contains(Todo task) {
        return this.todoList.contains(task);
    }
*/
    @Override
    public String toString() {
        return "TodoList{" +
                "inputFile=" + inputFile +
                ", todoList=" + todoList +
                '}';
    }
}

