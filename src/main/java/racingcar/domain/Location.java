package racingcar.domain;


import java.util.Objects;

public class Location {

    private static final int MIN_LOCATION = 0;
    private static final int MAX_LOCATION = 10;
    private int location;

    public Location(int location) {
        if (location < MIN_LOCATION)  {
            throw new IllegalArgumentException("Location의 값은 0보다 작은 수가 들어올 수 없습니다.");
        }

        if (location >= MAX_LOCATION) {
            throw new IllegalArgumentException("Location의 값은 10 이상일 순 없습니다.");
        }
        this.location = location;
    }

    public Location move() {
        return new Location(location + 1);
    }

    public int getLocation() {
        return location;
    }

    public boolean checkLocation(int location) {
        return this.location == location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location1 = (Location) o;
        return getLocation() == location1.getLocation();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLocation());
    }
}