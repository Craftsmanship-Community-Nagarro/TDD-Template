package org.nagarro;

import java.time.chrono.ChronoLocalDate;
import java.util.List;

public class Game {

    public List<Integer> nextRoll() {
        return List.of(5, 3, 1, 5, 6);


    }

    public int selectPair() {
        return 8;
    }
}
