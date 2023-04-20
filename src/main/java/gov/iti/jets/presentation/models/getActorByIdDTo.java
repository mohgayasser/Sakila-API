package gov.iti.jets.presentation.models;

import gov.iti.jets.persistence.dto.actor.ActorDto;
import jakarta.ws.rs.core.UriInfo;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class getActorByIdDTo {
    ActorDto actorDto;
    private List<Link> links;
    List<Link> createList(UriInfo uriInfo, Integer id){
        links = new ArrayList<>();

        links.add(new Link(uriInfo.getBaseUriBuilder().toString()+"actors/"+id,"get actor By Id"));
        links.add(new Link(uriInfo.getBaseUriBuilder().toString()+"actors/","update Actor"));
        links.add(new Link(uriInfo.getBaseUriBuilder().toString()+"actors","post new actor"));
        links.add(new Link(uriInfo.getBaseUriBuilder().toString()+"actors/"+id+"/getCategories","get Actors' participation categories ."));
        links.add(new Link(uriInfo.getBaseUriBuilder().toString()+"actors/"+id+"/getFilms","get All actor films"));
        return links;
    }
    public void addLink(Link link, UriInfo uriInfo,Integer id) {
        createList(uriInfo,id);
        if (link  != null) {
            this.links.add(link);
        }

    }
}
