package com.msjf.finance.cas.modules.imagevalidcode.facade;

import com.msjf.finance.cas.modules.imagevalidcode.service.ImageValidcodeService;
import com.msjf.finance.msjf.core.response.Response;
import org.springframework.stereotype.Service;
import com.msjf.finance.cas.facade.imagevalidcode.ImageValidcodeFacade;
import com.msjf.finance.cas.facade.imagevalidcode.domain.ImageValidcodeDomain;
import com.msjf.finance.cas.modules.imagevalidcode.service.impl.ImageValidcodeServiceImpl;
import com.msjf.finance.cas.modules.util.StringUtil;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service("imageValidcodeFacade")
public class ImageValidcodeFacadeImpl implements ImageValidcodeFacade {
    @Resource
    ImageValidcodeService imageValidcodeService;
    @Override
    public Response<ImageValidcodeDomain> getBase64ImageValidecode(HashMap mapParams) {
        Response<ImageValidcodeDomain> rs=new Response<ImageValidcodeDomain>();
        try{
            Response<Map> response=imageValidcodeService.getBase64ImageValidecode(mapParams);
            Map map=response.getData();
            ImageValidcodeDomain imageValidcodeDomain=new ImageValidcodeDomain();
            imageValidcodeDomain.setUniqueID(StringUtil.valueOf(map.get("uniqueID")));
            imageValidcodeDomain.setValidcode(StringUtil.valueOf(map.get("validcode")));
            rs.success(response.getMsg(),imageValidcodeDomain);
        }catch (Exception e){
            return rs.fail(e.getMessage());
        }
        return rs;
    }

    @Override
    public Response checkImageValidecode(HashMap mapParams) {
        Response rs=imageValidcodeService.checkImageValidecode(mapParams);
        return rs;
    }
}
