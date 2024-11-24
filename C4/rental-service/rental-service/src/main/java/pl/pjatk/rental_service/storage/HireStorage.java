package pl.pjatk.rental_service.storage;

import org.springframework.stereotype.Component;
import pl.pjatk.rental_service.Hire;

import java.util.ArrayList;
import java.util.List;

@Component
public class HireStorage {
    List<Hire> hireList;

    public HireStorage() {
        this.hireList = new ArrayList<>();
    }

    public List<Hire> getHireList() {
        return hireList;
    }

    public void addHire(Hire hire) {
        hireList.add(hire);
    }
}
