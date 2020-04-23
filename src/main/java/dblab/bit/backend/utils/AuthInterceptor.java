package dblab.bit.backend.utils;

import dblab.bit.backend.interceptor.Auth;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @program: backend
 * @description: util class for auth by implement http handler interceptor
 * @author: lihuichao
 * @create: 2020-04-23
 **/
public class AuthInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        // 从 http 请求头中取出 token
        // 为了避免token为空，因此在处理时，若用户为登陆，前端也需要附加一个token为空的标示
        String token = httpServletRequest.getHeader("token");
        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();

        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(Auth.class)) {
            Auth userLoginToken = method.getAnnotation(Auth.class);
            if (userLoginToken.required()) {
                // 执行认证
                if (token == null) {
                    throw new RuntimeException("无token，请重新登录");
                }
                // 获取 token 中的 user id
                String id;
                /*
                try {
                    id = JWT.decode(token).getAudience().get(0);
                } catch (JWTDecodeException j) {
                    throw new RuntimeException("401");
                }
                User user = userService.getById(Long.parseLong(id));
                if (user == null) {
                    throw new RuntimeException("用户不存在，请重新登录");
                }
                // 验证 token
                else {
                    JWTVerifier jwtVerifierUser = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
                    try {
                        // 验证是否以用户的身份登陆
                        jwtVerifierUser.verify(token);
                    } catch (JWTVerificationException e) {
                        logger.warn("Unmatched user id and password!");
                        return false;
                    }
                    return true;
                }

                 */
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }

}
