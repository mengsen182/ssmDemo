package cn.bdqn.util;

/**
 * Created by Administrator on 2018/3/5/005.
 */
public class Message {
    private String code;
    private String msg;

    public static Message success() {
        Message message=new Message();
        message.setCode("0000");
        message.setMsg("操作成功");
        return message;
    }

    public static Message error() {
        Message message =new Message();
        message.setCode("1111");
        message.setMsg("操作失败");
        return message;
    }
    @Override
    public String toString() {
        return "Message{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
