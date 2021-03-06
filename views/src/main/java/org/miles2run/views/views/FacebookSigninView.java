package org.miles2run.views.views;

import facebook4j.Facebook;
import facebook4j.FacebookFactory;
import org.jug.view.View;
import org.jug.view.ViewException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.thymeleaf.TemplateEngine;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import static org.miles2run.core.utils.UrlUtils.absoluteUrlForResourceMethod;

@Path("/facebook/signin")
public class FacebookSigninView {

    private final Logger logger = LoggerFactory.getLogger(FacebookSigninView.class);

    @Inject
    private FacebookFactory facebookFactory;
    @Inject
    private TemplateEngine templateEngine;

    @GET
    @Produces("text/html")
    public View signin(@Context HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("principal") != null) {
            return View.of("/", true);
        }
        try {
            Facebook facebook = facebookFactory.getInstance();
            String redirectUrl = absoluteUrlForResourceMethod(request, FacebookCallbackView.class, "callback");
            logger.info(String.format("Facebook redirectUrl %s", redirectUrl));
            return View.of(facebook.getOAuthAuthorizationURL(redirectUrl), true).withAbsoluteUrl();
        } catch (Exception e) {
            throw new ViewException("Unable to get Facebook AuthorizationURL. Exception is: " + e.getMessage(), e, templateEngine);
        }
    }
}
