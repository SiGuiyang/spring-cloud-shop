package quick.pager.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quick.pager.shop.constants.ConstantsClient;
import quick.pager.shop.service.AddressService;
import quick.pager.shop.user.client.AddressClient;
import quick.pager.shop.user.response.AddressResponse;
import quick.pager.shop.user.response.Response;

@RestController
@RequestMapping(ConstantsClient.USER)
public class AddressController implements AddressClient {

    @Autowired
    private AddressService addressService;

    @Override
    @PostMapping("/address/default/{userId}")
    public Response<AddressResponse> address(@PathVariable("userId") Long userId) {
        return addressService.address(userId);
    }

    @Override
    @PostMapping("/address/{addressId}/info")
    public Response<AddressResponse> info(@PathVariable("addressId") Long addressId) {
        return Response.toResponse(addressService.queryByPrimaryKey(addressId));
    }
}
