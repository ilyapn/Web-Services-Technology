package wst.config;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.phase.Phase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wst.endpoint.EndpointService;

import javax.xml.ws.Endpoint;

@Configuration
public class SoapConfig {
    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public Endpoint endpoint(SpringBus springBus, EndpointService endpointService) {
        EndpointImpl endpoint = new EndpointImpl(springBus, endpointService);
        endpoint.getInInterceptors().add(new AuthInterceptor(Phase.READ));
        endpoint.publish("/db");
        return endpoint;
    }


}
