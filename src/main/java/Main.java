import java.util.HashMap;
import java.util.Map;

public class Main {

    Map<Long, Long> count(Map<String, UserStats>... visits) {
        Map<Long, Long> visitCounts = new HashMap<>();

        for (Map<String, UserStats> visit : visits) {
            for (Map.Entry<String, UserStats> entry : visit.entrySet()) {
                String userId = entry.getKey();
                UserStats userStats = entry.getValue();

                if (userId == null || userStats == null) {
                    continue; // Pomijamy przypadki, w których klucz lub wartość są puste
                }

                Long userIdLong;
                try {
                    userIdLong = Long.parseLong(userId);
                } catch (NumberFormatException e) {
                    continue; // Pomijamy przypadki, w których String nie może być przekonwertowany na Long
                }

                visitCounts.put(userIdLong, visitCounts.getOrDefault(userIdLong, 0L) + 1);
            }
        }

        return visitCounts;
    }
}
