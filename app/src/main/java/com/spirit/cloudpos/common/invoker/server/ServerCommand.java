package com.spirit.cloudpos.common.invoker.server;

/**
 * @author changwoo.son
 */
public enum ServerCommand {
    TEST_USER_CREATE_URL("/test/user/new"),
    USER_CREATE_URL("/users/new"),
    USER_GET_URL("/users/{userNo}"),
    USER_CHECK_ID_URL("/users/checkId"),
    RESTAURANT_CREATE_URL("/restaurants/new"),
    RESTAURANT_LIST_BY_USER_NO_URL("/restaurants");

    private String command;

    ServerCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
