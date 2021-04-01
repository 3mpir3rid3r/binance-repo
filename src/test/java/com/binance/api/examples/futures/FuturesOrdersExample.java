package com.binance.api.examples.futures;

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
public class FuturesOrdersExample {
    private static final String SYMBOL = "LINKUSDT";

    public static void main(String[] args) {
        BinanceFuturesApiClientFactory futuresApiClientFactory = BinanceAbstractFactory.createFuturesFactory("YOUR_API_KEY", "YOUR_SECRET");
        BinanceApiFuturesRestClient client = futuresApiClientFactory.newRestClient();

        FuturesNewOrderResponse futuresOrderResponse = client.newOrder(limitLong(SYMBOL, TimeInForce.GTC, WorkingType.CONTRACT_PRICE, "13", "27", false));
        long orderId = futuresOrderResponse.getOrderId();
        System.out.println("OrderID: " + orderId);

        CancelOrderResponse cancelOrderResponse = client.cancelOrder(new CancelOrderRequest(SYMBOL, orderId));
        System.out.println("Order Status: " + cancelOrderResponse.getStatus());
    }

}