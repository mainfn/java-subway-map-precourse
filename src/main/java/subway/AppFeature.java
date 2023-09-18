package subway;

import java.util.HashMap;
import java.util.Map;

public enum AppFeature {
  STATION_MANAGEMENT("1"),
  LINE_MANAGEMENT("2"),
  SECTION_MANAGEMENT("3"),
  PRINT_SUBWAY_MAP("4"),
  QUIT("Q");

  private static final Map<String, AppFeature> featureMap = new HashMap<>();

  static {
    for (final AppFeature appFeature : values()) {
      featureMap.put(appFeature.code, appFeature);
    }
  }

  private final String code;

  AppFeature(final String code) {
    this.code = code;
  }

  public static AppFeature of(final String code) {
    if (!featureMap.containsKey(code)) {
      throw new IllegalArgumentException("선택할 수 없는 기능입니다.");
    }
    return featureMap.get(code);
  }

}
