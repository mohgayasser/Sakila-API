package gov.iti.jets.presentation.models;

import gov.iti.jets.persistence.dto.films.getFilmDto;
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
public class GetFilmByIdDTO  {
    getFilmDto filmDto;
    private List<Link> links;
    List<Link> createList(UriInfo uriInfo,Integer id){
        links = new ArrayList<>();

        links.add(new Link(uriInfo.getBaseUriBuilder().toString()+"films/"+id,"get Film By Id"));
        links.add(new Link(uriInfo.getBaseUriBuilder().toString()+"films/getFilmName","get Film By first Name"));
        links.add(new Link(uriInfo.getBaseUriBuilder().toString()+"films/getAllFilms","get List Of Films"));
        links.add(new Link(uriInfo.getBaseUriBuilder().toString()+"films/"+id+"/checkExistence","check if this film exist"));
        links.add(new Link(uriInfo.getBaseUriBuilder().toString()+"films/"+id+"/getFilmRenter","get All film rents"));
        links.add(new Link(uriInfo.getBaseUriBuilder().toString()+"films/newFilm","Add film"));
        links.add(new Link(uriInfo.getBaseUriBuilder().toString()+"films/rentFilm","Rent film"));
        links.add(new Link(uriInfo.getBaseUriBuilder().toString()+"films/returnFilm","Return film"));
        links.add(new Link(uriInfo.getBaseUriBuilder().toString()+"films/getQuantity","get film Quantity in stock" ));
        return links;
    }
    public void addLink(Link link, UriInfo uriInfo) {
        createList(uriInfo,filmDto.getId());
        if (link  != null) {
            this.links.add(link);
        }

    }
}
