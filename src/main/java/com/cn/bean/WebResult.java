package com.cn.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/6/317:56
 */
public class WebResult {
    @JsonProperty
    private boolean status;
    @JsonProperty
    private String answer;

    @Override
    public String toString() {
        return "WebResult{" +
                "status=" + status +
                ", answer='" + answer + '\'' +
                '}';
    }
    @JsonProperty
    public boolean isStatus() {
        return status;
    }
    @JsonProperty
    public void setStatus(boolean status) {
        this.status = status;
    }
    @JsonProperty
    public String getAnswer() {
        return answer;
    }
    @JsonProperty
    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
