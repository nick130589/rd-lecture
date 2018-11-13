package rd.lecture;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping
    public Person get(@RequestParam(value="name", defaultValue="Bill") String name) {
        return new Person(name, 10);
    }
}