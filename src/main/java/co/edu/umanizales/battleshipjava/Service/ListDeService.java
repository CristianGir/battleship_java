package co.edu.umanizales.battleshipjava.Service;

import co.edu.umanizales.battleshipjava.model.*;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class ListDeService {
    private ListDE list = new ListDE();

    public List<ShipDistribution> getAllLinked() {
            return this.list.enlist();
    }

    public String add(ShipDistribution shipDistribution) {
        this.list.add(shipDistribution);
        return "Adicionado con éxito";
    }

    public String addFirst(ShipDistribution shipDistribution) {
        this.list.addFirst(shipDistribution);
        return "Adicionado con éxito";
    }
}
