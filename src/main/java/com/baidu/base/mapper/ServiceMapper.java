package com.baidu.base.mapper;

import com.baidu.base.domain.Account;
import com.baidu.base.domain.Bill;
import com.baidu.base.domain.Bill_Code;
import com.baidu.base.domain.Services;
import com.baidu.base.utils.PageBean1;

public interface ServiceMapper {
    PageBean1<Account> findAllAccount(Integer pageNum, int pageSize, Account account);

    int setState(Account account);

    int deleteAccount(Account account);

    int findSingle(String re_idcard);

    int addAccount(Account account);

    PageBean1<Services> findAllService(Integer pageNum, int pageSize);

    PageBean1<Bill> findAllBill(Integer pageNum, int pageSize);

    Account findAccountById(int account_id);

    PageBean1<Bill_Code> findAllBill_code(Integer pageNum, int pageSize);
}