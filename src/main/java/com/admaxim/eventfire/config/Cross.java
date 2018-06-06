package com.admaxim.eventfire.config;

import com.admaxim.eventfire.validation.InputType;
import com.admaxim.eventfire.validation.ValidatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class Cross implements Filter {

    private final static Logger log = LoggerFactory.getLogger(Cross.class);

    //********************************
    //           Filter Config      //
    //********************************
    private static Integer count = 0;
    private Long before;


    @Autowired
    ValidatorService validatorService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        try {

            // response
            log.info("=================Request-Start-"+(count++)+"-=====================");
            before = System.currentTimeMillis();
            ReadHttpServletRequest requestWrapper = new ReadHttpServletRequest((HttpServletRequest) servletRequest);

            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "POST, GET");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "X-requested-with, Content-Type");

            String body = requestWrapper.getNewRequest();
            String header = requestWrapper.getHeader();
            if (body != null && header != null) {
                /*
                * Note:- This below line's first update the request and conver the imp's to imp by getting
                * the single first index object. if the object is not their this will not process ad send the simple same
                * json string for validation if the string valid then dofilter map the json into @Pojo.
                * */
                log.info("New:- "+"header " + header + ", body " + body);
                if (validatorService.isResponseValidator(body, InputType.REQUEST.toString().equals("REQUEST") ? InputType.REQUEST : null)) {
                    filterChain.doFilter(requestWrapper, servletResponse);
                } else {
                    /*
                    * Note:- IF Validator fail this will show error
                    * if imp's size 0 then here
                    * if imp's object not their then here
                    * */
                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    String responseMessage = "{\"result\": \"Oops an error happened!\nSomething bad happened uh-oh!\"}";
                    response.getWriter().print(responseMessage);
                }
            }
        }catch (NullPointerException e) {
            log.error("--Error--> "+ e.getMessage());
            filterChain.doFilter(servletRequest, servletResponse);

        }finally {
            long result = System.currentTimeMillis() - before;
            log.info("Total response time -> (" + (result) + ") miliseconds");
            log.info("=================Request-End=====================");
        }
    }

    @Override
    public void destroy() { }

}
