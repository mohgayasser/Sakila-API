package gov.iti.jets.presentation.models;

import gov.iti.jets.persistence.dto.actor.ActorCategoryDto;
import gov.iti.jets.persistence.entity.Category;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class ActorFavCategory {
    Long maxParticipate;
    Category category;
}
