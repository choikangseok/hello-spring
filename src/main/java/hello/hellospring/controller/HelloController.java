package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello");
        return "hello";

    }
    @GetMapping("hell-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template.html";

    }
    @GetMapping("hello-string")
    @ResponseBody
    public  String helloString(@RequestParam("name") String name){
        return "hello" + name; // "hello spring"
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloAp(@RequestParam("name") String name, @RequestParam("age") String age){
        Hello hello = new Hello();
        hello.setName(name);
        hello.setAge(age);
        return hello;
    }
    static class Hello {
        private String name;
        private String age;

        public String getName(){
            return name;
        }
        public String getAge(){
            return age;
        }
        public void setName(String name){
            this.name = name;
        }
        public void setAge(String age){
            this.age = age;
        }

    }



}
