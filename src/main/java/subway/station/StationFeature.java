package subway.station;

import java.util.HashMap;
import java.util.Map;

public enum StationFeature {
  CREATE_LINE("1"),
  REMOVE_LINE("2"),
  QUERY_LINE("3"),
  BACKWARD("B");

  private final static Map<String, StationFeature> featureMap = new HashMap<>();

  static {
    for (final StationFeature stationFeature : values()) {
      featureMap.put(stationFeature.code, stationFeature);
    }
  }

  private final String code;

  StationFeature(final String code) {
    this.code = code;
  }

  public static StationFeature of(final String code) {
    if (!featureMap.containsKey(code)) {
      throw new IllegalArgumentException("선택할 수 없는 기능입니다.");
    }
    return featureMap.get(code);
  }
}
