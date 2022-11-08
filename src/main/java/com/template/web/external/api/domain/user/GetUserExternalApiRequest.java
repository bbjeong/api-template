package com.template.web.external.api.domain.user;

import com.template.web.external.api.domain.ExternalApiRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class GetUserExternalApiRequest implements ExternalApiRequest {
    private String id;
}
