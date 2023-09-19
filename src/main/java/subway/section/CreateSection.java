package subway.section;

public final class CreateSection {

  private final String lineName;
  private final String stationName;
  private final int order;

  public CreateSection(
      final String lineName,
      final String stationName,
      final int order
  ) {
    this.lineName = lineName;
    this.stationName = stationName;
    this.order = order;
  }

  public String getLineName() {
    return lineName;
  }

  public String getStationName() {
    return stationName;
  }

  public int getOrder() {
    return order;
  }
}
