package apo.java.practice.interview.uber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a map of string arrays, unroll the map into each value combination.
 * <p>
 * For example:
 * <p>
 * unroll({
 * "name": ["bob", "jane"],
 * "color": ["red", "green", "blue"],
 * "city": ["new york"],
 * })
 * <p>
 * Should produce 2 x 3 x 1 = 6 entries:
 * <p>
 * [
 * {"name": "bob", "color": "red", "city": "new york"},*
 * {"name": "bob", "color": "green", "city": "new york"},*
 * {"name": "bob", "color": "blue", "city": "new york"},*
 * {"name": "jane", "color": "red", "city": "new york"},*
 * {"name": "jane", "color": "green", "city": "new york"},*
 * {"name": "jane", "color": "blue", "city": "new york"},*
 * ]
 */
public class UnRollMap {

    public static void main(String[] args) {
        var map = Map.of("name", List.of("bob", "jane"), "color", List.of("red", "green", "blue"), "city", List.of("new york"));
        System.out.println(unRoll(map));
    }

    public static List<Map<String, String>> unRoll(Map<String, List<String>> mappings) {
        List<Map<String, String>> result = new ArrayList<>();
        for (var e : mappings.entrySet()) {
            result = combine(result, e);
        }
        return result;
    }

    public static List<Map<String, String>> combine(List<Map<String, String>> result, Map.Entry<String, List<String>> entry) {
        List<Map<String, String>> newResult = new ArrayList<>();
        for (var value : entry.getValue()) {
            if (result.isEmpty()) {
                Map<String, String> newMap = new HashMap<>();
                newMap.put(entry.getKey(), value);
                newResult.add(newMap);
            } else {
                for (var r : result) {
                    Map<String, String> newMap = new HashMap<>(r);
                    newMap.put(entry.getKey(), value);
                    newResult.add(newMap);
                }
            }
        }
        return newResult;
    }

}
