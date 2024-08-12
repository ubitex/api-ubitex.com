package com.ex.api.client.spot;

import com.ex.api.dto.CommonResponse;
import com.ex.api.dto.spot.SpotPostOrderRequest;


/**
 * @create 2023/9/20 11:48
 */
public interface SpotApiClient {


    CommonResponse postOrder(SpotPostOrderRequest request);

    CommonResponse getOrder(Long id);

    CommonResponse queryOrder(Long orderId);

    CommonResponse delOrder(Long id);
}
