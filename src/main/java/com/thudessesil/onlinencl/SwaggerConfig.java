package com.thudessesil.onlinencl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean

    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("apiGroup1")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.thudessesil.onlinencl"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Online-NCL API Documentation")
                .description("ModelFile Management, Script Management and NCL Wrapper API")
                .contact(new Contact("THU DESS Informatics Lab", "https://github.com/THU-EarthInformationScienceLab", "liuyufu18@mails.tsinghua.edu.cn"))
//                .termsOfServiceUrl("http://www.eknown.com")
                .version("1.0")
                .build();
    }
}
