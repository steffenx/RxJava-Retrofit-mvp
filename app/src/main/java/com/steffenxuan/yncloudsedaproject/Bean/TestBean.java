package com.steffenxuan.yncloudsedaproject.Bean;

/**
 * Created by Steffen_xuan on 2019/7/22.
 */

public class TestBean {


    /**
     * data : {"content":"这个世界需要更多英雄。"}
     * status : {"code":"1"}
     */
    private DataEntity data;
    private StatusEntity status;

    public void setData(DataEntity data) {
        this.data = data;
    }

    public void setStatus(StatusEntity status) {
        this.status = status;
    }

    public DataEntity getData() {
        return data;
    }

    public StatusEntity getStatus() {
        return status;
    }

    public class DataEntity {
        /**
         * content : 这个世界需要更多英雄。
         */
        private String content;

        public void setContent(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }
    }

    public class StatusEntity {
        /**
         * code : 1
         */
        private String code;

        public void setCode(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
}
