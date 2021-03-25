package hu.nive.ujratervezes.zarovizsga.cleaning;

import java.util.ArrayList;
import java.util.List;

public class CleaningService {
    private final List<Cleanable> cleanables = new ArrayList<>();

    public List<Cleanable> getCleanables() {
        return new ArrayList<>(cleanables);
    }

    public int cleanAll() {
        int result = 0;
        for (Cleanable item : cleanables) {
            result += item.clean();
        }
        cleanables.clear();
        return result;
    }

    public void add(Cleanable cleanable) {
        cleanables.add(cleanable);
    }

    public int cleanOnlyOffices() {
        int result = 0;
        for (Cleanable item : cleanables) {
            if (item instanceof Office) {
                result += item.clean();
            }
        }
        cleanables.removeIf(item -> item instanceof Office);
        return result;
    }

    public List<Cleanable> findByAddressPart(String addressPart) {
        List<Cleanable> result = new ArrayList<>();
        for (Cleanable item : cleanables) {
            if (item.getAddress().contains(addressPart)) {
                result.add(item);
            }
        }
        return result;
    }

    public String getAddresses() {
        StringBuilder result = new StringBuilder();
        for (Cleanable item : cleanables) {
            result.append(item.getAddress() + ", ");
        }
        return result.substring(0, result.length() - 2);
    }
}
