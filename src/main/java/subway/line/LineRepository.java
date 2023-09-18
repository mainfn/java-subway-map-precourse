package subway.line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class LineRepository {

  private final List<Line> lines = new ArrayList<>();

  public List<Line> findAll() {
    return Collections.unmodifiableList(lines);
  }

  public void addLine(final Line line) {
    validateNameLength(line.getName());
    lines.add(line);
  }

  public Optional<Line> findByLineName(final String lineName) {
    return lines.stream()
        .filter(line -> line.getName().equals(lineName))
        .findFirst();
  }

  public boolean deleteLineByName(final String name) {
    return lines.removeIf(line -> Objects.equals(line.getName(), name));
  }

  public void validateNameLength(final String lineName) {
    if (lineName != null && lineName.length() < 2) {
      throw new IllegalArgumentException("지하철 노선 이름은 2글자 이상이어야 합니다.");
    }
  }
}
