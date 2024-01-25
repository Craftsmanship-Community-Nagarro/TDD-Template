package org.nagarro;



import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class HelloTest {

    @Test
    public void shouldGreet() {
        Hello hello = new Hello();

        String greeting = hello.greeting();

        assertThat("Hello World").isEqualTo(greeting);
    }

}
