package rd.lecture;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;

@SpringBootTest
@WebAppConfiguration
@ExtendWith(SpringExtension.class)
@Transactional
class PersonControllerTest {

    @Autowired
    protected WebApplicationContext context;

    @Test
    void name() {
        //GIVEN
        MockMvcBuilders.webAppContextSetup(context).build();

        //WHEN


        //THEN
    }
}