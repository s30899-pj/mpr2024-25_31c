package pl.pjatk.rental_service.storage;

import org.springframework.stereotype.Component;
import pl.pjatk.rental_service.Hire;

import java.util.List;

@Component
public class HireStorage {
    List<Hire> hireList;

    public HireStorage(List<Hire> hireList) {
        this.hireList = hireList;
    }

    public void addHire(Hire hire) {
        hireList.add(hire);
    }
}
