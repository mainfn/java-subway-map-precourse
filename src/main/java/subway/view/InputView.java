package subway.view;

import java.util.Scanner;
import subway.AppFeature;

public final class InputView {

  public AppFeature inputNextAppFeature() {
    System.out.println("## 메인 화면\n"
        + "1. 역 관리\n"
        + "2. 노선 관리\n"
        + "3. 구간 관리\n"
        + "4. 지하철 노선도 출력\n"
        + "Q. 종료\n"
        + "\n"
        + "## 원하는 기능을 선택하세요.");

    return AppFeature.of(readLine());
  }

  private String readLine() {
    final Scanner sc = new Scanner(System.in);
    return sc.nextLine().trim();
  }
}
