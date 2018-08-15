package tw.com.pai.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tw.com.pai.controller.form.Greeting;
import tw.com.pai.controller.form.HelloMessage;

@Controller
public class GreetingController {

	
	@Autowired
    private Optional<SimpMessageSendingOperations> simpMessageSendingOperations;
	
//    @MessageMapping("/hello")//"/hello"为WebSocketConfig类中registerStompEndpoints()方法配置的
//    @SendTo("/topic/greetings")
//    public void greeting(@Header("atytopic") String topic, @Headers Map<String, Object> headers) throws Exception {
//    	System.out.println("connected successfully....");
//        System.out.println(topic);
//        System.out.println(headers);
//    }
	
    @MessageMapping("/add" )
    @SendTo("/topic/showResult")
    public Greeting addNum(HelloMessage input) throws Exception {
        Thread.sleep(2000);
        Greeting result = new Greeting(input.getNum1()+"+"+input.getNum2()+"="+(input.getNum1()+input.getNum2()));
        return result;
    }
    
    /**
     * 这里用的是@SendToUser，这就是发送给单一客户端的标志。本例中，
     * 客户端接收一对一消息的主题应该是“/user/” + 用户Id + “/message” ,这里的用户id可以是一个普通的字符串，只要每个用户端都使用自己的id并且服务端知道每个用户的id就行。
     * @return
     */
//    @MessageMapping("/message")
//    @SendToUser("/message")
//    public Greeting handleSubscribe() {
//        System.out.println("this is the @SubscribeMapping('/marco')");
//        return new Greeting("I am a msg from SubscribeMapping('/macro').");
//    }
 
    /**
     * 测试对指定用户发送消息方法
     * @return
     */
//    @RequestMapping(path = "/send", method = RequestMethod.GET)
//    public Greeting send() {
//        simpMessageSendingOperations.convertAndSendToUser("1", "/message", new Greeting("I am a msg from SubscribeMapping('/macro')."));
//        return new Greeting("I am a msg from SubscribeMapping('/macro').");
//    }

    @RequestMapping("/start")
    public String start() {
        return "start";
    }
}
