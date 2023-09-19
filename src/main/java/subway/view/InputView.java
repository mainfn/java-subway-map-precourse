package subway.view;

import java.util.Scanner;
import subway.AppFeature;
import subway.FeatureKind;
import subway.line.CreateLine;
import subway.line.LineFeature;
import subway.section.CreateSection;
import subway.section.DeleteSection;
import subway.section.SectionFeature;
import subway.station.Station;
import subway.station.StationFeature;
import subway.utils.FeatureSelectionMessages;

public final class InputView {

  private boolean isInitialFeatureSelection = true;

  public AppFeature inputAppFeature() {
    if (!isInitialFeatureSelection) {
      System.out.println();
    }
    isInitialFeatureSelection = false;
    System.out.println(FeatureSelectionMessages.APP_FEATURE_SELECTION_MESSAGE);

    return AppFeature.of(readLine());
  }

  // STATION
  public StationFeature inputStationFeature() {
    System.out.println();
    System.out.println(FeatureSelectionMessages.STATION_FEATURE_SELECTION_MESSAGE);

    return StationFeature.of(readLine());
  }

  // LINE
  public LineFeature inputLineFeature() {
    System.out.println();
    System.out.println(FeatureSelectionMessages.LINE_FEATURE_SELECTION_MESSAGE);
    return LineFeature.of(readLine());
  }


  // LINE
  public SectionFeature inputSectionFeature() {
    System.out.println();
    System.out.println(FeatureSelectionMessages.SECTION_FEATURE_SELECTION_MESSAGE);
    return SectionFeature.of(readLine());
  }


  public String inputNameForCreation(final FeatureKind featureKind) {
    // 역 / 노선 / 구간
    System.out.println();
    System.out.printf("## 등록할 %s 이름을 입력하세요.\n", featureKind);
    return readLine();
  }

  public Station inputStation() {
    System.out.println();
    System.out.println("## 등록할 역 이름을 입력하세요.");
    return Station.of(readLine());
  }

  public CreateLine inputCreateLine() {
    System.out.println();
    System.out.println("## 노선을 입력하세요.");
    final String lineName = readLine();
    System.out.println();
    System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.");
    final Station firstStation = Station.of(readLine());
    System.out.println();
    System.out.println("## 등록할 노선의 하행 종점역 이름을 입력하세요.");
    final Station lastStation = Station.of(readLine());

    return CreateLine.of(lineName, firstStation, lastStation);
  }

  public CreateSection inputCreateSection() {
    System.out.println();
    System.out.println("## 노선을 입력하세요.");
    final String lineName = readLine();

    System.out.println();
    System.out.println("## 역이름을 입력하세요.");
    final String stationName = readLine();

    System.out.println();
    System.out.println("## 순서를 입력하세요.");
    final int order = Integer.parseInt(readLine());

    return new CreateSection(lineName, stationName, order);
  }

  public DeleteSection inputDeletionSection() {
    System.out.println();
    System.out.println("## 노선을 입력하세요.");
    final String lineName = readLine();

    System.out.println();
    System.out.println("## 역이름을 입력하세요.");
    final String stationName = readLine();

    return new DeleteSection(lineName, stationName);
  }

  public String inputNameForDeletion(final FeatureKind featureKind) {
    // 역 / 노선 / 구간
    System.out.println();
    System.out.printf("## 삭제할 %s 이름을 입력하세요.\n", featureKind);
    return readLine();
  }

  private String readLine() {
    final Scanner sc = new Scanner(System.in);
    return sc.nextLine().trim();
  }
}
