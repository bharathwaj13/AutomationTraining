package org.onboard.collections.comparator;

import java.util.Comparator;

public class Checker implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        if (o1.getScore() != o2.getScore())
            return Integer.compare(o1.getScore(), o2.getScore());
        return o1.getName().compareTo(o2.getName());
    }
}
