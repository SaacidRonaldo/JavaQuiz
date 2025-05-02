package mj.lop;

public class GreetingController {


    @RestController
    public class GreetingController {

        @GetMapping("/")
        public String welcome() {
            return "Welcome to the Spring Boot API!";
        }

        @GetMapping("/greet/{name}")
        public String greet(@PathVariable String name) {
            return "Hello, " + name + "!";
        }
    }

}
