package org.miles2run.jaxrs.config;

import org.jug.filters.*;
import org.jug.view.NotFoundExceptionMapper;
import org.jug.view.ViewExceptionMapper;
import org.jug.view.ViewResourceNotFoundExceptionMapper;
import org.jug.view.ViewWriter;
import org.miles2run.business.domain.jpa.CommunityRun;
import org.miles2run.jaxrs.api.v1.*;
import org.miles2run.jaxrs.filters.InjectProfileFilter;
import org.miles2run.jaxrs.views.*;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class RestConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(NotFoundExceptionMapper.class);
        classes.add(ViewWriter.class);
        classes.add(ViewExceptionMapper.class);
        classes.add(ViewResourceNotFoundExceptionMapper.class);
        classes.add(EnableSessionFilter.class);
        classes.add(AuthenticationFilter.class);
        classes.add(AfterLoginFilter.class);
        classes.add(IndexView.class);
        classes.add(TwitterSigninView.class);
        classes.add(TwitterCallbackView.class);
        classes.add(ProfileView.class);
        classes.add(HomeView.class);
        classes.add(FacebookSigninView.class);
        classes.add(FacebookCallbackView.class);
        classes.add(SigninView.class);
        classes.add(InjectProfileFilter.class);
        classes.add(LogoutView.class);
        classes.add(ActivityResource.class);
        classes.add(ProgressResource.class);
        classes.add(CounterResource.class);
        classes.add(NotificationResource.class);
        classes.add(FriendshipResource.class);
        classes.add(InjectPrincipalFilter.class);
        classes.add(ProfileResource.class);
        classes.add(ProfileSuggestionResource.class);
        classes.add(GoogleSigninView.class);
        classes.add(GoogleCallbackView.class);
        classes.add(ActivityView.class);
        classes.add(TimelineResource.class);
        classes.add(DashboardResource.class);
        classes.add(GoalView.class);
        classes.add(GoalTimelineResource.class);
        classes.add(GoalResource.class);
        classes.add(PingResource.class);
        classes.add(CommunityRunResource.class);
        return classes;
    }
}
