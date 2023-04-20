package gov.iti.jets.presentation.models;

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
public class getCategoryByIdDTo {
    CategorywithoutFilmsDto categorywithoutFilmsDto;
    private List<Link> links;
    List<Link> createList(UriInfo uriInfo, Integer id){
        links = new ArrayList<>();

        links.add(new Link(uriInfo.getBaseUriBuilder().toString()+"categories/"+id,"get category By Id"));
        links.add(new Link(uriInfo.getBaseUriBuilder().toString()+"categories/","update category name"));
        links.add(new Link(uriInfo.getBaseUriBuilder().toString()+"categories/","POST new category "));
        links.add(new Link(uriInfo.getBaseUriBuilder().toString()+"categories/"+id+"/films","get all category films"));
        return links;
    }
    public void addLink(Link link, UriInfo uriInfo) {
        createList(uriInfo,categorywithoutFilmsDto.getId());
        if (link  != null) {
            this.links.add(link);
        }

    }
}
