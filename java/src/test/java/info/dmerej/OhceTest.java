package info.dmerej;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.fail;

public class OhceTest {
  public class StubConsole extends ConsoleInteractor {
    public int number_of_calls = 0;
    public ArrayList<String> calls = new ArrayList<>();
    public String readInput(){
      number_of_calls += 1;
      switch (this.number_of_calls) {
        case 1:
          return "hello";
        case 2:
          return "oto";
        case 3:
          return "quit";
      }

      return "";
    }
    public void printMessage(String message) {
      calls.add(message);
    }
  }
  @Test
  void testMainLoop() {
    /*
     TODO: check that given the following inputs:
      - hello
      - oto
     - quit

    The following messages are shown to the user:
     - olleh
     - oto
     - That was a palindrome!

    */
    StubConsole console = new StubConsole();
    Ohce ohce = new Ohce(console);
    ohce.mainLoop();

    assert Objects.equals(console.calls.get(0), "olleh");
    assert Objects.equals(console.calls.get(1), "oto");
    assert Objects.equals(console.calls.get(2), "That was a palindrome!");
  }
}
