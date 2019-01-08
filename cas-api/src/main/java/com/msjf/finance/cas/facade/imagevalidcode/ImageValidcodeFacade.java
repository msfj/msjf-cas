package com.msjf.finance.cas.facade.imagevalidcode;

import com.msjf.finance.cas.common.response.Response;
import com.msjf.finance.cas.facade.imagevalidcode.domain.ImageValidcodeDomain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ImageValidcodeFacade {
    Response<ImageValidcodeDomain> getBase64ImageValidecode(HashMap mapParams);

    Response checkImageValidecode(HashMap mapParams);
}
