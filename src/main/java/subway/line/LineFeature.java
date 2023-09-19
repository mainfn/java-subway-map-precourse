package subway.line;

import java.util.HashMap;
import java.util.Map;

public enum LineFeature {
  CREATE_LINE("1"),
  REMOVE_LINE("2"),
  QUERY_LINE("3"),
  BACKWARD("B");

  private final static Map<String, LineFeature> featureMap = new HashMap<>();

  static {
    for (final LineFeature lineFeature : values()) {
      featureMap.put(lineFeature.code, lineFeature);
    }
  }

  private final String code;

  LineFeature(final String code) {
    this.code = code;
  }

  public static LineFeature of(final String code) {
    if (!featureMap.containsKey(code)) {
      throw new IllegalArgumentException("선택할 수 없는 기능입니다.");
    }
    return featureMap.get(code);
  }
}
