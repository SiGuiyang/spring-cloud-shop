package quick.pager.shop.exception;

import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * 短息登陆异常
 *
 * @author siguiyang
 */
public class OAuth2SmsInvalidException extends OAuth2Exception {

    public OAuth2SmsInvalidException(String msg, Throwable t) {
        super(msg, t);
    }

    public OAuth2SmsInvalidException(String msg) {
        super(msg);
    }

    @Override
    public String getOAuth2ErrorCode() {
        return "invalid_sms_code";
    }

}
