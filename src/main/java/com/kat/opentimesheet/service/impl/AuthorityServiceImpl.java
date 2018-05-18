package com.kat.opentimesheet.service.impl;

import com.kat.opentimesheet.common.constant.UserTypeConst;
import com.kat.opentimesheet.common.model.LoggedUser;
import com.kat.opentimesheet.common.model.TsUserEntity;
import com.kat.opentimesheet.common.util.PasswordUtil;
import com.kat.opentimesheet.repository.interfaces.UserRepo;
import com.kat.opentimesheet.service.interfaces.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    UserRepo userRepo;

    @Override
    public LoggedUser validateUser(String username, String password) {
        String md5Password = PasswordUtil.hashMD5(password);
        TsUserEntity userByUsernameAndPassword = userRepo.getUserByUsernameAndPassword(username.toLowerCase(), md5Password);
        if(userByUsernameAndPassword != null) {
            LoggedUser loggedUser = new LoggedUser();
            loggedUser.setUsername(username);
            loggedUser.setUserId(userByUsernameAndPassword.getUserId());
            if(userByUsernameAndPassword.getUserType() == UserTypeConst.ADMIN || userByUsernameAndPassword.getUserType() == UserTypeConst.NORMAL){
                loggedUser.setUserType(userByUsernameAndPassword.getUserType());
            }
            if(userByUsernameAndPassword.getUserType() == UserTypeConst.NORMAL){

            }
            return loggedUser;
        }
        return null;
    }
}
