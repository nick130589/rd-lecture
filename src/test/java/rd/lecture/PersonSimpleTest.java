package rd.lecture;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PersonSimpleTest {

    @Test
    void returnsFirstName() {
        //GIVEN
        Person sut = new Person("John", "Doe");


        //WHEN
        String actualFirstName = sut.getFirstName();

        //THEN
        assertThat(actualFirstName).isEqualTo("John");
    }
}