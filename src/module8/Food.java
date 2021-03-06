package module8;

/**
 * Created by Igor on 30.03.2017.
 */
public class Food {
    private final int id;
    private String name;
    private Country country;
    private int expiration;

    public Food() {
        this.id = IdGenerator.generateId();
    }

    public Food(String name, Country country, int expiration) {
        this.id = IdGenerator.generateId();
        this.name = name;
        this.country = country;
        this.expiration = expiration;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public int getExpiration() {
        return expiration;
    }

    public void setExpiration(int expiration) {
        this.expiration = expiration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Food food = (Food) o;

        return id == food.id;

    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + country +
                ", expiration=" + expiration +
                '}';
    }
}
