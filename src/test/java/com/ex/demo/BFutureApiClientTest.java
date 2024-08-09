package com.ex.demo;

import com.google.gson.Gson;
import com.ex.api.client.future.FutureCApiClientImpl;
import com.ex.api.client.future.FutureApiClient;
import com.ex.api.dto.CommonResponse;
import com.ex.api.dto.future.FuturePostOrderRequest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * BTC BASE Future
 * @create 2023/9/20 16:15
 */
public class BFutureApiClientTest {
    Gson gson = new Gson();
    FutureApiClient client = new FutureCApiClientImpl(null);

    @Test
    public void postOrder(){
        FuturePostOrderRequest request = FuturePostOrderRequest.builder().symbol("btc_usdt")
                .origQty("4")
                .orderType("LIMIT")
                .timeInForce("GTC")
                .price("26972.9")
                .orderSide("BUY")
                .positionSide("LONG")
                .build();
        CommonResponse commonResponse = client.postOrder(request);
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void batchOrder(){
        FuturePostOrderRequest request = FuturePostOrderRequest.builder().symbol("btc_usdt")
                .origQty("4")
                .orderType("LIMIT")
                .timeInForce("GTC")
                .price("26972.9")
                .orderSide("BUY")
                .positionSide("LONG")
                .build();
        FuturePostOrderRequest request2 = FuturePostOrderRequest.builder().symbol("btc_usdt")
                .origQty("4")
                .orderType("LIMIT")
                .timeInForce("GTC")
                .price("26972.9")
                .orderSide("BUY")
                .positionSide("LONG")
                .build();
        List<FuturePostOrderRequest> requestList = new ArrayList<>();
        requestList.add(request);
        requestList.add(request2);
        CommonResponse commonResponse = client.batchOrder(requestList);
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void orderListHistory() {
        Map<String, String> params = new HashMap<>();
        CommonResponse commonResponse = client.orderListHistory(params);
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void orderTradeList() {
        Map<String, String> params = new HashMap<>();
        CommonResponse commonResponse = client.orderTradeList(params);
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void orderDetail() {
        CommonResponse commonResponse = client.orderDetail(275110136488455424L);
        System.out.println("result:"+commonResponse);
    }
    @Test
    public void orderList() {
        Map<String, String> params = new HashMap<>();
        CommonResponse commonResponse = client.orderList(params);
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void orderCancel() {
        CommonResponse commonResponse = client.orderCancel(275110136488455424L);
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void allCancel() {
        CommonResponse commonResponse = client.allCancel(null);
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void entrustCreatePlan() {
        Map<String, String> params = new HashMap<>();
        params.put("symbol","btc_usdt");
        params.put("orderSide","BUY");
        params.put("entrustType","TAKE_PROFIT");
        params.put("origQty","1");
        params.put("timeInForce","GTC");
        params.put("triggerPriceType","INDEX_PRICE");
        params.put("positionSide","LONG");
        params.put("stopPrice","55");
        CommonResponse commonResponse = client.entrustCreatePlan(params);
        System.out.println("result:"+commonResponse);
    }
    @Test
    public void entrustCancelPlan() {
        CommonResponse commonResponse = client.entrustCancelPlan(275110136488455424L);
        System.out.println("result:"+commonResponse);
    }
    @Test
    public void entrustCancelAllPlan() {
        CommonResponse commonResponse = client.entrustCancelAllPlan("btc_usdt");
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void accountInfo() {
        CommonResponse commonResponse = client.accountInfo();
        System.out.println("result:"+commonResponse);
    }

    @Test
    public void balanceDetail() {
        CommonResponse commonResponse = client.balanceDetail("usdt");
        System.out.println("result:"+commonResponse);
    }


}
