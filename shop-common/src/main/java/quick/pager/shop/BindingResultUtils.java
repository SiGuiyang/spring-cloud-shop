package quick.pager.shop;

import java.util.List;
import java.util.Optional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import quick.pager.shop.constants.ResponseStatus;
import quick.pager.shop.exception.ShopValidException;

/**
 * BindingResult 验证工具类
 *
 * @author siguiyang
 */
public class BindingResultUtils {

    /**
     * 获取字段验证失败返回的自定返回内容
     *
     * @param bindingResult bindingResult
     * @return null 说明验证成功，非null 验证失败，存在字段验证失败的场景
     */
    public static String getFieldErrorMessage(BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Optional<List<FieldError>> optional = Optional.ofNullable(bindingResult.getFieldErrors());
            if (optional.isPresent()) {
                Optional<FieldError> first = optional.get().stream().findFirst();
                if (first.isPresent()) {
                    FieldError fieldError = first.get();
                    throw new ShopValidException(ResponseStatus.Code.FAIL_CODE, fieldError.getDefaultMessage());
                }
            }
        }
        return null;
    }
}
