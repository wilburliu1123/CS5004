package hw9.controller;

import hw9.model.Constants;
import hw9.model.Options;
import hw9.model.ParseException;
import hw9.model.Todo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class TodoGenerator {
    private static final int id = 0;
    private static final int text = 1;

    /**
     * Generate a Todo object based on a given options fields.
     * @param options - an Option object.
     * @return a Todo object.
     * @throws ParseException thrown when an Option object failed to build or a Todo object failed to build.
     * @throws java.text.ParseException
     */
    public static Todo generateTodo(Options options) throws ParseException, java.text.ParseException {
        Todo.Builder builder = new Todo.Builder(options.getDescription());
        if (options.getDueDate() != null){
            DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            Date due = formatter.parse(options.getDueDate());
            builder.addDue(due);
        }
        if (options.getCompleted() != null){
            builder.addCompletion();
        }
        builder.addId(null);
        if (options.getPriority() != null) {
            builder.addPriority(Integer.valueOf(options.getPriority()));
        }
        if (options.getCategory() != null) {
            builder.addCategory(options.getCategory());
        }
        return builder.build();
    }

    /**
     * Generate a Todo object based on a given options fields.
     * @param inputData - an Option object.
     * @return a Todo object.
     * @throws ParseException thrown when an Option object failed to build or a Todo object failed to build.
     * @throws java.text.ParseException thrown when an Option object failed to build or a Todo object failed to build.
     */
    public static Todo generateTodo(List<String> inputData) throws ParseException, java.text.ParseException {
        Todo.Builder builder = new Todo.Builder(inputData.get(text));
        builder.addId(Integer.parseInt(inputData.get(id)));
        // start from third column(2 from List<String>) since id and text are required for each todo
        int colIdx = 2;
        if (inputData.get(colIdx).equals("true")) {
            builder.addCompletion();
        }
        colIdx++;
        if (!inputData.get(colIdx).equals(Constants.UNDEFINED)) {
            DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            Date due = formatter.parse(inputData.get(colIdx));
            builder.addDue(due);
        }
        colIdx++;
        if (!inputData.get(colIdx).equals(Constants.UNDEFINED)){
            Integer priority = Integer.valueOf(inputData.get(colIdx));
            builder.addPriority(priority);
        }
        colIdx++;
        if (!inputData.get(colIdx).equals(Constants.UNDEFINED)){
            builder.addCategory(inputData.get(colIdx));
        }
        return builder.build();
    }

}
