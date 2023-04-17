package gov.iti.jets.service.util.mapper;

import gov.iti.jets.persistence.entity.Customer;
import gov.iti.jets.presentation.models.AddCustomerDto;
import gov.iti.jets.presentation.models.Location;
import lombok.SneakyThrows;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.WKTReader;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;


@Mapper
public interface newCustomerMapper {
    newCustomerMapper INSTANCE = Mappers.getMapper(newCustomerMapper.class);
    String map(byte[] bytes);

    @SneakyThrows
    @Named("pointConverter")
    default Geometry PointToGeometry(Location location) {
        if (location == null) {
            return null;
        }
        GeometryFactory geometryFactory = new GeometryFactory();
        Coordinate coordinate = new Coordinate(location.getLongitude(), location.getLatitude());
        Point point = geometryFactory.createPoint(coordinate);

        Geometry geometry = new WKTReader().read(String.valueOf(point));
        return geometry;
    }
//    @SneakyThrows
//    @Named("fromBlobToString")
//    default String  BlobConverter(SerialBlob entity){
//
//        byte[] bytes = entity.getBytes(1, (int) entity.length());
//        String str = new String(bytes, "UTF-8");
//        return  str;
//    }
    @Mappings({
            @Mapping(source = "address.city", target = "address.city.city"),
            @Mapping(source = "address.country", target = "address.city.country.country"),
            @Mapping(source = "address.location", target = "address.location", qualifiedByName = "pointConverter")
    })
    Customer addCustomerDtoToCustomer(AddCustomerDto addCustomerDto);
//
//    @Mappings({
//            @Mapping(source = "address.city.city", target = "address.city"),
//            @Mapping(source = "address.city.country.country", target = "address.country"),
//            @Mapping(source="address.location",target = "address.location",qualifiedByName = "fromBlobToString")
//    })
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    AddCustomerDto customerToAddCustomerDto(Customer customer);


}
