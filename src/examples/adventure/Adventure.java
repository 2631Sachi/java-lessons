package examples.adventure;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.out;

/** This very simple text adventure game uses Lists and Maps to store information about the world. */
public class Adventure {
  public static void main(String[] args) {
    var location = "Farm";
    var transitions = Map.of(
        "Farm",     List.of("Town"),
        "Town",     List.of("Farm", "Airport"),
        "Airport",  List.of("Town", "Resort")
    );
    var scanner = new Scanner(System.in);
    while (! location.isEmpty()) {
      out.println("You are at the " + location);
      var places = transitions.get(location);
      out.println("You can go to " + places);
      out.println("Where to? ");
      var response = scanner.nextLine();
      if (places.contains(response)) {
        location = response;
      } else {
        out.println("You can't go there.");
      }
    }
  }
}
