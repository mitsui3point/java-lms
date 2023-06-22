package nextstep.courses.domain;

import nextstep.users.domain.NsUser;

import java.util.List;

public interface StudentRepository {
    int save(Student student);

    List<NsUser> findAllBySessionIdAndApprovalStatus(Long id, ApprovalStatus approvalStatus);
}