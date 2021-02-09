package com.codemao.maomaster.gateway.config;import lombok.extern.slf4j.Slf4j;import org.apache.commons.lang.StringUtils;import org.springframework.cloud.gateway.filter.GatewayFilterChain;import org.springframework.cloud.gateway.filter.GlobalFilter;import org.springframework.context.annotation.Configuration;import org.springframework.core.Ordered;import org.springframework.core.io.buffer.DataBuffer;import org.springframework.http.HttpHeaders;import org.springframework.http.HttpStatus;import org.springframework.http.server.reactive.ServerHttpRequest;import org.springframework.http.server.reactive.ServerHttpResponse;import org.springframework.web.server.ServerWebExchange;import reactor.core.publisher.Mono;/** * @author lishi */@Configuration@Slf4jpublic class CustomGlobalFilter implements GlobalFilter, Ordered {    @Override    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {        log.info("进入自定义的filter");        ServerHttpRequest request = exchange.getRequest();        HttpHeaders headers = request.getHeaders();        String token = headers.getFirst("token");        if (!StringUtils.isEmpty(token) && "token".equals(token)) {            log.info("用户身份信息合法,放行请求继续执行!!!");            return chain.filter(exchange);        } else {            ServerHttpResponse response = exchange.getResponse();            response.getHeaders().add("Content-Type", "application/json; charset=utf-8");            response.setStatusCode(HttpStatus.UNAUTHORIZED);            String message = "{\"message\": \"权限拒绝\",\"errorCode\": 401}";            DataBuffer wrap = response.bufferFactory().wrap(message.getBytes());            return response.writeWith(Mono.just(wrap));        }    }    @Override    public int getOrder() {  //filter 数字越小filter越先执行        return -1;    }}