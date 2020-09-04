package quick.pager.shop.service;

import quick.pager.shop.param.SendParam;
import quick.pager.shop.user.response.Response;

/**
 * 短信发送服务
 *
 * @author siguiyang
 */
public interface SMSCodeService {

    Response send(SendParam param);


//
//    @Autowired
//    private RedisService redisService;
//    @Autowired
//    private KafkaService kafkaService;
//
//
//    @Override
//    public Response doService(BaseDTO dto) {
//
//        SmsDTO smsDTO = (SmsDTO) dto;
//
//        String phone = smsDTO.getPhone();
//        String source = smsDTO.getSource();
//        String graphicCode = smsDTO.getGraphicCode();
//
//        String key = RedisKeys.UserKeys.SHOP_SMS_VERIFY_CODE + phone;
//
//        Response<List<String>> verifySendSMSResp = verifySendSMSParameters(key, phone, source, graphicCode);
//
//        if (ResponseStatus.Code.SUCCESS != verifySendSMSResp.getCode()) {
//            return verifySendSMSResp;
//        }
//
//        String content = redisService.get(RedisKeys.UserKeys.SHOP_SMS_TEMPLATE + source);
//
//        SmsDTO smsdto = new SmsDTO();
//        smsdto.setPhone(phone);
//        smsdto.setContent(MessageFormat.format(content, verifySendSMSResp.getData()));
//        kafkaService.sender(MqMessage.builder().queueName(RabbitMqKeys.SEND_SMS).payLoad(smsdto).build());
//
//        return verifySendSMSResp;
//    }
//
//
//    /**
//     * 发送短信前验证
//     *
//     * @param key         redis key
//     * @param phone       手机号码
//     * @param source      发送短信数据源
//     * @param graphicCode 图形验证码
//     */
//    private Response<List<String>> verifySendSMSParameters(String key, String phone, String source, String graphicCode) {
//
//        if (null != redisService.get(key)) {
//            return new Response<>(ResponseStatus.Code.FAIL_CODE, ResponseStatus.REPEAT_SUBMIT);
//        }
//
//        String graphicCodeKey = RedisKeys.UserKeys.SHOP_GRAPHICS_CODE + phone;
//
//        Response<List<String>> response = new Response<>();
//
//        List<String> verifyCodeCache = redisService.getListOps(RedisKeys.UserKeys.SHOP_SMS_TEMPLATE_CODE);
//
//        // 是否验证图形验证码
//        if (verifyCodeCache.contains(source)) {
//            String redisGraphicCode = redisService.get(graphicCodeKey);
//
//            if (StringUtils.isEmpty(graphicCode)) {
//                response.setCode(ResponseStatus.Code.FAIL_CODE);
//                response.setMsg(ResponseStatus.USER_GRAPHIC_CODE_EMPTY);
//            } else if (StringUtils.isEmpty(redisGraphicCode)) {
//                response.setCode(ResponseStatus.Code.FAIL_CODE);
//                response.setMsg(ResponseStatus.USER_GRAPHIC_CODE_EXPIRE);
//            } else if (!graphicCode.equals(redisGraphicCode)) {
//                response.setCode(ResponseStatus.Code.FAIL_CODE);
//                response.setMsg(ResponseStatus.USER_GRAPHIC_CODE_ERROR);
//            }
//        }
//
//        return response;
//    }
}
