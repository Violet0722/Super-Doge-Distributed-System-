package com.nike.service;

import com.nike.models.Order;
import com.nike.models.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class OrderService {

    @Autowired
    RestTemplate restTemplate;

    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    public void setDelivery(Order order) {

        Date safeDeliveryTime = getDeliveryTime("http://SAFE-DELIVERY-CLIENT/safe/delivery/time");
        Date fastDeliveryTime = getDeliveryTime("http://FAST-DELIVERY-CLIENT/fast/delivery/time");

        if(safeDeliveryTime.before(fastDeliveryTime)){
            order.setDeliveryCompany("Safe Delivery");
            order.setDeliveryTime(dateFormat.format(safeDeliveryTime));
        } else {
            order.setDeliveryCompany("Fast Delivery");
            order.setDeliveryTime(dateFormat.format(fastDeliveryTime));
        }

    }

    private Date getDeliveryTime(String url) {

        String time = restTemplate.getForObject(url, String.class);
        Date d = null;

        try {
            d = dateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return d;
    }

    public void updatePoints(OrderRequest request){

        int leftPoints = request.getPreviousPoints() - request.getCostPoints();
        String url = "http://DOGE-MEMBERSHIP-CLIENT/points/" + request.getMemberId() + "/" + leftPoints;
        restTemplate.postForObject(url, null,String.class);
    }

}
