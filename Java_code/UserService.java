package service;

import entity.User;
import entity.vo.MessageModel;
import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import util.GetSqlSession;
import util.StringUtil;

public class UserService {
    public MessageModel userlogin(String uname, String upwd) {
        User u = new User();
        u.setUserName(uname);
        u.setUserPwd(upwd);
        MessageModel messageModel = new MessageModel();
        messageModel.setObject(u);
        if(StringUtil.isEmpty(uname)||StringUtil.isEmpty(upwd)){
            messageModel.setCode(0);
            messageModel.setMsg("姓名密码不为空");
            return messageModel;
        }
        SqlSession session = GetSqlSession.createSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.queryUserByName(uname);

        if(user ==null){
            messageModel.setCode(0);
            messageModel.setMsg("用户不存在");
            return messageModel;
        }

        if(!upwd.equals((user.getUserPwd()))){
            messageModel.setCode(0);
            messageModel.setMsg("密码不对");
            return messageModel;
        }

        messageModel.setObject(user);
        return messageModel;
    }
}
