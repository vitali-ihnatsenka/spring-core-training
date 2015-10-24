package by.epam.training.domain;

/**
 * Created by Vitali on 20.10.2015.
 */
public class Event {
    private String name;
    private int basePrice;
    private Rating rating;

    public Event(String name, int basePrice, Rating rating) {
        this.name = name;
        this.basePrice = basePrice;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (basePrice != event.basePrice) return false;
        if (!name.equals(event.name)) return false;
        if (rating != event.rating) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + basePrice;
        result = 31 * result + rating.hashCode();
        return result;
    }

    @Override
    public String  toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", basePrice=" + basePrice +
                ", rating=" + rating +
                '}';
    }
}
