package hw9.model;

import java.util.Objects;

/**
 * A Options class represents all possible legal combination of command line arguments.
 */
public class Options {
    private String csvFile;
    private String path;
    private String addTodo;
    private String description;
    private String completed;
    private String dueDate;
    private String priority;
    private String category;
    private String completeToDo;
    private String completedIds;
    private String display;
    private String showIncomplete;
    private String showCategory;
    private String sortByDate;
    private String sortByPriority;

    /**
     * Constructor for options class using builder pattern
     * @param builder nested builder class used to construct Options class
     */
    private Options(Builder builder){
        this.csvFile = builder.csvFile;
        this.path = builder.path;
        this.addTodo = builder.addTodo;
        this.description = builder.description;
        this.completed = builder.completed;
        this.dueDate = builder.dueDate;
        this.priority = builder.priority;
        this.category = builder.category;
        this.completeToDo = builder.completeTodo;
        this.completedIds = builder.completedIds;
        this.display = builder.display;
        this.showIncomplete = builder.showIncomplete;
        this.showCategory = builder.showCategory;
        this.sortByDate = builder.sortByDate;
        this.sortByPriority = builder.sortByPriority;
    }
    public String getCsvFile() { return csvFile; }

    public void setCsvFile(String csvFile) {
        this.csvFile = csvFile;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) { this.path = path; }

    public String getAddTodo() {
        return addTodo;
    }

    public void setAddTodo(String addTodo) {
        this.addTodo = addTodo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCompleteToDo() {
        return completeToDo;
    }

    public void setCompleteToDo(String completeToDo) {
        this.completeToDo = completeToDo;
    }

    public String getCompletedIds() { return completedIds; }

    public void setCompletedIds(String completedIds) { this.completedIds = completedIds; }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getShowIncomplete() {
        return showIncomplete;
    }

    public void setShowIncomplete(String showIncomplete) {
        this.showIncomplete = showIncomplete;
    }

    public String getShowCategory() {
        return showCategory;
    }

    public void setShowCategory(String showCategory) {
        this.showCategory = showCategory;
    }

    public String getSortByDate() {
        return sortByDate;
    }

    public void setSortByDate(String sortByDate) {
        this.sortByDate = sortByDate;
    }

    public String getSortByPriority() {
        return sortByPriority;
    }

    public void setSortByPriority(String sortByPriority) {
        this.sortByPriority = sortByPriority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Options options = (Options) o;
        return Objects.equals(csvFile, options.csvFile) && Objects.equals(getPath(), options.getPath()) && Objects.equals(getAddTodo(), options.getAddTodo()) && Objects.equals(getDescription(), options.getDescription()) && Objects.equals(getCompleted(), options.getCompleted()) && Objects.equals(getDueDate(), options.getDueDate()) && Objects.equals(getPriority(), options.getPriority()) && Objects.equals(getCategory(), options.getCategory()) && Objects.equals(getCompleteToDo(), options.getCompleteToDo()) && Objects.equals(getDisplay(), options.getDisplay()) && Objects.equals(getShowIncomplete(), options.getShowIncomplete()) && Objects.equals(getShowCategory(), options.getShowCategory()) && Objects.equals(getSortByDate(), options.getSortByDate()) && Objects.equals(getSortByPriority(), options.getSortByPriority());
    }

    @Override
    public int hashCode() {
        return Objects.hash(csvFile, getPath(), getAddTodo(), getDescription(), getCompleted(), getDueDate(), getPriority(), getCategory(), getCompleteToDo(), getDisplay(), getShowIncomplete(), getShowCategory(), getSortByDate(), getSortByPriority());
    }

    @Override
    public String toString() {
        return "Options{" +
                "csvFile='" + csvFile + '\'' +
                ", path='" + path + '\'' +
                ", addTodo='" + addTodo + '\'' +
                ", description='" + description + '\'' +
                ", completed='" + completed + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", priority='" + priority + '\'' +
                ", category='" + category + '\'' +
                ", completeToDo='" + completeToDo + '\'' +
                ", completedIds='" + completedIds + '\'' +
                ", display='" + display + '\'' +
                ", showIncomplete='" + showIncomplete + '\'' +
                ", showCategory='" + showCategory + '\'' +
                ", sortByDate='" + sortByDate + '\'' +
                ", sortByPriority='" + sortByPriority + '\'' +
                '}';
    }

    /**
     * Nested builder class used to construct options class
     */
    public static class Builder {
        private String csvFile;
        private String path;
        private String addTodo;
        private String description;
        private String completed;
        private String dueDate;
        private String priority;
        private String category;
        private String completeTodo;
        private String completedIds;
        private String display;
        private String showIncomplete;
        private String showCategory;
        private String sortByDate;
        private String sortByPriority;

        public Builder(){
        }

        public Builder csvFile(String csvFile){
            this.csvFile = csvFile;
            return this;
        }

        public Builder path(String path) {
            this.path = path;
            return this;
        }

        public Builder addTodo(String addTodo) {
            this.addTodo = addTodo;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder completed(String completed) {
            this.completed = completed;
            return this;
        }

        public Builder dueDate(String dueDate){
            this.dueDate = dueDate;
            return this;
        }

        public Builder priority(String priority){
            this.priority = priority;
            return this;
        }

        public Builder category(String category){
            this.category = category;
            return this;
        }

        public Builder completeTodo(String completeTodo){
            this.completeTodo = completeTodo;
            return this;
        }

        public Builder completedIds(String completedIds){
            this.completedIds = completedIds;
            return this;
        }

        public Builder display(String display){
            this.display = display;
            return this;
        }

        public Builder showIncomplete(String showIncomplete){
            this.showIncomplete = showIncomplete;
            return this;
        }

        public Builder showCategory(String showCategory){
            this.showCategory = showCategory;
            return this;
        }

        public Builder sortByDate(String sortByDate){
            this.sortByDate = sortByDate;
            return this;
        }

        public Builder sortByPriority(String sortByPriority){
            this.sortByPriority = sortByPriority;
            return this;
        }

        public Options build() {
            return new Options(this);
        }
    }
}
