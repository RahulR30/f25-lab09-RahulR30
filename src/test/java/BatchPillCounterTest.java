import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BatchPillCounterTest {

  @Test
  public void usage() {
    PillCounter counter = new BatchPillCounter(new LoggingPillCounter());
    boolean result = conveyerBelt(counter);
    assertTrue(result);
  }

  private boolean conveyerBelt(PillCounter counter) {
    for (int bottle = 0; bottle < 100; bottle += 1) {
      for (int pill = 0; pill < 100; pill += 1) {
        counter.addPill(1);
      }
      assertEquals(100, counter.getPillCount());
      counter.reset();
    }

    //make 1000 bottles of 20 pills each
    for (int bottle = 0; bottle < 1000; bottle += 1) {
      for (int pill = 0; pill < 20; pill += 4) {
        counter.addPill(4);
      }
      assertEquals(20, counter.getPillCount());
      counter.reset();
    }

    for (int bottle = 0; bottle < 500; bottle += 1) {
      for (int pill = 0; pill < 200; pill += 2) {
        counter.addPill(2);
      }
      assertEquals(200, counter.getPillCount());
      counter.reset();
    }

    return true;
  }
}