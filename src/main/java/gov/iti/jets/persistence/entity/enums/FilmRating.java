package gov.iti.jets.persistence.entity.enums;

public enum FilmRating {
    G("G"),
    PG("PG"),
    PG13("PG-13"),
    R("R"),
    NC17("NC-17");
    public final String pg;
    FilmRating(String pg) {
        this.pg = pg;
    }
}
