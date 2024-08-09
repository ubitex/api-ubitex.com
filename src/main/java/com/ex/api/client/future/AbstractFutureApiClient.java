package com.ex.api.client.future;

import com.google.gson.Gson;
import com.ex.api.dto.CommonResponse;
import com.ex.api.dto.future.FutureOrderCancelAllRequest;
import com.ex.api.dto.future.FutureOrderCancelRequest;
import com.ex.api.dto.future.FuturePostOrderRequest;
import retrofit2.Call;
import retrofit2.Response;

import java.util.List;
import java.util.Map;

/**
 * @create 2023/9/20 18:23
 */
public abstract class AbstractFutureApiClient implements FutureApiClient {
    private final Gson gson = new Gson();
    @Override
    public CommonResponse postOrder(FuturePostOrderRequest request) {
        return executeSync(getService().postOrder(request));
    }
    @Override
    public CommonResponse batchOrder(List<FuturePostOrderRequest> futurePostOrderRequestList){
        return executeSync(getService().batchOrder(gson.toJson(futurePostOrderRequestList)));
    }

    @Override
    public CommonResponse orderListHistory(Map<String, String> params) {
        return executeSync(getService().orderListHistory(params));
    }

    @Override
    public CommonResponse orderTradeList(Map<String, String> params) {
        return executeSync(getService().orderTradeList(params));
    }

    @Override
    public CommonResponse orderDetail(Long orderId) {
        return executeSync(getService().orderDetail(orderId));
    }
    @Override
    public CommonResponse orderList(Map<String, String> params){
        return executeSync(getService().orderList(params));
    }
    @Override
    public CommonResponse orderCancel(Long orderId){
        return executeSync(getService().orderCancel(FutureOrderCancelRequest.builder().orderId(orderId).build()));
    }

    @Override
    public CommonResponse cancelOrderBatch(List<Long> orderIdList, List<String> clientOrderIds){
        return executeSync(getService().cancelOrderBatch(gson.toJson(orderIdList), gson.toJson(clientOrderIds)));
    }

    @Override
    public CommonResponse allCancel(String symbol){
        symbol = symbol==null?"":symbol;
        return executeSync(getService().allCancel(FutureOrderCancelAllRequest.builder().symbol(symbol).build()));
    }

    @Override
    public CommonResponse entrustCreatePlan(Map<String, String> params){
        return executeSync(getService().entrustCreatePlan(params));
    }

    @Override
    public CommonResponse entrustCancelPlan(Long entrustId){
        return executeSync(getService().entrustCancelPlan(entrustId));
    }

    @Override
    public CommonResponse entrustCancelAllPlan(String symbol){
        return executeSync(getService().entrustCancelAllPlan(symbol));
    }

    @Override
    public CommonResponse accountInfo(){
        return executeSync(getService().accountInfo());
    }

    @Override
    public CommonResponse balanceDetail(String coin){
        return executeSync(getService().balanceDetail(coin));
    }

    @Override
    public CommonResponse createMockOrder(FuturePostOrderRequest request) {
        return executeSync(getService().createMockOrder(request));
    }

    @Override
    public CommonResponse mergePosition(Map<String, String> params) {
        return executeSync(getService().mergePosition(params));
    }

    public CommonResponse executeSync(Call<CommonResponse> call) {
        try {
            Response<CommonResponse> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            }else {
                System.err.println(String.format("failed to call interface:%s,%s",response.code(),response.toString()));
                return CommonResponse.failure(response.toString());
            }
        }catch (Exception e){
            System.err.println("call interface exception:"+e);
            throw new RuntimeException(e);
        }
    }

    abstract FutureApiService getService();

}
