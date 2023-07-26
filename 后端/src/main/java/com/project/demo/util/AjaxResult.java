package com.project.demo.util;

import java.util.HashMap;
//这个类是用来接口写好后返回状态码和信息的
public class AjaxResult extends HashMap<String,Object> {
    private static final long serialVersionUID = 1L;

    /** 状态码 */
    public static final String CODE_TAG = "code";

    /** 返回内容 */
    public static final String MSG_TAG = "msg";

    /** 数据对象 */
    public static final String DATA_TAG = "data";

    /**
     * 状态类型
     */
    public enum Type
    {
        /** 成功 */
        SUCCESS(0),
        /** 警告 */
        WARN(301),
        /** 错误 */
        ERROR(500);
        private final int value;

        Type(int value)
        {
            this.value = value;
        }

        public int value()
        {
            return this.value;
        }
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象，使其表示一个空消息。
     */
    public AjaxResult()
    {
    }
    /**
     * 初始化一个新创建的 AjaxResult (自定义的一个构造方法)
     *
     *  @param code 返回自定义的状态码
     * @param msg 返回状态码对应的内容
     * @param data 数据对象
     */
    public AjaxResult(String code, String msg, Object data)
    {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        super.put(DATA_TAG, data);

    }

    /**
     * 返回构造方法——这个构造方法是我这边自己定义的，为了给前端返回状态码，和对应的内容信息，还有数据
     *@param code 返回自定义的状态码
     * @param msg 返回内容
     * @param data 数据对象
     *
     */
    public static AjaxResult result(String code,String msg, Object data)
    {
        return new AjaxResult(code, msg, data);
    }

}
