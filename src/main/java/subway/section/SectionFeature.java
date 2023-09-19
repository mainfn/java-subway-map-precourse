package subway.section;

import java.util.HashMap;
import java.util.Map;

public enum SectionFeature {
  CREATE_SECTION("1"),
  REMOVE_SECTION("2"),
  BACKWARD("B");

  private final static Map<String, SectionFeature> featureMap = new HashMap<>();

  static {
    for (final SectionFeature sectionFeature : values()) {
      featureMap.put(sectionFeature.code, sectionFeature);
    }
  }

  private final String code;

  SectionFeature(final String code) {
    this.code = code;
  }

  public static SectionFeature of(final String code) {
    if (!featureMap.containsKey(code)) {
      throw new IllegalArgumentException("선택할 수 없는 기능입니다.");
    }
    return featureMap.get(code);
  }
}
