package cn.hsiangsun.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class MyParamGatewayFilterFactory extends AbstractGatewayFilterFactory<MyParamGatewayFilterFactory.Config> {

    private static final String PARAM_NAME = "param";

    public MyParamGatewayFilterFactory() {
        super(Config.class);
    }

    public List<String> shortcutFieldOrder() {
        return Arrays.asList(PARAM_NAME);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            //获取param对应的参数名&值
            ServerHttpRequest request = exchange.getRequest();//当前这条请求
            if ( request.getQueryParams().containsKey(config.param) ){//当前这条请求包含配置类中的参数名
                request.getQueryParams().get(config.param).forEach(value->{
                    System.out.printf("=========局部过滤器======= key-->%s  value-->%s",config.param,value);
                });//得到当前参数的value(List)

            }
            return chain.filter(exchange);
        });
    }


    /**
     * 配置文件类
     * */
    public static class Config{
        private String param;

        public String getParam() {
            return param;
        }
        public void setParam(String param) {
            this.param = param;
        }
    }






}
