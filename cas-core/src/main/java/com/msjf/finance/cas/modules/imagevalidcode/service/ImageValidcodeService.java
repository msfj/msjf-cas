package com.msjf.finance.cas.modules.imagevalidcode.service;

import com.msjf.finance.cas.common.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ImageValidcodeService {
    Response<Map> getBase64ImageValidecode(HashMap mapParams);

    Response checkImageValidecode(HashMap mapParams);
}
