package hw9.model;

import java.util.Date;

public interface ITodo {
    void setCompleted();

    void setId(Integer id);

    Integer getId();
    String getText();
    Boolean getCompleted();
    Date getDue();
    Integer getPriority();
    String getCategory();
}
