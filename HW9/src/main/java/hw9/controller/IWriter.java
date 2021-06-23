package hw9.controller;

import hw9.model.TodoList;

public interface IWriter {

    /**
     * update csv file
     * @param todoList given current todoList
     */
    void update(TodoList todoList);
}
