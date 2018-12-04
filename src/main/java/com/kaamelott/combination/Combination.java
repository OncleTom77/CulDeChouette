package com.kaamelott.combination;

import java.util.List;

public interface Combination {

    boolean match(List<Integer> orderedDices);

    int compute(List<Integer> orderedDices);

    int compute(int value);
}
