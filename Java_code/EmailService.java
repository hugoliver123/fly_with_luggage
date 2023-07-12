package service;

import entity.email;
import entity.vo.MessageModel;
import email_mapper.EmailMapper;
import org.apache.ibatis.session.SqlSession;
import util.GetSqlSession;
import util.StringUtil;

public class EmailService {
    public static MessageModel submitEmail(String email) {
        email e = new email();
        e.setEmail(email);
        MessageModel messageModel = new MessageModel();
        messageModel.setObject(e);
        if (StringUtil.isEmpty(email)) {
            messageModel.setCode(0);
            messageModel.setMsg("input cannot be empty");
            return messageModel;
        }
        SqlSession session = GetSqlSession.createSqlSession();
        EmailMapper emailMapper = session.getMapper(EmailMapper.class);
        email em= emailMapper.queryEmail(email);

        if(em !=null){
            messageModel.setCode(0);
            messageModel.setMsg("The e-mail is submitted");
            return messageModel;
        }
        else{
            emailMapper.updateEmail(email);
            session.commit();
        }
        session.close();
        return messageModel;
    }
}
