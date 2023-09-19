package subway;

public enum FeatureKind {
  APP_FEATURE("메인"),
  LINE_FEATURE("노선"),
  SECTION_FEATURE("구간"),
  STATION_FEATURE("역");

  private final String name;


  FeatureKind(final String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }
}
