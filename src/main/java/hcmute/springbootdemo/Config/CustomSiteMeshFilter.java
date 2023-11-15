package hcmute.springbootdemo.Config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

public class CustomSiteMeshFilter extends ConfigurableSiteMeshFilter {
    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        builder.addDecoratorPath("/login/","/decorators/login.jsp");
        builder.addDecoratorPath("/*","/decorators/web.jsp");
        builder.addDecoratorPath("/admin*","/decorators/admin.jsp");
    }
}
