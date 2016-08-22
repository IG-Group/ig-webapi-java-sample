package com.iggroup.webapi.samples.client.rest.dto.workingorders.otc.deleteOTCWorkingOrderV1;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
Delete working order request.
 N.B.: This request requires a payload with no request attributes (e.g. empty json string:  {} )
*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeleteOTCWorkingOrderV1Request {

}
