/*
 *
 *  Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.wso2.carbon.identity.local.auth.api.endpoint.exception;


import org.wso2.carbon.identity.local.auth.api.endpoint.constant.AuthEndpointConstants;
import org.wso2.carbon.identity.local.auth.api.endpoint.dto.ErrorDTO;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class ConflictRequestException extends WebApplicationException {

    private String message;

    public ConflictRequestException(ErrorDTO errorDTO) {

        super(Response.status(Response.Status.CONFLICT).entity(errorDTO).header(AuthEndpointConstants
                .HEADER_CONTENT_TYPE, AuthEndpointConstants.DEFAULT_RESPONSE_CONTENT_TYPE).build());
        message = errorDTO.getDescription();
    }

    public ConflictRequestException() {

        super(Response.Status.CONFLICT);
    }

    @Override
    public String getMessage() {

        return message;
    }
}
