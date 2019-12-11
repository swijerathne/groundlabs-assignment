package junit.spring.main;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import pages.HomePage;
import pages.LoginPage;
import testbase.TestBase;

@Configuration
@PropertySources({
        @PropertySource("configurations/config.properties"),
})
public class AppConfig {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public TestBase getTestBaseObject() {
        return new TestBase();
    }



    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public LoginPage getLoginPageObject() {
        return new LoginPage(getTestBaseObject());
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public HomePage getHomePageObject() {
        return new HomePage(getTestBaseObject());
    }
}
