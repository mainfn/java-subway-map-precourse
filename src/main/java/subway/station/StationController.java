package subway.station;

import java.util.List;
import subway.FeatureKind;
import subway.view.InputView;
import subway.view.OutputView;

public final class StationController {

  private final StationService stationService;
  private final InputView inputView;
  private final OutputView outputView;


  public StationController(
      final StationService stationService,
      final InputView inputView,
      final OutputView outputView
  ) {
    this.stationService = stationService;
    this.inputView = inputView;
    this.outputView = outputView;
  }


  public void selectFeature() {
    final StationFeature feature = inputView.inputStationFeature();

    if (feature.equals(StationFeature.CREATE_LINE)) {
      final String stationName = inputView.inputNameForCreation(FeatureKind.STATION_FEATURE);
      stationService.addStation(stationName);
      outputView.printCreationMessage(FeatureKind.STATION_FEATURE);
    }
    if (feature.equals(StationFeature.REMOVE_LINE)) {
      final String stationName = inputView.inputNameForDeletion(FeatureKind.STATION_FEATURE);
      stationService.deleteStation(stationName);
      outputView.printDeletionMessage(FeatureKind.STATION_FEATURE);
    }
    if (feature.equals(StationFeature.QUERY_LINE)) {
      final List<Station> stations = stationService.findAllStations();
      outputView.printList(FeatureKind.STATION_FEATURE, stations);
    }
  }
}
