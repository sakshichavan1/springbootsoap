package com.example.endpoint;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.service.UserService;
import com.example.soap_spring_boot.GetUserRequest;
import com.example.soap_spring_boot.GetUserResponse;

@Endpoint
public class UserEndpoint {

    @Autowired
    private UserService userService;


    @PayloadRoot(namespace = "http://example.com/soap-spring-boot",
            localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUserRequest(@RequestPayload GetUserRequest request) {
        GetUserResponse response = new GetUserResponse();
        response.setUser(userService.getUsers(request.getName()));
        return response;
    }
}
