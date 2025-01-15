package info.dmerej;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.fail;

public class OhceTest {
  public class StubConsole extends ConsoleInteractor {
    public Stack<String> calls = new Stack<>(){{
      addAll(Arrays.asList("quit", "oto", "hello"));
    }};
    public ArrayList<String> outputs = new ArrayList<>();
    public String readInput(){
      if(!calls.isEmpty()){
        return calls.pop();
      }
      return "quit";
    }
    public void printMessage(String message) {
      outputs.add(message);
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

    assert console.outputs.equals(new ArrayList<String>(Arrays.asList("olleh", "oto", "That was a palindrome!")));
  }
}
