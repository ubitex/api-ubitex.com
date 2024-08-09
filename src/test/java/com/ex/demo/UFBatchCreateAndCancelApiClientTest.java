package com.ex.demo;

import com.ex.api.client.future.FutureApiClient;
import com.ex.api.client.future.FutureUApiClientImpl;
import com.ex.api.dto.CommonResponse;
import com.ex.api.dto.future.FuturePostOrderRequest;
import com.google.gson.Gson;
import org.junit.Test;

import java.util.*;

/**
 * USDT BASE Future
 * @create 2023/9/20 16:15
 */
public class UFBatchCreateAndCancelApiClientTest {
    Gson gson = new Gson();
    FutureApiClient client = new FutureUApiClientImpl(null);




//    @Test
//    public void allCancel() {
//        CommonResponse commonResponse = client.allCancel(null);
//        System.out.println("result:"+commonResponse);
//    }

    @Test
    public void createAndCancel() {
        String clientOrderId = System.currentTimeMillis()+"1";
        String clientOrderId2 = System.currentTimeMillis()+"2";
        String clientOrderId3 = System.currentTimeMillis()+"3";
        String clientOrderId4 = System.currentTimeMillis()+"4";
//        FuturePostOrderRequest request = FuturePostOrderRequest.builder().symbol("trb_usdt")
//                .origQty("15")
//                .orderType("LIMIT")
//                .timeInForce("GTC")
//                .price("6.50")
//                .orderSide("BUY")
//                .clientOrderId(clientOrderId)
//                .positionSide("LONG")
//                .build();
//        FuturePostOrderRequest request2 = FuturePostOrderRequest.builder().symbol("trb_usdt")
//                .origQty("16")
//                .orderType("LIMIT")
//                .timeInForce("GTC")
//                .price("7.50")
//                .orderSide("BUY")
//                .clientOrderId(clientOrderId2)
//                .positionSide("LONG")
//                .build();
        FuturePostOrderRequest request3 = FuturePostOrderRequest.builder().symbol("TRX_USDT")
                .origQty("8300")
                .orderType("LIMIT")
                .timeInForce("GTC")
                .price("0.12300788")
                .orderSide("BUY")
                .clientOrderId(clientOrderId3)
                .positionSide("LONG")
                .build();
        FuturePostOrderRequest request4 = FuturePostOrderRequest.builder().symbol("TRX_USDT")
                .origQty("60616")
                .orderType("LIMIT")
                .timeInForce("GTC")
                .price("0.12300788")
                .orderSide("SELL")
                .clientOrderId(clientOrderId4)
                .positionSide("SHORT")
                .build();


        List<FuturePostOrderRequest> requestList = new ArrayList<>();
//        requestList.add(request);
//        requestList.add(request2);
        requestList.add(request3);
//        requestList.add(request4);
        CommonResponse createResponse = client.batchOrder(requestList);
        System.out.println("createResponse:"+createResponse);

//        List<String> orderIdList = new ArrayList<>();
//        orderIdList.add(clientOrderId);
//        orderIdList.add(clientOrderId2);
//        orderIdList.add(clientOrderId2);
//        orderIdList.add(clientOrderId4);
//        CommonResponse cancelResponse = client.cancelOrderBatch(Collections.emptyList(), orderIdList);
//        System.out.println("cancelResponse:"+cancelResponse);
    }

}
