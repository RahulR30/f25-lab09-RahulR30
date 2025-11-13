public class PillCounterDecorator implements PillCounter {

  protected final PillCounter delegate;

  // Constructor takes another PillCounter to delegate to
  public PillCounterDecorator(PillCounter delegate) {
    this.delegate = delegate;
  }

  @Override
  public void addPill(int num) {
    delegate.addPill(num);
  }

  @Override
  public void removePill() {
    delegate.removePill();
  }

  @Override
  public int getPillCount() {
    return delegate.getPillCount();
  }

  @Override
  public void reset() {
    delegate.reset();
  }
}