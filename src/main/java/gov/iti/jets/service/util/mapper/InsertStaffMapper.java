package gov.iti.jets.service.util.mapper;

import gov.iti.jets.persistence.entity.Staff;
import gov.iti.jets.presentation.models.InsertStaffDto;
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
public interface InsertStaffMapper {
    InsertStaffMapper INSTANCE = Mappers.getMapper(InsertStaffMapper.class);
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
    @Mappings(
            {
                    @Mapping(source = "address.location", target = "address.location", qualifiedByName = "pointConverter"),
                    @Mapping(source = "storeId", target = "store.id"),
                    @Mapping(source = "address.city",target = "address.city.city"),
                    @Mapping(source = "address.country",target = "address.city.country.country")}

    )
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Staff insertStaffDtoToStaff(InsertStaffDto insertStaffDto);
}
