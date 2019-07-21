package cn.hsiangsun.filter;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class MyGlobalFilter implements GlobalFilter, Ordered { //实现全局过滤器 同时实现 顺序接口 全局过滤器不需要配置文件
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        List<String> token = request.getQueryParams().get("token");
        if (token == null || token.size() == 0 ){
            System.out.println("==========Global Filter Has Worked============");
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);//设置响应为未授权状态
            return exchange.getResponse().setComplete();//设置当前请求已完成
        }
        //正常情况继续执行
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        //值越小越先执行
        return 1;
    }
}
