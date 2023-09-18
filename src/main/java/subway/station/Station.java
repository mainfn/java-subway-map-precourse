package subway.station;

public final class Station {

  private final String name;

  private Station(final String name) {
    this.name = name;
  }

  public static Station of(final String name) {
    return new Station(name);
  }

  public String getName() {
    return name;
  }

  // 추가 기능 구현
}
