package gov.iti.jets.presentation.models;

import gov.iti.jets.persistence.dto.store.StoreManagerDto;
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
public class getStoreManagerById {
private StoreManagerDto storeManagerDto;
    private List<Link> links;
    List<Link> createList(UriInfo uriInfo, Integer id){
        links = new ArrayList<>();


        links.add(new Link(uriInfo.getBaseUriBuilder().toString()+"stores/"+id+"/manager","get Store manager"));
        links.add(new Link(uriInfo.getBaseUriBuilder().toString()+"stores/"+id+"/address","get store Address"));
        links.add(new Link(uriInfo.getBaseUriBuilder().toString()+"stores","put updated store "));
        return links;
    }
    public void addLink(Link link, UriInfo uriInfo) {
        createList(uriInfo,storeManagerDto.getId());
        if (link  != null) {
            this.links.add(link);
        }

    }
}
