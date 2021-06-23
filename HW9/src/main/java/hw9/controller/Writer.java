package hw9.controller;

import hw9.model.Todo;
import hw9.model.TodoList;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.List;

public class Writer implements IWriter{
    private final String FIRST_ROW = "\"id\",\"text\",\"completed\",\"due\",\"priority\",\"category\"";
    String path;
    public Writer(String path, TodoList todoList){
        this.path = path;
        update(todoList);
    }

    /**
     * update csv file
     *
     * @param todoList given current todo list
     */
    @Override
    public void update(TodoList todoList) {
        List<Todo> list = todoList.getTodoList();
        StringBuilder sb = new StringBuilder();
        sb.append(FIRST_ROW + "\n");
        for (Todo todo : list) {
            sb.append("\"" + todo.getId() + "\",\"" + todo.getText() + "\",\"" + todo.getCompleted() + "\",\"");
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            String date;
            if (todo.getDue() != null) {
                date = formatter.format(todo.getDue());
            } else {
                date = "?";
            }
            sb.append(date + "\",\"");
            if (todo.getPriority().equals(4)) {
                sb.append("?\",\"");
            } else {
                sb.append(todo.getPriority() + "\",\"");
            }
            String categoryString;
            if (todo.getCategory() != null) {
                categoryString = todo.getCategory();
            } else {
                categoryString = "?";
            }
            sb.append(categoryString + "\"\n");
        }
        sb.setLength(sb.length()-1);
        try(FileWriter fw = new FileWriter(this.path)) {
            fw.write(sb.toString());
        } catch(Exception e) {
        }
    }
}