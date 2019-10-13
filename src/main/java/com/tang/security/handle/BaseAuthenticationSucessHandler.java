package com.tang.security.handle;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @auther: tangkc
 * @Date: 2019/10/13 23:46
 * @Description:
 */
@Component
public class BaseAuthenticationSucessHandler implements AuthenticationSuccessHandler {
	// private RequestCache requestCache = new HttpSessionRequestCache();

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	//
	// @Autowired
	// private ObjectMapper mapper;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
										Authentication authentication) throws IOException {
		// response.setContentType("application/json;charset=utf-8");
		// response.getWriter().write(mapper.writeValueAsString(authentication));
		// SavedRequest savedRequest = requestCache.getRequest(request, response);
		// System.out.println(savedRequest.getRedirectUrl());
		// redirectStrategy.sendRedirect(request, response, savedRequest.getRedirectUrl());
		redirectStrategy.sendRedirect(request, response, "/index");
	}
}