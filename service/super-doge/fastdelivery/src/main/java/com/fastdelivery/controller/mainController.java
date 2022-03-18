package com.fastdelivery.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RestController
public class mainController {

    @CrossOrigin(origins = "*")
    @GetMapping("/fast/delivery/time")
    @ResponseBody
    public String calculateDeliveryTime() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, 3);

        return dateFormat.format(c.getTime());
    }
}
