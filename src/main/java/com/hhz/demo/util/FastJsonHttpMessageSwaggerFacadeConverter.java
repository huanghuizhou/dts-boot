package com.hhz.demo.util;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import springfox.documentation.spring.web.json.Json;

import java.io.IOException;
import java.io.OutputStream;


/**
 * @author admin
 */
public class FastJsonHttpMessageSwaggerFacadeConverter extends FastJsonHttpMessageConverter {

    @Override
    protected void writeInternal(Object obj, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        if (obj instanceof Json) {
            OutputStream out = outputMessage.getBody();
            out.write(((Json) obj).value().getBytes());
        } else {
            super.writeInternal(obj, outputMessage);
        }
    }
}
