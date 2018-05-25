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

    @Autowired
    ValidatorService validatorService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        try {

            // response
            log.info("=================Request-Start=====================");
            long before=System.currentTimeMillis();

            ReadHttpServletRequest requestWrapper = new ReadHttpServletRequest((HttpServletRequest) servletRequest);

            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "POST, GET");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "X-requested-with, Content-Type");

            // handle the rtb-request
            if (requestWrapper.getBody() != null && requestWrapper.getHeader() != null) {
                if (validatorService.isResponseValidator(requestWrapper.getBody(), requestWrapper.getHeader().equals("REQUEST")
                                ? InputType.REQUEST : InputType.REQUEST)) {
                    filterChain.doFilter(requestWrapper, servletResponse);
                } else {
                    // error-have
                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    response.getWriter().print("<html><head><title>Oops an error happened!</title></head>");
                    response.getWriter().print("<body>Something bad happened uh-oh!</body>");
                    response.getWriter().print(validatorService.showValidationResult());
                    response.getWriter().println("</html>");
                }
                // handle the other request
            }
            long after = System.currentTimeMillis();
            log.info("Total response time -> (" + (after - before) + ") miliseconds");
            log.info("=================Request-End=====================");

        }catch (NullPointerException e) {
            log.error("--Error--> "+ e.getMessage());
        }
    }

    @Override
    public void destroy() { }

}
