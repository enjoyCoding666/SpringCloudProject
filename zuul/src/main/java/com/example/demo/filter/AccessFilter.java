package com.example.demo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.log4j.Logger;


import javax.servlet.http.HttpServletRequest;


public class AccessFilter extends ZuulFilter {
    private static Logger log=Logger.getLogger(AccessFilter.class);

    /**
     * 过滤的类型，可以返回"pre"、"route"、"post"、"error"
     * filterType() - 按类型对过滤器进行分类。 可以返回用于预路由过滤的“pre”，用于路由到原点的“route”，用于后路由过滤的“post”，用于错误处理的“error”。
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 返回数字，表示过滤器执行的顺序。filterOrders返回的结果不需要是连续的顺序，如1，2，3，4。
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否过滤
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑。
     * 以下方法表示设置过滤。url只有带有有效参数才可以访问。
     * @return
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));

        Object accessToken = request.getParameter("accessToken");
        if(accessToken == null) {
            log.warn("access token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }
        log.info("access token ok");
        return null;
    }
}
