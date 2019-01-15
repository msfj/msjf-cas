package com.msjf.finance.cas.facade.imagevalidcode;
import com.msjf.finance.cas.facade.imagevalidcode.domain.ImageValidcodeDomain;
import com.msjf.finance.msjf.core.response.Response;
import java.util.HashMap;
public interface ImageValidcodeFacade {
    Response<ImageValidcodeDomain> getBase64ImageValidecode();

    Response checkImageValidecode(ImageValidcodeDomain imageValidcodeDomain);
}
