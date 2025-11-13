public class BatchPillCounter extends PillCounterDecorator {

  private int pendingPills = 0;

  public BatchPillCounter(PillCounter delegate) {
    super(delegate);
  }

  @Override
  public void addPill(int num) {
    // Don't immediately forward — just accumulate
    pendingPills += num;
  }

  @Override
  public int getPillCount() {
    // Before returning count, "flush" pending pills
    flush();
    return delegate.getPillCount();
  }

  @Override
  public void reset() {
    // Flush any pending pills before resetting
    flush();
    delegate.reset();
  }

  private void flush() {
    if (pendingPills > 0) {
      delegate.addPill(pendingPills);
      pendingPills = 0;
    }
  }
}