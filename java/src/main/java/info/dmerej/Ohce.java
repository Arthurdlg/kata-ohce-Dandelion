package info.dmerej;

public class Ohce {
  private final ConsoleInteractor interactor;

  public Ohce() {
    interactor = new ConsoleInteractor();
  }

  public Ohce(ConsoleInteractor interactor) {
    this.interactor = interactor;
  }

  public void mainLoop() {
    while (true) {
      String input = interactor.readInput();
      if (input.equals("quit")) {
        break;
      }
      var reversed = StringReverser.reverse(input);
      interactor.printMessage(reversed);
      if (reversed.equals(input)) {
        interactor.printMessage("That was a palindrome!");
      }
    }
  }
}
