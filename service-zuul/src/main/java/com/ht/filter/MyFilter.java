package com.ht.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.http.HttpResponse;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Administrator on 2019/8/1.
 */
//@Component
public class MyFilter extends ZuulFilter{

    /**
     filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
     pre：路由之前
     routing：路由之时
     post： 路由之后
     error：发送错误调用
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     *filterOrder: 过滤的顺序 ，数值越小，优先级越高
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * shouldFilter：这里可以写逻辑判断，是否要过滤，false为不过滤，true为过滤。
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return false;
    }

    /**
     * run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        //得到当前请求上下文
        RequestContext ctx = RequestContext.getCurrentContext();
        //通过上下文得到http请求
        HttpServletRequest request = ctx.getRequest();
        //设置是否向客户端发送Response响应，true表示发送，false表示不发送
        ctx.setSendZuulResponse(true);
        //通过上下文得到HttpServletResponse对象
        HttpServletResponse response=ctx.getResponse();
        //设置响应类型和编码格式
        response.setContentType("application/json;charset=UTF-8");
        //打印请求方式post还是get。获取请求url
        System.out.println(request.getMethod()+","+request.getRequestURL().toString());
        //获取请求参数
        Object accessToken = request.getParameter("name");
        if(accessToken == null) {
            System.err.println("Token is empty");
            ctx.setSendZuulResponse(false);
            //设置响应状态码
            ctx.setResponseStatusCode(401);
            try {
                //重定向到错误页面
                response.sendRedirect("/error.html");
                URL url=new URL("http://localhost:8769/error.html");
                ctx.setRouteHost(url);
                System.out.println("pre:"+ctx.getRouteHost());
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                //在网页输出的内容，中文乱码需要先设置响应编码，见上
                //ctx.getResponse().getWriter().write("哎呀！token is empty");
            }catch (Exception e){}
        }
        return ctx;
    }
}
