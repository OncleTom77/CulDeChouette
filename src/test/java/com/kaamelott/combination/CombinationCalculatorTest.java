package com.kaamelott.combination;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CombinationCalculatorTest {

    @ParameterizedTest(name = "Chouette de {index} ({0}) : {1}")
    @CsvSource(value = {
            "113",
            "252",
            "433",
            "446",
            "515",
            "566",
    })
    void should_only_have_one_chouette_combination_when_roll_represents_only_a_chouette(String roll) {
        List<Combination> combinations = new CombinationCalculator().getCombinationsFrom(roll);

        assertThat(combinations).hasSize(1);
        assertThat(combinations).hasOnlyElementsOfType(ChouetteCombination.class);
    }

    @ParameterizedTest(name = "Velute ({0}) : {1}")
    @CsvSource(value = {
            "413",
            "154",
            "235",
            "156",
            "246",
    })
    void should_only_have_one_velute_combination_when_roll_represents_only_a_velute(String roll) {
        List<Combination> combinations = new CombinationCalculator().getCombinationsFrom(roll);

        assertThat(combinations).hasSize(1);
        assertThat(combinations).hasOnlyElementsOfType(VeluteCombination.class);
    }

    @ParameterizedTest(name = "Chouette-Velute ({0}) : {1}")
    @CsvSource(value = {
            "112",
            "224",
            "336",
    })
    void should_only_have_one_chouette_velute_combination_when_roll_represents_only_a_chouette_velute(String roll) {
        List<Combination> combinations = new CombinationCalculator().getCombinationsFrom(roll);

        assertThat(combinations).hasSize(1);
        assertThat(combinations).hasOnlyElementsOfType(ChouetteVeluteCombination.class);
    }

    @ParameterizedTest(name = "Cul de Chouette ({0}) : {1}")
    @CsvSource(value = {
            "111, 50",
            "222, 60",
            "333, 70",
            "444, 80",
            "555, 90",
            "666, 100",
    })
    void should_only_have_one_cul_de_chouette_combination_when_roll_represents_only_a_cul_de_chouette(String roll) {
        List<Combination> combinations = new CombinationCalculator().getCombinationsFrom(roll);

        assertThat(combinations).hasSize(1);
        assertThat(combinations).hasOnlyElementsOfType(CulDeChouetteCombination.class);
    }

    @ParameterizedTest(name = "Suite ({0})")
    @CsvSource(value = {
            "234",
            "345",
            "456",
    })
    void should_only_have_one_suite_combination_when_roll_represents_only_a_suite(String roll) {
        List<Combination> combinations = new CombinationCalculator().getCombinationsFrom(roll);

        assertThat(combinations).hasSize(1);
        assertThat(combinations).hasOnlyElementsOfType(SuiteCombination.class);
    }

    @Test
    void should_have_one_velute_and_one_suite_combinations_when_roll_is_equivalent_to_123() {
        String roll = "123";

        List<Combination> combinations = new CombinationCalculator().getCombinationsFrom(roll);

        assertThat(combinations).hasSize(2);
        assertThat(combinations).hasAtLeastOneElementOfType(VeluteCombination.class);
        assertThat(combinations).hasAtLeastOneElementOfType(SuiteCombination.class);
    }

    @ParameterizedTest(name = "Néant ({0})")
    @CsvSource(value = {
            "136",
            "236",
            "125",
    })
    void should_only_have_neant_combination_when_roll_represents_no_other_combination(String roll) {
        List<Combination> combinations = new CombinationCalculator().getCombinationsFrom(roll);

        assertThat(combinations).hasSize(1);
        assertThat(combinations).hasOnlyElementsOfType(NeantCombination.class);
    }
}
