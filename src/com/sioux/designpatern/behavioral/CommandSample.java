package com.sioux.designpatern.behavioral;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by myrap_000 on 9/25/2015.
 */
public class CommandSample {
    public static void main(String[] args) {
        Stock abcStock = new Stock();

        BuyStock buyStockOrder = new BuyStock(abcStock);
        SellStock sellStockOrder = new SellStock(abcStock);

        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.excuteOrder();
    }
}

interface IOrder {
    void execute();
}

class Stock {
    public void sell() {
        System.out.println("Stock sell");
    }

    public void buy() {
        System.out.println("Stock bought");
    }
}

class BuyStock implements IOrder {
    private Stock _stock;

    public BuyStock(Stock stock) {
        _stock = stock;
    }

    @Override
    public void execute() {
        _stock.buy();
    }
}

class SellStock implements IOrder {
    private Stock _stock;

    public SellStock(Stock _stock) {
        this._stock = _stock;
    }

    @Override
    public void execute() {
        _stock.sell();
    }
}

class Broker {
    private List<IOrder> _orders = new ArrayList<IOrder>();

    public void takeOrder(IOrder order) {
        _orders.add(order);
    }

    public void excuteOrder() {
        for (IOrder order : _orders) order.execute();
    }
}