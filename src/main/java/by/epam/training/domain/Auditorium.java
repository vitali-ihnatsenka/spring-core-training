package by.epam.training.domain;

import java.util.List;

/**
 * Created by Vitali on 20.10.2015.
 */
public class Auditorium {
    private String name;
    private int numberOfSeats;
    private List<Integer> vipSeats;

    public Auditorium(String name, int numberOfSeats, List<Integer> vipSeats) {
        this.name = name;
        this.numberOfSeats = numberOfSeats;
        this.vipSeats = vipSeats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public List<Integer> getVipSeats() {
        return vipSeats;
    }

    public void setVipSeats(List<Integer> vipSeats) {
        this.vipSeats = vipSeats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Auditorium that = (Auditorium) o;

        if (numberOfSeats != that.numberOfSeats) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (vipSeats != null ? !vipSeats.equals(that.vipSeats) : that.vipSeats != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + numberOfSeats;
        result = 31 * result + (vipSeats != null ? vipSeats.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Auditorium{" +
                "name='" + name + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                ", vipSeats=" + vipSeats +
                '}';
    }
}
