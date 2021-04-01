package com.binance.api.examples.testnet;

import com.binance.api.client.BinanceApiFuturesRestClient;
import com.binance.api.client.domain.TimeInForce;
import com.binance.api.client.domain.WorkingType;
import com.binance.api.client.domain.account.FuturesNewOrderResponse;
import com.binance.api.client.domain.account.request.CancelOrderRequest;
import com.binance.api.client.domain.account.request.CancelOrderResponse;
import com.binance.api.client.factory.BinanceAbstractFactory;
import com.binance.api.client.factory.BinanceFuturesApiClientFactory;

import static com.binance.api.client.domain.account.FuturesNewOrder.limitLong;

/**
 * Examples on how to place orders, cancel them.
 *
 * @author Mahdi Sheikh Hosseini
 */
public class TestnetOrdersExample {
    private static final String SYMBOL = "LTCUSDT";
    private static final String API_KEY = "";
    private static final String SECRET_KEY = "";

    public static void main(String[] args) {
        BinanceFuturesApiClientFactory futuresApiClientFactory = BinanceAbstractFactory.createTestnetFactory(API_KEY, SECRET_KEY);
        BinanceApiFuturesRestClient client = futuresApiClientFactory.newRestClient();

        FuturesNewOrderResponse futuresOrderResponse = client.newOrder(limitLong(SYMBOL, TimeInForce.GTC, WorkingType.CONTRACT_PRICE, "13", "200", false));
        long orderId = futuresOrderResponse.getOrderId();
        System.out.println("OrderID: " + orderId);

        CancelOrderResponse cancelOrderResponse = client.cancelOrder(new CancelOrderRequest(SYMBOL, orderId));
        System.out.println("Order Status: " + cancelOrderResponse.getStatus());
    }

}