package com.admaxim.eventfire.config;

import com.fasterxml.jackson.annotation.JsonAlias;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import netscape.javascript.JSException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadHttpServletRequest extends HttpServletRequestWrapper {

    private final static Logger log = LoggerFactory.getLogger(Cross.class);

    private String body = "";
    private String newBody = "";
    private String header = "";
    private final String IMP = "imp";

    public ReadHttpServletRequest(HttpServletRequest request) throws IOException {
        super(request);
        BufferedReader bufferedReader = request.getReader();
        String line;
        StringBuffer stringBuffer = new StringBuffer();
        while ((line = bufferedReader.readLine()) != null) {
            stringBuffer.append(line);
        }
        setBody(stringBuffer.toString());
        // fetch header
        this.setHeader(request.getHeader("x-openrtb-version"));
        log.info("Old:- "+"header " + getHeader() + ", body " + getBody());
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        final ByteArrayInputStream byteArrayInputStream =
                new ByteArrayInputStream(getNewRequest().getBytes());
        return new ServletInputStream() {
            @Override
            public int read() throws IOException {
                return byteArrayInputStream.read();
            }
            @Override
            public boolean isFinished() { return false; }
            @Override
            public boolean isReady() { return false; }
            @Override
            public void setReadListener(ReadListener listener) {}

        };
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(this.getInputStream()));
    }

    public void setBody(String body) {
        log.info("Body-set");
        this.body = body;
        // set the new body also
        setNewRequest(getUpdateRequestBody(getBody()));
    }
    public void setHeader(String header) {
        log.info("Header-set");
        this.header = header;
    }

    public String getBody() {
        log.info("Body-get");
        return this.body;
    }
    public String getHeader() {
        log.info("Header-get");
        return this.header;
    }

    private String getUpdateRequestBody(String body) {

        JSONObject jsonRequest = (JSONObject) JSONSerializer.toJSON(body);
        /**
         * Find the imp's list and convert into the json-object then add into the request as update's
         * */
        if(jsonRequest.get(IMP) != null) {
            JSONArray jsonArray = jsonRequest.getJSONArray(IMP);
            if(jsonArray != null && (jsonArray.isArray() && jsonArray.size() > 0)) {
                JSONObject impObject = jsonRequest.getJSONArray(IMP).getJSONObject(0);
                // remove the list of imp
                jsonRequest.remove(IMP);
                // add the new one into the json reqeust
                jsonRequest.put(IMP, impObject);
            }
        }
        return jsonRequest.toString();
    }

    private void setNewRequest(String body) {
        log.info("newBody set");
        this.newBody = body;
    }

    public String getNewRequest() {
        log.info("newBody get");
        return this.newBody;
    }
}
