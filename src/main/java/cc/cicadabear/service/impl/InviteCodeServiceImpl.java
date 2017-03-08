package cc.cicadabear.service.impl;

import cc.cicadabear.domain.entity.InviteCode;
import cc.cicadabear.domain.repository.InviteCodeRepository;
import cc.cicadabear.service.InviteCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jack
 */
@Service("inviteCodeService")
public class InviteCodeServiceImpl implements InviteCodeService {

    @Autowired
    private InviteCodeRepository inviteCodeRepository;

    @Override
    public InviteCode loadCodeByNo(String code) {
        return inviteCodeRepository.findByNo(code);
    }

    @Override
    public boolean isExistByNo(String code) {
        return loadCodeByNo(code) == null;
    }

    @Override
    public List<InviteCode> loadCodesByUser(int userId) {
        List<InviteCode> list = inviteCodeRepository.findByUser(userId);
        return list;
    }

}