package hello.hellospring.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")//http://localhost:8080/hello
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";//tmplates/hello.html //viewResolver가 해당 역할을 해줌
    }

    //MVC
    @GetMapping("hello-mvc")//http://localhost:8080/hello-mvc
    public String helloMVC(@RequestParam(value = "name", required = true) String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";//templates/hello-template
    }

    //API방식
    @GetMapping("hello-string")//http://localhost:8080/hello-string
    @ResponseBody//html body 부분에 해당 문자를 넣어주겠다.
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;//html body
        // viewResolver 대신 HttpMessageConverter가 동작
        // StringConverter가 동작(기본 문자 처리)
    }

    //API 방식 중 JSON방식
    @GetMapping("hello-api")//http://localhost:8080/hello-api
    @ResponseBody
    public Hello helloAPI(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;//{"name":"spring"}
        // viewResolver 대신 HttpMessageConverter가 동작
        // JsonConverter가 동작(기본 객체 처리)
    }

    @Getter
    @Setter
    @NoArgsConstructor
    static class Hello{
        private String name;
    }
}
