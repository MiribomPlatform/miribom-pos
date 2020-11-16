package com.spirit.cloudpos.common.invoker.server;


import com.spirit.cloudpos.common.invoker.server.model.type.HttpMethod;

/**
 * @author changwoo.son
 */
public enum ServerCommand {
    // TODO: testdb 삭제 시 제거
    TEST_USER_CREATE_URL("/test/user/new", HttpMethod.POST),
    // User
    USER_CREATE_URL("/users/new", HttpMethod.POST),
    USER_GET_URL("/users/{userNo}", HttpMethod.GET),
    USER_UPDATE_URL("/users/{userNo}", HttpMethod.PATCH),
    USER_DELETE_URL("/users/{userNo}", HttpMethod.DELETE),
    USER_CHECK_ID_URL("/users/checkId", HttpMethod.GET),
    // Restaurant
    RESTAURANT_CREATE_URL("/restaurants/new", HttpMethod.POST),
    RESTAURANT_LIST_BY_USER_NO_URL("/restaurants", HttpMethod.GET);

    private String command;
    private HttpMethod httpMethod;

    ServerCommand(String command, HttpMethod httpMethod) {
        this.command = command;
        this.httpMethod = httpMethod;
    }

    public String getCommand() {
        return command;
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }
}
