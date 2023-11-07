package br.agsi.SendSMS.controller;

import br.agsi.SendSMS.core.entity.SendSMSRecord;
import br.agsi.SendSMS.services.SendSMSTwilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send/sms")
public class SendSMSController {


    private final SendSMSTwilioService service;

    @Autowired
    public SendSMSController(SendSMSTwilioService service){
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<String> sendSMS (@RequestBody SendSMSRecord send) {
        String resp;
        try {
            resp = service.sendSMS(send.to(), send.msg());
            return ResponseEntity.ok(resp);
        } catch (Exception e) {
            resp = "erro sending sms";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("error sending sms: " + e);
        }

    }

}
