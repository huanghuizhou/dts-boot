package com.hhz.demo.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.hhz.demo.util.FastJsonHttpMessageSwaggerFacadeConverter;
import com.hhz.demo.util.GsonUtil;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.BytesPushThroughSerializer;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebMvc
public class MvcConf implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        HttpMessageConverters httpMessageConverters = makeDefaultConvertersWithHighPriorityFastJsonConverter();
        converters.addAll(httpMessageConverters.getConverters());
    }

    @Bean
    public ZkClient zkClient() {
        return new ZkClient("127.0.0.1:2181", 30000, 0x7fffffff, new BytesPushThroughSerializer());
    }


    @Bean
    public HttpMessageConverters makeDefaultConvertersWithHighPriorityFastJsonConverter() {
        ArrayList<HttpMessageConverter<?>> converters = new ArrayList<>();
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageSwaggerFacadeConverter();
        ArrayList<MediaType> supportedMediaTypes = new ArrayList<>();
        supportedMediaTypes.add(MediaType.valueOf("application/json;charset=UTF-8"));
        supportedMediaTypes.add(MediaType.valueOf("text/html;charset=UTF-8"));
        fastJsonHttpMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteDateUseDateFormat,
                SerializerFeature.QuoteFieldNames);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        converters.add(fastJsonHttpMessageConverter);
        GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter();
        gsonHttpMessageConverter.setGson(GsonUtil.getDefaultGson());
        gsonHttpMessageConverter.setDefaultCharset(Charset.forName("UTF-8"));
        gsonHttpMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
        converters.add(gsonHttpMessageConverter);

        return new HttpMessageConverters(true, converters);
    }

    /**
     * 启用DefaultServletHandling
     *
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/public/**").addResourceLocations("classpath:/public/");
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/META-INF/resources/").addResourceLocations("classpath:/resources/").addResourceLocations("classpath:/static/").addResourceLocations("classpath:/public/");
    }
}
