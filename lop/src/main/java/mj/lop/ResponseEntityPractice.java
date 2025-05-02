package mj.lop;

public class ResponseEntityPractice {

    @RestController
    public class ResponseDemoController {

        @GetMapping("/success")
        public ResponseEntity<String> success() {
            return ResponseEntity.ok()
                    .header("X-Custom-Header", "SuccessHeader")
                    .body("Request was successful!");
        }

        @GetMapping("/not-found")
        public ResponseEntity<Map<String, String>> notFound() {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Resource not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }

        @PostMapping("/create")
        public ResponseEntity<String> createResource(@RequestBody Map<String, String> body) {
            URI location = URI.create("/resource/123");
            return ResponseEntity.created(location).body("Resource created");
        }
    }

}
