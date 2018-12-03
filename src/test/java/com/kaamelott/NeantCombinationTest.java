package com.kaamelott;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NeantCombinationTest {

    @Test
    void should_return_0_when_compute_neant_combination_calculation() {
        NeantCombination neantCombination = NeantCombination.from();

        int score = neantCombination.compute();

        assertThat(score).isEqualTo(0);
    }
}