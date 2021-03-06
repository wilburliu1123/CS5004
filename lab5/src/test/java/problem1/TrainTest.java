package problem1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TrainTest {
  Train train;
  @Test
  public void getId() {
    train = new Train("1", 300, 400);
    assertEquals("1", train.getId());
  }

}