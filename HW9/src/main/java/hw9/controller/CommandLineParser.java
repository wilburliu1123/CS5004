package hw9.controller;

import hw9.model.Constants;
import hw9.model.Options;
import hw9.model.ParseException;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Represents list of arguments parsed against a Options descriptor.
 */
public class CommandLineParser {
    private static final Integer ONE_CMD = 1;
    private static final String COMMAND_PATTERN = "--";
    private static final String CSV_PATTERN = "(.*.csv)$";
    private static final String STRING_PATTERN = ".*";
    private static final String NUMERIC_STRING_PATTERN = "^[0-9 ]+$";
    private static final String PRIORITY_PATTERN = "(^[123]$)";
    private static final String DATE_PATTERN = "^(\\d{2}/\\d{2}/\\d{4})|(\\d{2}/\\d{1}/\\d{4})|(\\d{1}/\\d{2}/\\d{4})|(\\d{1}/\\d{1}/\\d{4})$";
    private Map<String, String> arguments;
    private Map<String, Integer> argumentCounts;
    private Options options;

    /**
     * Constructor for CommandLineParser class.
     */
    public CommandLineParser(String[] args) throws ParseException{
        this.arguments = new HashMap<>();
        this.argumentCounts = new HashMap<>();
        this.options = new Options.Builder()
                .csvFile(null)
                .path(null)
                .addTodo(null)
                .description(null)
                .completed(null)
                .dueDate(null)
                .priority(null)
                .category(null)
                .completeTodo(null)
                .completedIds(null)
                .display(null)
                .showIncomplete(null)
                .showCategory(null)
                .sortByDate(null)
                .sortByPriority(null)
                .build();
        this.parseArgs(args);
        this.getArgCounts(args);
        this.setOptions(args);
    }

    /**
     * Get Options object created by CommandLineParse.
     * @return An Options object.
     */
    public Options getOptions() {
        return this.options;
    }

    /**
     * Helper method parseArgs() parses a command line argument into a Map where keys are arguments start with "--",
     * values are additional arguments' values that do not start with "--". Both key and value are represented as String.
     *
     * @param args - command line input arguments.
     * @throws ParseException - this exception is thrown when the input arguments start with a argument value.
     */
    private void parseArgs(String[] args) throws ParseException{
        int i = 0;
        while ( i < args.length ){
            if (args[i].startsWith("--")){
                if (i < args.length - 1 && !args[i+1].startsWith("--")){
                    if (this.arguments.containsKey(args[i])){
                        this.arguments.put(args[i], this.arguments.get(args[i]) + " " + args[i+1]);
                    } else {
                        this.arguments.put(args[i], args[i+1]);
                    }
                    i += 2;
                }
                else{
                    this.arguments.put(args[i], null);
                    i++;
                }
            } else {
                throw new ParseException("The first argument musts starting with \"--\"");
            }
        }
    }

