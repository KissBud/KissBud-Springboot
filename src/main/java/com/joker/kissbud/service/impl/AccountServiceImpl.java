package com.joker.kissbud.service.impl;

import com.joker.kissbud.entity.Account;
import com.joker.kissbud.dao.AccountMapper;
import com.joker.kissbud.service.AccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * account--账号 服务实现类
 * </p>
 *
 * @author Joker
 * @since 2020-10-14
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

}
