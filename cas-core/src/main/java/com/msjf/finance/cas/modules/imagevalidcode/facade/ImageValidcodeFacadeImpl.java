package com.msjf.finance.cas.modules.imagevalidcode.facade;

import com.msjf.finance.cas.modules.imagevalidcode.emun.ImageValidcodeEnum;
import com.msjf.finance.cas.modules.imagevalidcode.service.ImageValidcodeService;
import com.msjf.finance.msjf.core.response.Response;
import org.springframework.stereotype.Service;
import com.msjf.finance.cas.facade.imagevalidcode.ImageValidcodeFacade;
import com.msjf.finance.cas.facade.imagevalidcode.domain.ImageValidcodeDomain;

import javax.annotation.Resource;

@Service("imageValidcodeFacade")
public class ImageValidcodeFacadeImpl implements ImageValidcodeFacade {
    @Resource
    ImageValidcodeService imageValidcodeService;
    @Override
    public Response<ImageValidcodeDomain> getBase64ImageValidecode() {
        try{
            return imageValidcodeService.getBase64ImageValidecode();
        }catch (Exception e){
            return new Response<ImageValidcodeDomain>().fail(ImageValidcodeEnum.IMAGE_GET_EXCEPTION);
        }
    }

    @Override
    public Response checkImageValidecode(ImageValidcodeDomain imageValidcodeDomain) {
        return  imageValidcodeService.checkImageValidecode(imageValidcodeDomain);
    }
}
