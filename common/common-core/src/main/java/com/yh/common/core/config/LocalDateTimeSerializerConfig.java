//package com.yh.common.core.config;
//
//import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
///**
// * 全局时间格式化
// *
// * @author yl_tao
// * @date 2022/4/29 19:59
// */
//@Configuration
//@Slf4j
//public class LocalDateTimeSerializerConfig {
//    @Value("${spring.jackson.date-format}")
//    private String pattern;
//
//    public LocalDateTimeSerializer localDateTimeSerializerConfig() {
//        log.info("时间格式化={}", pattern);
//        return new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(pattern));
//    }
//
//    @Bean
//    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
//        return builder -> builder.serializerByType(LocalDateTime.class, localDateTimeSerializerConfig());
//    }
//}
//
