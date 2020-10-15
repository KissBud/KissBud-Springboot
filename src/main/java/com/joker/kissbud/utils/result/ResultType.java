package com.joker.kissbud.utils.result;

import lombok.Getter;
import lombok.Setter;

/**
 * The Result type of api
 */
public enum ResultType {

    /**
     * Initialized
     */
    INITIALIZE("初始化"),
    /**
     * Business Success!
     */
    BUSINESS_SUCCESS("业务成功"),
    /**
     * Business Error
     */
    BUSINESS_ERROR("业务错误"),
    /**
     * Check Error
     */
    CHECK_ERROR("检测错误"),
    /**
     * Save Entity Error
     */
    SAVING_ERROR("保存错误"),
    /**
     * Delete Entity Error
     */
    DELETE_ERROR("删除错误"),
    /**
     * Update Entity Error
     */
    UPDATE_ERROR("更新错误"),
    /**
     * Query Entity Error
     */
    QUERY_ERROR("查询错误");

    /**
     * Reason for failed.
     */
    @Setter
    @Getter
    private String reason;

    ResultType(String reason) {
        this.reason = reason;
    }
}