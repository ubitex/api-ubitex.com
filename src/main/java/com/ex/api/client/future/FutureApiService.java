package com.ex.api.client.future;

import com.ex.api.dto.CommonResponse;
import com.ex.api.dto.future.FutureOrderCancelAllRequest;
import com.ex.api.dto.future.FutureOrderCancelRequest;
import com.ex.api.dto.future.FuturePostOrderRequest;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

/**
 * @create 2023/9/20 14:28
 */
public interface FutureApiService {

    @POST("/v1/future-u/trade/order/create")
    Call<CommonResponse> makeOrder(@QueryMap Map<String, String> params);

    @POST("/v1/future-u/trade/order/create")
    Call<CommonResponse> postOrder(@Body FuturePostOrderRequest futurePostOrderRequest);

    @POST("/v1/future-u/trade/order/create-batch")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Call<CommonResponse> batchOrder(@Query("list") String list);

    @GET("/v1/future-u/trade/order/list-history")
    Call<CommonResponse> orderListHistory(@QueryMap Map<String, String> params);

    @GET("/v1/future-u/trade/order/trade-list")
    Call<CommonResponse> orderTradeList(@QueryMap Map<String, String> params);

    @GET("/v1/future-u/trade/order/detail")
    Call<CommonResponse> orderDetail(@Query("orderId") Long orderId);

    @GET("/v1/future-u/trade/order/list")
    Call<CommonResponse> orderList(@QueryMap Map<String, String> params);

    @POST("/v1/future-u/trade/order/cancel")
    Call<CommonResponse> orderCancel(@Body FutureOrderCancelRequest request);

    @POST("/v1/future-u/trade/order/cancel-batch")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Call<CommonResponse> cancelOrderBatch(@Query("orderIds") String orderIds, @Query("clientOrderIds") String clientOrderIds);

    @POST("/v1/future-u/trade/order/cancel-all")
    Call<CommonResponse> allCancel(@Body FutureOrderCancelAllRequest request);

    @POST("/v1/future-u/trade/entrust/create-plan")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Call<CommonResponse> entrustCreatePlan(@QueryMap Map<String, String> params);

    @POST("/v1/future-u/trade/entrust/cancel-plan")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Call<CommonResponse> entrustCancelPlan(@Query("entrustId") Long entrustId);

    @POST("/v1/future-u/trade/entrust/cancel-all-plan")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Call<CommonResponse> entrustCancelAllPlan(@Query("symbol") String symbol);

    @GET("/v1/future-u/user/account/info")
    Call<CommonResponse> accountInfo();

    @GET("/v1/future-u/user/balance/detail")
    Call<CommonResponse> balanceDetail(@Query("coin") String coin);


    @POST("/v1/future-u/trade/mock/trade")
    Call<CommonResponse> createMockOrder(@Body FuturePostOrderRequest futurePostOrderRequest);

    @POST("/v1/future-u/trade/position/merge")
    Call<CommonResponse> mergePosition(@QueryMap Map<String, String> params);
    @GET("/v1/future-u/trade/position/list")
    Call<CommonResponse> getPosition(@QueryMap Map<String, String> params);
}
