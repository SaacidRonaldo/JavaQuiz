package mj.lop;

public class StaffService {
    @Service
    public class StaffService {
        private final Map<Long, Staff> staffMap = new HashMap<>();
        private AtomicLong idCounter = new AtomicLong();

        public List<Staff> getAllStaff() {
            return new ArrayList<>(staffMap.values());
        }

        public Staff getStaffById(Long id) {
            return staffMap.get(id);
        }

        public Staff createStaff(Staff staff) {
            long id = idCounter.incrementAndGet();
            staff.setId(id);
            staffMap.put(id, staff);
            return staff;
        }

        public Staff updateStaff(Long id, Staff staff) {
            if (staffMap.containsKey(id)) {
                staff.setId(id);
                staffMap.put(id, staff);
                return staff;
            }
            return null;
        }

        public boolean deleteStaff(Long id) {
            return staffMap.remove(id) != null;
        }
    }

}
