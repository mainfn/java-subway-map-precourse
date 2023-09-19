package subway.line;

import java.util.Objects;

public final class Line {

  private final String name;

  private Line(final String name) {
    validateLineNameLength(name);
    this.name = name;
  }

  public static Line of(final String name) {
    return new Line(name);
  }

  private void validateLineNameLength(final String lineName) {
    if (lineName.length() < 2) {
      throw new IllegalArgumentException("노선명은 2글자 이상이어야 합니다");
    }
  }

  // 추가 기능 구현
  public String getName() {
    return name;
  }

  @Override
  public boolean equals(final Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    Line line = (Line) object;
    return Objects.equals(name, line.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return name;
  }
}
