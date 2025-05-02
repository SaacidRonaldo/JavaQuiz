package mj.lop;

public class StaffController {

    @RestController
    @RequestMapping("/staffs")
    public class StaffController {

        @Autowired
        private StaffService staffService;

        @GetMapping
        public List<Staff> getAllStaff() {
            return staffService.getAllStaff();
        }

        @GetMapping("/{id}")
        public ResponseEntity<?> getStaffById(@PathVariable Long id) {
            Staff staff = staffService.getStaffById(id);
            if (staff != null)
                return ResponseEntity.ok(staff);
            else
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Staff not found");
        }

        @PostMapping
        public ResponseEntity<Staff> createStaff(@RequestBody Staff staff) {
            Staff created = staffService.createStaff(staff);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        }

        @PutMapping("/{id}")
        public ResponseEntity<?> updateStaff(@PathVariable Long id, @RequestBody Staff staff) {
            Staff updated = staffService.updateStaff(id, staff);
            if (updated != null)
                return ResponseEntity.ok(updated);
            else
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Staff not found");
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteStaff(@PathVariable Long id) {
            boolean deleted = staffService.deleteStaff(id);
            if (deleted)
                return ResponseEntity.ok("Staff deleted");
            else
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Staff not found");
        }
    }

}
