package hcmute.springbootdemo.Config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

public class CustomSiteMeshFilter extends ConfigurableSiteMeshFilter {
    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        builder.addDecoratorPath("/*","/decorators/user.jsp");
        builder.addDecoratorPath("/admin/*","/decorators/admin.jsp");
        builder.addDecoratorPath("/login/","/decorators/login.jsp");
        builder.addDecoratorPath("/register/","/WEB-INF/views/register/register.jsp");
        builder.addDecoratorPath("/profile_user/*","/WEB-INF/views/user/profile_user.jsp");
    }
}
