package gov.iti.jets.persistence.entity.enums;

public enum SpecialFeatures {
    Trailers("Trailers"),
    Commentaries("Commentaries"),
    DeletedScenes("Deleted Scenes"),
    BehindtheScenes("Behind the Scenes");
    public final String label;
    SpecialFeatures(String label) {
        this.label = label;
    }

}
