package com.dayana.market.persistence.mapper;

import com.dayana.market.domain.PurchaseItem;
import com.dayana.market.persistence.entity.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring" , uses = { ProductMapper.class})
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping( source = "id.id_producto", target = "productId"),
            @Mapping( source = "cantidad", target = "quantity"),
            @Mapping( source = "estado", target = "active")
    })
    PurchaseItem toPurchaseItem(ComprasProducto producto);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "id.id_compra", ignore = true),
            @Mapping(target = "compra", ignore = true),
            @Mapping(target = "producto", ignore = true)
    })
    ComprasProducto toComprasProducto(PurchaseItem item);
}
