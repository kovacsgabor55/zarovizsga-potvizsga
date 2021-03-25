package hu.nive.ujratervezes.zarovizsga.cleaning;

public class House implements Cleanable {
    private final String address;
    private final int area;
    private final int level;

    public House(String address, int area, int level) {
        this.address = address;
        this.area = area;
        this.level = level;
    }

    public House(String address, int area) {
        this(address, area, 1);
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public int clean() {
        return area * level * 80;
    }
}
