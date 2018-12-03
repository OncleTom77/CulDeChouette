package com.kaamelott;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CombinationCalculatorTest {

    @Test
    public void should_compute_chouette_combination_calculation() {
        String roll = "113";

        int score = new CombinationCalculator().computeScore(roll);

        assertThat(score).isEqualTo(1);
    }
}
