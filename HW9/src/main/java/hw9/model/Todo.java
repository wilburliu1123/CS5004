package hw9.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * Todo class is our data structure that stores todo item
 * It has id, text(description about this todo item)
 * whether this item is complete or not, due date, its priority (1 is highest priority)
 * and its category
 */
public class Todo implements ITodo {
    private static final Integer DEFAULT_ID = null;
    private static final boolean DEFAULT_COMPLETION = false;
    private static final Integer DEFAULT_PRIORITY = 4;
    private Integer id;
    private final String text;
    private boolean completed;
    private final Date due;
    private final Integer priority;
    private final String category;

    private Todo(Builder builder) throws ParseException, java.text.ParseException {
        this.id = builder.id;
        this.text = builder.text;
        this.completed = builder.completed;
        this.due = builder.due; //not parse here, move it to Facade or elsewhere
        this.priority = builder.priority;
        this.category = builder.category;
    }
    @Override
    public void setId(Integer id) { this.id = id; }
    @Override
    public Integer getId() { return this.id; }
    @Override
    public void setCompleted() { this.completed = true; }
    @Override
    public String getText() { return this.text; }
    @Override
    public Boolean getCompleted() { return this.completed; }
    @Override
    public Date getDue() { return this.due; }
    @Override
    public Integer getPriority() { return this.priority; }
    @Override
    public String getCategory() { return this.category; }

    public boolean hasId(Integer id){
        if (this.getId() != null) {
            return this.getId().equals(id);
        } else {
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return getCompleted() == todo.getCompleted() &&
                Objects.equals(getText(), todo.getText()) &&
                getDue() == todo.getDue() &&
                getPriority() == todo.getPriority() &&
                Objects.equals(getCategory(), todo.getCategory());
    }

    @Override
    public int hashCode() { return Objects.hash(getText(), getCompleted(), getDue(), getPriority(), getCategory()); }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String date;
        if (this.due != null) {
            date = formatter.format(this.due);
        } else {
            date = "?";
        }
        return "Todo{" +
            "id=" + id +
            ", text='" + text + '\'' +
            ", completed=" + completed +
            ", due=" + date +
            ", priority=" + priority +
            ", category='" + category + '\'' +
            '}';
    }

    public static class Builder {
        private String text; // Required
        private Integer id; // Auto generated
        private Boolean completed; // Default false
        private Date due; // Optional
        private Integer priority; // Default 4
        private String category; // Optional

        public Builder(String text) {
            this.text = text;
            this.id = DEFAULT_ID;
            this.completed = DEFAULT_COMPLETION;
            this.priority = DEFAULT_PRIORITY;
        }

        public Builder addId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder addCompletion() {
            this.completed = true;
            return this;
        }

        public Builder addDue(Date due) {
            this.due = due;
            return this;
        }

        public Builder addPriority(Integer priority) {
            this.priority = priority;
            return this;
        }

        public Builder addCategory(String category) {
            this.category = category;
            return this;
        }

        public Todo build() throws ParseException, java.text.ParseException {
            return new Todo(this);
        }
    }
}

