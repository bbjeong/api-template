package com.template.web.api.domain.user;

import com.template.web.api.domain.ApiRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class GetUserApiRequest implements ApiRequest {
    private String id;
}
