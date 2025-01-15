package info.dmerej;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class GreeterTest {
  public static class InnerClass extends SystemClock {
    int i;

    InnerClass(int i) {
      this.i = i;
    }

    public int getCurrentHour() {
      return i;
    }
  }

  @Test
  void nightlyGreeting() {
    // Assert that greeter says "Good night" when current hour is 0 (midnight)
    Greeter greeter = new Greeter(new InnerClass(0));
    assert greeter.greet().equalsIgnoreCase("good night");
  }

  @Test
  void neverAsserts() {
    // Assert that the assertion in greet() is never thrown, by checking all hours from 0 to 23
    for (int i = 0; i <= 23; i++) {
      Greeter greeter = new Greeter(new InnerClass(i));
      try {
        greeter.greet();
      } catch (AssertionError error) {
        fail(error.getMessage());
      }
    }
  }
}


