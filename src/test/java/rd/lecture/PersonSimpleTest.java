package rd.lecture;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class PersonSimpleTest {

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(2, 2, 4),
                Arguments.of(-2, 2, 0),
                Arguments.of(-2, -2, -4)
        );
    }

    @MethodSource("testData")
    @ParameterizedTest(name = "calculating {0} + {1} = {2}")
    void shouldAdd(int x1, int x2, int expected) {
        //GIVEN
        Calculator sut = new Calculator();

        //WHEN
        int actual = sut.add(x1, x2);

        //THEN
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void returnsFirstName() {
        //GIVEN


        Person person1 = new Person("John", 20);
        Person person2 = new Person("John", 10);
        Person person3 = new Person("John", 10);


        List<Person> people = Arrays.asList(person1, person2, person3);

        //WHEN

        //THEN
        //assertThat(actualFirstName, is("John1"));


        Assertions.assertThat(people)
                .extracting(Person::getAge).containsOnly(20);

    }
}