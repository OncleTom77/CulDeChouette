package com.kaamelott.combination;

import com.kaamelott.Dice;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CombinationsTest {

    @Test
    void should_match_expected_combination() {
        Dice dice = mock(Dice.class);
        Combination expectedCombination = mock(Combination.class);
        Combinations combinations = Combinations.from(asList(
                mock(Combination.class),
                expectedCombination,
                mock(Combination.class)
        ));

        when(expectedCombination.match(dice)).thenReturn(true);
        Combination matched = combinations.match(dice);

        assertThat(matched).isEqualTo(expectedCombination);
    }
}