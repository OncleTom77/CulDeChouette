package com.kaamelott.combination;

import com.kaamelott.Dice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class CulDeChouetteAcceptanceTest {

    private Combinations combinations;

    @BeforeEach
    void setUp() {
        combinations = Combinations.from(asList(
                new SuiteVeluteCombination(),
                new CulDeChouetteCombination(),
                new ChouetteVeluteCombination(),
                new SuiteCombination(),
                new VeluteCombination(),
                new ChouetteCombination(),
                new NeantCombination()
        ));
    }

    @ParameterizedTest(name = "Chouette de {index} ({0}) : {1}")
    @CsvSource(value = {
            "113",
            "252",
            "433",
            "446",
            "515",
            "566",
    })
    void should_have_chouette_combination_when_roll_represents_a_chouette(String roll) {
        Dice dice = Dice.from(roll);

        Combination matchedCombination = combinations.match(dice);

        assertThat(matchedCombination).isExactlyInstanceOf(ChouetteCombination.class);
    }

    @ParameterizedTest(name = "Velute ({0}) : {1}")
    @CsvSource(value = {
            "413",
            "154",
            "235",
            "156",
            "246",
    })
    void should_have_velute_combination_when_roll_represents_a_velute(String roll) {
        Combination matchedCombination = combinations.match(Dice.from(roll));

        assertThat(matchedCombination).isExactlyInstanceOf(VeluteCombination.class);
    }

    @ParameterizedTest(name = "Chouette-Velute ({0}) : {1}")
    @CsvSource(value = {
            "112",
            "224",
            "336",
    })
    void should_have_chouette_velute_combination_when_roll_represents_a_chouette_velute(String roll) {
        Combination matchedCombination = combinations.match(Dice.from(roll));

        assertThat(matchedCombination).isExactlyInstanceOf(ChouetteVeluteCombination.class);
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
    void should_have_cul_de_chouette_combination_when_roll_represents_a_cul_de_chouette(String roll) {
        Combination matchedCombination = combinations.match(Dice.from(roll));

        assertThat(matchedCombination).isExactlyInstanceOf(CulDeChouetteCombination.class);
    }

    @ParameterizedTest(name = "Suite ({0})")
    @CsvSource(value = {
            "234",
            "345",
            "456",
    })
    void should_have_suite_combination_when_roll_represents_a_suite(String roll) {
        Combination matchedCombination = combinations.match(Dice.from(roll));

        assertThat(matchedCombination).isExactlyInstanceOf(SuiteCombination.class);
    }

    @Test
    void should_have_suite_velute_combinations_when_roll_represents_a_suite_and_a_velute() {
        String roll = "123";

        Combination matchedCombination = combinations.match(Dice.from(roll));

        assertThat(matchedCombination).isExactlyInstanceOf(SuiteVeluteCombination.class);
    }

    @ParameterizedTest(name = "Néant ({0})")
    @CsvSource(value = {
            "136",
            "236",
            "125",
    })
    void should_have_neant_combination_when_roll_represents_no_other_combination(String roll) {
        Combination matchedCombination = combinations.match(Dice.from(roll));

        assertThat(matchedCombination).isExactlyInstanceOf(NeantCombination.class);
    }
}