    /**
     * Helper method getArgCounts() gets A string of Argument from the comments and the number of times it appears.
     * @param args -  The given command line argument.
     * @return All the given arguments in Map<string, Integer> if the argument is validated.
     */
    private Map getArgCounts(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String token = args[i];
            if (token.startsWith(COMMAND_PATTERN) && !argumentCounts.containsKey(token)){
                argumentCounts.put(token, ONE_CMD);
            }
            else if (token.startsWith(COMMAND_PATTERN) && argumentCounts.containsKey(token)){
                int numOfCmd = argumentCounts.get(token);
                argumentCounts.put(token, ONE_CMD + numOfCmd);
            }
        }
        return argumentCounts;
    }

    /**
     * Set Option's field if the input arguments are validated.
     * @param args - the command line input arguments.
     * @throws ParseException - this exception is thrown when fail to set an Option's field.
     */
    private void setOptions(String[] args) throws ParseException{
        checkCSV();
        if (this.checkOptionHasValue(Constants.CSV, CSV_PATTERN)) {
            options.setCsvFile(Constants.CSV);
            options.setPath(this.arguments.get(Constants.CSV));
        }
        if (this.checkAddTodo(Constants.ADD_TODO)
                && this.checkOptionHasNoValue(Constants.ADD_TODO)
                && this.checkRequiredArg(Constants.ADD_TODO,Constants.TODO_TEXT)){
            options.setAddTodo(Constants.ADD_TODO);
        }
        if (this.checkAddTodo(Constants.TODO_TEXT)
                && this.checkOptionHasValue(Constants.TODO_TEXT, STRING_PATTERN)
                && this.checkRequiredArg(Constants.TODO_TEXT, Constants.ADD_TODO)){
            options.setDescription(this.arguments.get(Constants.TODO_TEXT));
        }
        if (this.checkAddTodo(Constants.COMPLETED)
                && this.checkOptionHasNoValue(Constants.COMPLETED)
                && this.checkRequiredArg(Constants.COMPLETED, Constants.ADD_TODO)){
            options.setCompleted(Constants.COMPLETED);
        }
        if (this.checkAddTodo(Constants.CATEGORY)
                && this.checkOptionHasValue(Constants.CATEGORY, STRING_PATTERN)
                && this.checkRequiredArg(Constants.CATEGORY, Constants.ADD_TODO)) {
            options.setCategory(this.arguments.get(Constants.CATEGORY));
        }
        if (this.checkAddTodo(Constants.PRIORITY)
                && this.checkOptionHasValue(Constants.PRIORITY, PRIORITY_PATTERN)
                && this.checkRequiredArg(Constants.PRIORITY, Constants.ADD_TODO)){
            options.setPriority(this.arguments.get(Constants.PRIORITY));
        }
        if (this.checkAddTodo(Constants.DUE)
                && this.checkOptionHasValue(Constants.DUE, DATE_PATTERN)
                && this.checkRequiredArg(Constants.DUE, Constants.ADD_TODO)){
            options.setDueDate(this.arguments.get(Constants.DUE));
        }
        if (this.checkOptionHasValue(Constants.COMPLETE_TODO, NUMERIC_STRING_PATTERN)){
            options.setCompleteToDo(Constants.COMPLETE_TODO);
            options.setCompletedIds(this.arguments.get(Constants.COMPLETE_TODO));
        }
        if (this.checkOptionHasNoValue(Constants.DISPLAY)){
            options.setDisplay(Constants.DISPLAY);
        }
        if (this.checkRequiredArg(Constants.SHOW_CATEGORY, Constants.DISPLAY)
                && this.checkOptionHasValue(Constants.SHOW_CATEGORY, STRING_PATTERN)){
            options.setShowCategory(this.arguments.get(Constants.SHOW_CATEGORY));
        }
        if (this.checkRequiredArg(Constants.SHOW_INCOMPLETE, Constants.DISPLAY)
                && this.checkOptionHasNoValue(Constants.SHOW_INCOMPLETE)){
            options.setShowIncomplete(Constants.SHOW_INCOMPLETE);
        }
        checkSort();
        if (this.checkRequiredArg(Constants.SORT_DATE, Constants.DISPLAY)
                && this.arguments.containsKey(Constants.SORT_DATE)){
            options.setSortByDate(Constants.SORT_DATE);
        }
        if (this.checkRequiredArg(Constants.SORT_PRIORITY, Constants.DISPLAY)
                && this.arguments.containsKey(Constants.SORT_PRIORITY)){
            options.setSortByPriority(Constants.SORT_PRIORITY);
        }
    }

    /**
     * Check whether an given argument contains A CSV command
     * @throws ParseException throws when a CSV command is not given or it has been given more than once
     */
    private void checkCSV() throws ParseException {
        if (!this.argumentCounts.containsKey(Constants.CSV)){
            throw new ParseException("A CSV file is required but not provided. " +
                    "Expected: " + Constants.CSV);
        }
        else if (this.argumentCounts.get(Constants.CSV) > ONE_CMD){
            throw new ParseException("This program only takes one CSV file. Multiple files are provided.");
        }
    }

    /**
     * Check whether an Add Todo command is legal
     * @param option - an Option object parsed from command line input.
     * @return true if an Add Todo command is legal
     * @throws ParseException thrown when Add Todo command is given more than once.
     */
    private boolean checkAddTodo(String option) throws ParseException {
        if (this.argumentCounts.containsKey(option) && this.argumentCounts.get(option) > ONE_CMD){
            throw new ParseException("To add one todo at a time, this program only accept one " + option);
        }
        return true;
    }

    /**
     * Checks whether an Optional argument that does not requires a value actually has no value.
     * @param option - an optional argument (can be DISPLAY, ADD_TODO and COMPLETED...)
     * @return true if no value are assigned with the given optional argument. False, otherwise.
     */
    private boolean checkOptionHasNoValue(String option){
        if (this.arguments.containsKey(option) && this.arguments.get(option)==null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks whether a given string matches with a given format in String representation
     * @param arg - A given string to check.
     * @param format - A given format to check against with.
     * @return true if the given string matches with the pattern. False, otherwise.
     */
    private boolean checkArgFormat(String arg, String format){
        Pattern requiredPattern = Pattern.compile(format);
        if (requiredPattern.matcher(arg).matches()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks whether a given argument has a value in correct format.
     * @param arg -  A given string argument to check.
     * @param format -  A given format to check against with.
     * @return - true if a given argument has a value in correct format.
     * @throws ParseException thrown when a given argument doesn't have a value in correct format.
     */
    private boolean checkOptionHasValue(String arg, String format) throws ParseException {
        if (this.arguments.containsKey(arg)){
            if(this.arguments.get(arg) == null){
                throw new ParseException("A value is required for " + arg + " but not provided.");
            } else if (this.checkArgFormat(this.arguments.get(arg), format)) {
                return true;
            } else {
                String value = this.arguments.get(arg);
                throw new ParseException( value + ". Incorrect argument format for " + arg
                + " Suggest format: " + format);
            }
        }
        return false;
    }

    /**
     * Check whether a required argument presents giving an argument.
     * @param arg - The required argument.
     * @param optionalArg - The argument that has a requiring argument.
     * @return true if an optional argument that requires an argument actually has an argument. False, otherwise.
     * @throws ParseException - this exception is thrown when an optional argument requires any additional argument, but the
     * additional argument is not provided.
     */
    private boolean checkRequiredArg(String arg, String optionalArg) throws ParseException {
        if (this.arguments.containsKey(arg) && !this.arguments.containsKey(optionalArg)) {
            throw new ParseException(arg + " is given, but " + optionalArg + " is not provided.");
        }
        return true;
    }

    /**
     * Check whether a given input arguments contain legal sort arguments. Sort_by_priority and sort_by_date can't both
     * be present at once.
     * @throws ParseException - this exception is thrown when both sort_by_keys are provided.
     */
    private void checkSort() throws ParseException {
        if (this.arguments.containsKey(Constants.SORT_PRIORITY)
                && this.arguments.containsKey(Constants.SORT_DATE)){
            throw new ParseException("Both "+ Constants.SORT_PRIORITY + " and " + Constants.SORT_DATE +
                    " are provided. The program can only sort by one keyword.");
        }
    }

}
