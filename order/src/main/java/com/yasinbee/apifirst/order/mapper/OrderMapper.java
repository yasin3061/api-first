package com.yasinbee.apifirst.order.mapper;

import com.yasinbee.apifirst.order.dao.model.Order;
import com.yasinbee.apifirst.order.dto.OrderRequest;
import com.yasinbee.apifirst.order.dto.OrderResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order orderRequestToModel(OrderRequest request);

    OrderResponse orderModelToResponse(Order model);
}
