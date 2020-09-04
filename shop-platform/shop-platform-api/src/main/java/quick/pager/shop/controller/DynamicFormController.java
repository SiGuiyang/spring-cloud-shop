//package quick.pager.shop.platform.controller;
//
//
//import java.util.Collections;
//import java.util.List;
//import java.util.Objects;
//import java.util.Optional;
//import java.util.stream.Collectors;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import quick.pager.shop.constants.ConstantsClient;
//import quick.pager.shop.constants.ResponseStatus;
//import quick.pager.shop.model.DynamicForm;
//import quick.pager.shop.platform.request.DynamicFormSaveRequest;
//import quick.pager.shop.platform.response.DynamicFormResponse;
//import quick.pager.shop.service.DynamicFormService;
//import quick.pager.shop.user.response.Response;
//import quick.pager.shop.utils.BeanCopier;
//
///**
// * <p>
// * 自定义表单
// * </p>
// *
// * @author siguiyang
// * @since 2019-12-14
// */
//@RestController
//@RequestMapping(ConstantsClient.PLATFORM)
//public class DynamicFormController {
//
//    @Autowired
//    private DynamicFormService dynamicFormService;
//
//    /**
//     * 新增
//     */
//    @PostMapping("/dynamic/form/create")
//    public Response<Long> create(@RequestBody DynamicFormSaveRequest request) {
//        return new Response<>(dynamicFormService.create(request));
//    }
//
//    /**
//     * 修改
//     */
//    @PostMapping("/dynamic/form/modify")
//    public Response<Long> modify(@RequestBody DynamicFormSaveRequest request) {
//
//        if (Objects.isNull(request.getId())) {
//            return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.PARAMS_EXCEPTION);
//        }
//        return new Response<>(dynamicFormService.modify(request));
//    }
//

//
//}
