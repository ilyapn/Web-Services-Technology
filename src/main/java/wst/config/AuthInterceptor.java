package wst.config;

import org.apache.cxf.configuration.security.AuthorizationPolicy;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;

import org.apache.cxf.message.Message;

public class AuthInterceptor extends AbstractPhaseInterceptor<Message> {
    public AuthInterceptor(String phase) {
        super(phase);
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        message.getContextualPropertyKeys();
        AuthorizationPolicy contextualProperty =
                (AuthorizationPolicy) message.getContextualProperty("org.apache.cxf.configuration.security.AuthorizationPolicy");
        if (!contextualProperty.getPassword().equals("1") || !contextualProperty.getUserName().equals("1"))  {
            throw new Fault(new Throwable("Authorization error"));
        }

    }
}
