## Envio de SMS com Twilio

SpringBoot <br>
Java 17 <br>
Graalvm 17

Dependência do Twilio
```xml
<dependency>
	<groupId>com.twilio.sdk</groupId>
	<artifactId>twilio</artifactId>
	<version>8.0.0</version>
</dependency>
```
Necessário Configurar as Variaveis de Ambiente com as credenciais do TWILIO
```xml
${TWILIO_SID}
${TWILIO_KEY}
${TWILIO_FROM}
```
Endpoint:
<br>http://localhost:8080/send/sms
<br>Post
```json
{
  "to": "phone to",
  "msg": "body"
}
```
