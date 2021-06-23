package hw9.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import org.junit.Before;
import org.junit.Test;

public class TodoTest {
    Todo task1;
    Todo another;
    Todo task2;
    Todo task3;
    Todo task4;
    Todo task5;
    Todo task6;
    Todo noCompletion;
    Todo noDue;
    Todo noPriority;
    Todo noCategory;
    Date date;

    @Before
    public void setUp() throws Exception {
        date = new Date(01/01/2021);
        task1 = new Todo.Builder("HW9").addId(1).addCompletion().addDue(date).addPriority(3).addCategory("School").build();
        another = new Todo.Builder("HW9").addId(1).addCompletion().addDue(date).addPriority(3).addCategory("School").build();
        task2 = new Todo.Builder("HW8").addId(1).addCompletion().addDue(date).addPriority(3).addCategory("School").build();
        task3 = new Todo.Builder("HW9").addId(1).addDue(date).addPriority(3).addCategory("School").build();
        task4 = new Todo.Builder("HW9").addId(1).addCompletion().addPriority(3).addCategory("School").build();
        task5 = new Todo.Builder("HW9").addId(1).addCompletion().addDue(date).addPriority(2).addCategory("School").build();
        task6 = new Todo.Builder("HW9").addId(1).addCompletion().addDue(date).addPriority(3).addCategory("Homework").build();
        noCompletion = new Todo.Builder("noCompletion").addDue(date).addPriority(2).addCategory("School").build();
        noDue = new Todo.Builder("noDue").addCompletion().addPriority(3).addCategory("School").build();
        noPriority = new Todo.Builder("noPriority").addCompletion().addDue(date).addCategory("School").build();
        noCategory = new Todo.Builder("noCategory").addCompletion().addDue(date).addPriority(1).build();
    }


    @Test
    public void getText() {
        assertEquals("HW9", task1.getText());
    }

    @Test
    public void hasId() {
        assertTrue(task1.hasId(1));
        assertFalse(task1.hasId(2));
        assertFalse(noCompletion.hasId(1));
    }

    @Test
    public void getId() {
        assertTrue(task1.getId() == 1);
        noCompletion.setId(2);
        assertTrue(noCompletion.getId() == 2);
    }

    @Test
    public void getCompleted() {
        assertFalse(noCompletion.getCompleted());
        noCompletion.setCompleted();
        assertTrue(noCompletion.getCompleted());
    }

    @Test
    public void getDue() {
        assertEquals(date,task1.getDue());
        assertTrue(noDue.getDue() == null);
    }

    @Test
    public void getPriority() {
        assertTrue(task1.getPriority() == 3);
        assertTrue(noPriority.getPriority() == 4);
    }

    @Test
    public void getCategory() {
        assertEquals("School", task1.getCategory());
        assertTrue(noCategory.getCategory() == null);
    }

    @Test
    public void testEquals() {
        assertTrue(task1.equals(task1));
        assertFalse(task1.equals(noCompletion));
        assertTrue(task1.equals(another));
        assertFalse(task1.equals(task2));
        assertFalse(task1.equals(task3));
        assertFalse(task1.equals(task4));
        assertFalse(task1.equals(task5));
        assertFalse(task1.equals(task6));
        assertFalse(task1.equals(null));
        assertFalse(task1.equals(""));
    }

    @Test
    public void testHashCode() {
        assertTrue(task1.hashCode() == another.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("Todo{id=1, text='HW9', completed=true, due=12/31/1969, priority=3, category='School'}", task1.toString());
        assertEquals("Todo{id=null, text='noDue', completed=true, due=?, priority=3, category='School'}", noDue.toString());
    }
}