package gov.iti.jets.presentation.models;

import gov.iti.jets.persistence.dto.customer.CustomerDto;
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
public class GetCustomerByIdDTo {
    CustomerDto customerDto;
    private List<Link> links;
    List<Link> createList(UriInfo uriInfo,Integer id){
        links = new ArrayList<>();

        links.add(new Link(uriInfo.getBaseUriBuilder().toString()+"customers/"+id,"get Customer By Id"));
        links.add(new Link(uriInfo.getBaseUriBuilder().toString()+"customers/getBalanceInDate","get Customer Debit"));
        links.add(new Link(uriInfo.getBaseUriBuilder().toString()+"customers/"+id+"/getRentalHistory","get All Customer Rental History"));
        links.add(new Link(uriInfo.getBaseUriBuilder().toString()+"customers/"+id+"/getPaymentHistory","get All Customer Payments"));
        links.add(new Link(uriInfo.getBaseUriBuilder().toString()+"customers/newCustomer","Add Customer"));
        return links;
    }
    public void addLink(Link link, UriInfo uriInfo) {
        createList(uriInfo,customerDto.getId());
        if (link  != null) {
            this.links.add(link);
        }

    }
}
