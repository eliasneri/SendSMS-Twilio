package br.agsi.SendSMS.services;

import br.agsi.SendSMS.core.SendSMSInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SendSMSTwilioService implements SendSMSInterface {

    @Value("${twilio.sid}")
    private String twilioSid;

    @Value("${twilio.key}")
    private String twilioKey;

    @Value("${twilio.phone.from}")
    private String twilioPhoneFrom;

    @Override
    public String sendSMS(String to, String msg) {
        Twilio.init(twilioSid, twilioKey);

        PhoneNumber phoneTo = new PhoneNumber(to);
        PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber(to),
                        new com.twilio.type.PhoneNumber(twilioPhoneFrom),
                        msg).create();

        return "sms sended: " + to + " - message: " + msg;
    }
}
