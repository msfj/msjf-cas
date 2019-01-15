package com.msjf.finance.cas.modules.imagevalidcode.service;

import com.msjf.finance.cas.facade.imagevalidcode.domain.ImageValidcodeDomain;
import com.msjf.finance.msjf.core.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ImageValidcodeService {
    Response<ImageValidcodeDomain> getBase64ImageValidecode();

    Response checkImageValidecode(ImageValidcodeDomain imageValidcodeDomain);
}
