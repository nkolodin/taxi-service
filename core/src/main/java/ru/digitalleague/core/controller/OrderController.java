package ru.digitalleague.core.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ru.digitalleague.core.api.RatingService;
import ru.digitalleague.core.api.TaxiService;
import ru.digitalleague.core.model.FeedBackModel;
import ru.digitalleague.core.model.OrderDetails;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private TaxiService taxiService;

    @Autowired
    private RatingService ratingService;

    @PostMapping("/order-taxi")
    @ApiOperation(value = "Контроллер для заказа такси")
    public ResponseEntity<String> receive(@RequestBody OrderDetails orderDetails) {
        log.info("Received message from postman" + orderDetails);

        String result = taxiService.notifyTaxi(orderDetails);

        return ResponseEntity.ok(result);
    }

    @PostMapping("/feedback")
    @ApiOperation(value = "Контроллер для заказа такси")
    public ResponseEntity<String> feedBack(@RequestBody FeedBackModel feedBackModel) {
        ratingService.save(feedBackModel);

        return ResponseEntity.ok("Ваш рейтинг принят, спасибо");
    }
}
