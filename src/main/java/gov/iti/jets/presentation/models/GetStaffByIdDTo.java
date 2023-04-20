package gov.iti.jets.presentation.models;

import gov.iti.jets.persistence.dto.staff.ShowStaffDto;
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
public class GetStaffByIdDTo {
    ShowStaffDto showStaffDto;
    private List<Link> links;
    List<Link> createList(UriInfo uriInfo, Integer id){
        links = new ArrayList<>();

        links.add(new Link(uriInfo.getBaseUriBuilder().toString()+"staffs/"+id,"get staff member By Id"));
        links.add(new Link(uriInfo.getBaseUriBuilder().toString()+"staffs/"+id,"delete staff By id"));
        links.add(new Link(uriInfo.getBaseUriBuilder().toString()+"staffs/"+id+"/getPayments","get staff payment"));
        links.add(new Link(uriInfo.getBaseUriBuilder().toString()+"staffs/"+id+"/getRental","get All staff rental"));
        links.add(new Link(uriInfo.getBaseUriBuilder().toString()+"staffs/getALlStaff","get  staff list"));
        links.add(new Link(uriInfo.getBaseUriBuilder().toString()+"staffs/\"newStaff\"","new staff"));
        return links;
    }
    public void addLink(Link link, UriInfo uriInfo) {
        createList(uriInfo,showStaffDto.getId());
        if (link  != null) {
            this.links.add(link);
        }

    }
}
