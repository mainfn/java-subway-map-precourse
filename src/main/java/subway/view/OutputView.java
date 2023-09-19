package subway.view;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import subway.FeatureKind;
import subway.line.Line;
import subway.station.Station;

public final class OutputView {

  public void printCreationMessage(final FeatureKind featureKind) {
    // 역 / 노선 / 구간
    System.out.println();
    System.out.printf("[INFO] 지하철 %s이 등록되었습니다.", featureKind);
    System.out.println();
  }

  public void printDeletionMessage(final FeatureKind featureKind) {
    // 역 / 노선 / 구간
    System.out.println();
    System.out.printf("[INFO] 지하철 %s이 삭제되었습니다.\n", featureKind);
    System.out.println();
  }

  private void print(final List list) {
    for (final Object name : list) {
      printWithInfoPrefix(name.toString());
    }
  }

  public void printList(
      final FeatureKind featureKind,
      final List list
  ) {
    System.out.println();
    System.out.printf("## %s 목록\n", featureKind);
    print(list);
  }

  public void printSubwayMap(final Map<Line, List<Station>> subwayMap) {
    System.out.println();
    System.out.println("## 지하철 노선도");
    for (final Entry<Line, List<Station>> entry : subwayMap.entrySet()) {
      final Line line = entry.getKey();
      final List<Station> stations = entry.getValue();

      printWithInfoPrefix(line.toString());
      printWithInfoPrefix("---");
      print(stations);
      System.out.println();
    }

  }

  private void printWithInfoPrefix(final String message) {
    System.out.printf("[INFO] %s\n", message);
  }
}
