package subway;

import subway.view.InputView;

public final class AppController {

  private final InputView inputView;

  public AppController(final InputView inputView) {
    this.inputView = inputView;
  }

  public void run() {
    boolean isRunning = true;

    while (isRunning) {
      isRunning = dispatchAppFeature();
    }
  }

  public boolean dispatchAppFeature() {
    final AppFeature appFeature = inputView.inputNextAppFeature();
    if (appFeature.equals(AppFeature.STATION_MANAGEMENT)) {
      // TODO:
    }
    if (appFeature.equals(AppFeature.LINE_MANAGEMENT)) {
      // TODO:
    }
    if (appFeature.equals(AppFeature.SECTION_MANAGEMENT)) {
      // TODO:
    }
    if (appFeature.equals(AppFeature.PRINT_SUBWAY_MAP)) {
      // TODO:
    }
    return appFeature != AppFeature.QUIT;
  }
}
