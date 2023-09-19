package subway;

import java.util.List;
import java.util.Map;
import subway.line.Line;
import subway.line.LineController;
import subway.line.LineService;
import subway.section.SectionController;
import subway.station.Station;
import subway.station.StationController;
import subway.view.InputView;
import subway.view.OutputView;

public final class AppController {

  private final InputView inputView;
  private final OutputView outputView;

  private final StationController stationController;
  private final LineController lineController;
  private final SectionController sectionController;

  private final LineService lineService;

  public AppController(
      final InputView inputView,
      final OutputView outputView,
      final StationController stationController,
      final LineController lineController,
      final SectionController sectionController,
      final LineService lineService
  ) {
    this.inputView = inputView;
    this.outputView = outputView;
    this.stationController = stationController;
    this.lineController = lineController;
    this.sectionController = sectionController;
    this.lineService = lineService;
  }

  public void run() {
    boolean isRunning = true;

    while (isRunning) {
      isRunning = selectFeature();
    }
  }

  public boolean selectFeature() {
    final AppFeature appFeature = inputView.inputAppFeature();
    if (appFeature.equals(AppFeature.STATION_MANAGEMENT)) {
      stationController.selectFeature();
    }
    if (appFeature.equals(AppFeature.LINE_MANAGEMENT)) {
      lineController.selectFeature();
    }
    if (appFeature.equals(AppFeature.SECTION_MANAGEMENT)) {
      sectionController.selectFeature();
    }
    if (appFeature.equals(AppFeature.PRINT_SUBWAY_MAP)) {
      final Map<Line, List<Station>> subwayMap = lineService.getSubwayMap();
      outputView.printSubwayMap(subwayMap);
    }
    return appFeature != AppFeature.QUIT;
  }
}
