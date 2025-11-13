import java.util.ArrayList;
import java.util.List;

public class MonitoringPillCounter extends PillCounterDecorator {

  private int currentAddCount = 0;
  private final List<Integer> addCounts = new ArrayList<>();

  public MonitoringPillCounter(PillCounter delegate) {
    super(delegate);
  }

  @Override
  public void addPill(int num) {
    super.addPill(num);
    currentAddCount++;
  }

  @Override
  public void reset() {
    // save the count for this "bottle"
    addCounts.add(currentAddCount);
    currentAddCount = 0;
    super.reset();
  }

  public List<Integer> getAddCounts() {
    return new ArrayList<>(addCounts);
  }
}