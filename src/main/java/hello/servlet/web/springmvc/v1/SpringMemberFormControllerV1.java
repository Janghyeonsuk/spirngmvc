package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // 스프링이 자동으로 스프링 빈으로 등록, 스프링 MVC에서 애노테이션 기반 컨트롤러로 인식
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/members/new-form") // ※ 핸들러를 꺼내서 어댑터에서 꺼내서 실행해줌
    public ModelAndView process() {
        return new ModelAndView("new-form");
    }
}
