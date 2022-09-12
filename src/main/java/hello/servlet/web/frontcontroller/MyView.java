package hello.servlet.web.frontcontroller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class MyView {
    private String viewPath;

    public MyView(String viewPath) {
        this.viewPath = viewPath;
    }

    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);//컨트롤러 -> 뷰
        dispatcher.forward(request, response);// 다른 서블릿이나 JSP 이동할수 있는 기능
    }

    public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        modelToRequestAttribute(model, request); //Map 루프 -> model에 request 값을 담아둠
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);//컨트롤러 -> 뷰
        dispatcher.forward(request, response);// 다른 서블릿이나 JSP 이동할수 있는 기능
    }

    private static void modelToRequestAttribute(Map<String, Object> model, HttpServletRequest request) {
        model.forEach((key, value) -> request.setAttribute(key, value)); //모델에 있는 데이터를 forEach 통해서 꺼낸다.
    }
}
